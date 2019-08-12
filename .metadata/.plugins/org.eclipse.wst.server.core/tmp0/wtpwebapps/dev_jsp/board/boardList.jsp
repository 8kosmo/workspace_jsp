<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int tot = 0;
	if(session.getAttribute("s_tot")!=null){
		tot = Integer.parseInt(session.getAttribute("s_tot").toString());
	}
	out.print("tot:"+tot);
%>
<!-- 
	화면처리를 태그로 할 때와 스크립트로 할 때
	1.태그안에 코드를 작성하면 디자인과 코드가 분리가 안되서 가독성이 떨어짐.
	2.스크립트로 처리할 때 화면에서 코드가 분리됨(이벤트 처리나 DOM조작하는 코드작성시 접근성이 좋다)
	3.화면과 스크립트 코드를 분리하게 되면 react적용시 라이프 사이클에 따라 코드 적용이 용이함.
	 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC패턴을 적용한 계층형 게시판</title>
<%@ include file="/common/JEasyUICommon.jsp" %>
<script type="text/javascript">
	//var tb_value;
	function addAction() {
		$("#f_boardAdd").attr("method","post");
		$("#f_boardAdd").attr("action","/board/test.mo?crud=boardAdd");
		$("#f_boardAdd").submit();
	}
/*
학습목표
나는 오라클서버에서 조회된 결과를 담은 List<Map>을 화면(datagrid)에 출력을 내보낼 수 있다.
화면(DOM구성)과 Java코드가 만나는 부분에 대한 처리 방법에 대해 설명하고 코드에 적용할 수 있다.
화면은 html로 그리지만 조회된 결과를 html에 반영하기 위해 DOM을 조작하는 방법에 대해 말 할 수 있다.
그 둘 사이에서 json의 역할에 대해서 설명 할 수 있다.

결론
화면을 조작하는 여러가지 방법에 대한 경험을 가지고 다양한 UI솔루션이 제공하는 컴포넌트에
조회된 결과를 반영할 수 있도록 연습해 두자.
각 device 마다 혹은 시스템마다 서로 다른 UI솔루션을 선택하고 사용할 수 있으므로
여러가지 경우에 대해 미리 생각해 봄으로써 UI솔루션이 javascript기반이거나 xml기반 혹은
안드로이드에서 적용할 수 있도록 실습해 볼 것.
 */
	function boardList(){//태그 조작(DOM조작)
		cb_value=user_combo;
		//선택한 콤보에 대한 키워드
		tb_value=$("#keyword").val();
		//alert(cb_value);
		//alert(tb_value);
		$("#dg_board").datagrid({
			url:"/board/test.mo?crud=boardList&cb_search="+cb_value
					+"&keyword="+tb_value
					+"&pageNumber=1"
					+"&pageSize=2"
 			,onLoadSuccess: function data() {
				//alert("load success!");
				user_combo='';
				$.ajax({
					url:"test.mo?crud=total&cb_search="+cb_value
						+"&keyword="+tb_value
						+"&timestamp="+new Date().getTime()
					,method:"get"
					,success:function(data){
						alert(data);
						$("#pn_board").pagination({
							total:data
						});
					}
				});
				user_combo ='';
			} 
		});
	};
	function pageMove(pageNumber,pageSize){
        //alert(pageNumber+", "+pageSize);
        $("#dg_board").datagrid({
        	url:"/board/test.mo?crud=boardList&pageNumber="+pageNumber+"&pageSize="+pageSize
        });
	}
	function addForm(){
		//alert();
		$("#dlg_boardAdd").dialog('open');
	};
	function updForm(){
		alert();
	};
	function delForm(){
		alert();
	};
</script>
</head>
<body onLoad="boardList()">
<script type="text/javascript">
	//전역변수 선언위치
	//목록화면에서 사용자가 제목을 더블클릭 했을때 셀에 대한 정보만 들어있으므로
	//선택한 로우에 숫자값을 가지고 숨어있는 필드 bm_no값을 가져와서 담는다.
	var g_no
	var user_combo;//콤보박스에서 선택한 값 담기
/* ==========================[날짜 기본 포맷을 재정의]========================== */
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?"0"+m:m)+'-'+(d<10?"0"+d:d);
	}
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	};
	$(document).ready(function() {
/* ==========================[datagrid 초기화 및 설정]========================== */
		$("#dg_board").datagrid({
			 rownumbers:"true"
			,columns:[[
		        {field:'BM_NO',title:'글번호',width:100, hidden:'true'}
		       ,{field:'BM_TITLE',title:'제목',width:350}
		       ,{field:'BM_WRITER',title:'작성자',width:100,align:'center'}
		       ,{field:'BM_DATE',title:'작성일',width:100,align:'center'}
		       ,{field:'BS_FILE',title:'첨부파일',width:100,align:'left'}
		       ,{field:'BM_HIT',title:'조회수',width:100,align:'center'}
			]]
			,onSelect:function(index,row){
				//alert(row.BM_NO);
				g_no = row.BM_NO;
			}
			,onDblClickCell: function(index,field,value){
				//제목을 더블클릭
				if("BM_TITLE"==field){
					//alert("제목: "+value);
					common_window_popup("test.mo?crud=boardDetail&bm_no="+g_no,"900","650","read");
					//선택한 로우값 초기화
					$("#dg_board").datagrid('clearSelections');
				}
				//첨부파일 더블클릭
				else if("BS_FILE"==field){
					//alert("파일명: "+value);
					location.href="download.jsp?bs_file="+value;
				}
			}//end of onDdlClickCell
		});
/* ==========================[combobox 이벤트 처리]========================== */
		$("#cb_search").combobox({
			onChange:function(){
				user_combo = $(this).combobox('getValue');
			}
		});
/* ==========================[pagination 이벤트 처리]========================== */	
		$('#pn_board').pagination({
			total:<%=tot%>
			,pageSize:2
		    ,pageList: [2,3,5,10]
		//pageNumber:현재 내가 바라보는 페이지
		//pageSize:한 페이지에 뿌릴 로우 수
		   ,onSelectPage: function(pageNumber, pageSize){
               pageMove(pageNumber,pageSize);
           }
		});
/* ==========================[textbox 엔터 이벤트 처리]========================== */
		$("#keyword").textbox('textbox').bind('keydown',function(e){
			if(e.keyCode==13){
				//alert("엔터이벤트");
				$("#dg_board").datagrid({
					url:"test.mo?crud=boardList&cb_search="+user_combo+"&keyword="+$("#keyword").val()
				});
			}
		});
	});//end of ready
</script>
<!--==========================[글목록화면 시작]==========================
jEasyui의 DataGrid API를 활용하여 작성	
1)익스프레션을 이용하여 화면 처리
	:tr, td태그를 직접 작성해서 처리하는 방식
2)json포맷으로 처리해서 매핑
	:field명만 맞춰주면 자동으로 매핑
-->
<table id="dg_board" class="easyui-datagrid" title="글목록" style="width:800px;height:400px"
 data-options="toolbar:'#tb_board,#tb_search',footer:'#pn_board'"></table>
<!--==========================[페이지 네이션 추가]==========================-->
<div id="pn_board" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;"></div>
<!-- 조건검색 추가(툴바하기) -->
<div id="tb_search" style="padding:2px 5px;">
	<select id="cb_search" name="cb_search" class="easyui-combobox" panelHeight="auto" style="width:100px">
		<option selected value="">선택</option>
		<option value="bm_title">제목</option>
		<option value="bm_content">내용</option>
		<option value="bm_writer">작성자</option>
	</select>
	<input class="easyui-textbox" id="keyword" name="keyword" style="width:320px">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	작성일:<input class="easyui-datebox" id="bm_date" name="bm_date" style="width:120px">
</div>
<div id="tb_board" style="padding:2px 5px;">
	<a href="javascript:boardList()" class="easyui-linkbutton" iconCls='icon-search' plain="true">조회</a>
	<a href="javascript:addForm()" class="easyui-linkbutton" iconCls='icon-edit' plain="true">입력</a>
	<a href="javascript:updForm()" class="easyui-linkbutton" iconCls='icon-add' plain="true">수정</a>
	<a href="javascript:delform()" class="easyui-linkbutton" iconCls='icon-remove' plain="true">삭제</a>
</div>
<!--==========================[글목록화면 끝   ]==========================-->

<!--==========================[글쓰기화면 시작]==========================
jEasyui의 Dialog API를 활용하여 작성
-->
<div id="dlg_boardAdd" title="글쓰기" class="easyui-dialog" data-options="closed:'true', modal:'true', footer:'#tbar_boardAdd'">
<!-- form전송 -->	
	<form id="f_boardAdd" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bm_no" value="0">
	<input type="hidden" name="bm_group" value="0">
	<input type="hidden" name="bm_pos" value="0">
	<input type="hidden" name="bm_step" value="0">
		<table>
			<tr>
				<td width="100px">제목</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_title" name="bm_title" data-options="width:'400px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">작성자</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_writer" name="bm_writer" data-options="width:'200px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">이메일</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_email" name="bm_email" data-options="width:'300px'">
				</td>
			</tr>
			<tr>
				<td width="100px">내용</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_content" name="bm_content" data-options="multiline:'true',width:'400px',height:'150px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">비번</td>
				<td width="500px">
					<input class="easyui-passwordbox" id="bm_pw" name="bm_pw" data-options="width:'200px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">첨부파일</td>
				<td width="500px">
					<input class="easyui-filebox" id="bs_file" name="bs_file" data-options="width:'300px'">
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 입력 화면 버튼 추가 -->
<div id="tbar_boardAdd" align="right">
	<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save">저장</a>
	<a href="javascript:$('#dlg_boardAdd').dialog('close')"
	   class="easyui-linkbutton" iconCls="icon-cancel">닫기</a>
</div> 
<!--==========================[글쓰기화면 끝   ]==========================-->
</body>
</html>