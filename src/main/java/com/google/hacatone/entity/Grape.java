package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grapes database table.
 * 
 */
@Entity
@Table(name="grapes", catalog = "hacatone_db")
public class Grape implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String color;
	private String description;
	private String name;
	private String thumb;

    public Grape() {
    }


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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