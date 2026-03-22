package com.greenstudio.DTO;

public class AdminLoginResponse
{
	private String token;
	private String message;
	
	public AdminLoginResponse(String token, String message)
	{
		this.token=token;
		this.message=message;
	}

	public String getToken() {
		return token;
	}


	public String getMessage() {
		return message;
	}

	
}
