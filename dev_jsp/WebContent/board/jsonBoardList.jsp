<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> boardList = (List<Map<String,Object>>)request.getAttribute("boardList");
	String result = null;
	if(boardList.size()>0) {
		Gson g = new Gson();
		result = g.toJson(boardList);//toJson -  주소번지만 끌고 오는 Override메소드
	}
	else {
		result="";
	}
	out.print(result);
%>