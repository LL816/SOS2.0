<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Congrats</title>

</head>

<%-- <%@ include file="head.jsp" %>
定义了frameset就不需要body。
frame的名字用于其他页面通过指定target控制显示区域
 --%>
<frameset rows="15%,*">
	<frame name="head" src="${pageContext.request.contextPath }/head.jsp">
	<frame name="main" src="#">
</frameset>


</html>