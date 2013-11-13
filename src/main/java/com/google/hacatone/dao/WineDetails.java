package com.google.hacatone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.jdbc.Work;
import com.google.hacatone.entity.Wines;

public class WineDetails implements Work{

	private Wines wine;
	private int id;
	
	
	public WineDetails(int id) {
		this.id = id;
	}
	
	@Override
	public void execute(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM `wines` where id=?");
		ps.setInt(1, this.id);
		ResultSet rs = ps.executeQuery();;
		
		while(rs.next()){
		this.wine = new Wines();
		wine.setId(rs.getInt(1));
		wine.setName(rs.getString(2));
		wine.setDescription(rs.getString(3));
		wine.setImg(rs.getString(4));
		wine.setBirthdate(rs.getDate(5));
		wine.setOrigin(rs.getString(6));
		wine.setCategory(rs.getString(7));
		wine.setColor(rs.getString(8));
		wine.setRegion(rs.getString(9));
		wine.setRaion(rs.getString(10));
		wine.setCalories(rs.getString(11));
		}
	}
	public Wines getWine() {
		return wine;
	}
	public void setWine(Wines wine) {
		this.wine = wine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
