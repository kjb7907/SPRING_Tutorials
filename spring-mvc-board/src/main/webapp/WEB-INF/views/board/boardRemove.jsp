<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BOARD REMOVE</h1>
	삭제할 글 번호 ${boardNo}</br>
	비밀번호 입력</br>
	<form action = "/board/boardRemove" method = "post">
		<input type = "hidden" value = "${boardNo}" name = "boardNo">
		<input type = "text" name = "boardPw"></br>
		<input type = "submit">
	</form>

</body>
</html>