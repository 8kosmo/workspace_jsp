package com.mvc3;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vo.SNSMessageSet;

public class SNSController implements ControllerVer3 {
	Logger logger = Logger.getLogger(SNSController.class);
	String requestName = null;
	String crud = null;
	SNSLogic snsLogic = null;
	public SNSController(String requestName, String crud) {
		logger.info("SNSController||생성자 호출성공");
		this.requestName = requestName;
		this.crud = crud;
		snsLogic = new SNSLogic();
	}
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("SNSController||ModelAndView execute 호출성공");
		ModelAndView mav = null;
		if("smsgList".equals(crud)) {
			List<SNSMessageSet> smsgList = null;
			smsgList = snsLogic.smsgList();
			logger.info("smsgList.size(); ==> "+smsgList.size());
			mav = new ModelAndView();
			mav.addObject("smsgList", smsgList);
			mav.setViewName("./bootMsgList.jsp");
//			//List 1
//			List<String> nameList = new ArrayList<>();
//			nameList.add("김유신");
//			mav.addObject("list", nameList);
//			//List 2
//			List<String> nickList = new ArrayList<>();
//			nickList.add("나초보");
//			mav.addObject("list2", nickList);
		}
		return mav;
	}

}
