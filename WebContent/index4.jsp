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

	<script type="text/javascript" src="/Servlet3/js/echarts.js"></script>
	<script type="text/javascript">
		function fun1(){
			var option={
					title:{
						text:"学生成绩一览",
						subtext:"MIKE&ALLEN",
						x:"center"
					},
					xAxis:{
						data:["一月","二月","三月"]
					},
					yAxis:{},
					legend:{
						data:["MIKE","ALLEN"],
						left:"left"
					},
					series:[{
						name:"MIKE",
						type:"bar",
						data:[80,90,30]
					},{
						name:"ALLEN",
						type:"bar",
						data:[33,45,69]
					}]
			}
			var domObj=document.getElementById("main");
			var echartObj=echarts.init(domObj);
			echartObj.setOption(option);
		}
	</script>
</head>
<body>
	<input type="button" value="柱状图" onclick="fun1()">
	<div id="main" style="width:600px;height:400px;"></div>
</body>
</html>