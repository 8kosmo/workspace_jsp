package com.mvc2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.SwDesignVO;

public class Test2Controller implements Controller {
	Logger logger = Logger.getLogger(Test2Controller.class);
	String path = null;
	String requestName = null;
	String crud = null;
	TestLogic tLogic = null;
	public Test2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
		tLogic = new TestLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		if("examReceipt".equals(crud)) {
			int result = 0;//시험접수 업무에 대한 요청이므로 insert
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			result = tLogic.examReceipt(pMap);
			if(result==1){
				path = "redirect:examReceiptSuccess.jsp";
			}else {
				path = "redirect:examReceoptFail.jsp";
			}
		}
		/**********************
		 * 수험과목 목록을 가져오기 구현 *
		 **********************/
		else if("subjectList".equals(crud)) {
			List<Map<String, Object>> subList = null;
			subList = tLogic.subjectList();
			//이 부분이 빠지게 되면 NullPointerException
			req.setAttribute("subList", subList);
			path = "forward:jsonSubjectList.jsp";
		}else if("isOk".equals(crud)) {
			String msg = null;
			//오라클 서버에 넘길 값을 map에 담기 위한 객체 생성하기
			Map<String, Object> pMap = new HashMap<>();
			//요청 값을 받아오는 공통 클래스를 생성한 후
			HashMapBinder hmb = new HashMapBinder(req);
			//bind메소드 호출하면 공통코드에서 자동으로 담아줌.
			//파라미터로 받아오는 값이 한글이 아니므로 bindPost대신 bind호출
			hmb.bind(pMap);
			msg = tLogic.isOk(pMap);
			req.setAttribute("msg", msg);
			path = "forward:isOkResult.jsp";
		}else if("swDesignExam".equals(crud)) {
				logger.info("소프트웨어설계문제 호출");
				// 사용자가 입력한 값 받아오기
				Map<String, Object> pMap = new HashMap<String, Object>();
				List<Map<String, Object>> designList = tLogic.swDesignExam(pMap);
				logger.info("designList==>" +designList);
				/*
				 * 꺼내온 정보가 표준 패턴이 아닌 2중 구조로 되어 있어서 기존에 사용하던 for문으로 값을 꺼낼 수 없다.
				 * 따라서 키 값을 사용하여 일차 컬렉션을 꺼내고 난 후 
				 * Iterator를 활용하여 값을 꺼내야 원하는 정보를 볼 수 있다.
				 */
				List list = designList;
				if(designList != null) {
					list = (List)designList.get(0).get("key");
				}
				/*
				 * 블록체인 만들 때
				 * 오픈소스[네아로, 캡챠, 카카오맵, 검색로봇 API사용시...]에서 서버 정보를 외부에 제공할 때
				 * UI솔루션(js기반) - jeasyui, bootstrap, semantic, react...
				 * Chart 솔루션에서 파이그래프, 막대그래프...
				 * 보고서 작성할 때
				 */
				Iterator<Map<String, Object>> iter = list.iterator();
				while (iter.hasNext()) {
					SwDesignVO swdVO = (SwDesignVO) iter.next();
					logger.info("문제 ==>" + swdVO.getQuestion());
				}
				req.setAttribute("designList", list);
				path = "forward:jsonSwDesign.jsp";
		}else {
			path = "redirect:index.jsp";
		}
		return path;
	}

}
