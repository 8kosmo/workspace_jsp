package com.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.MemberVO;
import com.vo.ZipCodeVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao mDao = new MemberDao();
	ZipCodeDao zDao = new ZipCodeDao();
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert 호출 성공");
		int result = 0;
		result = mDao.memberInsert(pMap);
		return result;
	}

	public List<Map<String, Object>> memberList() {
		logger.info("memberList 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = mDao.memberList();
		return memList;
	}

	public List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		logger.info("zipcodeList 호출 성공");
		List<ZipCodeVO> zipList = null;
		zipList = zDao.zipcodeList(zVO);
		return zipList;
	}
	public MemberVO proc_login(MemberVO pmVO) {
		logger.info("proc_login 호출 성공");
		//mDao.proc_login(pmVO);
		mDao.proc_login(pmVO);
		return pmVO;
	}
	public String login(MemberVO pmVO) {
		logger.info("login 호출 성공");
		// 화면에 전달될 메시지 값
		/*
		 * 1. 아이디와 비번 일치
		 * 2. 아이디가 존재하지 않을 때
		 * 3. 비번이 일치하지 않을 때
		 */
		String mem_name = null;
		mem_name = mDao.isId(pmVO);
		if("아이디가 존재합니다.".equals(mem_name)) {	// 아이디가 존재할 때
			mem_name = mDao.login(pmVO);
		}
		else {
			mem_name="아이디가 존재하지 않습니다.";
		}
		return mem_name;
	}
}
