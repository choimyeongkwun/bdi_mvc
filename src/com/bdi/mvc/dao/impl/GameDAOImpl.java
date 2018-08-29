package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.dao.GameDAO;
import com.bdi.mvc.vo.Game;

public class GameDAOImpl implements GameDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con=con;
	}

	@Override
	public List<Game> selectGameList(Game game) throws SQLException {
			String sql = "select * from game_chart";
			List<Game> gameList = new ArrayList<Game>();
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			while(rs.next()) {
				Game gm = new Game(rs.getInt("gcNo"),rs.getString("gcName"),
						rs.getInt("gcPrice"),rs.getString("gcvender"),
						rs.getInt("geOrder"),rs.getString("gcDesc"),rs.getString("gcImg"));
				gameList.add(gm);
			}
			}catch(SQLException e) {
				throw e;
			}
			return gameList;
	}

	@Override
	public Game selectGame(Game game) throws SQLException {
		String sql = "select * from game_chart where gcNo=?";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Game gm = new Game(rs.getInt("gcNo"),rs.getString("gcName"),
						rs.getInt("gcPrice"),rs.getString("gcVender"),
						rs.getInt("gcOrder"),rs.getString("gcDesc"),rs.getString("gcImg"));
				return gm;
			}
			}catch(SQLException e) {
				throw e;
			}
			return null;
	}

	@Override
	public int insertGame(Game game) throws SQLException {
		String sql = "insert into Game_chart(gcName,gcVender,gcDesc,gcImg)";
		sql +=" values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, game.getGcName());
			ps.setString(2, game.getGcvender());
			ps.setString(3, game.getGcDesc());
			ps.setString(4, game.getGcImg());
			return ps.executeUpdate();
		
		}catch(SQLException e) {
			throw e;
		}
	}
				
			}