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
	<script type="text/javascript" src="/Servlet3/js/jQuery-3.4.1.js"></script>
	<script type="text/javascript" src="/Servlet3/js/echarts.js"></script>
	<script type="text/javascript">
		$.get(
				"/Servlet3/one.do",
				"keyWord=",
				function(data){
					for(var i=0;i<data.length;i++){
						var str=$("<option></option>");
						str.text(data[i].dName);
						str.val(data[i].deptNo);
						$('#deptList').append(str);
					}
				},
				"json")
				$(function(){
					$('#deptList').change(function(){
						$.get('/Servlet3/dept/select.do',
								"deptNo="+$('#deptList').val(),
								function(data){
									$(".deptTable tr:gt(0)").remove();
									var xAxisArr=[];
									var numArr=[]
									for(var i=0;i<data.length;i++){
										// var str='<tr><td>'+data[i].dName+'</td><td>'+data[i].jobName+'</td><td>'+data[i].jobNum+'</td></tr>';
										// $('.deptTable').append(str);
										var $tr=$('<tr></tr>');
										if(i==0){
											var $td1=$('<td rowspan='+data.length+'></td');
											$tr.append($td1)
										}
											
										xAxisArr.push(data[i].jobName);
										numArr.push(data[i].jobNum);
										var $td2=$('<td></td>');
										var $td3=$('<td></td>');
										//console.log(i,$td1[0],$td2[0],$td3[0])
										$td1.text(data[i].dName);
										$td2.text(data[i].jobName);
										$td3.text(data[i].jobNum);
										$tr.append($td2).append($td3);
										$('.deptTable').append($tr);
									}
									
									var option={
											title:{
												text:"部门职位一览",
												subtext:data[0].dName,
												x:"center"
											},
											xAxis:{
												data:xAxisArr
											},
											yAxis:{},
											legend:{
												data:[data[0].dName],
												left:"left"
											},
											series:[{
												name:data[0].dName,
												type:"bar",
												data:numArr
											}]
									}
									var domObj=document.getElementById("main");
									var echartObj=echarts.init(domObj);
									echartObj.setOption(option);
									
								},
								"json"
								)
					})
				})
	</script>
</head>
<body>
	<select name="deptList" id="deptList">
		<option value="0">--请选择--</option>
	</select>
	<table class="deptTable" border="1" cellspacing="0">
		<tr>
			<td>部门名称</td>
			<td>职位名称</td>
			<td>职位人数</td>
		</tr>
	</table>
	<div id="main" style="width:600px;height:400px;"></div>
</body>
</html>