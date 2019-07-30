<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="mvo" scope="request" class="com.vo.MemberVO"/>
<%
	mvo.setMem_id("apple");
	mvo.setMem_name("이순신");
%>
<%=mvo.getMem_id() %>
<%=mvo.getMem_name() %>
<%
	request.setAttribute("mvo", mvo);
%>
<jsp:forward page="b.jsp"/>
<%
	//RequestDispatcher view = request.getRequestDispatcher("b.jsp");
	//view.forward(request, response);
%>
</body>
</html>