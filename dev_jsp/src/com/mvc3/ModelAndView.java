package com.mvc3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndView {
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	String viewName = null;
	//forward시 유지할 정보를 담을 list
	List<Map<String, Object>> reqList = new ArrayList<>();
	//페이지 이동처리는 ActionServletVer3에서 처리함.
	public ModelAndView() {
	}
	//만일 니가 여기서 페이지 이동 처리를 한다면 아래 생성자
	public ModelAndView(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
	}
	public void setViewName(String viewName) {
	//==>/test/XXX.mvc?crud=XXX
	//    board/boardList.jsp
	//	 /test/board/boardList.jsp	==> 404
	//	viewName = "../"+viewName;//페이지 이름을 줄 때는 루트패스를 떼고 이름만 작성
		this.viewName = viewName;
	}
	//select한 결과를 응답페이지에 넘길 때 List컬렉션을 담아주어야 함.
	/*
	 * ModelAndView mav = new ModelAndView();
	 * mav.setViewName("board/boardList.jsp");//forward만 처리함.
	 * mav.addObject("list",list);
	 */
	public void addObject(String name, Object obj) {
		/*
		 * 응답페이지에 담을 정보가 2개 이상일 때
		 * req.setAttribute("list",list);
		 * req.setAttribute("list2",boardList);
		 */
		Map<String, Object> rMap = new HashMap<>();
		rMap.put(name,obj);
		reqList.add(rMap);
	}
}
