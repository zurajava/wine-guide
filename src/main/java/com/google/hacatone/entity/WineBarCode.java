package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="wine_barcode", catalog = "hacatone_db")
public class WineBarCode implements Serializable {
	private static final long serialVersionUID = 1L;
	private String wine_id;
	private String bar_code;

    public WineBarCode() {
    }
    @Id
    @Column(name = "wine_id")
	public String getWine_id() {
		return wine_id;
	}

	public void setWine_id(String wine_id) {
		this.wine_id = wine_id;
	}
	@Column(name = "bar_code")
	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	
	

}