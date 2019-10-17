<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
	<title>??</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
</head>
<body>
	<form action="/Servlet3/dept/add.do">
		部门编号：<input type="text" name="deptno"><br>
		部门名称：<input type="text" name="dname" onblur="check()"><br>
		<b class="showInfo"></b><br>
		部门地址：<input type="text" name="loc">
	</form>
</body>
</html>

<!--
<script text="text/javascrpt">

	function check(){
		var param=document.getElementsByName('dname')[0].value;
		var showInfo=document.getElementsByClassName('showInfo')[0];
		var xmlHttp=new XMLHttpRequest();
		xmlHttp.onreadystatechange=function(){
			
			if(xmlHttp.readyState==4){
				var data=xmlHttp.responseText;
				showInfo.innerHTML=data;
			}
		};
		xmlHttp.open('get','/Servlet3/dept/check.do?dname='+param,false);
		xmlHttp.send();
		window.alert("体现异步同步差异性标志")
	}
	
</script>
  -->
  <script type="text/javascript" src="/Servlet3/js/jQuery-3.4.1.js"></script>
	<script type="text/javascript">
		function check(){
			console.log( $("input[name='dname']").val())
			$.ajax({
				type:'get',
				url:'/Servlet3/dept/check.do',
				data:{dname: $("input[name='dname']").val() },
				dataType:'text',
				success:function(data){
					$('.showInfo').html(data)
				}
			})
		}
	
	</script>