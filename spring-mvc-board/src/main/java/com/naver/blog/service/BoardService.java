package com.naver.blog.service;

import java.util.Map;

public interface BoardService {
		
		int modifyBoard(Board board); //수정
		int removeBoard(Board board); //삭제
		Board boardView(int boardNo); // 뷰
		int addBoard(Board board); //추가
		Map<String, Object> getBoardListPerCurrentPage(int currentPage); //리스트
	}

