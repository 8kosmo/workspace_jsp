<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> designList = null;
	designList = (List<Map<String,Object>>)request.getAttribute("designList");
	String imsi = null;
	if(designList.size()>0) {
		Gson g = new Gson();
		imsi = g.toJson(designList);
		
	}
	else {
		imsi="";
	}
	out.print(imsi);
%>