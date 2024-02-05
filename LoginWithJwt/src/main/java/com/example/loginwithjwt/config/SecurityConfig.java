package com.example.loginwithjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.loginwithjwt.jwt.JwtFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService CustomUserDataService;
	
	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(CustomUserDataService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@SuppressWarnings("deprecation")
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
				http.csrf(csrf->csrf.disable())
					.authorizeHttpRequests(request->request.antMatchers("/index","/login","/register","/logout","/adduser","/loginauth").permitAll()
					.antMatchers("/admin/**").hasAuthority("Admin")
					.antMatchers("/user/**").hasAuthority("User"))
					.formLogin(login->login.loginPage("/login").loginProcessingUrl("/login")
					.successHandler(new CustomSuccessHandler()).permitAll())
					.logout(logout->logout.logoutUrl("/logout").invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("/index").permitAll());
				
				http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
