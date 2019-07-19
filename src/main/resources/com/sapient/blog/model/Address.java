package com.sapient.blog.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Address")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String street;
	private String suite;
	private String city;
	private int zipcode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(long id,String street, String suite, String city, int zipcode) {
		super();
		this.id=id;
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode="
				+ zipcode + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
}
