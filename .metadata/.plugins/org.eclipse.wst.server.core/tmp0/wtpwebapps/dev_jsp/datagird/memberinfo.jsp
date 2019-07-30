<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
<table id="dg"></table>
	<script type="text/javascript">
		$('#dg').datagrid({
			columns : [[ 
				{field : 'code', title : 'Code', width : 100}, 
				{field : 'name', title : 'Name', width : 100}, 
				{field : 'price',title : 'Price',width : 100,align : 'right'}
			]],
			data:[
				{"code":"A001","name":"홍길동","price":1000}
			]
		});
	</script>
</body>
</html>