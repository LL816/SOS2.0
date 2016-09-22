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
	<c:forEach var="c" items="${requestScope.pageDisplayInfo.getDataToBeDisplayed()}">
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
<br>
<br>
<script>
function gotohref(id){
	  var target = document.getElementById(id);	 
	  var limit = document.getElementById("limit");
	  var number = document.getElementById("numGoto");
	  target.href= "${pageContext.request.contextPath }/Orders?currentPageNum="+number.value+"&limitInOnePage="+limit.value;

}
  function gethref(id,currentPageNum){
	  var target = document.getElementById(id);	 
	  var limit = document.getElementById("limit");

	  target.href= "${pageContext.request.contextPath }/Orders?currentPageNum="+currentPageNum+"&limitInOnePage="+limit.value;

  }
</script>
<form>
每页最多显示<input type="text" min=1 max=100 value=${pageDisplayInfo.getLimitInOnePage()} name="limitInOnePage" id="limit">行数据

共${pageDisplayInfo.getTotalPageNum()}页       
第<input type="number" min=1 max=${pageDisplayInfo.getTotalPageNum() } id="numGoto" value=${pageDisplayInfo.getCurrentPageNum() }>页
<a id="goto" href="" onclick="gotohref(this.id)">GO</a>    

<br>
<br>
<a id="pre" href="" onclick="gethref(this.id,${pageDisplayInfo.getPreviousPageNum()})">上一页 </a>   


<c:forEach var="chosenNum" items="${pageDisplayInfo.getPageBar()}">
	<a id=${chosenNum.intValue()} href="" onclick="gethref(this.id,${chosenNum.intValue()})">${chosenNum.intValue()}</a>   
</c:forEach>

<a id="next" href="" onclick="gethref(this.id,${pageDisplayInfo.getNextPageNum()})">下一页</a>   
</form>
<br>
<br>

</body>
</html>