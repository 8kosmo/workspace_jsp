package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception;
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, String crud)
			throws Exception;
}
