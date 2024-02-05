package com.example.loginwithjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.loginwithjwt.ResponseDTO;
import com.example.loginwithjwt.config.CustomUserDataService;
import com.example.loginwithjwt.jwt.JwtUtils;
import com.example.loginwithjwt.model.UserData;
import com.example.loginwithjwt.repository.UserDatarepository;

@Service
public class UserDataServiceImpl implements UserDataService{
	
	@Autowired
	private UserDatarepository userDatarepository;
	
	@Autowired
	private CustomUserDataService customUserDataService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	ResponseDTO response=new ResponseDTO();
	
	private void setResponseData(int status,String message,Object data) {
		response.setStatus(status);
		response.setMessage(message);
		response.setData(data);
	}

	@Override
	public ResponseEntity<ResponseDTO> register(UserData userData) {
		UserData user = userDatarepository.findByEmail(userData.getEmail());
		if(user == null) {
			userData.setPassword(new BCryptPasswordEncoder().encode(userData.getPassword()));
			userData.setVerified(true);
			setResponseData(200,"User registered succesfully", userDatarepository.save(userData));
			return new ResponseEntity<ResponseDTO>(response,HttpStatus.ACCEPTED);
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseDTO> loginAuth(String username, String password) {
		try {
			Authentication auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			if (auth.isAuthenticated()) {
				if (customUserDataService.getUserData().isVerified()) {
					setResponseData(200, "The token", jwtUtils.generateToken(customUserDataService.getUserData().getEmail(),
							customUserDataService.getUserData().getRole()));
					return new ResponseEntity<ResponseDTO>(response, HttpStatus.ACCEPTED);
				} else {
					setResponseData(400, "User is not authenticated", "Bad Request");
					return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setResponseData(400, "Something wrong bad", "Bad Request");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
