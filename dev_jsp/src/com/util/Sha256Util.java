package com.util;

import java.security.MessageDigest;

public class Sha256Util {
	public static String applySha256(String user) {
		StringBuffer hexString = new StringBuffer();
		try {
			//java api를 활요하여 256비트 암호화 처리하기
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(user.getBytes("UTF-8"));
			//16진수로 값을 변경하여 담을 변수 선언
			for(int i=0;i<hash.length;i++) {
				//10진수를 16진수로 바꿔주는 메소드
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length()==1) hexString.append('0');
				hexString.append(hex);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return hexString.toString();
	}
}
