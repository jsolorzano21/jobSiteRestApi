package com.cdcc.controller;
import static org.springframework.http.ResponseEntity.ok;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdcc.azure.KeyBean;
import com.cdcc.config.JwtTokenProvider;
import com.cdcc.exception.TokenException;
import com.cdcc.models.Role;
import com.cdcc.models.Users;
import com.cdcc.repository.UsersRepository;
import com.cdcc.services.MongoUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import com.cdcc.azure.AzureADUtils;

@CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private static final Object APPLICATION_ID = "9ae0c120-eeca-4069-a6e1-cfc84629aa2b";

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UsersRepository users;

    @Autowired
    private MongoUserDetailsService userService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthBody data) {
    	Map<Object, Object> model = new HashMap<>();
    	System.out.println("Controller entered");
    	String bearerTokenValue = "";
        try {
        	if(data.getEmail() == "" && data.getPassword() == "") {
        		boolean isValidToken = false;
        		String bearerToken = data.getAdToken();
        		Claims claims = null;
        		Map<String, Object> tokenBody = new HashMap<String, Object>();
        		if(bearerToken != null && bearerToken.startsWith("Mstoken ")) { 
        	    	try {
        	    	Map<String, Object> tokenHeader = new HashMap<String, Object>();
        	    	String signatureJws = "";
        	    	bearerTokenValue = bearerToken.substring(8, bearerToken.length());
        	    	AzureADUtils getTokenValues = new AzureADUtils();
        	    	Map<String, Object> mapTokenComponents = getTokenValues.getTokenComponents(bearerTokenValue);
        	    	tokenHeader = (Map<String, Object>) mapTokenComponents.get("header");
        	    	tokenBody = (Map<String, Object>) mapTokenComponents.get("body");
        	    	signatureJws = (String) mapTokenComponents.get("signature");
        	    	
        	    	//(2) GET OPENID CONFIGURATIONS AND SELECT THE MACHING KEY BEAN
                    String keysUrl = "https://login.microsoftonline.com/common/discovery/keys";
                    KeyBean keyBeanForAccess = null;
                    for (KeyBean keyBean : getTokenValues.discoveryKeys(keysUrl).getKeys()) {
                        if (keyBean.getKid().equals((String) tokenHeader.get("kid"))) {
                            keyBeanForAccess = keyBean;
                            break;
                        }
                    }
        	    	
        	    	//(3) VALIDATE THE JWT CLAIMS
                    PublicKey pubKeyNew = null;
                    try {
                        byte[] modulusBytes = Base64.getUrlDecoder().decode(keyBeanForAccess.getN());
                        byte[] exponentBytes = Base64.getUrlDecoder().decode(keyBeanForAccess.getE());
                        BigInteger modulusInt = new BigInteger(1, modulusBytes);
                        BigInteger exponentInt = new BigInteger(1, exponentBytes);
                        KeySpec publicSpec = null;
                        KeyFactory keyFactory = KeyFactory.getInstance(keyBeanForAccess.getKty());
                        switch (keyBeanForAccess.getKty()) {
                            case "RSA":
                                publicSpec = new RSAPublicKeySpec(modulusInt, exponentInt);
                                break;
                        }
                        pubKeyNew = keyFactory.generatePublic(publicSpec);
                        claims = Jwts.parser()
                                .setSigningKey(pubKeyNew)
                                .parseClaimsJws(bearerTokenValue).getBody();
                        System.out.println("Expiration Date:: " + claims.getExpiration().toString());
                        System.out.println("Issued Date:: " + claims.getIssuedAt().toString());
                        System.out.println("Issuer:: " + claims.getIssuer());
                        System.out.println("Audience:: " + claims.getAudience());
                    } catch (Exception e) {
                        throw new TokenException(500, "Invalid claims: " + e.getMessage());
                    }
        			
        			  if (claims == null || !APPLICATION_ID.equals(claims.getAudience())) { throw
        			  new TokenException(500, "Invalid audience claim"); }
        			 
        			//(4) VERIFY SIGNATURE	    	
        		    	try {
        	                byte[] signature = Base64.getUrlDecoder().decode(signatureJws);
        	                Signature sig = Signature.getInstance("SHA256withRSA");
        	                System.out.println("The Signature: " + sig);
        	                sig.initVerify(pubKeyNew);
        	                sig.update(bearerTokenValue.getBytes());
        	                boolean newCheck = sig.verify(signature);
        	            } catch (Exception e) {
        	                throw new TokenException(500, "Invalid signature: " + e.getMessage());
        	            }
        		    	
        		    	isValidToken = true;
        		    	System.out.println("The token value: " + isValidToken);
        	    	} catch (TokenException e) {
        	            System.out.println("Invalid token! " + e);
        	        }	
        		    	
        	    }
        		
        		if(isValidToken) {
        			List<Object> strList = Arrays.asList(tokenBody.get("roles"));
        			List<Object> role = (List<Object>) strList.get(0);
        			String finalRole = (String) role.get(0);
        			String token = jwtTokenProvider.createTokenSingleSignOn((String) tokenBody.get("preferred_username"), finalRole, claims);
	        		model.put("username", (String) tokenBody.get("preferred_username"));
		            model.put("token", token);
        		}
        		
        	}else {
	            String username = data.getEmail();
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
	            String token = jwtTokenProvider.createToken(username, this.users.findByEmail(username).getRoles());
	            model.put("username", username);
	            model.put("token", token);
        	}
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Users user) {
        Users userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
        }
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }
}