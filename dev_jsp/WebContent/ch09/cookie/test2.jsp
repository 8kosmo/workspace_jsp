<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String dap1 = request.getParameter("dap1");
    	String dap2 = request.getParameter("dap2");
    	//alert("dap1:"+dap1);
    	//out.print("1번문제답: " +dap1);
    	//out.print("2번문제답: " +dap2);
	Cookie cookie = new Cookie("dap1",dap1);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제2</title>
<%@include file="/common/JEasyUICommon.jsp" %>
<script type="text/javascript">
	function answer(p_dap){
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test2").cb[i].checked=1;
			}
			else{
				document.getElementById("f_test2").cb[i].checked=0;
			}
		}
	}
	//이전문제 선택시 이번문제 답안지를 hidden에 기억하기
	function prev(){
		location.href="test1.jsp?dap1=<%=dap1%>";
	}
	//다음문제 선택시 이전문제 답안지를 hidden에 기억하기
	function next(){
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
			if(document.getElementById("f_test2").cb[i].checked==1){
				document.getElementById("f_test2").dap2.value=temp;
			}
			else{
				temp=temp+1; 
			}
		}
		document.getElementById("f_test2").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		//돔 스캔이 완료되었을 때 체크박스 개수만큼 반복해서 답안지가 같은 값을 찾고,
		//값이 같으면 checked속성을 1로 초기화 해줌.
		//다른 경우는 모두 0으로 초기화 함.
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
				//alert(document.getElementById("f_test1").dap1.value);
				if(<%=dap2%>==document.getElementById("f_test2").cb[i].value){
					document.getElementById("f_test2").cb[i].checked=1;
				}else{
					document.getElementById("f_test2").cb[i].checked=0;
				}
		}
	});
	</script>
	<div class="easyui-panel" title="문제2" style="width:600px;height:100px"
			data-options="fit:true,border:true,footer:'#footer'">
<form id="f_test2" method="get" action="test3.jsp">
	<input type="hidden" id="dap2" name="dap2" value="<%=dap2%>"/>
<div>
문제2.다음 중에서 자바에서 제공하는 타입이 아닌것은
</div>
<div style="margin-bottom:20px"></div>
	<input type="checkbox"  name='cb'  value="1" onChange="answer(0)" />
1.int
<div style="margin-bottom:10px"></div>
	<input type="checkbox"  name='cb'  value="2"onChange="answer(1)" />
2.string
<div style="margin-bottom:10px"></div>
	<input type="checkbox"  name='cb'  value="3" onChange="answer(2)" />
3.varchar2
<div style="margin-bottom:10px"></div>
	<input type="checkbox"  name='cb' value="4" onChange="answer(3)" />
4.Object
   </form>
   </div>
    <div id="footer" style="padding:5px;">
        <a href="javascript:prev()" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" >이전문제</a>
        <a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" >다음문제</a>
    </div>
 
</body>
</html>