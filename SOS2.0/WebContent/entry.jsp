<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please login first!</title>
<script>
	function changeImage(img){
		img.src=img.src+"?"+new Date().getTime();
	}
</script>
<%--排版无法完成兼容，浏览器页面大小变化会影响各模块分布 --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>
<div id="inputArea">
	<form id="inputInfo" action="${pageContext.request.contextPath }/Login" method="post">
		<div id="title1">user name</div> <div id="content1"><input type="text" id="userName" name="userName" height="1000" required="required"/><br></div>
		<div id="nameMessage">6~18 characters</div>
		<div id="title2">password</div> <div id="content2"><input type="password" id="passWd" name="passWd" required="required"/><br></div>
		<div id="passwdMessage">6~18 characters</div>
		<div id="login"><input type="submit" value="登录" style = "font-size:25px; width:100px; height:50px"/></div>
		<div id="statusMessage">${statusMessage }</div>
		<div id="randomImageInput"><input type="text" id="inputRandom" name="inputRandom"/></div>
		<div id="randomImage"><img src="${pageContext.request.contextPath }/RandomImage" id="imageRandom" name="imageRandom" onclick="changeImage(this)"></div>
	</form>
	<form action="${pageContext.request.contextPath }/register.jsp" method="get">
		<div id="register">
			<input type="submit" value="注册" style = "font-size:25px; width:100px; height:50px"/>
		</div>
	</form>	
</div>
</body>
</html>