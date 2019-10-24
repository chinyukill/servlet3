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
		$(
			function(){
				$(":button:first").click(function(){
					$.get(
						"/Servlet3/one.do",
						"keyWord="+$('input[name="keyWord"]').val(),
						function(data){
							var html="";
							if(data.length>0){
								html="<tr>"
									+"<td>部门</td>"
									+"<td>编号</td>"
									+"<td>地址</td>"
									+"</tr>";
									for(var i=0;i<data.length;i++){
										html+="<tr>"
										html+="<td>"+data[i].dName+"</td>"
										+"<td>"+data[i].deptNo+"</td>"
										+"<td>"+data[i].loc+"</td>"
										html+="</tr>"
									}
									
							}else{
								html+="暂无数据";
							}
							$('#deptList').html(html);
							//$(":button:first").unbind("click");
						},
						"json"
					)
				})
			}
		)
	</script>
</head>
<body>
	<input type="text" name="keyWord" class="keyWord" />
	<button>检索</button>
	<table id="deptList"></table>
</body>
</html>