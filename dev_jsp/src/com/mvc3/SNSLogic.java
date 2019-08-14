package com.mvc3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.SNSMessageSet;

public class SNSLogic {
	Logger logger = Logger.getLogger(SNSLogic.class);
	SNSDao snsDao = null;
	public SNSLogic() {
		snsDao = new SNSDao();
	}
	public List<SNSMessageSet> smsgList() {
		logger.info("SNSLogic||smsgList 호출성공");
		List<SNSMessageSet> smsgList = null;
		smsgList = snsDao.smsgList();
		logger.info("smsgList: "+smsgList);
		return smsgList;
	}
}
