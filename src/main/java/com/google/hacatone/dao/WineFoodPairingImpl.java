package com.google.hacatone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.jdbc.Work;

import com.google.hacatone.entity.WineFoodPairing;

public class WineFoodPairingImpl implements Work{

	private List<WineFoodPairing> wine;
	private int id;
	
	
	public WineFoodPairingImpl(int id) {
		this.id = id;
	}
	
	@Override
	public void execute(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM `wine_food_pairing` WHERE food_id=?");
		ps.setInt(1, this.id);
		ResultSet rs = ps.executeQuery();;
		this.wine = new ArrayList<WineFoodPairing>();
		
		while(rs.next()){
	    WineFoodPairing w = new WineFoodPairing();
		w.setWineTypeId(rs.getInt(1));
		w.setFoodTypeId(rs.getInt(2));
		wine.add(w);
		}
	}
	
	

	public List<WineFoodPairing> getWine() {
		return wine;
	}

	public void setWine(List<WineFoodPairing> wine) {
		this.wine = wine;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
