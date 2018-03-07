<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>工作汇报系统</title>
	<link rel="stylesheet" type="text/css" href="./css/main.css">

  </head>
  <body>
  	<iframe id="top" frameborder="0" src="<%=basePath%>main/head.jsp"></iframe>
	<iframe id="left" frameborder="0" src="<%=basePath%>main/left.jsp"></iframe>
	<div id="right">
		<iframe id="right1" frameborder="0" src="<%=basePath%>main/mainRight.jsp" name="rightFrame"></iframe>
	</div>
  </body>
</html>
