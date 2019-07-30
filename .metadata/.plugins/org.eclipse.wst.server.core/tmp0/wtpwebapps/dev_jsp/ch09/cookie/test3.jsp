<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String dap2 = request.getParameter("dap2");
    	//alert("dap1:"+dap1);
    	//out.print("1번문제답: " +dap1);
    	//out.print("2번문제답: " +dap2);
		Cookie cookie = new Cookie("dap2",dap2);
		cookie.setMaxAge(60*10);
		cookie.setPath("/");
		response.addCookie(cookie);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제3</title>
<%@include file="/common/JEasyUICommon.jsp" %>
<script type="text/javascript">
	function answer(p_dap){
		for(var i=0;i<document.getElementById("f_test3").cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test3").cb[i].checked=1;
			}
			else{
				document.getElementById("f_test3").cb[i].checked=0;
			}
		}
	}
	//이전문제 선택시 이번문제 답안지를 hidden에 기억하기
	function prev(){
		location.href="test2.jsp?dap2=<%=dap2%>";
	}
	//다음문제 선택시 이전문제 답안지를 hidden에 기억하기
	function next(){
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test3").cb.length;i++){
			if(document.getElementById("f_test3").cb[i].checked==1){
				document.getElementById("f_test3").dap3.value=temp;
			}
			else{
				temp=temp+1; 
			}
		}
		document.getElementById("f_test3").submit();
	}
	function answerSend(){
		alert("제출 하십니까?");
		location.href="result.jsp"
	}
</script>
</head>
<body>
	<div class="easyui-panel" title="문제3" style="width:600px;height:100px"
			data-options="fit:true,border:true,footer:'#footer'">
			
<form id="f_test3" method="get" action="result.jsp">
	<input type="hidden" id="dap3" name="dap3" />
<div>
문제3.다음 설명 중 틀린것을 고르시오
</div>
<div style="margin-bottom:20px"></div>
	<input type="checkbox"  name='cb' value="1"  onChange="answer(0)" />
1.JeasyUI는 자바스크립트 기반의 UI솔루션이다.
<div style="margin-bottom:10px"></div>
	<input type="checkbox"  name='cb' value="2"  onChange="answer(1)" />
2.JeasyUI는 Jquery기반의 솔루션이다.
<div style="margin-bottom:10px"></div>
	<input type="checkbox"  name='cb' value="3"  onChange="answer(2)" />
3.JeasyUI는 자바코드와 직접적으로 연동이 가능하다.
<div style="margin-bottom:10px"></div>
	<input type="checkbox"  name='cb' value="4"  onChange="answer(3)" />
4.JeasyUI는 html5보다 훨씬 더 많은 컴포넌트를 제공한다.
   </form>
   </div>
    <div id="footer" style="padding:5px;">
        <a href="javascript:prev()" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" >이전문제</a>
        <a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" >시험종료</a>
    </div>
 
</body>
</html>