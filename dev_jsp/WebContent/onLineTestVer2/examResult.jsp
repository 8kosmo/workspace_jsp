<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험응시결과</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
<script type="text/javascript">
	function examSend(){
		//alert("4번:"+$.cookie('c_test4'));
		var c_examno = $.cookie('c_examno');
		var exam_no = $('#exam_no').val();
		var dap1 = $.cookie('c_test1');
		var dap2 = $.cookie('c_test2');
		var dap3 = $.cookie('c_test3');
		var dap4 = $.cookie('c_test4');
		//전송한 답안지를 DB에 추가하고 현재 창은 닫기처리
 		$.ajax({
			method:"get"
			,url:"test.mo?crud=examAccount&exam_no="+c_examno
													+"&dap1="+dap1
													+"&dap2="+dap2
													+"&dap3="+dap3
													+"&dap4="+dap4
			,success:function(data){
				alert("당신의 취득점수는 "+data+" 입니다.");
			}
		});
		self.close();
	}
</script>
</head>
<body>
	<div id="pan_confirm" class="easyui-panel" style="width:700px;height:300px"
		data-options="title:'답인지 제출하기',closed:'true',footer:'#btn_confirm',modal:true">
		<div id="u_dap"></div>
		<script type="text/javascript">
			$("#u_dap").text(" 1번."+$.cookie('c_test1')+" 2번."+$.cookie('c_test2')
							+" 3번."+$.cookie('c_test3')+" 4번."+$.cookie('c_test4')
			);
		</script>
		수고하셨습니다.<br>
		답안지 제출 버튼을 눌러 주세요.
	</div>
	<div id="btn_confirm" align="center">
		<a href="javascript:examSend()" class="easyui-linkbutton">답인지제출</a>
	</div>
</body>
</html>