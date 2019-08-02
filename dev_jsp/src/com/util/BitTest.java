package com.util;

public class BitTest {

	public static void main(String[] args) {
		int n = 150;
		System.out.println(Integer.toBinaryString(n));//10010110
		byte b = (byte)n;
		System.out.println(b);//-106
		System.out.println(b & 0xff);//150
	}

}
