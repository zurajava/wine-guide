package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="favorites", catalog = "hacatone_db")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date registerDate;
	private String userId;
	private int wineId;

    public Favorite() {
    }


    public Favorite(String userId, int wineId,Date registerDate) {
		this.registerDate = registerDate;
		this.userId = userId;
		this.wineId = wineId;
	}


	@Temporal( TemporalType.DATE)
	@Column(name="register_date")
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Id
	@Column(name="user_id")
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Column(name="wine_id")
	public int getWineId() {
		return this.wineId;
	}

	public void setWineId(int wineId) {
		this.wineId = wineId;
	}

}