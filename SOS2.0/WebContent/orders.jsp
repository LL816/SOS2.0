<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Lists</title>
</head>
<style>
	table,tr,td{
		border:1px solid black;
		width:80%;
    	white-space: nowrap;
    	font-size:20px;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<body>
<form action="Orders" method="post" >
<table>

	<tr>
		<th>商品名称</th>
		<th>商品单价</th>
		<th>商品数量</th>
		<th>商品总价</th>
		<th>选择订单</th>
	</tr>
	<c:forEach var="c" items="${requestScope.orders}">
	<tr>
		<td>${c.merchandiseName }</td>
		<td>${c.merchandisePrice }</td>
		<td>${c.num }</td>
		<td>${c.total_price }</td>
		<td><input type="radio" name="orderSelect" value="${c.order_id}" style="font-size:20px;background-color:#9999FF;"></td>
	</tr>
	</c:forEach>
</table>
<br>
<br>
${statusMessage}
<br>

<input type="submit" name="orderSubmit" value="删除订单" style="font-size:25px; width:150px; height:50px">
</form>
</body>
</html>