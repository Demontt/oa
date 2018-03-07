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
	<link rel="stylesheet" type="text/css" href="./css/list.css">

  </head>
  
  <body>
    <div id="bott1_1">
  	<div class="bott2">
  		<h2>待发年报</h2>
  	</div>
  	<div id="bott4">
  		<s:if test="#session.hbs.size()!=0">
  		<form action="" method="post">
			<table class="subtree1" width="600px;" style="margin-left: auto;margin-right: auto;">
				<tr align="center">
					<td class="td" bgcolor="#63ebfb" width="10%">序号</td>
					<td class="td" bgcolor="#63ebfb" width="20%">周期</td>
					<td class="td" bgcolor="#63ebfb" width="25%">日期</td>
					<td class="td" bgcolor="#63ebfb" width="20%">收件人</td>
					<td class="td" bgcolor="#63ebfb" width="25%" style="border-right: thin dashed gray;">操作</td>
				</tr>
				<s:iterator value="#session.hbs" status="status" var="info">
				<tr align="center">
					<td class="td">
						<s:property value="#status.count"/>
					</td>
					<td class="td">
						<s:property value="#info.zyys"/>年度
					</td>
					<td class="td">
						<s:property value="#info.rq"/>
					</td>
					<td class="td">
						<s:property value="#info.m_name"/>
					</td>
					<td class="td" style="border-right: thin dashed gray;" align="left">
						<div style="padding-left: 13px;">
							<!-- 两种获得服务器中对象属性的方法：#info.zyys和zyys。 -->
							<s:if test="#info.zyys==#session.zyy">
							<a style="color: blue;text-decoration: underline;" href="fasongHB?hb.ty=2&zyy=${info.zyys}">发送</a>
							&nbsp;
							<a style="color: blue;text-decoration: underline;" href="bianji?hb.ty=2&zyy=${info.zyys}">编辑</a>
							&nbsp;
							<a style="color: blue;text-decoration: underline;" href="deleteHB?hb.ty=2&zyy=${info.zyys}&hb.st=2">删除</a>
							</s:if>
							<s:if test="#info.zyys!=#session.zyy">
								<!-- 汇报的状态，汇报是已经发送了还是待发送。0表示没有邮件，1表示已发送，2表示待发送。 -->
								<s:if test="st==2">
								<span style="color: red;">
									汇报过期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</span>
								<a style="color: blue;text-decoration: underline;" href="javaScript:">删除</a>
								</s:if>
							</s:if>
						</div>
					</td>
				</tr>
				</s:iterator>
				<tr>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
				</tr>
			</table>
		</form>
		</s:if>
		<s:if test="#session.hbs.size()==0">
		<div id="bott7">
  			<div id="bott10">
  				<h1>目前还没有待发年报。</h1>
  			</div>
  		</div>
		</s:if>
		
  	</div>
  </div>
  </body>
</html>
