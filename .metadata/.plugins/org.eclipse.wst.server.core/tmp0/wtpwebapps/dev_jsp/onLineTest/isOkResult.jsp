<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//시나리오 단위테스트
//http://localhost:8000/onLineTest/isOk.kos?work=onLineTest&mem_id=test&exam_no=1907250002
	String msg = (String)request.getAttribute("msg");
	out.clear();
	out.print(msg);//'승인' or '확인불가'
%>