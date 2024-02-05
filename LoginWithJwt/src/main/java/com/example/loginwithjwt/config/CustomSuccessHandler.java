package com.example.loginwithjwt.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	SimpleUrlAuthenticationSuccessHandler userHandler = new SimpleUrlAuthenticationSuccessHandler("/user/dashboard");
	SimpleUrlAuthenticationSuccessHandler adminHandler = new SimpleUrlAuthenticationSuccessHandler("/admin/dashboard");

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {

			String authorityName = grantedAuthority.getAuthority();
			if (authorityName.equalsIgnoreCase("Admin")) {
				this.adminHandler.onAuthenticationSuccess(request, response, authentication);
				return;
			}
		}
		this.userHandler.onAuthenticationSuccess(request, response, authentication);

	}

}
