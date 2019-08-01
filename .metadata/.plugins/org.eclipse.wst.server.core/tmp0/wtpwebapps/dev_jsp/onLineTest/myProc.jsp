<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext, javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/dbPool");
		String sql = "SELECT deptno, dname, loc from dept";
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			out.print("부서번호: "+rs.getString("deptno")+", 부서명: "+rs.getString("dname"));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
