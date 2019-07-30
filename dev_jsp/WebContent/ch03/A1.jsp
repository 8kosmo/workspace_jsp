<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A1.jsp</title>
</head>
<body>
<%
	String name="john";
	//요청 객체에 담기
	session.setAttribute("name", name);
	response.sendRedirect("B1.jsp");//이동
%>
여기
</body>
</html>