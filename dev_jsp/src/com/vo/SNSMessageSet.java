package com.vo;

import java.util.List;
/*
 * List<SNSMessageSet>
 */
public class SNSMessageSet {
	private SNSMessageVO msgVO = null;
	private List<SNSRepleVO> reList = null;
	public SNSMessageVO getMsgVO() {
		return msgVO;
	}
	public void setMsgVO(SNSMessageVO msgVO) {
		this.msgVO = msgVO;
	}
	public List<SNSRepleVO> getReList() {
		return reList;
	}
	public void setReList(List<SNSRepleVO> reList) {
		this.reList = reList;
	}
}
