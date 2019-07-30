<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO" %>    
<%
//MemberController에서 세션에 담아논 값 읽어오기
//세션값은 서버의 cache메모리에 기억되어 있어서 페이지 이동과 상관없이
//그 시간 동안은 무조건 유지 된다.
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