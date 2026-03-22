package com.greenstudio.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greenstudio.Entity.Booking;
import com.greenstudio.Entity.Customer;

public interface YstudioRepoInterface extends JpaRepository<Booking,Long>
{

	
	List<Booking> findByCustomerUserId(long userId);

	@Query("SELECT b FROM Booking b WHERE b.startDate <= :endDate AND b.endDate >= :startDate")
	List<Booking> findConflictingBookings(LocalDate startDate, LocalDate endDate);

	
}
