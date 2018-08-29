package com.bdi.mvc.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.GameDAO;
import com.bdi.mvc.dao.impl.GameDAOImpl;
import com.bdi.mvc.service.GameService;
import com.bdi.mvc.vo.Game;

public class GameServiceImpl implements GameService {
	GameDAO  gdao = new GameDAOImpl();
	@Override
	public List<Game> selectGameList(Game game) throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			return gdao.selectGameList(null);
			} catch(SQLException e) {
					throw e;
			}finally {
					DBCon.close();
			}
		
	}
	@Override
	public Map<String, Object> insertGame(Game game) throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			int cnt =gdao.insertGame(game);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "저장이 실패했어여");
			if(cnt==1) {
				rMap.put("msg", "저장 성공~");
				}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
