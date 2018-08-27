package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		return list;
	}

	@Override
	public User selectUser(int uiNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(User us) {
		// TODO Auto-generated method stub
		return 0;
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

}
