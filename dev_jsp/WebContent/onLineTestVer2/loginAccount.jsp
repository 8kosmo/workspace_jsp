<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO" %>    
<%
//MemberController에서 세션에 담아논 값 읽어오기
//세션값은 서버의 cache메모리에 기억되어 있어서 페이지 이동과 상관없이
//그 시간 동안은 무조건 유지 된다.
//request.getAttribute("rmVO");시간이 아니라 forward를 통해 유지
//forward의 경우 화면 호출시 파라미터에 request와 response가 담겨있다.
//서블릿에서 갹체 주입 받은 원본이므로 그 원본에서 값을 꺼내는 방식
//session의 경우 컴터의 cache메모리에 담긴 정보는 꺼내는 것이므로 어디서든 꺼낼 수 있다.
//톰캣의 경우 기본시간은 30분이고 그 시간을 연장하려면 web.xml 설정추가
	MemberVO rmVO = (MemberVO)session.getAttribute("rmVO");
	String mem_name = rmVO.getMem_name();
	//out.print(rmVO.getMem_id()+" , "+rmVO.getMem_name());
%>
     <div id="loginForm" class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-right">
          <label for="msg">
          	<font color="white"><%=mem_name %>님 환영합니다.</font>
          </label>
          <button type="button" class="btn btn-dark" onclick="logoutAction()">로그아웃</button>
        </form>
    </div>