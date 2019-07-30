<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dap1 = request.getParameter("dap1");
	String dap2 = request.getParameter("dap2");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제2</title>
<%@include file="../common/JEasyUICommon.jsp"%>
<script type="text/javascript">
	function answer(p_dap) {
		// 브라우저가 DOM구성시 같은 이름이면 자동으로 배열 전환
		for (var i = 0; i < document.getElementById("f_test2").cb.length; i++) {
			if (p_dap == i) {
				document.getElementById("f_test2").cb[i].checked = 1;
			} 
			else {
				document.getElementById("f_test2").cb[i].checked = 0;
			}
		}
	}
	function prev() {
		location.href="test1.jsp?dap1=<%=dap1%>";	
	}
	function next() {
		var temp = 1;
		for(var i=0; i<document.getElementById("f_test2").cb.length; i++) {
			if(document.getElementById("f_test2").cb[i].checked==1) {
				document.getElementById("f_test2").dap2.value = temp;
			}
			else {
				temp = temp + 1;
			}
		}
		document.getElementById("f_test2").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function() {
		// DOM스캔이 완료되었을 때 체크박스 갯수마늠 반복해서 답안지가 같은 값을 찾고
		// 값이 같으면 checked속성을 1로 초기화 해줌.
		// 다른 경우는 모두 0으로 초기화 함.
		for(var i=0; i<document.getElementById("f_test2").cb.length; i++) {
			//alert(document.getElementById("f_test1").cb[i].value);
			if(<%=dap2%> == document.getElementById("f_test2").cb[i].value) {
				document.getElementById("f_test2").cb[i].checked=1;
			}
			else {
				document.getElementById("f_test2").cb[i].checked=0;
			}
		}
	});
</script>
	<div class="easyui-panel" title="문제2" style="width: 500px; height: 500px; padding: 10px"
		data-options="fit:false,border:true,footer:'#footer'">
		<form id="f_test2" method="get" action="test3.jsp">
		<input type="hidden" id="dap1" name="dap1" value="<%=dap1%>">
		<input type="hidden" id="dap2" name="dap2"/>
		<div>
			<div style="margin-bottom: 5px"></div>
			문제2. 스키마 3계층 중에 데이터베이스 물리적 구조를 정의하는 계층을 고르시오.
		</div>
		<br>
		<div style="margin-bottom: 10px"></div>
		<input type="checkbox" name="cb" value="1" onChange="answer(0)"> 
		1.외부스키마
		<div style="margin-bottom: 5px"></div>
		<input type="checkbox" name="cb" value="2" onChange="answer(1)"> 
		2.서브스키마
		<div style="margin-bottom: 5px"></div>
		<input type="checkbox" name="cb" value="3" onChange="answer(2)"> 
		3.내부스키마
		<div style="margin-bottom: 5px"></div>
		<input type="checkbox" name="cb" value="4" onChange="answer(3)"> 
		4.개념스키마
		</form>
	</div>
	<div id="footer" style="padding: 5px;">
		<a id="btn" href="javascript:prev()" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo'" style="width: 80px">이전</a> 
		<a id="btn" href="javascript:next()" class="easyui-linkbutton"
			data-options="iconCls:'icon-redo'" style="width: 80px">다음</a>
	</div>
</body>
</html>
<!-- 답 3번 -->