package com.greenstudio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenstudio.Entity.Customer;
import com.greenstudio.Repository.GstudioRepoInterface;

@Service
public class GstudioServiceInterfaceImpl implements GstudioServiceInterface
{
	
	@Autowired
	GstudioRepoInterface repo;
	
	
	public Customer save(Customer c1)
	{
		return repo.save(c1);
		
	}
	
	public List<Customer> findAll() 
	{
		
		return repo.findAll();
	}
	
	@Override
	public String deleteById(long userId) 
	{
		if(repo.existsById(userId))
		{
		 repo.deleteById(userId);
		 return "deleted successfully "+userId;
		}
		else
			return "the "+userId+" user id doesn't exist";
	}


	public String updateById(long userId, Customer update) 
	{
		
		Optional <Customer> opt = repo.findById(userId);
		if(opt.isPresent())
		{
			Customer existing = opt.get();
			existing.setUserName(update.getUserName());
			existing.setPassword(update.getPassword());
			existing.setMobileNo(update.getMobileNo());
			existing.setGender(update.getGender());
			
			return "updated existing user "+repo.save(existing);	
		}
		else
		{
			return "user not exist";
		}
	}

	@Override
	public Optional<Customer> findById(long userId) {
		
		return repo.findById(userId);
	}

	public Optional<Customer> login(String userName, String password)
	{
        return repo.findByUserNameAndPassword(userName, password);
    }

	@Override
	public String forgetPassword(String userName, String password)
	{
		Optional<Customer> exist = repo.findByUserName(userName);
		
		if(exist.isPresent())
		{
			Customer modify = exist.get();
			modify.setPassword(password);
			repo.save(modify);
			return "password modified successfully";
		}
		else
		{
			return "user does not exist";
		}
		
	}

	
	
	

	
	
}
