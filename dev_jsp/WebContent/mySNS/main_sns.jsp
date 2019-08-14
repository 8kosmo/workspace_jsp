<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
	List<Map<String,Object>> smsgList = 
	(List<Map<String,Object>>)request.getAttribute("smsgList");
	if(smsgList !=null){
		out.print("list ==> "+smsgList.size());
		for(int i=0;i<smsgList.size();i++){
			Map<String,Object> rMap = smsgList.get(i);
			Object keys[]  = rMap.keySet().toArray();
			for(int j=0;j<keys.length;j++){
				out.print(rMap.get(keys[j]));
			}
		}
	}
%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>My Simple SNS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$.ajax({
		 method:"get"
		,url:"test.mvc?crud=smsgList&timestamp="+new Date().getTime()
		,success:function(data){
			//alert(data);
			$("#d_msg").html(data);
		}
	});
</script>
<div class="jumbotron text-center">
  <h1>My Simple SNS</h1>
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-8">
      <h3>친구들의 최신소식</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
      <div id="d_msg"></div>
    </div>
    <div class="col-sm-4">
      <h3>새로운 친구들!!!</h3>        
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div>
</div>

</body>
</html>
