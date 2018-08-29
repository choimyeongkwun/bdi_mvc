package com.bdi.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.GameService;
import com.bdi.mvc.service.impl.GameServiceImpl;
import com.bdi.mvc.vo.Game;


public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	private GameService gm = new GameServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
		if(cmd.equals("gameList")) {
			uri = "/views" + uri;
			request.setAttribute("gameList", gm.selectGameList(null));
			} else {
			}
		}catch (SQLException e) {
			e.printStackTrace();
	}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri ="/views"+request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
		if(cmd.equals("gameInsert")) {
			String gcName = request.getParameter("gcName");
			String gcVender = request.getParameter("gcVender");
			String gcDesc = request.getParameter("gcDesc");
			String gcImg = request.getParameter("gcImg");
			Game game = new Game(null, gcName, null, gcVender, null, gcDesc, gcImg);
			request.setAttribute("rMap", gm.selectGameList(game));
			} else if(cmd.equals("gameUpdate")){
			
			} else if(cmd.equals("gameDelete")) {
			}	
		}catch (SQLException e) {
			e.printStackTrace();
	}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request,response);
	}
}
