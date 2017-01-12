package com.blog.beast4307.fileboard.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileBoardDaoImpl implements FileBoardDao {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardDaoImpl.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String BOARD_NS = "com.blog.beast4307.TestMapper.";
	
	//파일입력
	@Override
	public int insertBoardData(FileBoard fileBoard) {
		logger.info("insert");
		// TODO Auto-generated method stub
		return sqlSession.insert(BOARD_NS+"dataInsert", fileBoard);
	}

	//파일수정
	@Override
	public int updateFileBoard(FileBoard fileBoard) {
		
		return sqlSession.update(BOARD_NS+"updateFileBoard",fileBoard);
	}
	//파일삭제
	@Override
	public int deleteFileBoard(FileBoard fileBoard) {
		
		return sqlSession.delete(BOARD_NS+"deleteFileBoard",fileBoard);
	}
	
	//전체 행 수
	@Override
	public int selectTotalFileBoardCount() {

		return sqlSession.selectOne(BOARD_NS+"selectTotalBoardCount");
	}

	//파일리스트
	@Override
	public List<FileBoard> selectFileBoardPerPage(Map<String, Integer> map) {

		return sqlSession.selectList(BOARD_NS+"selectFileBoardListPerPage",map);
	}

	
	
	//하나의 행 가져오기
	@Override
	public FileBoard selectOne(int no) {

		
		return sqlSession.selectOne(BOARD_NS+"selectOne",no);
	}

	

}
