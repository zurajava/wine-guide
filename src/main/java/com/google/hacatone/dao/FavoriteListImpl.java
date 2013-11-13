package com.google.hacatone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.jdbc.Work;

import com.google.hacatone.entity.Favorite;

public class FavoriteListImpl implements Work {

	private List<Favorite> list;
	private String userId;

	public FavoriteListImpl(String userId) {
		this.userId = userId;
	}

	@Override
	public void execute(Connection connection) throws SQLException {
		PreparedStatement ps = connection
				.prepareStatement("SELECT * FROM `favorites` WHERE `user_id`=?");
		ps.setString(1, this.getUserId());
		ResultSet rs = ps.executeQuery();
		;
		this.list = new ArrayList<Favorite>();

		while (rs.next()) {
			Favorite g = new Favorite();
			g.setUserId(rs.getString(1));
			g.setWineId(rs.getInt(2));
			g.setRegisterDate(rs.getDate(3));
			this.list.add(g);

		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Favorite> getList() {
		return list;
	}

	public void setList(List<Favorite> list) {
		this.list = list;
	}

}
