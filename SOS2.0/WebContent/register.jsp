<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/registerstyle.css">
</head>
<body>
<div id="RegisterinputArea">
	<form id="inputInfo" action="${pageContext.request.contextPath }/Register" method="post">
		<div id="title1">user name</div> <div id="content1"><input type="text" id="username" name="username" height="1000" required="required"/><br></div>
		<div id="nameMessage">6~18 characters</div>
		<div id="title2">password</div> <div id="content2"><input type="password" id="passwd" name="passwd" required="required"/><br></div>
		<div id="passwdMessage">6~18 characters</div>
		<div id="title3">password</div> <div id="content3"><input type="password" id="passwd2" name="passwd2" required="required"/><br></div>
		<div id="passwdMessage2">Re-enter your password</div>
		
		<div id="submit"><input type="submit" value="提交" style = "font-size:25px; width:100px; height:50px"/></div>
		<div id="statusMessage">${statusMessage }</div>
	</form>	
	
		<form action="${pageContext.request.contextPath }/entry.jsp" method="get">
		<div id="login">
			<input type="submit" value="返回登陆页面" style = "font-size:12px; width:100px; height:50px"/>
		</div>
	</form>	
	
</div>


</body>
</html>