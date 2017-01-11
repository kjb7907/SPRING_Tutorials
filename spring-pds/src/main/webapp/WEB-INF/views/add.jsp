<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 입력</h1>
	<form action ="add" enctype = "multipart/form-data" method="post">
		<div>
			<lebel for="">TITLE</lebel>
			<input type = "text" name = "title" id ="title">
		</div>
		<div>
			<lebel for="">AUTH</lebel>
			<input type = "text" name = "auth" id ="auth">
		</div>
		<div>
			<lebel for="">file</lebel>
			<input type = "file" name = "multipartFile" id =" multipartFile">
		</div>
		<div><button>파일입력</button></div>
	</form>
</body>
</html>