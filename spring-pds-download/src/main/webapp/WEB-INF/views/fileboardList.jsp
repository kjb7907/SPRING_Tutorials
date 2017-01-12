<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
    <div>��ü���� �� : ${totalRowCount}/${list.size()}</div>
    <table border="1">
        <thead>
            <tr>
            	<th>no</th>
                <th>Title</th>
                <th>User</th>
                <th>download</th>
                <th>����</th>
                <th>����</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="b" items="${list}">
                <tr>
                    <td>${b.no}</td>
                    <td>${b.title}</td>
                    <td>${b.auth}</td>
                    <td><a href="${b.filePath}${b.fileName}${b.extention}"download=>�ٿ�ε�</a></td>
                    <td><a href ="<%=request.getContextPath()%>/modify?no=${b.no}">����</td>
                    <td><a href ="<%=request.getContextPath()%>/fileboardDelete?no=${b.no}">����</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 
    <div>
        <a href="<%=request.getContextPath()%>/add">�Խñ� �Է�</a>
    </div>
    <div>
        <c:if test="${currentPage>1}">
            <a href="<c:url value='/board/boardList?currentPage=${currentPage-1}'/>">����</a>
        </c:if>
        <c:if test="${currentPage < lastPage}"> 
            <a href="<c:url value='/board/boardList?currentPage=${currentPage+1}'/>">����</a>
        </c:if>
 
    </div>
</body>
</html>