package com.naver.blog.service;

import java.util.Map;

public interface BoardService {
		Board boardView(int boardNo);
		public int addBoard(Board board);
		Map<String, Object> getBoardListPerCurrentPage(int currentPage);
	}

