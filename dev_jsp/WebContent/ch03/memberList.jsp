<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
이 페이지는 dev_jsp풀더 밑에 ch03 밑에 있다.
이것을 요청하면 톰캣 서버는 자신이 바라보는 경로에서 해당 페이지를 찾음.
XXX_jsp.java 변환 -> XXX_jsp.class 컴파일  -> 실행 -> 태그생성
생성된 태그와 아래 태그들을 개인 컴퓨터에 다운로드 
사용자의 브라우저를 통해서 출력
*/
	String name = "이순신";
	out.print("너의 이름:"+name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var s_name = '김유신';
	
	s_name = '<%=name%>';
</script>
</head>
<body>
여기는 html영역입니다.
<div id='d_msg'></div>
<script type="text/javascript">
	s_name = '<%=name%>';
/*
  익스프레션에 출력된 정보는 항상 고정값이다.
  이미 서버에서 실행된 결과가 넘어오니까. 유연하게 바뀔 수 없다.
 */
	document.getElementById("d_msg").innerHTML=s_name;
</script>
</body>
</html>