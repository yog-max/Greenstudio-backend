package com.greenstudio.Service;

import java.util.List;
import java.util.Optional;

import com.greenstudio.Entity.Booking;
import com.greenstudio.Entity.Customer;


public interface YstudioServiceInterface 
{

	

	List<Booking> findAll();

	String deleteById(long eventId);

	String updateById(long eventId, Booking b1);

	List<Booking> findByCustomerId(long userId);

	String saveBookingWithValidation(Booking booking);

	Optional<Booking> findById(long eventId);

	Booking save(Booking booking);

	

}
