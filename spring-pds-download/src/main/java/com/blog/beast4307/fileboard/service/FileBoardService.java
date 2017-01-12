package com.blog.beast4307.fileboard.service;

import java.util.Map;

public interface FileBoardService {
	
	////파일수정을위한 한 행의 데이터 가져오기
	FileBoard selectOneForModify(int no);
	
	//파일수정
	int modifyFileBoard(FileBoardCommand fileBoardCommand,int no);
	
	//파일삭제
	int removeFileBoard(int no);
	
	//파일등록
	int addFileBoard(FileBoardCommand fileBoardCommand);
	
	//파일리스트
	Map<String,Object> getFileBoardListCurrentPage(int currentPage);
	
}
