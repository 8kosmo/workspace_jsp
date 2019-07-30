<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.ZipCodeVO" %>
<%
	List<ZipCodeVO> zipList = 
	(List<ZipCodeVO>)request.getAttribute("zipList");
	int size = 0;
	if(zipList!=null && zipList.size()>0) {
		size = zipList.size();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
<script type="text/javascript">
	//전역변수 선언 => 선택한 로우의 주소를 담는다.
	var g_address; 
	var g_zipcode; 
	$(document).ready(function() {
		$('#dg_member').datagrid({
			url:"memberList.kos?work=member",
			title:"회원관리 ver1.0",
			toolbar:"#tb_member",
		    columns:[[
		        {field:'MEM_ID',title:'아이디',width:150},
		        {field:'MEM_NAME',title:'이름',width:150},
		        {field:'MEM_ADDR',title:'주소',width:300},
		        {field:'MEM_ZIPCODE',title:'우편번호',width:150}
		    ]]
		});/////////////////end of datagrid
		$('#dg_zipcode').datagrid({
			title:"우편번호 검색기",
		    columns:[[
		        {field:'zipcode',title:'우편번호',width:150, align:'center'},
		        {field:'address',title:'주소',width:300, align:'left'}
		    ]],
		    data:[
		    	{"zipcode":15067, "address":"서울시 금천구 가산동"}
		    ]
		});
		$('#dlg_zipcode').dialog({
			title:"우편번호 검색기"
		   ,width:580
		   ,height:500
		   ,footer:"#tb_ins"
		   ,closed:true
		});
		
		$('#dlg_ins').dialog({
			title:"회원가입"
		   ,width:500
		   ,height: 450
		   ,footer:"#tb_ins"
		   ,closed:true
		});
		$('#btn_save').linkbutton({
			onClick:function(){
				//alert('save');
				$('#dlg_ins').dialog('close');
				$('#f_ins').attr('method','get');
				$('#f_ins').attr('action','./memberInsert.kos');
				$('#f_ins').submit();
			}
		});
		$('#dong').textbox('textbox').bind('keydown', function(e){
			if (e.keyCode == 13){	// when press ENTER key, accept the inputed value.
				//alert("엔터침")
				//우편번호 데이터 초기화
				$('#dg_zipcode').datagrid({
					url:"./zipcodeList.kos?work=member&dong="+$(this).val()
					,singleSelect:true	// 하나만 선택?
					,onSelect:function(index,row) {
						var row = $(this).datagrid('getSelected');
						g_address = row.address;
						g_zipcode = row.zipcode;
						//alert(row.address);
					}
					,onDblClickCell:function(index,field,value){
						alert(index+","+field+","+value);
						if('address'==field||'zipcode'==field) {
							// 우편번호 textbox에 출력 id
							$("#mem_zipcode").textbox('setValue',g_zipcode);
							$("#mem_addr").textbox('setValue',g_address);
							$("#dg_zipcode").datagrid('clearSelections');
						}
					}
				});
			}
		});
		$('#btn_search').linkbutton({
			onClick:function(){
				var u_dong = $("#dong").val();
				$.ajax({
					method:'get'
					,url:'./member/zipcodeList.kos?work=member&dong='+u_dong
					,success:function(data) {
						alert('data:'+data);
						$("#dg_zipcode").datagrid({
							
						});
					}
				})
			}
		});
		$('#btn_close').linkbutton({
			onClick:function(){
				$('#dlg_ins').dialog('close');
			}
		});
		$('#btn_add').linkbutton({
			onClick:function(){
				$('#dlg_ins').dialog('open');
			}
		});
		$('#btn_zipcode').linkbutton({
			onClick:function(){
				$('#dlg_zipcode').dialog('open');
			}
		});
	});
</script>
<table id="dg_member"></table>
<div id="tb_member" style="padding:5px;">
<a id="btn_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">가입</a>
</div>
<!-- 우편번호 검색기 -->
	<div id="dlg_zipcode" style="width: 100%; max-width: 600px; padding: 30px">
		<input class="easyui-textbox" id="dong" name="mem_id" labelPosition="top" data-options="prompt:'동을 입력하세요'" style="width:210px;">
		<a id="btn_search"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">우편번호 찾기</a>
		<div style="margin-bottom:10px"></div> 
		<table border="1" id="dg_zipcode">
		</table>
	</div>
	<!-- 우편번호 검색기 -->
<!-- =================================== 회원가입 ======================================== -->
<!--
사용자가 화면에 입력한 값을 서버측에 전달할 때는 name속성이 반드시 필요하다. 
입력 받는 컴포넌트에 값이 담기기 때문에 반드시 form 전송으로 처리한다.
form태그는 여러개를 사용할 수 있고 아이디로 구분하여 서로 다른 서버 계층으로
전송이 가능하다.
화면에는 존재하지 않지만 개발자가 업무처리를 위한 목적으로 따로 전달하고 싶은
정보가 있을 때도 form태그를 사용할 것.
이때 사용하는 컴포넌트는 hidden 속성으로 처리한다.
hidden속성은 input type text 속성과 동일하게 사용하면 된다.
아이디와 이름 속성을 반드시 부여 하여
서버에 전송할 때와 ajax처리 할 떄를 준비해 둔다.
아이디는 절대로 중복되면 안 된다.
실제 서버로 전송할 때는 form태그에 메소드 방식과 목적지를 기술하지 말고
jquery api를 사용하여 함수 처리한다.
화면에 담겨 있는 정보들은 가독성이 떨어지고 화면 내용이 많아지게 되면
찾기가 불편함.
 -->
<div id="dlg_ins">
	<form id="f_ins">
		<input type="hidden" id="work" name="work" value="member"/>
   <div style="margin-bottom:10px">
            <input class="easyui-textbox" id="mem_id" name="mem_id" label="아이디:" labelPosition="top" data-options="prompt:'아이디를 입력하세요'" style="width:100%;">
        </div>
        <div style="margin-bottom:10px">
            <input class="easyui-textbox" id="mem_name" name="mem_name" label="이름:" labelPosition="top"  style="width:100%;">
        </div>
        <div style="margin-bottom:10px">
            <input class="easyui-textbox" id="mem_zipcode" name="mem_zipcode" label="우편번호:" labelPosition="top" style="width:100%;">
        	<a id="btn_zipcode"  href="#" class="easyui-linkbutton">우편번호 검색</a>
        </div>
        <div style="margin-bottom:10px">
            <input class="easyui-textbox" id="mem_addr" name="mem_addr" label="주소:" labelPosition="top" style="width:100%;">
        </div>
        <div style="margin-bottom:10px">
            <input class="easyui-passwordbox" id="mem_pw" name="mem_pw" label="비번:" labelPosition="top" data-options="prompt:'비밀번호를 입력하세요'" style="width:100%;">
        </div>
        </form>
</div>
<div id="tb_ins" style="padding:5px;">
<a id="btn_save"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">저장</a>
<a id="btn_close" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">닫기</a>
</div>
<!-- =================================== 회원가입 ======================================== -->
</body>
</html>