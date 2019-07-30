package com.basic;

import java.util.HashMap;
import java.util.Map;
class Param{
	int ival;
}
public class ParameterTest {
	/*
	 * 리턴타입이 void이다.- 내가 설계한 메소드가 아닐 때
	 * public void doGet();//override
	 * 1)해결방법 첫번째 - 전변 사용하기
	 * -전제조건 ==> 반드시 인스턴스화로 해야 함.
	 * 	그런데 서블릿은 내가 인스턴스화를 직접하는가? login.nhn
	 * 	그럼 누가 인스턴스화를 한거지? -Tomcat -> 객체주입법 -> 인스턴스화
	 * 2)서블릿은 개발자가 직접 인스턴스화 하지 않음. ===> 불가함.
	 * 3)해결바업 두 번째 - 파라미터를 이용함.
	 * 
	 */
	public void methodA(Map<String, Object> target) {
		target.put("account",5000);//NullPointerException 일어난다.
		
	}
	public void methodB(int i) {
		System.out.println(i);
	}
	public void  methodC(Param p) {
		int i = p.ival; //NullPointerException 일어나지 않는다.
	}
	public static void main(String[] args) {
		ParameterTest pt = new ParameterTest();
		pt.methodB(10);
		Param p = new Param();
		p.ival=500;
		pt.methodC(p);
		//아래 코드에 대해 설명해 보세요.
		Map<String, Object>target = null;
		//pt.methodA(target);
		//완결편
		//insert here - methodA에서 충전된 5000원을 여기에서 사용하고 싶다.
		//어떡하지?
		target = new HashMap<String,Object>();
		pt.methodA(target);
		System.out.println("잔액: account"+target.get("account"));
	}

}
