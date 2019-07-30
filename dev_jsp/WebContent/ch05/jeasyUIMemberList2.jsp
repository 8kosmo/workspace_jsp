<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Map" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/demo/demo.css">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function memberList(){
		$("#dg_member").datagrid({
			url:'./memberList.do'
		});
	}
</script>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<!-- 조회결과가 있니? -> if문 생각해야한다. -->
<!-- 조회결과가 있다면 반복문 처리해야함. -->
	<table id="dg_member" toolbar="#tb_member" class="easyui-datagrid" title="회원목록" width="400px" border="1">
		<thead>
		<tr>
			<th data-options="field:'mem_id',width:100">아이디</th> <!-- 컬럼이 매핑이 되어야 한다. -->
			<th data-options="field:'mem_pw',width:100">비번</th>
			<th data-options="field:'mem_name',width:100">이름</th></tr>
		</thead>
		<a herf="#"></a>
	</table>
<!-- 조회 결과가 없을땐 조회결과가 없습니다. 출력하기 -->
<!-- 테이블 안에 들어갈 링크버튼 추가 -->
	<div id="tb_member">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="memberList()">조회</a>
		
	</div>
</body>
</html>