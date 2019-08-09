<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> boardDetail = 
			(List<Map<String,Object>>)request.getAttribute("boardDetail");
	Map<String, Object> rMap = new HashMap<>();
	/*
	마이바티스 사용시 자동으로 담아주므로 vo의 경우 사용자가 대소문자를 구분해서 사용하지만
	Map의 경우 마이바티스가 컬럼명을 기준으로 자동으로 키값을 생성하는데 디폴트가 대문자임.
	*/
	if(boardDetail != null){
		rMap = boardDetail.get(0);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<%@ include file="/common/JEasyUICommon.jsp"%>
<script type="text/javascript">
	function addAction() {
		$("#f_boardAdd").attr("method","post");
		$("#f_boardAdd").attr("action","/board/test.mo?crud=boardAdd");
		$("#f_boardAdd").submit();
		//부모창에 함수를 호출할 때 opener.함수명(); - e.g. opener.boardList();
		self.close();
	}
	/***댓글***/
	function repleForm(){
		$("#dlg_boardAdd").dialog('open');
	}
	/***수정***/
	function updateForm(){
		
	}
	/***삭제***/
	function deleteForm(){
		
	}
	/***목록***/
	function boardList(){

	}
           
</script>
</head>
<body>
<table id="pan_read" class="easyui-panel" title="글상세보기" data-options="footer:'#tb_read'"
style="width:670px;height:380px;padding:10px;background:#fafafa;">
	<tr>
		<td>제목</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_TITLE") %>" id="bm_title"
				name="bm_title" data-options="width:'450px'"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_WRITER") %>" id="bm_writer"
				name="bm_writer" data-options="width:'450px'"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_EMAIL") %>" id="bm_email"
				name="bm_email" data-options="width:'450px'"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_CONTENT") %>" id="bm_content"
				name="bm_content" data-options="multiline:'true', width:'450px',height:'90px'"></td>
	</tr>
	<tr>
		<td>비번</td>
		<td><input class="easyui-textbox" value="" id="bm_pw"
				name="bm_pw" data-options="width:'450px'"></td>
	</tr>
</table>
<div id="tb_read" style="padding:2px 5px;" align="center">
	<a href="javascript:repleForm()" class="easyui-linkbutton" iconCls='icon-edit' plain="true">댓글쓰기</a>
	<a href="javascript:updateForm()" class="easyui-linkbutton" iconCls='icon-add' plain="true">수정</a>
	<a href="javascript:deleteForm()" class="easyui-linkbutton" iconCls='icon-remove' plain="true">삭제</a>
	<a href="javascript:boardList()" class="easyui-linkbutton" iconCls='icon-search' plain="true">목록</a>
</div>
<!-- 수정하기, 삭제하기, 댓글쓰기, 목록 버튼 -->
<!--==========================[글수정하기 화면]==========================-->

<!--==========================[글삭제하기 화면]==========================-->

<!--==========================[댓글쓰기    화면]==========================-->
<div id="dlg_boardAdd" title="댓글쓰기" class="easyui-dialog" data-options="closed:'true', modal:'true', footer:'#tbar_boardAdd'">
<!-- form전송 -->	
	<form id="f_boardAdd" method="post" enctype="multipart/form-data">
	<input type="hidden" name="crud" value="boardAdd"/>
	<input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO")%>"/>
	<input type="hidden" name="bm_group" value="<%=rMap.get("BM_GROUP")%>"/>
	<input type="hidden" name="bm_pos" value="<%=rMap.get("BM_POS")%>"/>
	<input type="hidden" name="bm_step" value="<%=rMap.get("BM_STEP")%>"/>
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
		</table>
	</form>
</div>
<!-- 입력 화면 버튼 추가 -->
<div id="tbar_boardAdd" align="right">
	<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save">저장</a>
	<a href="javascript:$('#dlg_boardAdd').dialog('close')"
	   class="easyui-linkbutton" iconCls="icon-cancel">닫기</a>
</div> 
</body>
</html>