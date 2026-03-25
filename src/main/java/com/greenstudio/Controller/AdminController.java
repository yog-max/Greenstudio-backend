package com.greenstudio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenstudio.DTO.AdminLoginResponse;
import com.greenstudio.DTO.LoginRequest;
import com.greenstudio.Service.AdminServiceInterface;

@RestController
@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "http://localhost:5173",
	    "https://greenstudio-backend.onrender.com"
	})
@RequestMapping("/admin")
public class AdminController 
{
	
	 @Autowired
	    private AdminServiceInterface adminService;   // controller calls service only

	    // ── LOGIN API ──
	    // URL: POST http://localhost:8080/admin/login
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
	        try {
	            // Just call service — no logic in controller
	            AdminLoginResponse response = adminService.login(request);
	            return ResponseEntity.ok(response);

	        } catch (RuntimeException e) {
	            // If service throws error → return 401
	            return ResponseEntity.status(401).body(e.getMessage());
	        }
	    }
	    
	    @GetMapping("/generate-hash")
	    public String generateHash() {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String hash = encoder.encode("adminyogi@8688");
	        System.out.println("Generated Hash: " + hash);
	        return hash;
	    }
	

}
