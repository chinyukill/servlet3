<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<table border="2" style="text-align:center;">
		<tr>
			<td>部门名</td>
			<td>职位名</td>
			<td>人数</td>
		</tr>
		<c:forEach items="${requestScope.deptInfo}" var="bigMap_key_value">
			<c:forEach items="${bigMap_key_value.value}" var="key_value">
				<tr>
					<td>${bigMap_key_value.key}</td>
					<td>${key_value.key}</td>
					<td>${key_value.value}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
	<!--<table border="2" style="text-align:center;">
		<tr>
			<td>部门名</td>
			<td>职位名</td>
			<td>人数</td>
		</tr>
		<c:forEach items="${requestScope.deptInfo}" var="bigMap_key_value">
			<c:set var="rowNum" value="0"></c:set>
			<c:forEach items="${bigMap_key_value.value}" var="key_value" varStatus="countNum">
				<c:set var="rowNum" value="${rowNum+1}"></c:set>
			</c:forEach>
			<c:forEach items="${bigMap_key_value.value}" var="key_value" varStatus="countNum">
				<tr>
					<c:if test="${rowNum==countNum.count}">
						<td rowspan="${rowNum}">${bigMap_key_value.key}</td>
					</c:if>
					<td>${key_value.key}</td>
					<td>${key_value.value}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>-->
	<table border="2" style="text-align:center;">
		<tr>
			<td>部门名</td>
			<td>职位名</td>
			<td>人数</td>
		</tr>
		<c:forEach items="${requestScope.deptInfo}" var="bigMap_key_value">
			<c:set var="rowNum" value="0"></c:set>
			<c:forEach items="${bigMap_key_value.value}" var="key_value" varStatus="countNum">
				<c:set var="rowNum" value="${rowNum+1}"></c:set>
			</c:forEach>
			<c:forEach items="${bigMap_key_value.value}" var="key_value" varStatus="countNum">
				<tr>
					<c:if test="${countNum.count==1}">
						<td rowspan="${rowNum}">${bigMap_key_value.key}</td>
					</c:if>
					<td>${key_value.key}</td>
					<td>${key_value.value}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>