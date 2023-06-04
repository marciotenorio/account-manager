package br.ufrn.imd.AccountManager.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.ufrn.imd.AccountManager.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterToken extends OncePerRequestFilter {
	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token;
		var authorization = request.getHeader("Authorization");

		if (authorization != null) {
			token = authorization.replace("Bearer ", "");
			var subject = this.tokenService.getSubject(token);

			var user = this.userRepository.findByLogin((String) subject);

			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authentication);
		
		}
		
		filterChain.doFilter(request, response);
	}

}
