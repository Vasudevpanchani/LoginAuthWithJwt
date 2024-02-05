package com.example.loginwithjwt;

import lombok.Data;

@Data
public class ResponseDTO {
	
	private int status;
	
	private String message;
	
	private Object data;

}
