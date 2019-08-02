package com.chain;

import java.util.Date;

import com.util.Sha256Util;

public class Block {
	public String hash = null;//해시값 담을 변수
	public String previousHash = null;//이전 해시값을 담을 변수
	private String data = null;//블록에 저장할 데이터-금액
	//new Date().getTime()
	private long timeStamp = 0;//1970년1월1일부터 millisec단위로 숫자값
	
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

	public String calculateHash() {
		String calculateHash = Sha256Util.applySha256(
				previousHash+//이전 거래 내역을 확인할 수 있는 해시값
				Long.toString(timeStamp)+//채굴하는 값이 겹치는 것을 방지
				data);
		return calculateHash;
	}
}
