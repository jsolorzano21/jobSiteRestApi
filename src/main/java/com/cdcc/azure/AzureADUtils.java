package com.cdcc.azure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Base64.Decoder;

import javax.net.ssl.HttpsURLConnection;

import com.cdcc.exception.TokenException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AzureADUtils {
	
	public static Map<String, Object> getTokenComponents(String idToken) throws TokenException {
	    System.out.println("ID token getTokenComponnent: " + idToken);
        Decoder decoder = Base64.getDecoder();
        StringTokenizer tokenizer = new StringTokenizer(idToken, ".");
        System.out.println("Tokenizer: " + tokenizer);
        int i = 0;
        Map<String, Object> tokenHeader = new HashMap<String, Object>();
        Map<String, Object> tokenBody = new HashMap<String, Object>();
        String signatureJws = "";
        Map<String, Object> tokenMapParts = new HashMap<String, Object>();
        //(1) DECODE THE 3 PARTS OF THE JWT TOKEN
        try {
            while (tokenizer.hasMoreElements()) {
                if (i == 0) {
                    tokenHeader = string2JSONMap(new String(decoder.decode(tokenizer.nextToken())));
                } else if (i == 1) {
                    tokenBody = string2JSONMap(new String(decoder.decode(tokenizer.nextToken())));
                } else {
                    signatureJws = new String(tokenizer.nextToken());
                }
                i++;
            }
        } catch (IOException e) {
            throw new TokenException(500, e.getMessage());
        }
        
        System.out.println("Token Header: " + tokenHeader);
        System.out.println("Token Body: " + tokenBody);
        System.out.println("Signature: " + signatureJws);
        //(1.1) THE 3 PARTS OF THE TOKEN SHOULD BE IN PLACE
        if (tokenHeader == null || tokenBody == null || signatureJws == null || tokenHeader.isEmpty() || tokenBody.isEmpty() || signatureJws.isEmpty()) {
            throw new TokenException(500, "Invalid Token");
        }
        tokenMapParts.put("header", tokenHeader);
        tokenMapParts.put("body", tokenBody);
        tokenMapParts.put("signature", signatureJws);
        return tokenMapParts;
    }
	
	public static Map<String, Object> string2JSONMap(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        // convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }
	
	public OpenIdKeysBean discoveryKeys(String keysURL) {
		System.out.println("AuthController discoveryKeys method");
        URL url;
        OpenIdKeysBean openIdKeysBean = new OpenIdKeysBean();
        try {
            url = new URL(keysURL);
            System.out.println("Key URL: " + url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            if (con != null) {
                try {
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(con.getInputStream()));
                    String input;
                    StringBuilder builder = new StringBuilder();
                    while ((input = br.readLine()) != null) {
                        builder.append(input);
                    }
                    br.close();
                    System.out.println("Input Value: " + builder.toString());
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    openIdKeysBean = mapper.readValue(builder.toString(), OpenIdKeysBean.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("AuthController discoveryKeys method completed");
        return openIdKeysBean;
    }

}
