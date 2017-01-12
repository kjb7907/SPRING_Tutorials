package com.blog.beast4307.fileboard.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileBoardServiceImpl implements FileBoardService {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardServiceImpl.class);
	@Autowired
	private FileBoardDaoImpl fileBoardDaoImpl;
	
	//파일리스트
	@Override
	public Map<String, Object> getFileBoardListCurrentPage(int currentPage) {
		
		//pagePerRow, beginRow
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		
		//totalCount
		int totalRowCount = fileBoardDaoImpl.selectTotalFileBoardCount();	
		//lastPage
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("pagePerRow", pagePerRow);
		map.put("beginRow", beginRow);
		List<FileBoard> list = fileBoardDaoImpl.selectFileBoardPerPage(map);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		
		return returnMap;

	}
	
	//파일입력처리
	public int addFileBoard(FileBoardCommand fileBoardCommand){
		String realPath="D:/Jnnam/workspace-sts/FTPserver/WebContent/upload/"; //파일저장경로
		String path="http://localhost/FTPserver/upload/"; //DB에입력되는경로
		String fileName ="";
		File destFile = null;
		String extention="";
		FileBoard fileBoard = new FileBoard();
		try {
			//1.디렉토리 저장
			
			//파일명
			MultipartFile multipartFile = fileBoardCommand.getMultipartFile();
			UUID uuid = UUID.randomUUID();
			fileName =uuid.toString().replace("-","");
			
			//확장자 추출
			int index = multipartFile.getOriginalFilename().lastIndexOf(".");
			extention ="."+ multipartFile.getOriginalFilename().substring(index+1);
			
			
			//2. FileBoardcommand -> FileBoard -> DAO
			
			fileBoard.setTitle(fileBoardCommand.getTitle());
			fileBoard.setAuth(fileBoardCommand.getAuth());
			fileBoard.setFilePath(path);
			fileBoard.setFileName(fileName);
			fileBoard.setExtention(extention);
			
			destFile = new File(realPath+fileName+extention);
			multipartFile.transferTo(destFile);
			logger.info("{}",fileBoard.toString());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			destFile.delete();
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			destFile.delete();
			e.printStackTrace();
		}

		return fileBoardDaoImpl.insertBoardData(fileBoard);
	}
	
	//파일수정
	@Override
	public int modifyFileBoard(FileBoardCommand fileBoardCommand,int no) {
		String realPath="D:/Jnnam/workspace-sts/FTPserver/WebContent/upload/"; //파일저장경로
		String path="http://localhost/FTPserver/upload/"; //DB에입력되는경로
		String fileName ="";
		File destFile = null;
		String extention="";
		FileBoard fileBoard = new FileBoard();
		
		//파일 교체를위한 기존파일 삭제작업

		//1.db에서 파일no에 해당하는 행 가져오기
		fileBoard = fileBoardDaoImpl.selectOne(no);
		
		fileName=fileBoard.getFileName();
		extention = fileBoard.getExtention();

		destFile = new File(realPath+fileName+extention);
		destFile.delete();//삭제

		
		//새로운파일업로드작업
		try {
			//1.디렉토리 저장
			//파일명
			MultipartFile multipartFile = fileBoardCommand.getMultipartFile();
			UUID uuid = UUID.randomUUID();
			fileName =uuid.toString().replace("-","");
			
			//확장자 추출
			int index = multipartFile.getOriginalFilename().lastIndexOf(".");
			extention ="."+ multipartFile.getOriginalFilename().substring(index+1);
			
			
			//2. FileBoardcommand -> FileBoard -> DAO
			
			fileBoard.setTitle(fileBoardCommand.getTitle());
			fileBoard.setAuth(fileBoardCommand.getAuth());
			fileBoard.setFilePath(path);
			fileBoard.setFileName(fileName);
			fileBoard.setExtention(extention);
			
			destFile = new File(realPath+fileName+extention);
			multipartFile.transferTo(destFile);
			logger.info("{}",fileBoard.toString());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			destFile.delete();
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			destFile.delete();
			e.printStackTrace();
		}

		return fileBoardDaoImpl.updateFileBoard(fileBoard);
	}
	

	//파일삭제
	@Override
	public int removeFileBoard(int no) {
		String realPath="D:/Jnnam/workspace-sts/FTPserver/WebContent/upload/"; //파일삭제경로
		String fileName ="";
		String extention="";
		File destFile = null;
		
		//1.db에서 파일no에 해당하는 행 가져오기
		FileBoard fileBoard = fileBoardDaoImpl.selectOne(no);
		
		fileName=fileBoard.getFileName();
		extention = fileBoard.getExtention();

		destFile = new File(realPath+fileName+extention);
		destFile.delete();//삭제

		return fileBoardDaoImpl.deleteFileBoard(fileBoard);
	}

	
	//파일수정을위한 한 행의 데이터 가져오기
	@Override
	public FileBoard selectOneForModify(int no) {
		return fileBoardDaoImpl.selectOne(no);
	}
	
	
}

