<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html땅 -->
<%!
/* 자바땅 */
//디클러레이션 안에다 변수 선언하면 전변이다!
	int i;
	public String methodA(int i){
		i = 100;
		return "hello";
	}
%>
<%
	 String insa = methodA(10);
	 out.print("insa:"+insa+"<hr>");
//스크립틀릿 안에다 변수 선언하면 지역변수이다 !
 	String name;//지변
 	name="이성계";
	out.print(name);//이성계
	out.print("<br>");
	out.print(i);//0
%>
<%="문자열"%>

</body>
</html>