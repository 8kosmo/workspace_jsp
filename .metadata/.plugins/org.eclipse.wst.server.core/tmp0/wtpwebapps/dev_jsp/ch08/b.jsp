<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO mvo = (MemberVO)request.getAttribute("mvo");
	out.print(mvo.getMem_id());
	out.print("<br>");
	out.print(mvo.getMem_name());
	out.print("<br>");
	out.print(mvo.getMem_name());
%>

</body>
</html>