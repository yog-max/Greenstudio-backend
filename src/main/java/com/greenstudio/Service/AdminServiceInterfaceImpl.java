package com.greenstudio.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greenstudio.Config.JwtUtil;
import com.greenstudio.DTO.AdminLoginResponse;
import com.greenstudio.DTO.LoginRequest;
import com.greenstudio.Entity.Admin;
import com.greenstudio.Repository.AdminRepository;

@Service
public class AdminServiceInterfaceImpl implements AdminServiceInterface
{

	 	@Autowired
	    private AdminRepository adminRepository;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    @Override
	    public AdminLoginResponse login(LoginRequest request)
	    {

	        Optional<Admin> adminOpt = adminRepository.findByUserName(request.getUserName());

	        if (adminOpt.isEmpty()) {
	            throw new RuntimeException("Invalid username or password");
	        }

	        Admin admin = adminOpt.get();

	        boolean isPasswordCorrect = passwordEncoder.matches(
	            request.getPassword(),   // "admin123" typed by user
	            admin.getPassword()      // "$2a$10$..." stored in DB
	        );

	        if (!isPasswordCorrect) {
	            throw new RuntimeException("Invalid username or password");
	        }

	        String token = jwtUtil.generateToken(admin.getUserName());

	        // 6. Return token wrapped in DTO
	        return new AdminLoginResponse(token, "Login successful");
	    }

	
}
