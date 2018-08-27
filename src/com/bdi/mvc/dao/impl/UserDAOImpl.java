package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.vo.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> selectUserList(User us) {
		List<User> list = new ArrayList<User>();
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uiNo, uiName, uiId, uiPwd, uiDesc, uiAge, diNo from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = new User(rs.getInt("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						rs.getString("uiPwd"),
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getInt("diNo"));
				list.add(us);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBCon.close();
		}
		return null;
	}

	@Override
	public User selectUser(int uiNo) {
		
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uiNo, uiName, uiId, uiPwd, uiDesc, uiAge, diNo from user_info";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				User us = new User(rs.getInt("uiNo"),
							rs.getString("uiName"),
							rs.getString("uiId"),
							rs.getString("uiPwd"),
							rs.getString("uiDesc"),
							rs.getInt("uiAge"),
							rs.getInt("diNo"));
				return us;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBCon.close();
		}
		return null;
	}

	@Override
	public int insertUser(User us) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		String sql = "select uiNo, uiName, uiId, uiPwd, uiDesc, uiAge, diNo)";
		sql += "values(?,?,?,?,?)";
		int cnt =0;
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, us.getUino());
			ps.setString(2, us.getUiname());
			ps.setString(3, us.getUiid());
			ps.setString(4, us.getUipwd());
			ps.setString(5, us.getUidesc());
			ps.setInt(6, us.getUiage());
			ps.setInt(7, us.getDino());
			cnt +=ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int uiNo = rs.getInt(1);
				cnt += updateUserTotal(uiNo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBCon.close();
		}
		return cnt;
	}

	@Override
	public int updateUser(User us) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMaker(User us) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserTotal(int uino) {
		// TODO Auto-generated method stub
		return 0;
	}

}
