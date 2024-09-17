package com.iiht.securityjwt.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.iiht.securityjwt.MyUserDetailsService;
import com.iiht.securityjwt.util.JwtUtil;



@Component
public class JWTRequestFilter extends OncePerRequestFilter {

 
 	@Autowired
 	private MyUserDetailsService userDetailsService;
 
 	@Autowired
 	private JwtUtil jwtUtil;
 
 	@Override
 	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
 			throws ServletException, IOException {
 		System.out.println("from doFilterInternal .............");
 		
 		final String authorizationHeader = request.getHeader("Authorization");
 
 		String username = null;
 		String jwt = null;
 
 		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
 
 			jwt = authorizationHeader.substring(7);
 			username = jwtUtil.extractUsername(jwt);
 			System.out.println(username);
 		}
 		
 		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
 		
 
 			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
 			System.out.println(userDetails);
 			System.out.println(userDetails.getUsername());
 			if (jwtUtil.validateToken(jwt, userDetails)) {
 				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
 						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
 				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
 			   SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);	
 
 			}
 		}else {
 			System.out.println("hmmmmmmmmmmm");
 		}
 
 			filterChain.doFilter(request, response);
 
 		}
 	}