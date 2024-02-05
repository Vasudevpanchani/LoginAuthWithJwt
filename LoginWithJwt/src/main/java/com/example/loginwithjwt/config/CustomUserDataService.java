package com.example.loginwithjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.loginwithjwt.model.UserData;
import com.example.loginwithjwt.repository.UserDatarepository;

@Component
public class CustomUserDataService implements UserDetailsService{
	
	@Autowired
	private UserDatarepository userDatarepository;
	
	private UserData userData;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userData=userDatarepository.findByEmail(username);
		if(userData == null) {
			throw new UsernameNotFoundException("User Not Found!!");
		}
		return new CustomUserData(userData);
	}
	
	public UserData getUserData() {
		return userData;
	}

}
