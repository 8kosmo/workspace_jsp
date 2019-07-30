<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String dap1 = request.getParameter("dap1");
    	//alert("dap1:"+dap1);
    	//out.print("1번문제답: " +dap1);

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<%@include file="/common/JEasyUICommon.jsp" %>
<script type="text/javascript">
	//이건 멀티초이스를 막기위해 선택했는지 유무를 체크해주는 함수임.
	function answer(p_dap){//p_dap변수 1,2,3,4
		//브라우저가 돔구성시 같은 이름이면 자동으로 배열으로 전환해줌.
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){//체크박스가 여러개니깐 반복문
			if(p_dap==i){//파라미터로 받은 답이 i임? //i가 0부터 들어오는데, 0번째이면 그때 체크
				document.getElementById("f_test1").cb[i].checked=1;//checked	는 체크했니? 1은 true(체크해준다) 0은 펄스
			}
			else{
				document.getElementById("f_test1").cb[i].checked=0;//체크를 안해준다.	ex)1을체크하면 나머진 0이되고 2를체크하면 나머지0
			}
		}
	}
	//다음문제 선택시 이전문제 답안지를 hidden에 기억하기
	function next(){
		var temp = 1;//답안지가 1부터 1,2,3,4번이 답인데, 문제는 0번째부터 들어옴. 
		//배열개수만큼 0부터 4보다작은만큼 바퀴도는데 0번째가 선택됐을때는 1번이라고 
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(document.getElementById("f_test1").cb[i].checked==1){
				document.getElementById("f_test1").dap1.value=temp;//여기서 히든에다 담아주는것
				//alert("값: "+document.getElementById("f_test1").dap1.value);
			}
			else{
				temp=temp+1; 
			}
		}
		document.getElementById("f_test1").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		//돔 스캔이 완료되었을 때 체크박스 개수만큼 반복해서 답안지가 같은 값을 찾고,
		//값이 같으면 checked속성을 1로 초기화 해줌.
		//다른 경우는 모두 0으로 초기화 함.
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
				//alert(document.getElementById("f_test1").dap1.value);
				if(<%=dap1%>==document.getElementById("f_test1").cb[i].value){
					document.getElementById("f_test1").cb[i].checked=1;
				}else{
					document.getElementById("f_test1").cb[i].checked=0;
				}
		}
	});
</script>
	<div class="easyui-panel" title="문제1" style="width:600px;height:100px"
			data-options="fit:true,border:true,footer:'#footer'">
<form id="f_test1" method="get" action="test2.jsp"><!-- 이 폼을 get방식으로 test2에 결과를 전송함. -->
<input type="hidden" id="dap1" name="dap1"/>
<div>
문제1.DML구문 중에서 성격이 다른 하나를 고르시오.
</div>
<div style="margin-bottom:20px"></div>
<input type="checkbox"  name="cb" value="1" onChange="answer(0)" /> <!-- onChange는 값의 변경을 확인하는것. 확인위해 함수호출. -->
1.INSERT
<div style="margin-bottom:10px"></div>
<input type="checkbox"  name="cb" value="2" onChange="answer(1)" />
2.SELECT
<div style="margin-bottom:10px"></div>
<input type="checkbox"  name="cb" value="3"onChange="answer(2)" />
3.UPDATE
<div style="margin-bottom:10px"></div>
<input type="checkbox"  name="cb"  value="4"onChange="answer(3)" />
4.DELETE
   </form>
   </div>
   
    <div id="footer" style="padding:5px;">
        <a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" >다음문제</a>
    </div>
 
</body>
</html>