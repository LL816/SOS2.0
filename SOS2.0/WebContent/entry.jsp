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
<style type="text/css">
	body{
		margin:0px;
		padding:0px;
		font-size:14px;
		background-color:#9999FF;
		overflow:hidden:
		text-align:center;		
	}
	#inputArea{
		border:3px solid green;
		margin:auto;
		background-image:url('login.png');
		width:869px;
		height:265px;

	}
	#title1{

		font-size:40px;
		text-transform:uppercase;
		position:absolute;
		top:40%;
		left:30%;
	}	
	#content1{
		position:absolute;
		top:41.5%;
		left:45%;	
	}
	#nameMessage{
		color:blue;
		position:absolute;
		top:41.5%;
		left:60%;	
		font-size:20px;
	}
	#title2{
		font-size:40px;
		text-transform:uppercase;
		position:absolute;
		top:50%;
		left:30%;
	}
	#content2{
		position:absolute;
		top:51.5%;
		left:45%;

	}
	#passwdMessage{
		color:blue;
		position:absolute;
		top:51.5%;
		left:60%;
		font-size:20px;
	}
	#login{
		position:absolute;
		top:75%;
		left:40%;

	}
	#register{
		position:absolute;
		top:75%;
		left:60%;

	}
	#statusMessage{
		color:red;
		position:absolute;
		top:67%;
		left:40%;
		font-size:20px;
	}
	#randomImageInput{
		position:absolute;
		top:60%;
		left:40%;
	}
	#randomImage{
		position:absolute;
		top:60%;
		left:55%;
	}

</style>

</head>

<body>
<div id="inputArea">
	<form id="inputInfo" action="${pageContext.request.contextPath }/Login" method="post">
		<div id="title1">user name</div> <div id="content1"><input type="text" id="username" name="username" height="1000" required="required"/><br></div>
		<div id="nameMessage">6~18 characters</div>
		<div id="title2">password</div> <div id="content2"><input type="password" id="passwd" name="passwd" required="required"/><br></div>
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