package com.mvc1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	MemberController memCtrl = new MemberController();
	TestController tCtrl = new TestController();
	GoodsController goodsCtrl = new GoodsController();
	OrderController orderCtrl = new OrderController();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);
	}
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		/*
		 * 요청하는 이름에 따라 구체적인 업무를 구분하고 싶다면 호출하는 이름을 별도로 처리해야 한다.
		 * 어떡하면될까?
		 */
		String uri = req.getRequestURI();//	/member/memberList.kos
		String context = req.getContextPath();
		String command = uri.substring(context.length()+1);//+1은 처음/을 날린다.
											//command = member/memberList.kos
		int end = command.lastIndexOf('.');
		logger.info(command+" , "+end);
		command = command.substring(0,end);	//command = member/memberList.kos에서 .kos를 지운다
		logger.info(command);				//command = member/memberList
		/* 테스트 할 때 어떤 이름 이든 상관 없이 ?work=member를 넘겨주면 됨.
		 * work정보는 사용자가 요청시 결정해서 넘겨주고
		 * crud의 경우는 같은 회원관리 업무 중에서도 입력인지 수정건인지 삭제건인지 조회건인지
		 * 식별할 수 있어야 함.
		 */
		String work = req.getParameter("work");
		ActionForward forward = null;
		if("member".equals(work))
		{
			req.setAttribute("crud", command);
			forward = memCtrl.execute(req, res);
//			req.setAttribute("command", command);
//			req.setAttribute("crud", "insert");
//			req.setAttribute("crud", "update");
//			req.setAttribute("crud", "delete");
			forward = memCtrl.execute(req, res);
		}
		else if("onLineTest".equals(work))
		{
			/*
			 * FrontController의 실제 업무가 처리하는 클래스가 아니다.
			 * 요청건의 따라 해당 업무를 처리하는 클래스(MemberController, TestController)를 배정
			 * 이 때 필요한 정보가 work에 담겨 있는 정보임
			 * TestController의 excute 메소드가 호출되어야 함
			 * TestController의 메소드 하나. 처리해야는 업무는 4가지
			 * 분기 필요
			 * 기준되는 값이 crud의 담긴 값
			 */
			req.setAttribute("crud", command);
			forward = tCtrl.execute(req, res);
		}
		else if("goods".equals(work))
		{
			forward = goodsCtrl.execute(req, res);
		}
		else if("order".equals(work))
		{
			forward = orderCtrl.execute(req, res);
		}
		if(forward!=null)
		{
			if(forward.isRedirect())
			{
				res.sendRedirect(forward.getviewName());
			}else
			{
				RequestDispatcher view =
						req.getRequestDispatcher(forward.getviewName());
				view.forward(req, res);
			}
		}//end of if(forward!=null)
	}
}
