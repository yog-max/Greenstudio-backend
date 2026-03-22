package com.greenstudio.Service;

import com.greenstudio.DTO.AdminLoginResponse;
import com.greenstudio.DTO.LoginRequest;

public interface AdminServiceInterface
{

	

	AdminLoginResponse login(LoginRequest request);

}
