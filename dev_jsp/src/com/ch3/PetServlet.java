package com.ch3;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class PetServlet extends HttpServlet {
	Logger logger = Logger.getLogger(PetServlet.class);
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException{
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		StringBuffer url = req.getRequestURL();
		logger.info("url:"+uri);
		logger.info("context:"+context);
		logger.info("url:"+url);
		//애완동물 초이스 하는 페이지 처리
		if("/ch3/petChoice.do".equals(url)) {
			//주소번지를 먼저 생성하여 파라미터 타입으로 넘기고
			Map<String,Object> target = new HashMap<>();
			//공통 코드를 인스턴스화 할 때 파라미터로 req 요청 객체를 넘겨줌.
			HashMapBinder hmb = new HashMapBinder(req);
			//메소드에서 원본에 사용자가 선택한 정보 담아줌.
			hmb.bind(target);
			logger.info(target.get("name"));
			logger.info(target.get("address"));
			logger.info(target.get("pet"));
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException{
	service(req,res);
}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException{
		service(req,res);
	
	}
}