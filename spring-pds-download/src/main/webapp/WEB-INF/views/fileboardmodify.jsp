<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>fileBOARD MODIFY FORM</title>
</head>
<body>
<h1>BOARD MODIFY</h1>    
    <form enctype="multipart/form-data" action="<c:url value='/modify'/>" method="post">
        <div>boardNo</div>
        <div><input name="no" value="${fileboard.no}" type="text" readonly="readonly"/></div>
        <div>title </div>
        <div><input name="title" id="title" type="text" value="${fileboard.title}"/></div>
        <div>auth : </div>
        <div><input name="auth" value="${fileboard.auth}" id="boardTitle" type="text"/></div>
        <div>file : </div>
        <div><input type="file" name="multipartFile" id="multipartFile"/></div>
        <div>
            <input type="submit" value="글수정"/>
            <input type="reset" value="초기화"/>
        </div>
    </form>
</body>
</html>