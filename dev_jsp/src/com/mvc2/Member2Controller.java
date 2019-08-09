package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.MemberVO;

public class Member2Controller implements Controller {
	Logger logger = Logger.getLogger(Member2Controller.class);
	String path = null;
	String requestName = null;
	String crud = null;
	MemberLogic memLogic = null;
	public Member2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
		memLogic = new MemberLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		if("index".equals(crud)) {
			
			path="redirect:/onLineTestVer2/index.jsp";
		}
		else if("login".equals(crud)) {
			MemberVO pmVO = new MemberVO();
			//$.ajax({ url:"/member/test.mo?crud=.login&mem_id="+mem_id+"&mem_pw="+mem_pw });
			pmVO.setMem_id(req.getParameter("mem_id"));
			pmVO.setMem_pw(req.getParameter("mem_pw"));
			MemberVO rmVO = memLogic.proc_login(pmVO);
			HttpSession session = req.getSession();
			logger.info("이름 : "+rmVO.getMem_name());
			session.setAttribute("rmVO", rmVO);
			path="redirect:/onLineTestVer2/loginAccount.jsp";
			//path="redirect:/onLineTest/getSubjectList.kos";
		}
		return path;
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, String crud) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
