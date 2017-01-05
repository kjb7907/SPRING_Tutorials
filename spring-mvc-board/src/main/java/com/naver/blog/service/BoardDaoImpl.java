package com.naver.blog.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String BOARD_NS = "com.naver.blog.BoardMapper.";
	
	@Override
	public int deleteBoard(Board board) {
		System.out.println("dao deleteBoard");
		System.out.println(board.getBoardNo()+" "+board.getBoardPw());
		return sqlSession.delete(BOARD_NS+"deleteBoard", board);
	}

	@Override
	public Board selectBoardView(int boardNo) {
		System.out.println("selectelectBoardView");
		return sqlSession.selectOne(BOARD_NS+"selectBoardView",boardNo);
	}
	
	@Override
	public int selectTotalBoardCount() {
		System.out.println("selectTotalBoardCount");
		return sqlSession.selectOne(BOARD_NS+"selectTotalBoardCount");
	}

	@Override
	public int insertBoard(Board board) {
		System.out.println(board.toString());
		System.out.println("boardAdd");
		return sqlSession.insert(BOARD_NS+"boardAdd", board);
	}

	@Override
	public List<Board> selectBoardListPerPage(Map<String, Integer> map) {
		System.out.println("selectListPerPage");
		return sqlSession.selectList(BOARD_NS+"selectBoardListPerPage",map);
	}

}
