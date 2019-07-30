<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name="john";
	//요청 객체에 담기
	request.setAttribute("name", name);
	//response.sendRedirect("B.jsp");//이동
	//doGet(HttpServletRequest res)
	RequestDispatcher view = request.getRequestDispatcher("B.jsp");//객체를 인스턴스화 하는 코드
	view.forward(request,response);
	//주소가 변경됨 - 기존에 요청이 끊어지고 새로운 요청이 응답
	//request 객체가 같은 원본이 아니다.
%>
여기
</body>
</html>