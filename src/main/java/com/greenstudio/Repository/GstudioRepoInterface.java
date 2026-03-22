package com.greenstudio.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.greenstudio.Entity.Customer;

public interface GstudioRepoInterface extends JpaRepository <Customer, Long>
{

	
	Optional<Customer> findByUserNameAndPassword(String userName, String password);

	Optional<Customer> findByUserName(String userName);

	

	

	
	
			

	
}
