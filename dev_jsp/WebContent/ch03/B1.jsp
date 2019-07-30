<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B1.jsp</title>
</head>
<body>
<%
	String name = (String)session.getAttribute("name");
	out.print(name);//여기(request)에는 name에 해당하는 값이 없다.
%>
<h3>안산불기둥</h3>
</body>
</html>