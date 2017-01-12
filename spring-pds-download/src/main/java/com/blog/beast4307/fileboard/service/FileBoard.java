package com.blog.beast4307.fileboard.service;

public class FileBoard {
	private int no;
	private String title;
	private String auth;
	private String fileName;
	private String extention;
	private String filePath;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "FileBoard [title=" + title + ", auth=" + auth + ", fileName=" + fileName + ", extention=" + extention
				+ ", filePath=" + filePath + "]";
	}
	
}
