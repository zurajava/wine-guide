package com.google.hacatone.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "wine_food_pairing", catalog = "hacatone_db")
public class WineFoodPairing implements Serializable {
	private static final long serialVersionUID = 1L;
	private int foodTypeId;
	private int wineTypeId;

	public WineFoodPairing() {
	}

	@Id
	@Column(name = "food_id")
	public int getFoodTypeId() {
		return this.foodTypeId;
	}

	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}

	@Column(name = "wine_id")
	public int getWineTypeId() {
		return this.wineTypeId;
	}

	public void setWineTypeId(int wineTypeId) {
		this.wineTypeId = wineTypeId;
	}

}