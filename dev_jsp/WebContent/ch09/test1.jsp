<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dap1 = request.getParameter("dap1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<%@include file="../common/JEasyUICommon.jsp"%>
<script type="text/javascript">
	function answer(p_dap) {
		// 브라우저가 DOM구성시 같은 이름이면 자동으로 배열 전환
		for(var i=0; i<document.getElementById("f_test1").cb.length; i++) {
			if(p_dap==i){
				document.getElementById("f_test1").cb[i].checked=1;
			}
			else {
				document.getElementById("f_test1").cb[i].checked=0;				
			}
		}
	}
	// 다음문제 선택시 이전문제 답안지 기억하기 - hidden
	function next() {
		var temp = 1;
		for(var i=0; i<document.getElementById("f_test1").cb.length; i++) {
			if(document.getElementById("f_test1").cb[i].checked==1) {
				document.getElementById("f_test1").dap1.value = temp;
			}
			else {
				temp = temp + 1;
			}
		}
		document.getElementById("f_test1").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function() {
		// DOM스캔이 완료되었을 때 체크박스 갯수마늠 반복해서 답안지가 같은 값을 찾고
		// 값이 같으면 checked속성을 1로 초기화 해줌.
		// 다른 경우는 모두 0으로 초기화 함.
		for(var i=0; i<document.getElementById("f_test1").cb.length; i++) {
			//alert(document.getElementById("f_test1").cb[i].value);
			if(<%=dap1%> == document.getElementById("f_test1").cb[i].value) {
				document.getElementById("f_test1").cb[i].checked=1;
			}
			else {
				document.getElementById("f_test1").cb[i].checked=0;
			}
		}
	});
</script>
	<div class="easyui-panel" title="문제1" style="width: 500px; height: 500px; padding: 10px"
		data-options="fit:false,border:true,footer:'#footer'">
		<form id="f_test1" method="get" action="test2.jsp">
		<input type="hidden" id="dap1" name="dap1"/>
		<div>
			<div style="margin-bottom: 5px"></div>
			문제1. DML구문 중에서 성격이 다른 하나를 고르시오.
		</div>
		<br>
		<div style="margin-bottom: 10px"></div>
		<input type="checkbox" name="cb" value="1" onChange="answer(0)"> 
		1.INSERT
		<div style="margin-bottom: 5px"></div>
		<input type="checkbox" name="cb" value="2" onChange="answer(1)"> 
		2.SELECT
		<div style="margin-bottom: 5px"></div>
		<input type="checkbox" name="cb" value="3" onChange="answer(2)"> 
		3.UPDATE
		<div style="margin-bottom: 5px"></div>
		<input type="checkbox" name="cb" value="4" onChange="answer(3)"> 
		4.DELETE
		</form>
	</div>
	<div id="footer" style="padding: 5px;">
		<a id="btn" href="javascript:next()" class="easyui-linkbutton"
			data-options="iconCls:'icon-redo'" style="width: 80px">다음</a>
	</div>
</body>
<!-- 답 2번 -->
</html>