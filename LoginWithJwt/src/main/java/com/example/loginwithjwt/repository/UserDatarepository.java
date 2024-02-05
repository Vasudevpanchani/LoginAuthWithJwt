package com.example.loginwithjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginwithjwt.model.UserData;

@Repository
public interface UserDatarepository extends JpaRepository<UserData, Long>{
	
	public UserData findByEmail(String email);

}
