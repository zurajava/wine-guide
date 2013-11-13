package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="gallery", catalog = "hacatone_db")
public class Gallery implements Serializable {
	private static final long serialVersionUID = 1L;
	private int galleryTypeId;
	private int id;
	private String image;
	private int objectId;
	private String thumb;

	public Gallery() {
	}

	@Id
	@Column(name = "gallery_type_id")
	public int getGalleryTypeId() {
		return this.galleryTypeId;
	}

	public void setGalleryTypeId(int galleryTypeId) {
		this.galleryTypeId = galleryTypeId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "object_id")
	public int getObjectId() {
		return this.objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getThumb() {
		return this.thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

}