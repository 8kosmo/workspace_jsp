<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Map" %>
<%
/*
	테스트 시나리오 - 사용자 메뉴얼
	1.memberList.do - Memberservlet을 경유 - memberDao경유 - list받음 forward가 실행됨.
	2.memberList.jsp(X) - null을 만나게 된다.
*/
//jsp과목 - 50%가 DB연동
	List<Map<String,Object>> memList =
		(List<Map<String,Object>>)request.getAttribute("memList");
	int size= 0;
	if(memList!=null){
		size = memList.size();//이순간에 NullPointerException 의심 if문 작성
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<!-- 조회결과가 있니? -> if문 생각해야한다. -->
<!-- 조회결과가 있다면 반복문 처리해야함. -->
	<table width="400px" border="1">
		<thead>
		<tr><th>아이디</th><th>비번</th><th>이름</th></tr>
		</thead>

<%
	if(size>0){
	for(int i=0;i<size;i++){
		Map<String,Object> rMap = memList.get(i);
%>
		<!-- 데이터 출력 - <tr><td> -->
		<tr>
			<td><%=rMap.get("mem_id") %></td>
			<td><%=rMap.get("mem_id") %></td>
			<td><%=rMap.get("mem_id") %></td>
		</tr>
<%		
	}
%>

<%
	}else{
%>
<!-- html땅 -->
		<tr>
			<td colspan = "3">조회결과가 없습니다.</td>
		</tr>
<%
	}
%>
</table>
<!-- 조회 결과가 없을땐 조회결과가 없습니다. 출력하기 -->
</body>
</html>