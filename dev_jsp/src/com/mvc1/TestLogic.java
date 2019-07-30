package com.mvc1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.vo.SwDesignVO;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	SqlSessionFactory sqlSessionFactory = null;
	TestDao tDao = new TestDao();
	public List<Map<String, Object>> subjectList() {
		logger.info("subjectList 호출");
		List<Map<String, Object>> subList = null;
		subList = tDao.subjectList();
		return subList;		
	}
	public int examReceipt(Map<String, Object> pMap) {
		logger.info("examReceipt호출");
		int result = 0;
		String exam_no = "0";
		exam_no = tDao.getExamNo();
		logger.info("exam_no:"+exam_no);
		// 위에서 채번한 수험번호를 파라미터에 넣기 
		pMap.put("exam_no", exam_no);
		// 시험 응시 접수 처리 - insert건
		// 0이면 접수 실패, 1이면 접수 성공
		result = tDao.examReceipt(pMap); // 위에서 수험번호가 담겼으므로 호출 가능
		return 0;
	}
	public List<Map<String, Object>> swDesignExam(Map<String, Object> pMap) {
		logger.info("swDesignExam호출");
		List<Map<String, Object>> designList = new ArrayList<Map<String,Object>>();
		logger.info("designList==>" + designList);
		designList = tDao.swDesignExam(pMap);
		/*
		 * 파라미터 pMap에는 프로시저 호출시 resultMap속성이 담기고
		 * 리턴타입 List에는 프로시저 호출시 selectList를 사용하면 map에 담긴 정보를
		 * 다시 List에 자동으로 담아줌
		 */
		return designList;
	}
}
