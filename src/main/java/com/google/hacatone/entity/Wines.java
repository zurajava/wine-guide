package com.google.hacatone.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "wines", catalog = "hacatone_db")
public class Wines implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String name;
	private String description;
	private String img;
	private Date birthdate;
	private String origin;
	private String category;
	private String color;
	private String region;
	private String raion;
	private String calories;
    private boolean isFavorite=false;
	
	public Wines() {
	}

	public Wines(String name, String description, String category) {
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public Wines(String name, String description, Date birthdate, String origin, String category, String color, String region, String raion,
			String calories) {
		this.name = name;
		this.description = description;
		this.birthdate = birthdate;
		this.origin = origin;
		this.category = category;
		this.color = color;
		this.region = region;
		this.raion = raion;
		this.calories = calories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "img", nullable = false, length = 1000)
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthdate", length = 19)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "origin", length = 150)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Column(name = "category", nullable = false, length = 150)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "color", length = 150)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "region", length = 150)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "raion", length = 150)
	public String getRaion() {
		return this.raion;
	}

	public void setRaion(String raion) {
		this.raion = raion;
	}

	@Column(name = "calories", length = 20)
	public String getCalories() {
		return this.calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}
    @Transient
	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

}
