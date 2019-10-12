<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.chenxue.bean.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<table>
		<c:forEach items="${requestScope.students}" var="stu" varStatus="stuCount">
			<tr>
				<td>${stuCount.count}</td>
				<td>${stu.sid}</td>
				<td>${stu.sName}</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<c:forEach items="${requestScope.hashmaps}" var="key_Value">
			<tr>
				<td>${key_Value.key}</td>
				<td>${key_Value.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>