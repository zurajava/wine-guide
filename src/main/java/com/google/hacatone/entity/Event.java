package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="events", catalog = "hacatone_db")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private String city;
	private String country;
	private String description;
	private Date endDate;
	private String mail;
	private String name;
	private String organizer;
	private String phone;
	private Date startDate;
	private String img;
    public Event() {
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


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="end_date")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="start_date")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name="img")
	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}

}