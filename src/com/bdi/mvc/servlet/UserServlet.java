package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bdi.mvc.service.UserService;
import com.bdi.mvc.service.impl.UserServiceImpl;
import com.bdi.mvc.vo.User;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us= new UserServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("userList")) {
			List<User> userList = us.getUserList(null);
			request.setAttribute("list", userList);
		}else if(cmd.equals("makerView")|| cmd.equals("makerUpdate")) {
			String uiNoStr = request.getParameter("uiNO");
			if(uiNoStr==null) {
				request.setAttribute("msg","불가");
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			int uiNo = Integer.parseInt(uiNoStr);
			request.setAttribute("User",us.getUser(uiNo));
		}else if(cmd.equals("UserUpdate")) {
			
		}else if(cmd.equals("UserDelete")) {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		if(cmd.equals("userUpdate")) {
			String uiNo = request.getParameter("uiNo");
			String uiName = request.getParameter("uiName");
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			String uiDesc= request.getParameter("uiDesc");
			String uiAge = request.getParameter("uiAge");
			String diNo = request.getParameter("diNo");
			User uk = new User(Integer.parseInt(uiNo),uiName,uiId,
					uiPwd,uiDesc,Integer.parseInt(uiAge),
					Integer.parseInt(diNo));
			request.setAttribute("rMap",us.updateUser(uk));
		}else if(cmd.equals("userInsert")) {
			String uiNo = request.getParameter("uiNo");
			String uiName = request.getParameter("uiName");
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			String uiDesc = request.getParameter("uiDesc");
			String uiAge = request.getParameter("uiAge");
			String diNo = request.getParameter("diNo");
			User uk = new User(Integer.parseInt(uiNo),uiName,uiId,
					uiPwd,uiDesc,Integer.parseInt(uiAge),
					Integer.parseInt(diNo));
			request.setAttribute("rMap",us.insertUser(uk));
			}else if(cmd.equals("userDelete")) {
				String uiNo = request.getParameter("uiNo");
				User uk = new User(Integer.parseInt(uiNo),null,null,null,null,0,0);
				request.setAttribute("rMap", us.deleteUser(uk));
				uri ="/views/user/userView";
				}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
