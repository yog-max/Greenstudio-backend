package com.greenstudio.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenstudio.DTO.LoginRequest;
import com.greenstudio.DTO.LoginResponse;
import com.greenstudio.DTO.ResetPasswordRequest;
import com.greenstudio.Entity.Customer;
import com.greenstudio.Service.GstudioServiceInterface;


@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "http://localhost:5173",
	    "https://green-studio-steel.vercel.app"
	})
@RestController()
@RequestMapping("/user")
public class GstudioController
{

	@Autowired
	GstudioServiceInterface service;
	
	@PostMapping("/register")
	public Customer save(@RequestBody Customer c1)
	{
		return service.save(c1);
	}
	
	@GetMapping("/get")
	public List<Customer> findAll()
	{
		return service.findAll();
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteById(@PathVariable long userId)
	{
		return service.deleteById(userId);
	}
	
	@PutMapping("/update/{userId}")
	public String updateById(@PathVariable long userId, @RequestBody Customer c1)
	{
		return service.updateById(userId,c1);
	}
	
	@GetMapping("/find/{userId}")
	public Optional<Customer> findById(@PathVariable long userId)
	{
		return service.findById(userId);
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request)
	{
		Optional<Customer> customer = service.login(request.getUserName(), request.getPassword());
							
		if(customer.isPresent())
		{
			Customer c1=customer.get();
						return ResponseEntity.ok(
								new LoginResponse(
									c1.getUserId(),
									c1.getUserName(),
									"Login Successful"
									)
								);
								
		}
		return ResponseEntity.status(401).body("Invalid Credentials");
	}
	
	@PatchMapping("/forget/password/{userName}")
	public ResponseEntity<String> forgetPassword(@PathVariable String userName, @RequestBody ResetPasswordRequest request)
	{
		String response = service.forgetPassword(userName,request.getPassword());
		
		return ResponseEntity.ok(response);
		
	}
	
	
	
	
	
	
	
	
	
}
