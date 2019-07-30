package com.basic;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
/*
 * 웹서비스를 제공하기 위해서는 서블릿이 되어야 함.
 * 왜냐하면 통신을 지원(누가:톰캣[w(eb)A)pplication)S(erver)])받아야 하고
 * 서블릿이 생성될 때 마다 스레드 지원이 필요함.
 * 한 사람이 서버에 접속하여 여러 페이지를 이동하고,
 * 때로는 결재를 때로는 동영상을 시청하는 것을 관리해야함
 * 작업에 대한 순서, 경합 상황이 계속 발생하게 됨.
 * 이렇게 생성된 서블릿 객체는 싱글톤으로 관리됨.
 * 
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
//@WebServlet(urlPatterns="/hello.do")
public class HelloServlet extends HttpServlet {
	
	//Get방식으로 요청이 들어올 때
	/******************************************************************
	 * @return : void
	 * 질문: 리턴타입이 void인데 처리 결과를 어떻게 html 문서에서 받을 수 있는 걸까?
	 * @param1 :request 요청 객체 - 사용자가 화면에 입력한 아이디를 받아올 때
	 * @param2 :response 응답 객체 - mime type, charset지정
	 * 자바는 요청객체와 응답객체가 없다.
	 * 오라클 연동은 자바로 함.
	 * 질문2: 파라미터 객체는 누가 제공하나요? 톰캣 ! 
	 * 			객체 주입은 톰캣서버에서 담당한다요!
	 *  		그럼 언제 주입되는 거죠?
	 *  		-요청이 있을 때 주입 됨.
	 * 질문3: 서블릿의 doGet메소드는 어떻게 호출하나요?
	 * 시스템에서 자동으로 호출 합니다.(콜백메소드)
	 * 브라우저의 url 주소가 필요합니다.
	 * 서블릿을 호출하는데는 url 주소가 필요합니다.
	 * 이 주소는 배치 서줄자에 등록이 되어 있어야 합니다.
	 * 배치서술자는 DD(deploy discript) web.xml입니다.
	 * web.xml문서에 서블릿 클래스 이름을 등록하고 대응하는 url주소를 미리 정합니다. 
	 * http://localhost:8000/hello.do
	 * hello.do이름으로 HelloServlet 클래스를 찾아야 합니다.
	 * 그 방법은 ....?
	 *****************************************************************/
	Logger logger = Logger.getLogger(HelloServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		/*
		 * jsp에서는 내장 객체로 지원 되지만 서블릿에서는 내장객체 지원 없으므로 
		 * 다음과 같이 생성한 후 사용함.
		 */
		HttpSession session = req.getSession();
		//세션에 값을 담기
		session.setAttribute("name", "이순신");
		//세션에 있는 값 꺼내기
		//getAttibute메소드는 세션객체가 지 원하는 메소드로
		//리턴 타입은 Object임.
		//따라서 List같은 자료 구조도 담을 수 잇음.
		//그러나 cache 메모리 공간의 한계로 조회 결과를 담는데 사용하지 않음.
		//일반적으로 이경우에 request를 사용함
		String s_name = (String)session.getAttribute("name");
//		System.out.println("doGet");
//		logger.info("doGet");
		String mem_id ="test";
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<table border='1'>");
		out.print("<tr><td>서블릿으로 화면 그리는 거 아니다.</td></tr>");
		out.print("<tr><td>+mem_id+</td></tr>");
		out.print("</table>");
		//hello.do?command=insert
		String command =  req.getParameter("command");
		if("insert".equals(command)) {//입력이니?
			logger.info("입력선택하였음");
		}
		else if("update".equals(command)) {//수정이니?
			logger.info("수정선택하였음");
		}
		else if("delete".equals(command)) {//삭제이니?
			logger.info("삭제선택하였음");
		}
		else if("select".equals(command)) {//조회이니?
			logger.info("조회선택하였음");
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("doPost");
	}
	
}
//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//	throws ServletException, IOException{
//		String mem_id =req.getParameter("mem_id");
//		System.out.println("doGet호출 성공");
//		System.out.println(mem_id);
//	}
//	//Post방식으로 요청이 들어올 때
//	public void doPost(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException{
//		
//	}
