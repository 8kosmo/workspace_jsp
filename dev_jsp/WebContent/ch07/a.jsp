<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 액션태그</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	int i=10;
	String b="안녕";
%>
1.첫 번째 코드<br><!-- 실행순서1 -->
2.두 번째 코드<br><!-- 실행순서2 -->
<jsp:include page="b.jsp" flush="false">
	<jsp:param name="p1" value="<%=i %>"/>
	<jsp:param name="mem_name" value="<%=b %>"/>
</jsp:include>
3.세 번째 코드<br><!-- 실행순서6 -->
4.네 번째 코드<br><!-- 실행순서7 -->
</body>
</html>