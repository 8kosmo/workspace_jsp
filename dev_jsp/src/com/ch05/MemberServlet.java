package com.ch05;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MemberServlet extends HttpServlet {
	Logger logger = Logger.getLogger(MemberServlet.class);
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		logger.info("service호출 성공");
		//insert here -Dao객체를 주입하시오.
		MemberDao05 memDao = new MemberDao05();
		List<Map<String,Object>> memList = memDao.memberList();
		//request는 저장소 이기도 하다
		//request저장소에 다음 땐 setAttribute 호출함.
		req.setAttribute("memList", memList);
		//이동할 페이지 이름을 작성하시오.
		RequestDispatcher view = req.getRequestDispatcher("./jsonmemberList.jsp");
			view.forward(req,res);
		}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
			service(req,res);
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
			service(req,res);
		}
}
