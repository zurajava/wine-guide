package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="food_type", catalog = "hacatone_db")
public class FoodType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String thumb;

    public FoodType() {
    }


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getThumb() {
		return this.thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

}