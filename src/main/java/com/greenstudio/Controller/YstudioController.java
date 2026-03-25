package com.greenstudio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenstudio.Entity.Booking;
import com.greenstudio.Entity.Customer;
import com.greenstudio.Service.GstudioServiceInterface;
import com.greenstudio.Service.YstudioServiceInterface;

@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "http://localhost:5173",
	    "https://greenstudio-backend.onrender.com"
	})
@RestController()
@RequestMapping("/booking")
public class YstudioController 
{

	@Autowired
	GstudioServiceInterface s1;
	
	@Autowired
	YstudioServiceInterface service1;
	
	
	@PostMapping("/eventpost/{userId}")
	public String saveBooking(@PathVariable long userId, 
											 @RequestBody Booking booking)
	{
			Customer customer = s1.findById(userId)
										.orElseThrow(() ->
										new RuntimeException("User not found"));
			booking.setCustomer(customer);
			
			return service1.saveBookingWithValidation(booking);
	}
	
	
	@GetMapping("/eventget")
	public List<Booking> findAll1()
	{
		return service1.findAll();
	}
	
	@DeleteMapping("/event/delete/{eventId}")
	public String deleteById1(@PathVariable long eventId)
	{
		return service1.deleteById(eventId);
	}
	
	
	@GetMapping("/find/eventbooking/{userId}")
	public List<Booking> findBooking(@PathVariable long userId)
	{
		return service1.findByCustomerId(userId);
	}
	
	
	@PutMapping("/event/update/{eventId}")
	public String updateByBooking(@PathVariable long eventId, @RequestBody Booking b1)
	{
		return service1.updateById(eventId,b1);
	}
	
	@PatchMapping("/approve/{eventId}")
	public Booking approveBooking(@PathVariable long eventId) {
		Booking booking = service1.findById(eventId)
					.orElseThrow(() -> new RuntimeException("Booking not found"));
		
		booking.setStatus("APPROVED");
		
		return service1.save(booking);
	}
	
	@PatchMapping("/reject/{eventId}")
	public Booking rejectBooking(@PathVariable long eventId) {
		Booking booking = service1.findById(eventId)
					.orElseThrow(() -> new RuntimeException("Booking not found"));
		
		booking.setStatus("REJECTED");
		
		return service1.save(booking);
	}
	
}
