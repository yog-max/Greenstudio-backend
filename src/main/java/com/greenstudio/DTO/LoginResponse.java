package com.greenstudio.DTO;

public class LoginResponse
{
	
	private long userId;
	private String userName;
	private String message;
	public LoginResponse(long userId, String userName, String message) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.message = message;
	}
	public long getUserId() {
		return userId;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	 public String getMessage() {
	        return message;
	    }
	
	
	
	
	
	

}
