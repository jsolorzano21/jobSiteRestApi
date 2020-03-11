package com.cdcc.config;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.cdcc.exception.TokenException;

public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
        throws IOException, ServletException {
        String token = null;
        boolean validToken = false;
        boolean requireTokenValidation = false;
        String bearerToken = ((HttpServletRequest) req).getHeader("Authorization");
        System.out.println("BearerToken Value: " + bearerToken);
		try {
			if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
				token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
				requireTokenValidation = true;
		    }else if(bearerToken != null && bearerToken.startsWith("Mstoken ")) {
		    	token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
		    	validToken = true;
		    }
		} catch (TokenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (token != null && requireTokenValidation == true && jwtTokenProvider.validateToken(token)) {
            Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
            SecurityContextHolder.getContext().setAuthentication(auth);
		} else if(validToken) { System.out.println("This is a valid Token: ");
			Authentication auth = token != null ? jwtTokenProvider.getAuthenticationMsUser(token) : null;
	        SecurityContextHolder.getContext().setAuthentication(auth);
		}
			 
        filterChain.doFilter(req, res);
    }
}