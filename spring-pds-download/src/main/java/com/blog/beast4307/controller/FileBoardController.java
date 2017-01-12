package com.blog.beast4307.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.beast4307.fileboard.service.FileBoard;
import com.blog.beast4307.fileboard.service.FileBoardCommand;
import com.blog.beast4307.fileboard.service.FileBoardDao;
import com.blog.beast4307.fileboard.service.FileBoardServiceImpl;

@Controller
public class FileBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileBoardController.class);
	
	@Autowired
	private FileBoardServiceImpl fileBoardService;
	
	//파일수정폼
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(Model model,@RequestParam(value = "no") int no) {
		FileBoard fileBoard = fileBoardService.selectOneForModify(no);
		model.addAttribute("fileboard",fileBoard);
		return "fileboardmodify";
	}
	//파일수정처리
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(FileBoardCommand fileBoardCommand,
			@RequestParam(value = "no") int no){
		fileBoardService.modifyFileBoard(fileBoardCommand, no);
		return "redirect:/fileboardList";
	}
	//파일리스트
	@RequestMapping(value="/fileboardList")
	public String fileList(Model model,
			@RequestParam(value = "currentPage",defaultValue="1") int currentPage){
		Map<String,Object> returnMap = fileBoardService.getFileBoardListCurrentPage(currentPage);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("totalRowCount",returnMap.get("totalRowCount"));
		model.addAttribute("lastPage",returnMap.get("lastPage"));
		model.addAttribute("list",returnMap.get("list"));
		return "/fileboardList";
	}
	//파일 입력폼
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {

		return "add";
	}
	//파일입력처리
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(FileBoardCommand fileBoardCommand) {
		logger.debug(fileBoardCommand.toString());
		fileBoardService.addFileBoard(fileBoardCommand);
		return "redirect:/fileboardList";
	}
	
	//파일삭제
	@RequestMapping(value="/fileboardDelete")
	public String fileDelete(@RequestParam(value = "no") int no){
		fileBoardService.removeFileBoard(no);
		return "redirect:/fileboardList";
	}
}
