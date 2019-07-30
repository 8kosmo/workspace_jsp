<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String menu = request.getParameter("menu");
 	out.print(menu);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오른쪽허당이왼쪽비실이</title>
</head>
<body>
<table border="0" width="1000px"  height="480px">
<!-- top 영역  -->
<tr>
	<td>
	<jsp:include page="top.jsp" flush="false"/>
	</td>
</tr>
<!-- body 영역  -->
 <tr>
	<td>
	<table border="1" width="1000px" height="400px">
		<tr>
<!-- menu 영역 -->
		<td width="200px" height="400px">
		<!-- 메뉴에는 로그인, 온라인 시험, 게시판 -->
		<jsp:include page="menu.jsp" flush="false"/>
		</td>
<!-- main 영역 -->
		<td  width="800px" height="400px"> 
		
<%
	if("login".equals(menu)){
%>		
		<jsp:include page="login.jsp" flush="false"/>
<%
	}
	else if("test".equals(menu)){
%>
		<jsp:include page="test.jsp" flush="false"/>
<%
	}
	else if("board".equals(menu)){
%>
		<jsp:include page="board.jsp" flush="false"/>

<%
	}
%>
			</td>
			</tr>
		</table>
		</td>
	</tr>
<!-- bottom 영역 -->
<tr>
	<td>
	<jsp:include page="bottom.jsp" flush="false"/>
	</td>
</tr>
</table>
</body>
</html>