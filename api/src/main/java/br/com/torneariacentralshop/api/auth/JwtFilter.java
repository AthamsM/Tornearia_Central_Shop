package br.com.torneariacentralshop.api.auth;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	private final JwtService jwtService;
	private final UserDatailsServiceImpl userDatailsServiceImpl;
	
	public JwtFilter(JwtService jwtService, UserDatailsServiceImpl userDetailsServiceImpl) {
		this.jwtService = jwtService;
		this.userDatailsServiceImpl = userDetailsServiceImpl;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			        
		String authorization = request.getHeader("Authorization");
		
		if(authorization != null && authorization.startsWith("Bearer ")) {
			String token = authorization.substring(7);
			String email = jwtService.extractEmail(token);
			
			if(email != null  && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails user = userDatailsServiceImpl.loadUserByUsername(email);
				if(jwtService.isValid(token, user)) {
					UsernamePasswordAuthenticationToken authToken = 
							new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
			
		filterChain.doFilter(request, response);
		
	}	
}
