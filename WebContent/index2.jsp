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
	<script type="text/javascript">
	$.get(
			"/Servlet3/province_city/province.do",
			function(data){
				var html="<option value=0>--请选择--</option>";
				for(var i=0;i<data.length;i++){
					html+="<option value="+data[i].pId+">"+data[i].pName+"</option>"
				}
				$('.province').html(html);
			},
			"json"
		)
		$(function(){
			$('.province').change(function(){
				$.get(
				"/Servlet3/province_city/city.do",
				"pId="+$('.province').val(),
				function(data){
					var html="<option value=0>--请选择--</option>";
					for(var i=0;i<data.length;i++){
						html+="<option value="+data[i].cityId+">"+data[i].cityName+"</option>"
					}
					$('.city').html(html);
				},
				"json"
			)

		})
					
		})
	</script>
</head>
<body>
	<select name="province" id="province" class="province">
		<option value="0">--请选择--</option>

	</select>
	<select name="city" id="city" class="city">
			<option value="0">--请选择--</option>
	
		</select>
</body>
</html>