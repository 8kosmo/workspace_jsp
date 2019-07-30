<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc1.MemberDao, com.vo.MemberVO" %>
<%
	MemberDao mDao = new MemberDao();
	Map<String, Object> pMap = new HashMap<>();
	mDao.MY_PROC2(pMap);
	//out.print(mVO);
	//out.print("<br>");
	//ArrayList 안에는 MemberVO타입 
	//out.print(pMap);
	//out.print("<br>");
	//out.print(pMap.get("key"));
	List list = (List)pMap.get("key");
	//out.print(list.size());
	/* for(int i=0; i<list.size(); i++) {
		MemberVO mVO = (MemberVO)list.get(i);
		out.print("<br>"+mVO.getMem_name()+"<br>"+mVO.getMem_id()+"<br>"+mVO.getMem_pw()+"<br>");
	} */
	Gson g = new Gson();
	String imsi = g.toJson(list);
	out.print(imsi);
%>