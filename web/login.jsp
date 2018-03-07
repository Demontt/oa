<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>工作汇报系统_登录</title>
	<link rel="stylesheet" href="css/login_1.css" media="screen" type="text/css" />
  </head>
  
  <body>
  <span href="#" class="button" id="toggle-login">Login_in</span>

  <div id="login">
	  <div id="triangle"></div>
	  <h1>工作汇报系统_登录</h1>
	  <form action="login" method="post">
		  <input type="text" placeholder="请输入工号" name="user.gh" />
		  <input type="password" placeholder="请输入密码" name="user.pwd"/>
		  <input type="submit" value="登录" />
		  <input type="submit" style="float: right" value="忘记密码" />
	  </form>
  </div>

  <script src='js/login_2.js'></script>

  <script src="js/login_1.js"></script>

  </body>
</html>
