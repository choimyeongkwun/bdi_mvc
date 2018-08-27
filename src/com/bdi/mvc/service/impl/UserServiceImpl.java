package com.bdi.mvc.service.impl;

import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.dao.impl.UserDAOImpl;
import com.bdi.mvc.service.UserService;
import com.bdi.mvc.vo.User;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	@Override
	public List<User> getUserList(User us) {
		return udao.selectUserList(us);
	}

	@Override
	public User getUser(int uiNo) {
		// TODO Auto-generated method stub
		return udao.selectUser(uiNo);
	}

	@Override
	public Map<String, Object> insertUser(User us) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateUser(User us) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> deleteUser(User us) {
		// TODO Auto-generated method stub
		return null;
	}

}
