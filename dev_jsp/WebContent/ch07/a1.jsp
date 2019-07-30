<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a1.jsp</title>
</head>
<body>
1.첫 번째 코드<br><!-- 실행순서1 -->
2.두 번째 코드<br><!-- 실행순서2 -->
<%@ include file="b1.jsp" %>
3.세 번째 코드<br><!-- 실행순서6 -->
4.네 번째 코드<br><!-- 실행순서7 -->
</body>
</html>