package com.greenstudio.Entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Customer 
{

	@Id
	@GeneratedValue
	private Long userId; 
	@Column(nullable=false, unique=true)
	private String userName;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private long mobileNo;
	@Column(nullable=false)
	private String gender;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> bookings;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", userName=" + userName + ", password=" + password + ", mobileNo="
				+ mobileNo + ", gender=" + gender + ", bookings=" + bookings + "]";
	}
	
	
	
	
	
	
	
}
