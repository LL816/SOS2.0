<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merchandise List</title>
<style>
	table,tr,td{
		border:1px solid black;
		width:80%;
    	white-space: nowrap;
    	font-size:20px;
	}
</style>
<script type="text/javascript">
 	function submitOrder(){
		var nums = document.getElementsByName("num");
		var names = document.getElementsByName("name");
		var prices = document.getElementsByName("price");
		var remains = document.getElementsByName("remain");
		
		var target = -1;
		for(var i=0;i<nums.length;i++){
			var input = nums[i];

			if(input.value>input.max){
				alert("wrong input");
				return false;
			}
			else if(input.value!=0){
				target=i;
				break;
			}
		}
		if(target==-1){
			return false;
		}
		else{
/*			var form = document.getElementById("submitOrder");
			var input1 = document.createElement("merchandiseName");
			input1.type = "hidden";
			input1.name = "merchandiseName";
			input1.value = names[target].value;

			var input2 = document.createElement("merchandisePrice");
			input2.type = "hidden";
			input2.name = "merchandisePrice";
			input2.value = prices[target].value;
				
			var input3 = document.createElement("merchandiseRemaining");
			input3.type = "hidden";
			input3.name = "merchandiseRemaining";
			input3.value = remains[target].value-nums[target].value;
			alert(input3.value);
			form.appendChild(input1);
			form.appendChild(input2);
			form.appendChild(input3);
			*/
			var input=document.getElementById("merchandiseName");
			input.value=names[target].value;
			var input=document.getElementById("merchandisePrice");
			input.value=prices[target].value;
			var input=document.getElementById("merchandiseRemaining");
			input.value=remains[target].value-nums[target].value;
			var input=document.getElementById("num");
			input.value=nums[target].value;
			return true;
		}		
 	}
</script>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<body>

<table>

	<tr>
		<th>名称</th>
		<th>单价</th>
		<th>余量</th>
		<th>选择数量</th>
	</tr>
	<c:forEach var="c" items="${requestScope.mers}">
	<tr>
		<td>${c.merchandiseName }<input name="name" type="hidden" value=${c.merchandiseName }></td>
		<td>${c.merchandisePrice }<input name="price" type="hidden" value=${c.merchandisePrice }></td>
		<td>${c.merchandiseRemaining }<input name="remain" type="hidden" value=${c.merchandiseRemaining }></td>
		<td><input type="number" name="num" value=0 min="0" max=${c.merchandiseRemaining } style="background-color:#9999FF"></td>
	</tr>
	</c:forEach>
</table>
<br>
<br>
${statusMessage}
<br>
<form id="submitOrder" action="Merchandise" method="post" onsubmit="return submitOrder()">
	<input type="hidden" name="merchandiseName" id="merchandiseName">
	<input type="hidden" name="merchandisePrice" id="merchandisePrice">
	<input type="hidden" name="merchandiseRemaining" id="merchandiseRemaining">
	<input type="hidden" name="num" id="num">
	<input type="submit" name="orderSubmit" value="提交订单" style="font-size:25px; width:150px; height:50px">
</form>
</body>
</html>