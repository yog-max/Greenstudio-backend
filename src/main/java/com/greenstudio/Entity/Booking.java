package com.greenstudio.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Booking 
{
	@Id
	@GeneratedValue
	private long eventId;
	@Column(nullable=false)
	private String fullName;
	@Column(nullable=false)
	private long mobileNo;
	@Column(nullable=false)
	private String location;
	@Column(nullable=false)
	private String eventType;
	@Column(nullable=false)
	private LocalDate startDate;
	@Column(nullable=false)
	private LocalDate endDate;
	@Column(nullable=false)
	private String eventLocation;
	@Column(nullable=false)
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "customerId", nullable= false)
	private Customer customer;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Booking [eventId=" + eventId + ", fullName=" + fullName + ", mobileNo=" + mobileNo + ", location="
				+ location + ", eventType=" + eventType + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", eventLocation=" + eventLocation +", status=" +status + "]";
	}

	
	
	

}
