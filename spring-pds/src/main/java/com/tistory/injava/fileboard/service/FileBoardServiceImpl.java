package com.tistory.injava.fileboard.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tistory.injava.controller.FileBoardController;

@Service
public class FileBoardServiceImpl implements FileBoardService{
	private static final Logger logger = LoggerFactory.getLogger(FileBoardServiceImpl.class);
	
	@Override
	public int addFileBoard(FileBoardCommand fileBoardCommand) {
		logger.info("FileBoardServiceImpl.addFileBoard");
		String path = ""; //경로
		String fileName = ""; //파일명
		File destFile = null; //
		String extention = ""; //확장자
		
		try {
			
			//파일저장하기
			MultipartFile multipartfile = fileBoardCommand.getMultipartFile();
			path = "D://workspace-sts/spring-pds/upload/"; //경로지정
			UUID uuid = UUID.randomUUID();
			fileName = uuid.toString(); //파일명생성
			int index = multipartfile.getOriginalFilename().lastIndexOf(".");
			extention=multipartfile.getOriginalFilename().substring(index+1); //확장자추출
			logger.info(extention);
			destFile = new File(path+fileName+"."+extention); // 경로+파일명+확장자로 파일생성(비어있는상태)
			
			//db에 저장할 객체
			FileBoard fileBoard = new FileBoard();
			fileBoard.setTitle(fileBoardCommand.getTitle());
			fileBoard.setAuth(fileBoardCommand.getAuth());
			fileBoard.setFilePath(path);
			fileBoard.setFileName(fileName);
			fileBoard.setExtention(extention);
			
			
			multipartfile.transferTo(destFile); //생성한 파일에 데이터 주입

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			destFile.delete();
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 0;
	}

}
