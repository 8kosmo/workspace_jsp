<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestTest.do에 대한 응답페이지임</title>
</head>
<body>
<%
	List<String> nameList =
	(List<String>)request.getAttribute("nameList");
	for(String name:nameList){
		out.print("name==>"+name);
	}
%>
</body>
</html>