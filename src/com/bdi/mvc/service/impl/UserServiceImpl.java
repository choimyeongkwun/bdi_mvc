package com.bdi.mvc.service.impl;

import java.util.HashMap;
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
		Map<String,Object> rUser = new HashMap<String,Object>();
		rUser.put("msg","메이커 등록 오류!");
		rUser.put("success","false");
		if(udao.insertUser(us)==2) {
			rUser.put("msg","정상적으로 등록 되었습니다.");
			rUser.put("success","true");
		}
		return rUser;
	}

	@Override
	public Map<String, Object> updateUser(User us) {
		Map<String, Object> rUser = new HashMap<String,Object>();
		rUser.put("msg", "수정 실패");
		rUser.put("success", "false");
		int cnt = udao.updateUser(us);
		if(cnt==1) {
			if(udao.updateUserTotal(us.getUino())==1) {
				rUser.put("msg", "수정 성공");
				rUser.put("success", "true");
			}
		}
		return rUser;
	}
	@Override
	public Map<String, Object> deleteUser(User us) {
		Map<String,Object> rUser = new HashMap<String,Object>();
		rUser.put("msg","실패");
		rUser.put("seccess", "false");
		int cnt = udao.deleteMaker(us);
		if(cnt==1) {
			rUser.put("msg","삭제성공");
			rUser.put("success","true");
		}
		
		return rUser;
	}

}
