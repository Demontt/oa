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
	<link rel="stylesheet" type="text/css" href="./css/managersjxlist.css">

  </head>
  
  <body>
  	<div id="bott1">
	  	<div class="bott2">
	  		<h2>未读周报</h2>
	  	</div>
  		<div class="bott3">
			<table class="subtree1" width="365px;" style="margin-left: auto;margin-right: auto;">
				<tr align="center">
					<td class="td" bgcolor="#63ebfb" width="10%">序号</td>
					<td class="td" bgcolor="#63ebfb" width="20%">周期</td>
					<td class="td" bgcolor="#63ebfb" width="26%">部门</td>
					<td class="td" bgcolor="#63ebfb" width="24%">发件人</td>
					<td class="td" bgcolor="#63ebfb" width="20%" style="border-right: thin dashed gray;">操作</td>
				</tr>
				<s:iterator value="#session.wfzbs" status="status" var="info">
				<tr align="center">
					<td class="td">
						<s:property value="#status.count"/>
					</td>
					<td class="td">
						第<s:property value="zyys"/>周
					</td>
					<td class="td">
						<s:property value="bm_name"/>
					</td>
					<td class="td">
						<s:property value="csren"/>
					</td>
					<td class="td" style="border-right: thin dashed gray;" align="center">
						<!-- 允许管理员在任何周期批复当前周期之前的汇报。 -->
						<a href="pifu?hb.ty=0&zyy=${zyys}&hb.csren=${csren}">
    						<input type="button" class="inpu1" value='批复'/>
    					</a>
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
  		</div>
  	</div>
  	<div id="bott1_1">
  	  	<div class="bott2">
	  		<h2>未读月报</h2>
	  	</div>
  		<div class="bott3">
			<table class="subtree1" width="365px;" style="margin-left: auto;margin-right: auto;">
				<tr align="center">
					<td class="td" bgcolor="#63ebfb" width="10%">序号</td>
					<td class="td" bgcolor="#63ebfb" width="20%">周期</td>
					<td class="td" bgcolor="#63ebfb" width="26%">部门</td>
					<td class="td" bgcolor="#63ebfb" width="24%">发件人</td>
					<td class="td" bgcolor="#63ebfb" width="20%" style="border-right: thin dashed gray;">操作</td>
				</tr>
				<s:iterator value="#session.wfybs" status="status" var="info">
				<tr align="center">
					<td class="td">
						<s:property value="#status.count"/>
					</td>
					<td class="td">
						第<s:property value="zyys"/>月
					</td>
					<td class="td">
						<s:property value="bm_name"/>
					</td>
					<td class="td">
						<s:property value="csren"/>
					</td>
					<td class="td" style="border-right: thin dashed gray;" align="center">
						<!-- 允许管理员在任何周期批复当前周期之前的汇报。 -->
						<a href="pifu?hb.ty=1&zyy=${zyys}&hb.csren=${csren}">
    						<input type="button" class="inpu1" value='批复'/>
    					</a>
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
  		</div>
  	</div>
  	<div id="bott1_2">
  	  	<div class="bott2">
	  		<h2>未读年报</h2>
	  	</div>
  		<div class="bott3">
			<table class="subtree1" width="365px;" style="margin-left: auto;margin-right: auto;">
				<tr align="center">
					<td class="td" bgcolor="#63ebfb" width="10%">序号</td>
					<td class="td" bgcolor="#63ebfb" width="20%">周期</td>
					<td class="td" bgcolor="#63ebfb" width="26%">部门</td>
					<td class="td" bgcolor="#63ebfb" width="24%">发件人</td>
					<td class="td" bgcolor="#63ebfb" width="20%" style="border-right: thin dashed gray;">操作</td>
				</tr>
				<s:iterator value="#session.wfnbs" status="status" var="info">
				<tr align="center">
					<td class="td">
						<s:property value="#status.count"/>
					</td>
					<td class="td">
						第<s:property value="zyys"/>年
					</td>
					<td class="td">
						<s:property value="bm_name"/>
					</td>
					<td class="td">
						<s:property value="csren"/>
					</td>
					<td class="td" style="border-right: thin dashed gray;" align="center">
						<!-- 允许管理员在任何周期批复当前周期之前的汇报。 -->
						<a href="pifu?hb.ty=0&zyy=${zyys}&hb.csren=${csren}">
    						<input type="button" class="inpu1" value='批复'/>
    					</a>
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
  		</div>
  	</div>
  </body>
</html>
