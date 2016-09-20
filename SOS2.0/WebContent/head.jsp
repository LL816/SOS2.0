<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	body{
		margin:0px;
		padding:0px;
		font-size:14px;
		background-color:#9999FF;
		overflow:hidden:
		text-align:center;		
	}
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
<%--target对应主页面划分frame的name，_top代表 Opens the linked document in the full body of the window--%>
<form action="${pageContext.request.contextPath }/Merchandise" target="main">
<input type="submit" value="商品清单" 	style = "font-size:25px; width:120px; height:50px"/>
</form>
</div>
<div id="button2">
<form action="${pageContext.request.contextPath }/Orders" target="main">
<input type="submit" value="订单列表" style = "font-size:25px; width:120px; height:50px"/>
</form>
</div>
<div id="button3">
<form action="${pageContext.request.contextPath }/entry.jsp" target="_top">
<input type="submit" value="退出" style = "font-size:25px; width:120px; height:50px"/>
</form>
</div>

