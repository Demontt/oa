<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>工作汇报系统</title>
    
  </head>
  
  <body bgcolor="#f6f9fb">
       <span>工作汇报系统</span>
  </body>
</html>
