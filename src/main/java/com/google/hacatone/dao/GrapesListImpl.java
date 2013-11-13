package com.google.hacatone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.jdbc.Work;

import com.google.hacatone.entity.Wines;
public class GrapesListImpl implements Work{

	private List<Wines> list;
	@Override
	public void execute(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM `wines`");
		ResultSet rs = ps.executeQuery();;
		this.list = new ArrayList<Wines>();
		
		while(rs.next()){
			Wines g = new Wines();
		g.setId(rs.getInt(1));
		g.setName(rs.getString(2));
		g.setDescription(rs.getString(3));
		g.setImg(rs.getString(4));
	    g.setBirthdate(rs.getDate(5));
	    g.setOrigin(rs.getString(6));
	    g.setCategory(rs.getString(7));
	    g.setColor(rs.getString(8));
	    g.setRegion(rs.getString(9));
	    g.setRaion(rs.getString(10));
	    g.setCalories(rs.getString(11));
	    this.list.add(g);
		
		}
	}
	public List<Wines> getList() {
		return list;
	}
	public void setList(List<Wines> list) {
		this.list = list;
	}

}
