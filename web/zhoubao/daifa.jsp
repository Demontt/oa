<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xinjian.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 设置当前页面允许使用中文 -->
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/list.css">
	<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="./js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function f1(){
			WdatePicker({minDate:'%y-%M-{%d}',maxDate:'2050-10-01'});
		}
		function add_t1(a) {
	    	var tds = $(a).parent().parent().parent().parent().children();
	    	var xh = tds.eq(tds.length-1).children().eq(0).text();
	    	var num = parseInt(xh) + 1;
	        var new_tr =
            $('<tr align="center">'+
                '<td class="td">'+num+'</td>'+
                '<td class="td">'+
                '<textarea name="cdtask" style="resize:none; margin-top: 5px;" rows="1" cols="43"></textarea>'+
                '</td>'+
                '<td class="td">'+
                '<input name="xdrq" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; "/>'+
                '</td>'+
                '<td class="td">'+
                '<input name="wcrq" class="d4312" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px;"/>'+
                '</td>'+
                '<td class="td" style="border-right: thin dashed gray;">'+
                '<div style="width: 40px;height: 20px;">'+
                '<a href="javascript:" onclick="add_t1(this);">增加</a>'+
                '</div>'+
                '<div style="margin-top: 3px; width: 40px;height: 20px;">'+
                '<a href="javascript:" onClick="del_t1(this);">删除</a>'+
                '</div>'+
                '</td>'+
                '</tr>');
            $("#n1").append(new_tr);
		}
		function del_t1(a){
			$(a).parent().parent().parent().remove();
			var tds = $("#n1").children();
			for(var i=1;i<=tds.length-1;i++){
				tds.eq(i).children().eq(0).text(i);
			}
		}
		function add_t2(a) {
	    	var tds = $(a).parent().parent().parent().parent().children();
	    	var xh = tds.eq(tds.length-1).children().eq(0).text();//1
	    	var num = parseInt(xh) + 1;//2
	        var new_tr = 
	          $('<tr align="center">'+
	          		'<td class="td">'+num+'</td>'+
	          		'<td class="td">'+
	          			'<textarea name="nextTask" style="resize:none; margin-top: 5px;" rows="1" cols="33"></textarea>'+
	          		'</td>'+
	          		'<td class="td">'+
	          			'<input name="nextWCDate" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:145px; margin-top: 4px; font-size: 21px; "/>'+
	          		'</td>'+
	          		'<td class="td">'+
	          			'<select name="nextzrren">'+
	          				'<s:iterator value="#session.users" status="status" var = "info">'+
							'<option value="<s:property value="#info.username"/>">'+
								'<s:property value="#info.username"/>'+
							'</option>'+
							'</s:iterator>'+
	          			'</select>'+
	          		'</td>'+
	          		'<td class="td">'+
	          			'<select name="nextczbm">'+
	          				'<s:iterator value="#session.bms" status="status" var = "info">'+
							'<option value="<s:property value="#info.name"/>">'+
								'<s:property value="#info.name"/>'+
							'</option>'+
							'</s:iterator>'+
	          			'</select>'+
	          		'</td>'+
	          		'<td class="td">'+
	          			'<textarea name="nextbz" style="resize:none; margin-top: 5px;" rows="1" cols="12"></textarea>'+
	          		'</td>'+
	          		'<td class="td" style="border-right: thin dashed gray;">'+
	          			'<div style="width: 40px;height: 20px;">'+
	          				'<a href="javascript:" onclick="add_t2(this);">增加</a>'+
	          			'</div>'+
	          			'<div style="margin-top: 3px; width: 40px;height: 20px;">'+
								'<a href="javascript:" onClick="del_t2(this);">删除</a>'+
						'</div>'+
	          		'</td>'+
	          	'</tr>');
	        $("#n2").append(new_tr);
		}
		function del_t2(a){
			$(a).parent().parent().parent().remove();
			var tds = $("#n2").children();
			for(var i=1;i<=tds.length-1;i++){
				tds.eq(i).children().eq(0).text(i);
			}
		}
		function add_t3(a) {
	    	var tds = $(a).parent().parent().parent().parent().children();
	    	var xh = tds.eq(tds.length-1).children().eq(0).text();
	    	var num = parseInt(xh) + 1;
	        var new_tr = 
	          $('<tr align="center">'+
					'<td class="td">'+num+'</td>'+
					'<td class="td">'+
						'<textarea name="wtrenwu" style="resize:none; margin-top: 5px;" rows="1" cols="25"></textarea>'+
					'</td>'+
					'<td class="td">'+
						'<textarea name="wtwt" style="resize:none; margin-top: 5px;" rows="1" cols="25"></textarea>'+
					'</td>'+
					'<td class="td">'+
						'<textarea name="wtdc" style="resize:none; margin-top: 5px;" rows="1" cols="25"></textarea>'+
					'</td>'+
					'<td class="td" style="border-right: thin dashed gray;">'+
						'<div style="width: 40px;height: 20px;">'+
							'<a href="javascript:" onclick="add_t3(this);">增加</a>'+
						'</div>'+
						'<div style="margin-top: 3px; width: 40px;height: 20px;">'+
							'<a href="javascript:" onClick="del_t3(this);">删除</a>'+
						'</div>'+
					'</td>'+
				'</tr>');
	        $("#n3").append(new_tr);
		}
		function del_t3(a){
			$(a).parent().parent().parent().remove();
			var tds = $("#n3").children();
			for(var i=1;i<=tds.length-1;i++){
				tds.eq(i).children().eq(0).text(i);
			}
		}

        function upsashb(a){
            var b = "upsashb?zyy=${hb.zyys}&hb.ty=0&hb.st="+a;
            document.form1.action=b;
            document.form1.submit();
        }
	</script>
  </head>
  
  <body>
    <div id="bott1_1">
  	<div id="bott2">
  		<h2>员工周报</h2>
  	</div>
	<div id="bott3">
		<table width="1100px;">
	  		<tr>
	  			<td width="140px;"></td>
	  			<td width="70px;">当前状态:</td>
	  			<td width="400px;">&nbsp;&nbsp;编辑</td>
	  			<td width="90px;">当前处理人:</td>
	  			<td width="400px;">${sessionScope.name}</td>
	  		</tr>
	  	</table>
	</div>
	<div id="bott4">
	<!-- 解决了同一个form需由有两个不同的提交路径问题。 -->
		<form action="" method="post" name="form1">
	  		<!-- 隐藏数据区域 -->
	  		<input type="hidden" name="hb.id" value="${hb.id}"/>
	  		<input type="hidden" name="hb.bm_name" value="${hb.bm_name}"/>
	  		<input type="hidden" name="hb.rq" value="${hb.rq}"/>
	  		<input type="hidden" name="hb.m_name" value="${hb.m_name}"/>
	  		<input type="hidden" name="hb.zyys" value="${hb.zyys}"/>
	  			
				<table id="subtree1" width="1100px;">
					<tr>
						<td class="td" width="16%" bgcolor="#63ebfb">公司</td>
						<td class="td" width="35%">&nbsp;&nbsp;芊芊股份有限公司</td>
						<td class="td" width="4%" bgcolor="#63ebfb">部门</td>
						<td class="td" width="45%" style="border-right: thin dashed gray;">&nbsp;&nbsp;${hb.bm_name}</td>
					</tr>
					<tr>
						<td class="td" bgcolor="#63ebfb">姓名</td>
						<td class="td">&nbsp;&nbsp;${sessionScope.name}</td>
						<td class="td" bgcolor="#63ebfb">日期</td>
						<td class="td" style="border-right: thin dashed gray;">&nbsp;&nbsp;${hb.rq}</td>
					</tr>
					<tr>
						<td class="td" bgcolor="#63ebfb">汇报上级</td>
						<td class="td">&nbsp;&nbsp;${hb.m_name}</td>
						<td class="td" bgcolor="#63ebfb">周数</td>
						<td class="td" style="border-right: thin dashed gray;">&nbsp;&nbsp;第${hb.zyys}周</td>
					</tr>
					<tr>
						<td class="td" bgcolor="#63ebfb">上周工作重点</td>
						<td class="td" style="border-right: thin dashed gray;" colspan="3">
							<table class="td_table">
								<tbody id="n">
							  		<tr align="center">
							  			<td class="td" width="6%" bgcolor="#63ebfb">序号</td>
							  			<td class="td" width="74%" bgcolor="#63ebfb">承担的任务</td>
							  			<td class="td" width="20%" bgcolor="#63ebfb" style="border-right: thin dashed gray;">预计完成日期</td>
							  		</tr>
							  		<s:iterator value="pts" status="status" var ="info" >
										<%--id="pts"--%>
						  			<tr align="center">
							  			<td class="td">
							  				<s:property value="#status.count"/>
										</td>
							  			<td class="td">
							  			<!-- textarea得到Action中的参数格式固定，只能这么写，不然前面会有很多空格。 -->
											<textarea name="precdt" disabled="disabled" style="resize:none; margin-top: 5px;" rows="1" cols="67"><s:property value="#info.cdtask"/></textarea>
										</td>
							  			<td class="td" style="border-right: thin dashed gray;">
											<input name="prerq1" class="d4311" disabled="disabled" value="<s:property value="#info.wcrq"/>" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; "/>
											<div style="display: none;">
												<input name="returnDate" disabled="disabled" class="d4312" class="Wdate" type="text" onFocus="f2();" style="height: 33px; width:175px; margin-top: 23px; font-size: 21px;"/>
											</div>
										</td>
						  			</tr>
						  			</s:iterator>
						  		</tbody>
						  		<tr>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  		</tr>
						  	</table>
						  </td>
					</tr>
					<tr>
						<td class="td" bgcolor="#63ebfb">本周主要工作总结</td>
						<td class="td" style="border-right: thin dashed gray;" colspan="3">
							<table class="td_table">
								<tbody id="n1">
								<tr align="center">
									<td class="td" width="4%" bgcolor="#63ebfb">序号</td>
									<td class="td" width="50%" bgcolor="#63ebfb">承担的任务</td>
									<td class="td" width="20%" bgcolor="#63ebfb">任务下达日期</td>
									<td class="td" width="20%" bgcolor="#63ebfb">计划完成日期</td>
									<td class="td" width="6%" bgcolor="#63ebfb" style="border-right: thin dashed gray;">操作</td>
								</tr>
								<s:if test="#session.nts.size()==0">
									<tr align="center">
										<td class="td">1</td>
										<td class="td">
											<textarea name="cdtask" style="resize:none; margin-top: 5px;" rows="1" cols="43"></textarea>
										</td>
										<td class="td">
											<input name="xdrq" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; "/>
										</td>
										<td class="td">
											<input name="wcrq" class="d4312" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; "/>
										</td>
										<td class="td" style="border-right: thin dashed gray;">
											<div style="width: 40px;height: 20px;">
												<a href="javascript:" onclick="add_t1(this);">增加</a>
											</div>
										</td>
									</tr>
								</s:if>
								<s:elseif test="#session.nts.size()!=0">
									<s:iterator value="#session.nts" status="status" var ="info" >
										<%--id="nextts"--%>
										<s:if test="#status.count==1">
											<tr align="center">
												<td class="td">
													<s:property value="#status.count"/>
												</td>
												<td class="td">
													<textarea name="cdtask" style="resize:none; margin-top: 5px;" rows="1" cols="43"><s:property value="#info.cdtask"/></textarea>
												</td>
												<td class="td">
													<input name="xdrq" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; " value="<s:property value="#info.xdrq"/>"/>
												</td>
												<td class="td">
													<input name="wcrq" class="d431w" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; " value="<s:property value="#info.wcrq"/>"/>
												</td>
												<td class="td" style="border-right: thin dashed gray;">
													<div style="width: 40px;height: 20px;">
														<a href="javascript:" onclick="add_t1(this);">增加</a>
													</div>
												</td>
											</tr>
										</s:if>
										<s:elseif test="#status.count!=1">
											<tr align="center">
												<td class="td">
													<s:property value="#status.count"/>
												</td>
												<td class="td">
													<textarea name="cdtask" style="resize:none; margin-top: 5px;" rows="1" cols="43"><s:property value="#info.cdtask"/></textarea>
												</td>
												<td class="td">
													<input name="xdrq" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; " value="<s:property value="#info.xdrq"/>"/>
												</td>
												<td class="td">
													<input name="wcrq" class="d4312" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:175px; margin-top: 4px; font-size: 21px; " value="<s:property value="#info.wcrq"/>"/>
												</td>
												<td class="td" style="border-right: thin dashed gray;">
													<div style="width: 40px;height: 20px;">
														<a href="javascript:" onclick="add_t1(this);">增加</a>
													</div>
													<div style="margin-top: 3px; width: 40px;height: 20px;">
														<a href="javascript:" onClick="del_t1(this);">删除</a>
													</div>
												</td>
											</tr>
										</s:elseif>
									</s:iterator>
								</s:elseif>
								</tbody>
								<tr>
									<td style="border-bottom: thin dashed gray;"></td>
									<td style="border-bottom: thin dashed gray;"></td>
									<td style="border-bottom: thin dashed gray;"></td>
									<td style="border-bottom: thin dashed gray;"></td>
									<td style="border-bottom: thin dashed gray;"></td>
									<td style="border-bottom: thin dashed gray;"></td>
									<td style="border-bottom: thin dashed gray;"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="td" bgcolor="#63ebfb">下周计划工作重点</td>
						<td class="td" style="border-right: thin dashed gray;" colspan="3">
							<table class="td_table">
								<tbody id="n2">
									<tr align="center">
										<td class="td" width="6%" bgcolor="#63ebfb">序号</td>
										<td class="td" width="40%" bgcolor="#63ebfb">承担的任务</td>
										<td class="td" width="17%" bgcolor="#63ebfb">预计完成日期</td>
										<td class="td" width="8%" bgcolor="#63ebfb">责任人</td>
										<td class="td" width="8%" bgcolor="#63ebfb">协助部门</td>
										<td class="td" width="15%" bgcolor="#63ebfb">备注</td>
										<td class="td" width="6%" bgcolor="#63ebfb" style="border-right: thin dashed gray;">操作</td>
									</tr>

									<s:if test="#session.nxts.size()==0">
									<tr align="center">
							  			<td class="td">1</td>
							  			<td class="td">
											<textarea name="nextTask" style="resize:none; margin-top: 5px;" rows="1" cols="33"></textarea>
										</td>
							  			<td class="td">
											<input name="nextWCDate" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:140px; margin-top: 4px; font-size: 21px; "/>
										</td>
										<td class="td">
											<select name="nextzrren">
												<s:iterator value="#session.users" status="status" var = "info">
												<option value="<s:property value="#info.username"/>">
													<s:property value="#info.username"/>
												</option>
												</s:iterator>
											</select>
										</td>
										<td class="td">
											<select name="nextczbm">
												<s:iterator value="#session.bms" status="status" var = "info">
												<option value="<s:property value="#info.name"/>">
													<s:property value="#info.name"/>
												</option>
												</s:iterator>
											</select>
										</td>
										<td class="td">
											<textarea name="nextbz" style="resize:none; margin-top: 5px;" rows="1" cols="12"></textarea>
										</td>
							  			<td class="td" style="border-right: thin dashed gray;">
								  			<div style="width: 40px;height: 20px;">
												<a href="javascript:" onclick="add_t2(this);">增加</a>
								  			</div>
										</td>
							  		</tr>
									</s:if>
									<s:elseif test="#session.nxts.size()!=0">
									<s:iterator value="#session.nxts" status="status" var ="info" >
										<%--id="nextts"--%>
									<s:if test="#status.count==1">
									<tr align="center">
							  			<td class="td">
							  				<s:property value="#status.count"/>
							  			</td>
							  			<td class="td">
											<textarea name="nextTask" style="resize:none; margin-top: 5px;" rows="1" cols="33"><s:property value="#info.cdtask"/></textarea>
										</td>
							  			<td class="td">
											<input name="nextWCDate" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:140px; margin-top: 4px; font-size: 21px; " value="<s:property value="#info.rq"/>"/>
										</td>
										<td class="td">
											<select name="nextzrren">
												<s:iterator value="#session.users" status="status" var = "info">
												<option value="<s:property value="#info.username"/>">
													<s:property value="#info.username"/>
												</option>
												</s:iterator>
											</select>
										</td>
										<td class="td">
											<select name="nextczbm">
												<s:iterator value="#session.bms" status="status" var = "info">
												<option value="<s:property value="#info.name"/>">
													<s:property value="#info.name"/>
												</option>
												</s:iterator>
											</select>
										</td>
										<td class="td">
											<textarea name="nextbz" style="resize:none; margin-top: 5px;" rows="1" cols="12"><s:property value="#info.bz"/></textarea>
										</td>
							  			<td class="td" style="border-right: thin dashed gray;">
								  			<div style="width: 40px;height: 20px;">
												<a href="javascript:" onclick="add_t2(this);">增加</a>
								  			</div>
										</td>
							  		</tr>
							  		</s:if>
							  		<s:elseif test="#status.count!=1">
							  		<tr align="center">
							  			<td class="td">
							  				<s:property value="#status.count"/>
							  			</td>
							  			<td class="td">
											<textarea name="nextTask" style="resize:none; margin-top: 5px;" rows="1" cols="33"><s:property value="#info.cdtask"/></textarea>
										</td>
							  			<td class="td">
											<input name="nextWCDate" class="d4311" class="Wdate" type="text" onFocus="f1();" style="height: 33px; width:140px; margin-top: 4px; font-size: 21px; " value="<s:property value="#info.rq"/>"/>
										</td>
										<td class="td">
											<select name="nextzrren">
												<s:iterator value="#session.users" status="status" var = "info">
												<option value="<s:property value="#info.username"/>">
													<s:property value="#info.username"/>
												</option>
												</s:iterator>
											</select>
										</td>
										<td class="td">
											<select name="nextczbm">
												<s:iterator value="#session.bms" status="status" var = "info">
												<option value="<s:property value="#info.name"/>">
													<s:property value="#info.name"/>
												</option>
												</s:iterator>
											</select>
										</td>
										<td class="td">
											<textarea name="nextbz" style="resize:none; margin-top: 5px;" rows="1" cols="12"><s:property value="#info.bz"/></textarea>
										</td>
										<td class="td" style="border-right: thin dashed gray;">
						          			<div style="width: 40px;height: 20px;">
						          				<a href="javascript:" onclick="add_t2(this);">增加</a>
						          			</div>
						          			<div style="margin-top: 3px; width: 40px;height: 20px;">
													<a href="javascript:" onClick="del_t2(this);">删除</a>
											</div>
						          		</td>
							  		</tr>
	          						</s:elseif>
							  		</s:iterator>
							  		</s:elseif>
						  		</tbody>
						  		<tr>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  			<td style="border-bottom: thin dashed gray;"></td>
						  		</tr>
						  	</table>
						</td>
					</tr>
					<tr>
						<td class="td" style="border-bottom: thin dashed gray;" bgcolor="#63ebfb">存在的问题及合理化建议</td>
						<td class="td" style="border-bottom: thin dashed gray;border-right: thin dashed gray;" colspan="3">
							<table class="td_table">
								<tbody id="n3">
									<tr align="center">
										<td class="td" width="6%" bgcolor="#63ebfb">序号</td>
										<td class="td" width="30%" bgcolor="#63ebfb">承担的任务</td>
										<td class="td" width="29%" bgcolor="#63ebfb">主要问题</td>
										<td class="td" width="29%" bgcolor="#63ebfb">对策及建议</td>
										<td class="td" width="6%" bgcolor="#63ebfb" style="border-right: thin dashed gray;">操作</td>
									</tr>
									<s:if test="#session.wts.size()==0">
									<tr align="center">
								  		<td class="td">1</td>
								  		<td class="td">
											<textarea name="wtrenwu" style="resize:none; margin-top: 5px;" rows="1" cols="25"></textarea>
										</td>
								  		<td class="td">
											<textarea name="wtwt" style="resize:none; margin-top: 5px;" rows="1" cols="25"></textarea>
										</td>
								  		<td class="td">
									  		<textarea name="wtdc" style="resize:none; margin-top: 5px;" rows="1" cols="25"></textarea>
										</td>
										<td class="td" style="border-right: thin dashed gray;">
									  		<div style="width: 40px;height: 20px;">
												<a href="javascript:" onclick="add_t3(this);">增加</a>
								  			</div>
										</td>
								  	</tr>
									</s:if>
									<s:elseif test="#session.wts.size()!=0">
									<s:iterator value="#session.wts" status="status" var ="info" >
										<%--id="wts"--%>
									<s:if test="#status.count==1">
									<tr align="center">
								  		<td class="td">
								  			<s:property value="#status.count"/>
								  		</td>
								  		<td class="td">
											<textarea name="wtrenwu" style="resize:none; margin-top: 5px;" rows="1" cols="25"><s:property value="#info.cdtask"/></textarea>
										</td>
								  		<td class="td">
											<textarea name="wtwt" style="resize:none; margin-top: 5px;" rows="1" cols="25"><s:property value="#info.zywt"/></textarea>
										</td>
								  		<td class="td">
									  		<textarea name="wtdc" style="resize:none; margin-top: 5px;" rows="1" cols="25"><s:property value="#info.dcjjy"/></textarea>
										</td>
										<td class="td" style="border-right: thin dashed gray;">
									  		<div style="width: 40px;height: 20px;">
												<a href="javascript:" onclick="add_t3(this);">增加</a>
								  			</div>
										</td>
								  	</tr>
									</s:if>
									<s:elseif test="#status.count!=1">
									<tr align="center">
								  		<td class="td">
								  			<s:property value="#status.count"/>
								  		</td>
								  		<td class="td">
											<textarea name="wtrenwu" style="resize:none; margin-top: 5px;" rows="1" cols="25"><s:property value="#info.cdtask"/></textarea>
										</td>
								  		<td class="td">
											<textarea name="wtwt" style="resize:none; margin-top: 5px;" rows="1" cols="25"><s:property value="#info.zywt"/></textarea>
										</td>
								  		<td class="td">
									  		<textarea name="wtdc" style="resize:none; margin-top: 5px;" rows="1" cols="25"><s:property value="#info.dcjjy"/></textarea>
										</td>
										<td class="td" style="border-right: thin dashed gray;">
											<div style="width: 40px;height: 20px;">
												<a href="javascript:" onclick="add_t3(this);">增加</a>
											</div>
											<div style="margin-top: 3px; width: 40px;height: 20px;">
												<a href="javascript:" onClick="del_t3(this);">删除</a>
											</div>
										</td>
								  	</tr>
									</s:elseif>
									</s:iterator>
									</s:elseif>
									
							  	</tbody>
								  	<tr>
								  		<td style="border-bottom: thin dashed gray;"></td>
								  		<td style="border-bottom: thin dashed gray;"></td>
								  		<td style="border-bottom: thin dashed gray;"></td>
								  		<td style="border-bottom: thin dashed gray;"></td>
								  		<td style="border-bottom: thin dashed gray;"></td>
								  	</tr>
							</table>
						</td>
					</tr>
				</table>
				<div id="bott6">
					<table style="margin-left: -10px;">
						<tr>
							<td>
								<input class="a" type="button" onclick="upsashb(1)" value="发&nbsp;&nbsp;&nbsp;&nbsp;送"/>
							</td>
							<td>
								<input class="a" type="button" onclick="upsashb(2)" value="保&nbsp;&nbsp;&nbsp;&nbsp;存"/>
							</td>
						</tr>
					</table>
				</div>
			</form>
	  	</div>
  </div>
  </body>
</html>
