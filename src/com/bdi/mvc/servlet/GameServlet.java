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
		String uri = "/views"+request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);		
		request.setCharacterEncoding("utf-8");
		try {
		if(cmd.equals("gameList")) {
			request.setAttribute("gameList", gm.selectGameList(null));
			} else if(cmd.equals("gameView")|| cmd.equals("gameUpdate")){
				String gcNumStr = request.getParameter("gcNum");
				Game game = new Game();
				game.setGcNum(Integer.parseInt(gcNumStr));
				request.setAttribute("game", gm.selectGame(game));
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
		request.setCharacterEncoding("utf-8");
		try {
		if(cmd.equals("gameInsert")) {
			String gcName = request.getParameter("gcName");
			String gcVendor = request.getParameter("gcVendor");
			String gcDesc = request.getParameter("gcDesc");
			String gcImg = request.getParameter("gcImg");
			Game game = new Game(null, gcName, null, gcVendor, null, gcDesc, gcImg);
			request.setAttribute("rMap", gm.insertGame(game));
			} else if(cmd.equals("gameUpdate")){
				String gcName = request.getParameter("gcName");
				String gcVendor = request.getParameter("gcVendor");
				String gcDesc = request.getParameter("gcDesc");
				String gcImg = request.getParameter("gcImg");
				Game game = new Game(Integer.parseInt(request.getParameter("gcNum")),gcName,null, gcVendor, null, gcDesc, gcImg);
				request.setAttribute("rMap", gm.updateGame(game));
			} else if(cmd.equals("gameDelete")) {
				Game game = new Game(Integer.parseInt(request.getParameter("gcNum")),null,null, null, null, null, null);
				request.setAttribute("rMap", gm.deleteGame(game));
			}	
		}catch (SQLException e) {
			e.printStackTrace();
	}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request,response);
	}
}
