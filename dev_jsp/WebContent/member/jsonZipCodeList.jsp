<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.ZipCodeVO" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<ZipCodeVO> zipList = null;
	zipList = (List<ZipCodeVO>)request.getAttribute("zipList");
	String imsi = null;
	if(zipList.size()>0) {
		Gson g = new Gson();
		imsi = g.toJson(zipList);
		
	}
	else {
		imsi="";
	}
	out.print(imsi);
%>