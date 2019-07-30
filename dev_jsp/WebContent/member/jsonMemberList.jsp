<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> memList = null;
	memList = (List<Map<String,Object>>)request.getAttribute("memList");
	String imsi = null;
	if(memList.size()>0) {
		Gson g = new Gson();
		imsi = g.toJson(memList);
		
	}
	else {
		imsi="";
	}
	out.print(imsi);
%>