<%@page import="com.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//스크립틀릿 - 지역변수,메소드선언 불가,생성자 불가, 제어문 가능, 인스턴스화 가능
	MemberVO mVO = new MemberVO();//순제어
	mVO.setMem_id("test");
	mVO.setMem_name("실험남");
%>
<%=mVO.getMem_name() %>, <%=mVO.getMem_id() %>
<jsp:useBean id="mVO2" scope="request" class="com.vo.MemberVO"/>
<jsp:setProperty name="mVO2" property="mem_name" value="최종현"/>
아이디 : <jsp:getProperty name="mVO2" property="mem_name"/>
</body>
</html>