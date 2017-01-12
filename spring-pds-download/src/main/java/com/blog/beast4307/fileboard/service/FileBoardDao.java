package com.blog.beast4307.fileboard.service;

import java.util.List;
import java.util.Map;

public interface FileBoardDao {
	
	//파일수정
	int updateFileBoard(FileBoard fileBoard);
	//하나의 행 가져오기
	FileBoard selectOne(int no);
	//파일삭제
	int deleteFileBoard(FileBoard fileBoard);
	//파일등록
	int insertBoardData(FileBoard fileBoard);
	//파일전체행수
	int selectTotalFileBoardCount();
	//파일리스트
	List<FileBoard> selectFileBoardPerPage(Map<String,Integer> map);

}
