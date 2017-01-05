package com.naver.blog.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {

	Board selectBoardView(int boardNo);
	int insertBoard(Board board);
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);
}
