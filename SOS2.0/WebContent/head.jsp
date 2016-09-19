<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#welcomeMessage{
		font-size:30px;
		color:blue;	
		float:left;	
	}
	#button1{
		margin-left:100px;
		float:left;

	}
	#button2{
		margin-left:100px;
		float:left;
	}
	#button3{
		float:right;
	}
</style>
<div id="welcomeMessage">
Welcome ${userName }!
</div>
<div id="button1">
<form action="${pageContext.request.contextPath }/merchandisesList.jsp">
<input type="submit" value="商品清单" 	style = "font-size:25px; width:120px; height:50px"/>
</form>
</div>
<div id="button2">
<form action="${pageContext.request.contextPath }/ordersList.jsp">
<input type="submit" value="订单列表" style = "font-size:25px; width:120px; height:50px"/>
</form>
</div>
<div id="button3">
<form action="${pageContext.request.contextPath }/entry.jsp">
<input type="submit" value="退出" style = "font-size:25px; width:120px; height:50px"/>
</form>
</div>

