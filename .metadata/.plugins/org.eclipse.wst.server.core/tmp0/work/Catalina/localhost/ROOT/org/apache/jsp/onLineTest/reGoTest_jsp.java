/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-30 06:24:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onLineTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reGoTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/onLineTest/../common/JEasyUICommon.jsp", Long.valueOf(1564466224729L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" <!-- \r\n");
      out.write(" jquery api를 활용한 쿠키 활용\r\n");
      out.write(" 쿠키 만들기\r\n");
      out.write(" $.cookie('name','value');\r\n");
      out.write(" $.cookie('name','value',{expires:1});\r\n");
      out.write(" $.cookie('name','value',{expires:1,path:'/'});\r\n");
      out.write(" 쿠키 읽기\r\n");
      out.write("$.cookie('name');\r\n");
      out.write("쿠키 삭제\r\n");
      out.write("$.removeCookie('name');\r\n");
      out.write("  -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>자격시험 보기</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/commons.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.cookie.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction examSend(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction examStart(){\r\n");
      out.write("\t//문제지 정보를 가져온다.\r\n");
      out.write("\t//그런데 페이지는 이미 서버에서 클라이언트로 다운로드가 된 상태이므로 새로운 요청을 하면 페이지가 변경되는 상황이다.\r\n");
      out.write("\t//현재 페이지는 그대로 유지 되면서 시험시작 버튼을 클릭했을 때 내용정보만 가져와서 기존 페이지에\r\n");
      out.write("\t//끼워넣고 싶다면 ajax를 사용할 것.\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\tmethod:\"get\"\r\n");
      out.write("\t\t\t,url:\"swDesignExam.kos?work=onLineTest&sub_cd=\"+g_subcd\r\n");
      out.write("\t\t\t//,dataType:\"json\"\r\n");
      out.write("\t\t\t,success:function(data){\r\n");
      out.write("\t\t\t\tvar jsonDoc = JSON.parse(data);//자바스크립트 객체 배열\r\n");
      out.write("\t\t\t\tif(jsonDoc.length>0){\r\n");
      out.write("\t\t\t\t\tvar v_test1 =\"\";\r\n");
      out.write("\t\t\t\t\tvar v_test2 =\"\";\r\n");
      out.write("\t\t\t\t\tvar v_test3 =\"\";\r\n");
      out.write("\t\t\t\t\tvar v_test4 =\"\";\r\n");
      out.write("\t\t\t\t\t//다음문제 이동시 선택한 답안정보를 꺼내서 쿠키에 저장 처리\r\n");
      out.write("\t\t\t\t\t//checkbox가 4개씩 들어 있으므로 브라우저는 이것을 배열로 처리\r\n");
      out.write("\t\t\t\t\t//전체 보기가 16개 이므로 16개 전체 배열을 사용하지 않고 4개씩 배열 처리하기 위해서\r\n");
      out.write("\t\t\t\t\t//폼의 아이디로 구분한다.\r\n");
      out.write("\t\t\t\t\tv_test1+=\"<form id='f_test1'>\";\r\n");
      out.write("\t\t\t\t\tv_test1+=jsonDoc[0].d_no+\". \"+jsonDoc[0].question+\"<br><br>\";\r\n");
      out.write("\t\t\t\t\tv_test1+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,1)'>\"+jsonDoc[0].answer1+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test1+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,1)'>\"+jsonDoc[0].answer2+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test1+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,1)'>\"+jsonDoc[0].answer3+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test1+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,1)'>\"+jsonDoc[0].answer4+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test1+=\"</form>\";\r\n");
      out.write("\t\t\t\t\t$(\"#d_test1\").html(v_test1);\r\n");
      out.write("\t\t\t\t\tv_test2+=\"<form id='f_test2'>\";\r\n");
      out.write("\t\t\t\t\tv_test2+=jsonDoc[1].d_no+\". \"+jsonDoc[1].question+\"<br><br>\";\r\n");
      out.write("\t\t\t\t\tv_test2+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,2)'>\"+jsonDoc[1].answer1+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test2+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,2)'>\"+jsonDoc[1].answer2+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test2+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,2)'>\"+jsonDoc[1].answer3+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test2+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,2)'>\"+jsonDoc[1].answer4+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test2+=\"</form>\";\r\n");
      out.write("\t\t\t\t\t$(\"#d_test2\").html(v_test2);\r\n");
      out.write("\t\t\t\t\tv_test3+=\"<form id='f_test3'>\";\r\n");
      out.write("\t\t\t\t\tv_test3+=jsonDoc[2].d_no+\". \"+jsonDoc[2].question+\"<br><br>\";\r\n");
      out.write("\t\t\t\t\tv_test3+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,3)'>\"+jsonDoc[2].answer1+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test3+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,3)'>\"+jsonDoc[2].answer2+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test3+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,3)'>\"+jsonDoc[2].answer3+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test3+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,3)'>\"+jsonDoc[2].answer4+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test3+=\"</form>\";\r\n");
      out.write("\t\t\t\t\t$(\"#d_test3\").html(v_test3);\r\n");
      out.write("\t\t\t\t\tv_test4+=\"<form id='f_test4'>\";\r\n");
      out.write("\t\t\t\t\tv_test4+=jsonDoc[3].d_no+\". \"+jsonDoc[3].question+\"<br><br>\";\r\n");
      out.write("\t\t\t\t\tv_test4+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,4)'>\"+jsonDoc[3].answer1+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test4+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,4)'>\"+jsonDoc[3].answer2+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test4+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,4)'>\"+jsonDoc[3].answer3+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test4+=\"&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,4)'>\"+jsonDoc[3].answer4+\"<br>\";\r\n");
      out.write("\t\t\t\t\tv_test4+=\"</form>\";\r\n");
      out.write("\t\t\t\t\t$(\"#d_test4\").html(v_test4);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$('#dlg_test1').dialog('open');\r\n");
      out.write("\t}\r\n");
      out.write("/* \t//멀티선택을 배제하기 위한 함수 선언\r\n");
      out.write("\tfunction answer(p_dap,fname) {\r\n");
      out.write("\t\t// 브라우저가 DOM구성시 같은 이름이면 자동으로 배열 전환\r\n");
      out.write("\t\tfor (var i = 0; i < document.getElementById(\"'\"+fname+\"'\").cb.length; i++) {\r\n");
      out.write("\t\t\tif (p_dap == i) {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"'\"+fname+\"'\").cb[i].checked = 1;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"'\"+fname+\"'\").cb[i].checked = 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t} */\r\n");
      out.write("\t//멀티선택을 배제하기 위한 함수 선언\r\n");
      out.write("\tfunction answer(p_dap,num) {\r\n");
      out.write("\t\t// 브라우저가 DOM구성시 같은 이름이면 자동으로 배열 전환\r\n");
      out.write("\t\tfor (var i = 0; i < document.getElementById(\"f_test\"+num).cb.length; i++) {\r\n");
      out.write("\t\t\tif (p_dap == i) {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"f_test\"+num).cb[i].checked = 1;\r\n");
      out.write("\t\t\t\t//alert(\"선택한 값:\"+document.getElementById(\"f_test\"+num).cb[i].value);\r\n");
      out.write("\t\t\t\t//$.cookie('c_test'+num,document.getElementById(\"f_test\"+num).cb[i].value);\r\n");
      out.write("\t\t\t\t//$.cookie('name','value',{expires:1});\r\n");
      out.write("\t\t\t\t//$.cookie('name','value',{expires:1,path:'/'});\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"f_test\"+num).cb[i].checked = 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction prev(p_test) {\r\n");
      out.write("\t\tif(p_test==\"dlg_test2\"){\r\n");
      out.write("\t\t\t$(\"#dlg_test1\").dialog('open');\r\n");
      out.write("\t\t\t$(\"#dlg_test2\").dialog('close');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(p_test==\"dlg_test3\"){\r\n");
      out.write("\t\t\t$(\"#dlg_test2\").dialog('open');\r\n");
      out.write("\t\t\t$(\"#dlg_test3\").dialog('close');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(p_test==\"dlg_test4\"){\r\n");
      out.write("\t\t\t$(\"#dlg_test3\").dialog('open');\r\n");
      out.write("\t\t\t$(\"#dlg_test4\").dialog('close');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction next(p_test) {\t\r\n");
      out.write("\t\tvar dap;//사용자가 선택한 답을 담기\r\n");
      out.write("\t\tif(p_test=='dlg_test1'){\r\n");
      out.write("\t\t\t//선택한 답안지의 값을 담기\r\n");
      out.write("\t\t\tvar temp=1;//체크박스가 넘어갈 때 마다 1씩 증가\r\n");
      out.write("\t\t\t//\r\n");
      out.write("\t\t\tfor(var i=0; i<document.getElementById(\"f_test1\").cb.length; i++) {\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"f_test1\").cb[i].checked==1) {\r\n");
      out.write("\t\t\t\t\tdap=temp;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\ttemp = temp + 1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.cookie('c_test1',dap);\r\n");
      out.write("\t\t\t$(\"#dlg_test1\").dialog('close');\r\n");
      out.write("\t\t\t$(\"#dlg_test2\").dialog('open');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(p_test=='dlg_test2'){\r\n");
      out.write("\t\t\t//선택한 답안지의 값을 담기\r\n");
      out.write("\t\t\tvar temp=1;//체크박스가 넘어갈 때 마다 1씩 증가\r\n");
      out.write("\t\t\t//\r\n");
      out.write("\t\t\tfor(var i=0; i<document.getElementById(\"f_test2\").cb.length; i++) {\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"f_test2\").cb[i].checked==1) {\r\n");
      out.write("\t\t\t\t\tdap=temp;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\ttemp = temp + 1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.cookie('c_test2',dap);\r\n");
      out.write("\t\t\t$(\"#dlg_test2\").dialog('close');\r\n");
      out.write("\t\t\t$(\"#dlg_test3\").dialog('open');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(p_test=='dlg_test3'){\r\n");
      out.write("\t\t\t//선택한 답안지의 값을 담기\r\n");
      out.write("\t\t\tvar temp=1;//체크박스가 넘어갈 때 마다 1씩 증가\r\n");
      out.write("\t\t\t//\r\n");
      out.write("\t\t\tfor(var i=0; i<document.getElementById(\"f_test3\").cb.length; i++) {\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"f_test3\").cb[i].checked==1) {\r\n");
      out.write("\t\t\t\t\tdap=temp;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\ttemp = temp + 1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.cookie('c_test3',dap);\r\n");
      out.write("\t\t\t$(\"#dlg_test3\").dialog('close');\r\n");
      out.write("\t\t\t$(\"#dlg_test4\").dialog('open');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(p_test=='dlg_test4'){\r\n");
      out.write("\t\t\t//선택한 답안지의 값을 담기\r\n");
      out.write("\t\t\tvar temp=1;//체크박스가 넘어갈 때 마다 1씩 증가\r\n");
      out.write("\t\t\t//\r\n");
      out.write("\t\t\tfor(var i=0; i<document.getElementById(\"f_test4\").cb.length; i++) {\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"f_test4\").cb[i].checked==1) {\r\n");
      out.write("\t\t\t\t\tdap=temp;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\ttemp = temp + 1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.cookie('c_test4',dap);\r\n");
      out.write("\t\t\t$(\"#dlg_test4\").dialog('close');\r\n");
      out.write("\t\t\t//다이얼로그창을 새로운 페이지로 이관(examResult.jsp)\r\n");
      out.write("\t\t\t//$(\"#dlg_confirm\").dialog('open');\r\n");
      out.write("\t\t\tcommon_window_popup('examResult.jsp','750','350','examresult');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tvar g_subcd;\r\n");
      out.write("\t// DOM구성이 완료되었을 때 콤보박스를 초기화 할 것\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$('#cd_subject').combobox({\r\n");
      out.write("\t\t    url:'/onLineTest/subjectList.kos?work=onLineTest'\r\n");
      out.write("\t\t    ,valueField:'SUB_CD'\t// Map의 담긴 값은 대문자로..\r\n");
      out.write("\t\t    ,textField:'SUB_NAME'\r\n");
      out.write("\t\t    ,panelHeight:'auto'\r\n");
      out.write("\t\t    ,onSelect:function(record) {\r\n");
      out.write("\t\t    \talert(record.SUB_NAME);\r\n");
      out.write("\t\t    \tg_subcd = record.SUB_CD;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<div id=\"reGoTest\" class=\"easyui-panel\" title=\"Test Take\" style=\"width:100%;max-width:400px;padding:30px 30px\">\r\n");
      out.write("\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t<select class=\"easyui-combobox\" id=\"cd_subject\" label=\"수험과목 선택:\" labelPosition=\"top\" data-options=\"prompt:'수험번호를 선택하세요'\" style=\"width:100%\"></select>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"margin-bottom:10px\">\r\n");
      out.write("\t\t<input class=\"easyui-textbox\" label=\"수험번호: \" labelPosition=\"top\" size=\"150px\" style=\"width:100%\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<a id=\"btn_xxx\" href=\"javascript:examStart()\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-ok'\" style=\"width:100px;height:32px\">시험시작</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 시험문제 1 -->\r\n");
      out.write("\t<div id=\"dlg_test1\" class=\"easyui-dialog\" style=\"width:700px;height:300px\"\r\n");
      out.write("\t\tdata-options=\"title:'문제1',closed:'false',buttons:'#btn_test1',modal:true\">\r\n");
      out.write("\t\t<div id=\"d_test1\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"btn_test1\">\r\n");
      out.write("\t\t<a href=\"javascript:next('dlg_test1')\" class=\"easyui-linkbutton\">다음문제</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 시험문제 2 -->\r\n");
      out.write("\t<div id=\"dlg_test2\" class=\"easyui-dialog\" style=\"width:700px;height:300px\"\r\n");
      out.write("\t\tdata-options=\"title:'문제2',closed:'false',buttons:'#btn_test2',modal:true\">\r\n");
      out.write("\t\t<div id=\"d_test2\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"btn_test2\">\r\n");
      out.write("\t\t<a href=\"javascript:prev('dlg_test2')\" class=\"easyui-linkbutton\">이전문제</a>\r\n");
      out.write("\t\t<a href=\"javascript:next('dlg_test2')\" class=\"easyui-linkbutton\">다음문제</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 시험문제 3 -->\r\n");
      out.write("\t<div id=\"dlg_test3\" class=\"easyui-dialog\" style=\"width:700px;height:300px\"\r\n");
      out.write("\t\tdata-options=\"title:'문제3',closed:'false',buttons:'#btn_test3',modal:true\">\r\n");
      out.write("\t\t<div id=\"d_test3\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"btn_test3\">\r\n");
      out.write("\t\t<a href=\"javascript:prev('dlg_test3')\" class=\"easyui-linkbutton\">이전문제</a>\r\n");
      out.write("\t\t<a href=\"javascript:next('dlg_test3')\" class=\"easyui-linkbutton\">다음문제</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 시험문제 4 -->\r\n");
      out.write("\t<div id=\"dlg_test4\" class=\"easyui-dialog\" style=\"width:700px;height:300px\"\r\n");
      out.write("\t\tdata-options=\"title:'문제4',closed:'false',buttons:'#btn_test4',modal:true\">\r\n");
      out.write("\t\t<div id=\"d_test4\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"btn_test4\">\r\n");
      out.write("\t\t<a href=\"javascript:prev('dlg_test4')\" class=\"easyui-linkbutton\">이전문제</a>\r\n");
      out.write("\t\t<a href=\"javascript:next('dlg_test4')\" class=\"easyui-linkbutton\">다음문제</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 답인지 확인 -->\r\n");
      out.write("\t<!-- 쿠키값 확인 위해 examResult.jsp로 이동 -->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}