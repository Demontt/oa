<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>工作汇报</title>
	<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
	<link rel="stylesheet" href="css/login_1.css" media="screen" type="text/css" />
  </head>
  
  <body>
  <div id="login">
	  <h1>修改信息</h1>
	  <form form action="" method="post">
		  <input type="text" value="${us.username}" readonly="readonly" />
		  <input type="text" pattern="telephone" name="phone" placeholder="请输入手机号" />
		  <input type="password" placeholder="请输入原始密码" name="pwd" required="required"/>
		  <input type="password" placeholder="请输入新密码"  name="npwd" required="required"/>
		  <input type="submit" value="确定" />
	  </form>
  </div>
  <script src='js/login_2.js'></script>
  <script src="js/login_1.js"></script>
  </body>
</html>
