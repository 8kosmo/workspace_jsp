<%@page import="com.util.PageBar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//총 레코드 수
	int tot = 0;
	if(session.getAttribute("s_tot")!=null){
		tot = Integer.parseInt(session.getAttribute("s_tot").toString());
	}
	out.print("tot:"+tot);
	int size = 0;
	List<Map<String, Object>> boardList = 
			(List<Map<String, Object>>)request.getAttribute("boardList");
	if(boardList != null && boardList.size()>0){
		size = boardList.size();
	}
	/////////////페이지 네비게이션 추가분/////////////
	int numPerPage = 5;
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
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
	var tb_value;
/*
 * 각 로우별로 DB에서 새로 읽어들인 값이 출력이 되고 그 파일이름으로 다운로드 파일명을 찾아야 하므로
 이벤트가 발생할 때 파일 이름은 달라지게 된다.
 자바코드로 읽어들인 정보를 자바스크립트 변수로 사용하는 것은 가능한 일이나 그 값은 상수처럼 정해진 값
 즉 정적인 성격을 가지고 있으므로 사용할 때 주의할 것.
 서버에서 바뀐 값이 화면에 즉시 반영 될 수 없는 것은 서버페이지가 아닌 응답 페이지의 경우 이미 html코드로
 변경된 페이지가 다운되고 출력되므로 절대로 유동적인 변화를 기대할 수 없다.
 */
	function fileDown(fname) {
		location.href="download.jsp?bs_file="+fname;
	}
	function boardDetail(p_bmno){
		//common_window_popup("test.mo?crud=boardDetail&bm_no="+p_bmno,"900","650","read");
		location.href="test.mo?crud=boardDetail&bm_no="+p_bmno;
	}
	function addAction() {
		$("#f_boardAdd").attr("method","post");
		$("#f_boardAdd").attr("action","/board/test.mo?crud=boardAdd");
		$("#f_boardAdd").submit();
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
<body>
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
/* ==========================[combobox 이벤트 처리]========================== */
		$("#cb_search").combobox({
			onChange:function(){
				user_combo = $(this).combobox('getValue');
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
<table id="dg_board" class="easyui-datagrid" title="글목록" style="width:800px;height:600px"
 data-options="singleSelect:'true', toolbar:'#tb_board,#tb_search',footer:'#pn_board'">
<!-- 헤더 부분 추가 -->
	<thead>
		<tr>
			<th data-options="field:'BM_TITLE',width:'350px'">제목</th>
            <th data-options="field:'BM_WRITER',width:'100px'">작성자</th>
            <th data-options="field:'BM_DATE',width:'100px'">작성일</th>
            <th data-options="field:'BS_FILE',width:'100px'">첨부파일</th>
            <th data-options="field:'BM_HIT',width:'100px'">조회수</th>
		</tr>
	</thead>
	<!-- 데이터 출력 영역 -->
	<tbody>
<%
	if(size==0){
%>
		<tr>
			<td colspan="5">조회결과가 없습니다.</td>
		</tr>
<%
	}
	else if(size>0){
//		for(int i=0;i<size;i++){
		for(int i=nowPage*numPerPage;i<(nowPage*numPerPage)+numPerPage;i++){//초기값nowPage=0,numPerPage=2일경우, i=0;i<2;i++라는 뜻
			if(size==i) break;
			Map<String, Object> rMap = boardList.get(i);
%>
		<tr>
			<td>
<!-- 당신은 댓글 입니까? -->
<%	
	String imgPath = "\\pds\\";
	if(Integer.parseInt(rMap.get("BM_POS").toString()) > 0){
		for(int j=0;j<Integer.parseInt(rMap.get("BM_POS").toString());j++){
			out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		}
%>
	<img src="<%=imgPath %>reply.gif" border="0">
<%
	}
%>
	<a href="javascript:boardDetail('<%=rMap.get("BM_NO") %>')" style="text-decoration:none;color:black">
			<%=rMap.get("BM_TITLE")%></a>
			</td>
			<td><%=rMap.get("BM_WRITER")%></td>
			<td><%=rMap.get("BM_DATE")%></td>
<!-- 
익스프레션을 사용하게 되면 자바 코드로 읽어들인 값을 html태그 영역에 출력해준 결과가 로컬 PC로 다운된다.
소스보기를 해보면 익스프레션 식은 보이지 않고 처리 결과 즉 문자열만 확인할 수 있을 것이다.
이것만 보더라도 서버에서 변경된 결과값들이 화면에 왜 즉시 반영될 수 없는 구조 인지확인 할 수 있겠다.
자바 스크립트에서 값을 넘길 때는 반드시 싱글 혹은 더블 쿼테이션을 붙여야 변수로 취급 반지 않는다.
F12에서 undefine variable 메세지를 봤다면 그것 때문이다. -->
			<td><a href="javascript:fileDown('<%=rMap.get("BS_FILE")%>')" style="text-decoration:none;color:black"><%=rMap.get("BS_FILE")%></a></td>
			<td><%=rMap.get("BM_HIT")%></td>
		</tr>
<%
		}//end of for
	}//////end of else if
%>
	</tbody>
 </table>
<!--==========================[페이지 네이션 추가]==========================-->
<table border="1" bordercolor="red" style="width:800px;height:20px">
	<tr>
	<td align="center" >
<%
	String pagePath = "test.mo?crud=boardList";
	PageBar pb = new PageBar(numPerPage,size,nowPage,pagePath);
	String pagination = null;
	pagination = pb.getPageBar();
	out.print(pagination);
%>
	</td>
	</tr>
</table>
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
					<input class="easyui-filebox" id="bs_file" name="bs_file" 
						data-options="width:'300px'">
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