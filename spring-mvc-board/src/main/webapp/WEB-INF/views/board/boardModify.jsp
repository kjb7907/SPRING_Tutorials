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
	<h1>BOARD MODIFY</h1>
		<form action="/board/boardModify" method="post">
			
			boardNo : ${board.boardNo}
			<div><input name="boardNo" id="boardPw" type="hidden" value = "${board.boardNo}"/></div>
			<div>boardPw : </div>
			<div><input name="boardPw" id="boardPw" type="password" value =""/></div>
			<div>boardTitle : </div>
			<div><input name="boardTitle" id="boardTitle" type="text" value = "${board.boardTitle}"/></div>
			<div>boardContent : </div>
			<div><textarea name="boardContent" id="boardContent" rows="5" cols="50">${board.boardContent}</textarea></div>
			<div>boardName : </div>
			<div><input name="boardUser" id="boardUser" type="text" value ="${board.boardUser}"/></div>
			<div>
				<input type="submit" value="글수정"/>
				<input type="reset" value="초기화"/>
			</div>
		</form>
</body>
</html>