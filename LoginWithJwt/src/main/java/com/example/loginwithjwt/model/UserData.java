package com.example.loginwithjwt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;


@Data
@Entity
@Table(name = "user_info",uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class UserData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String email;

	private String password;

	private String role;

	private boolean verified;

}
