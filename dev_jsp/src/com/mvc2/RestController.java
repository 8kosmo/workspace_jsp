package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String jsonStr = null;
		jsonStr = "[{\"mem_id\":\"test\"},{\"mem_name\":\"이순신\"}]";
		return jsonStr;
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, String crud) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
