<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    /*
    쿠키값을 담은 후에 클라이언트로 컴터로 응답을 내려보내야 한다.
    다르게 말하면 쿠키에 값을 담자마자 같은 페이지에서는 그 마지막 정보는 읽을 수 없다.
    */
    String dap3 = request.getParameter("dap3");
		Cookie cookie = new Cookie("dap3",dap3);
		cookie.setMaxAge(60*10);
		cookie.setPath("/");
		//채점하는 페이지가 한 페이지 더 뒤에 있어야함.
		response.addCookie(cookie);//여기서 클라이언트쪽으로 넘어가다보니 같은 페이지에서는 3번에 대한 답이 접근이 불가능
		response.sendRedirect("account.jsp");//forward처리는 필요없다. redirect해도 10분동안은 유지됨.
%>

