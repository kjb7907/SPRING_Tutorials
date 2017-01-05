package com.naver.blog.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	
	int deleteBoard(Board board);
	Board selectBoardView(int boardNo);
	int insertBoard(Board board);
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);
}
