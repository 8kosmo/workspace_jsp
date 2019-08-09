package com.mvc2;

import org.apache.log4j.Logger;

public class ControllerMapping {
	static Logger logger = Logger.getLogger(ControllerMapping.class);
	
	static String crud = "";
	/**
	 * 
	 * @param command onLineTest/test.mo?crud=select
	 * @param crud
	 * @return
	 */
	public static Controller getController(String command, String crud) {//(5)(onLineTest/test.mo, else)
		ControllerMapping.crud = crud;
		Controller controller = null;
		String commands[] = command.split("/");
		String work = commands[0];//onLineTest
		String requestName = commands[1];//test.mo
		if("board".equals(work)) {
			controller = new BoardController(requestName,ControllerMapping.crud);//(6)(test.mo , else)			
		}
		else if("onLineTestVer2".equals(work)) {
			controller = new Test2Controller(requestName,ControllerMapping.crud);//(6)(test.mo , else)
		}
		else if("member".equals(work)) {
			controller = new Member2Controller(requestName,ControllerMapping.crud);
		}
		return controller;
	}
}
