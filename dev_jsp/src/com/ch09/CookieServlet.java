package com.ch09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ch05.MemberServlet;

public class CookieServlet extends HttpServlet {
	Logger logger = Logger.getLogger(MemberServlet.class);
	public void doGet
	(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doservice(req, res);
	}
	public void doPost
	(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{		
		doservice(req, res);
	}
	private void doservice
	(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		String db_id = "test";
		String db_pw = "123";
		String db_name = "김유신";
		
		if((db_id.equals(mem_id))&&(db_pw.equals(mem_pw))) {
			Cookie cookie = new Cookie("c_name", db_name);
			cookie.setMaxAge(60*30);
			cookie.setPath("/");
			res.addCookie(cookie);
		}
		res.sendRedirect("layout_1.jsp");
		
	}
}
