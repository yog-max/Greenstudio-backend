package com.greenstudio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenstudio.Entity.Booking;
import com.greenstudio.Entity.Customer;
import com.greenstudio.Repository.YstudioRepoInterface;

@Service
public class YstudioServiceInterfaceImpl implements YstudioServiceInterface
{
	
	@Autowired
	YstudioRepoInterface repo1;

	
	@Override
	public String saveBookingWithValidation(Booking booking) 
	{
		List<Booking> conflicts = repo1.findConflictingBookings(
									booking.getStartDate(),
									booking.getEndDate());
		
		if(!conflicts.isEmpty())
		{
		return "Selected dates already booked";
		}
			booking.setStatus("PENDING");
			repo1.save(booking);
			return "Booking successful";
		
	}


	@Override
	public List<Booking> findAll() {
		
		return repo1.findAll();
	}

	@Override
	public String deleteById(long eventId)
	{
		
		if(repo1.existsById(eventId))
		{
			repo1.deleteById(eventId);
			return eventId+" Deleted Successfully";
		}
		else
		{
			return "Id not found, delete Unsucessfull";
		}
		
	}


	@Override
	public String updateById(long eventId, Booking b1) 
	{
		Optional<Booking> existing = repo1.findById(eventId);
		if(existing.isPresent())
		{
			Booking update = existing.get();
			update.setFullName(b1.getFullName());
			update.setMobileNo(b1.getMobileNo());
			update.setLocation(b1.getLocation());
			update.setStartDate(b1.getStartDate());
			update.setEndDate(b1.getEndDate());
			update.setEventLocation(b1.getEventLocation());
			update.setEventType(b1.getEventType());
			
			return "Updated successfully \n"+ repo1.save(update);
		}
		else
		{
			return "User Id not exist";
		}
		
	}

	@Override
	public List<Booking> findByCustomerId(long userId)
	{
		
		return repo1.findByCustomerUserId(userId);
	}


	@Override
	public Optional<Booking> findById(long eventId) {
		
		return repo1.findById(eventId);
	}


	@Override
	public Booking save(Booking booking) 
	{
		
		return repo1.save(booking);
	}

	

	

}
