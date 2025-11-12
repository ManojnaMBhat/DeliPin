package com.example.smartdelivery.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

	 @Autowired
	    private JwtUtil jwtUtil;

	    @Override
	    protected boolean shouldNotFilter(HttpServletRequest request) {
	        String path = request.getRequestURI();

	        return path.startsWith("/swagger-ui")
	                || path.startsWith("/v3/api-docs")
	                || path.startsWith("/v2/api-docs")
	                || path.startsWith("/swagger-resources")
	                || path.startsWith("/webjars")
	                || path.startsWith("/api/auth");
	    }

	    @Override
	    protected void doFilterInternal(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    FilterChain filterChain) throws ServletException, IOException {

	        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
	        String token = null;

	        if (header != null && header.startsWith("Bearer ")) {
	            token = header.substring(7);
	        }

	        if (token != null && jwtUtil.validateJwtToken(token)) {
	            String username = jwtUtil.getUsernameFromToken(token);

	            UsernamePasswordAuthenticationToken auth =
	                    new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

	            SecurityContextHolder.getContext().setAuthentication(auth);
	        }

	        filterChain.doFilter(request, response);
	    }
}
