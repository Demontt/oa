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
	<script type="text/javascript">
		function likai(){
			var inputObj = document.getElementById("inphone");
			var us = document.getElementById("phonemes");
			//先去空
			var reg = /[ ]+/g;
			var str = inputObj.value;
			var str1 = str.replace(reg,"");
			if(str1==""){
				us.innerHTML = "请正确输入手机号";
				return false;
			}else{
				var reg1 = /^1[3|4|5|7|8][0-9]\d{8}$/;
				var f = reg1.test(str1);
				if(f){
					inputObj.value=str1;
					us.innerHTML = "";
					return true;
				}
				if(!f){
					us.innerHTML = "请正确输入手机号";
					return false;
				}
			}
		}
		function sub(){
			return likai();
		}

        function update(a){
            var b = "update?user.username="+a;
            document.form1.action=b;
            document.form1.submit();
        }
	</script>
  </head>
  
  <body>
    <div id="bott1_1" style="width: 1000px;margin-left: 110px;">
  	<div class="bott2">
  		<h2>员工管理</h2>
  	</div>
  	<div id="bott4" style="margin-left: 40px;">
  		<form action="" method="post" name="form1" >
			<table class="subtree1" width="800px;" style="margin-left: auto;margin-right: auto;">
				<tr align="center">
					<td class="td" bgcolor="#63ebfb" width="10%">序号</td>
					<td class="td" bgcolor="#63ebfb" width="20%">部门</td>
					<td class="td" bgcolor="#63ebfb" width="15%">权限</td>
					<td class="td" bgcolor="#63ebfb" width="20%">姓名</td>
					<td class="td" bgcolor="#63ebfb" width="35%" style="border-right: thin dashed gray;">操作</td>
				</tr>
				<s:iterator value="#session.users" status="status" var="info">
				<tr align="center">
					<td class="td">
						<s:property value="#status.count"/>
					</td>
					<td class="td">
						<s:property value="bm_id"/>
					</td>
					<td class="td">
						<s:property value="pow"/>
					</td>
					<td class="td">
						<s:property value="username"/>
					</td>
					<td class="td" style="border-right: thin dashed gray;">
    					<!-- 超级管理员在管理员没有管理员工的情况下可以删除 -->
    					<s:if test="xss==0">
						<a href="javaScript:">
    						<input type="button" class="inpu1" value='删除'/>
    					</a>
    					&nbsp;&nbsp;
    					</s:if>
    					<s:if test="xss!=0">
    					<input type="button" class="inpu1" style="background-color: gray;" disabled="disabled" value='删除'/>
    					&nbsp;&nbsp;
    					</s:if>
						<a href="update?user.username=${username}">
							<input type="button" class="inpu1" value="修改"/>
						</a>
    					<s:if test="xss==0">
						&nbsp;&nbsp;
    					<a href="javaScript:">
    						<input type="button" class="inpu1" value='撤权'/>
    					</a>
    					</s:if>
    					<s:if test="xss!=0">
						&nbsp;&nbsp;
    						<input type="button" class="inpu1" disabled="disabled" style="background-color: gray;" value='撤权'/>
    					</s:if>
    					
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
  	</div>
  	<!-- 超级管理员的修改 -->
  	<s:if test="#session.f==1">
  	<div id="bott4" style="margin-left: 40px;height: 140px;">
	  	<div class="bott2">
	  		<h2>修改</h2>
	  	</div>
  		<form action="upuser" method="post">
  			<input type="hidden" value="${user.id}" name="user.id"/>
			<table class="subtree1" width="650px;" style="margin-left: auto;margin-right: auto;">
				<tr align="center">
					<td class="td" bgcolor="#63ebfb" width="13%">姓名</td>
					<td class="td" bgcolor="#63ebfb" width="18%">工号</td>
					<td class="td" bgcolor="#63ebfb" width="20%">手机号</td>
					<td class="td" bgcolor="#63ebfb" width="29%">部门</td>
					<td class="td" bgcolor="#63ebfb" width="20%" style="border-right: thin dashed gray;">操作</td>
				</tr>
				<tr align="center">
					<td class="td">
						<s:property value="user.name"/>
					</td>
					<td class="td">
						<s:property value="user.gh"/>
					</td>
					<td class="td">
						<input id="inphone" type="text" name="user.phone" value="${user.phone}" style="font-size: 15px;width: 120px;" onblur="likai()"/>
					</td>
					<td class="td">
						<select name="bmname">
							<s:iterator value="bms" status="status" var = "info">
							<option value="<s:property value="#info.name"/>">
								<s:property value="#info.name"/>
							</option>
							</s:iterator>
						</select>
					</td>
					<td id="td" style="border-right: thin dashed gray;">
    					<input type="submit" class="inpu1" value='确定'/>
					</td>
				</tr>
				<tr>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
					<td style="border-bottom: thin dashed gray;"></td>
				</tr>
			</table>
		</form>
		<div style="width: 150px;height: 20px;margin: 0 auto;margin-top:-10px;">
			<span id="phonemes" style="color: red;">${mes}</span>
		</div>
  	</div>
  	</s:if>
  	
  </div>
  </body>
</html>
