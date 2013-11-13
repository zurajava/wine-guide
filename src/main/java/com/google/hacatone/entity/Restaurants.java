package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="restaurants", catalog = "hacatone_db")
public class Restaurants implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private String city;
	private String country;
	private String latitude;
	private String longitude;
	private String name;
	private String phone;

    public Restaurants() {
    }


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}