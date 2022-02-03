package com.cdcc.config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Base64.Decoder;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cdcc.azure.AzureADUtils;
import com.cdcc.azure.KeyBean;
import com.cdcc.azure.OpenIdKeysBean;
import com.cdcc.exception.TokenException;
import com.cdcc.models.Role;
import com.cdcc.services.MongoUserDetailsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	private static final Object APPLICATION_ID = "9ae0c120-eeca-4069-a6e1-cfc84629aa2b";
	private static final Object APPLICATION_ID_2 = "aa2f2910-4d54-43a4-8f2b-69e5e8e9067a";

	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";

	@Value("${security.jwt.token.expire-length:3600000}")
	private long validityInMilliseconds = 3600000; // 1h

	@Autowired
	private MongoUserDetailsService userDetailsService;
	
	@PostConstruct
	protected void init() {
	    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String createToken(String username, Set<Role> set) {
	    Claims claims = Jwts.claims().setSubject(username);
	    claims.put("roles", set);
	    Date now = new Date();
	    Date validity = new Date(now.getTime() + validityInMilliseconds);
	    return Jwts.builder()//
	        .setClaims(claims)//
	        .setIssuedAt(now)//
	        .setExpiration(validity)//
	        .signWith(SignatureAlgorithm.HS256, secretKey)//
	        .compact();
	}
	
	public Authentication getAuthentication(String token) {
		System.out.println("Get Authentication: " + token);
	    UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
	    System.out.println("userDetails: " + userDetails);
	    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	public Authentication getAuthenticationMsUser(String token) {
		System.out.println("Get Authentication: " + token);
	    //UserDetails userDetails = this.userDetailsService.loadUserByUsername("j.solorzano3317@gmail.com");
	    //System.out.println("userDetails: " + userDetails);
	    return new UsernamePasswordAuthenticationToken(null, "", null);
	}
	
	public String getUsername(String token) {
		System.out.println("getUserName: " + token);
	    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	public String resolveToken(HttpServletRequest req) throws TokenException {
	    String bearerToken = req.getHeader("Authorization");
	    System.out.println("Token Value: " + bearerToken);
	    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
	        return bearerToken.substring(7, bearerToken.length());
	    }else if (bearerToken != null && bearerToken.startsWith("Mstoken ")) {
	        return bearerToken.substring(8, bearerToken.length());   	
	    }
	    
	    return null;
	}
	
	public String createTokenSingleSignOn(String username, String set, Claims claims2) {
	    Claims claims = Jwts.claims().setSubject(username);
	    claims.put("roles", set);
	    Date now = new Date();
	    return Jwts.builder()//
	        .setClaims(claims)//
	        .setIssuedAt(claims2.getIssuedAt())//
	        .setExpiration(claims2.getExpiration())//
	        .signWith(SignatureAlgorithm.HS256, secretKey)//
	        .compact();
	}
	
	public String resolveTokenSingleSignOn(HttpServletRequest req) throws TokenException {
    	boolean isValidToken = false;
    	String bearerTokenValue = "";
		String bearerToken = req.getHeader("Authorization");
	    System.out.println("Token Value: " + bearerToken);
        System.out.println("Joanie Solorzano");

	    if(bearerToken != null && bearerToken.startsWith("Mstoken ")) { 
	    	try {
	    	Map<String, Object> tokenHeader = new HashMap<String, Object>();
	    	Map<String, Object> tokenBody = new HashMap<String, Object>();
	    	String signatureJws = "";
	    	bearerTokenValue = bearerToken.substring(8, bearerToken.length());
	    	AzureADUtils getTokenValues = new AzureADUtils();
	    	Map<String, Object> mapTokenComponents = getTokenValues.getTokenComponents(bearerTokenValue);
	    	tokenHeader = (Map<String, Object>) mapTokenComponents.get("header");
	    	tokenBody = (Map<String, Object>) mapTokenComponents.get("body");
	    	System.out.println("TokenHeader: " + tokenHeader);
	    	System.out.println("TokenBody: " + tokenBody);
	    	signatureJws = (String) mapTokenComponents.get("signature");
	    	
	    	//(2) GET OPENID CONFIGURATIONS AND SELECT THE MACHING KEY BEAN
            String keysUrl = "https://login.microsoftonline.com/common/discovery/keys";
            KeyBean keyBeanForAccess = null;
            for (KeyBean keyBean : getTokenValues.discoveryKeys(keysUrl).getKeys()) {
            	System.out.println("Key Bean: " + keyBean.getKid() + "tokenHeader: " + tokenHeader.get("kid"));
                if (keyBean.getKid().equals((String) tokenHeader.get("kid"))) {
                    keyBeanForAccess = keyBean;
                    break;
                }
            }
	    	//System.out.println("Key Bean For Access: " + keyBeanForAccess.getX5c());
	    	
	    	//(3) VALIDATE THE JWT CLAIMS
            PublicKey pubKeyNew = null;
            Claims claims = null;
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
                System.out.println("Joanie Solorzano");
                System.out.println("Issuer:: " + claims.getIssuer());
                System.out.println("Audience:: " + claims.getAudience());
                System.out.println("Joanie Solorzano");
            } catch (Exception e) {
                throw new TokenException(500, "Invalid claims: " + e.getMessage());
            }
			
            System.out.println("Joanie Solorzano");
			  if (claims == null || !APPLICATION_ID.equals(claims.getAudience()) && !APPLICATION_ID_2.equals(claims.getAudience())) { throw
			  new TokenException(500, "Invalid audience claim"); }
			 
			//(4) VERIFY SIGNATURE	    	
		    	try {
	                byte[] signature = Base64.getUrlDecoder().decode(signatureJws);
	                Signature sig = Signature.getInstance("SHA256withRSA");
	                System.out.println("The Signature: " + sig);
	                sig.initVerify(pubKeyNew);
	                sig.update(bearerTokenValue.getBytes());
	                boolean newCheck = sig.verify(signature);
	                System.out.println("Check Value: " + newCheck);
	            } catch (Exception e) {
	                throw new TokenException(500, "Invalid signature: " + e.getMessage());
	            }
		    	
		    	isValidToken = true;
		    	System.out.println("The token value: " + isValidToken);
	    	} catch (TokenException e) {
	            System.out.println("Invalid token! " + e);
	        }	
		    	
	    }
		return bearerTokenValue;
	}
	
	public boolean validateToken(String token) {
		System.out.println("this is the token: " + token);
	    try {
	        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
	        if (claims.getBody().getExpiration().before(new Date())) {
	            return false;
	        }
	        return true;
	    } catch (JwtException | IllegalArgumentException e) {
	        throw new JwtException("Expired or invalid JWT token: " + e);
	    }
	}

}