package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="foods", catalog = "hacatone_db")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String thumb;
	private int type_id;

    public Food() {
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


	public int getType_id() {
		return type_id;
	}


	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

}