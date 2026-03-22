package com.greenstudio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.greenstudio.Entity.Customer;


public interface GstudioServiceInterface {

	Customer save(Customer c1);

	List<Customer> findAll();

	String deleteById(long userId);

	String updateById(long userId, Customer c1);

	Optional<Customer> findById(long userId);

	Optional<Customer> login(String userName, String password);

	String forgetPassword(String userName, String string);

	

	

	
	

}
