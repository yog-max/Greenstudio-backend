package com.greenstudio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenstudio.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>
{

	 Optional<Admin> findByUserName(String userName);

}
