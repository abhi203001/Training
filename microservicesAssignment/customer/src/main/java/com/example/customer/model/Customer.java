package com.example.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tcustomers")
public class Customer {

	@Id
	private String cid;
	private String cname;
	private String email;
	private long phoneNumber;
	private Address address;

	public Customer(String cid, String cname, String email, long phoneNumber, Address address) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
	

}
