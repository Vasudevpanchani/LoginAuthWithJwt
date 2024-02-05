package com.example.loginwithjwt.service;

import org.springframework.http.ResponseEntity;

import com.example.loginwithjwt.ResponseDTO;
import com.example.loginwithjwt.model.UserData;

public interface UserDataService {
	
	public ResponseEntity<ResponseDTO> register(UserData userData);
	
	public ResponseEntity<ResponseDTO> loginAuth(String username,String password);

}
