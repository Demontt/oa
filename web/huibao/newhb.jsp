<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ztt
  Date: 2017/11/22
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"  type="text/css" href="../css/list.css">
</head>
<body>
    <div id="bott1">
        <%--<s:if test="hb.ty==0">--%>
            <div id="bott2">
                <h1>员工周报</h1>
            </div>
        <%--</s:if>--%>
        <s:if test="hb.ty==1">
            <div id="bott2">
                <h1>员工月报</h1>
            </div>
        </s:if>
        <s:if test="hb.ty==2">
            <div id="bott2">
                <h1>员工年报</h1>
            </div>
        </s:if>
        <%--如果当前未编辑汇报，那么就可以新建--%>
        <%--<s:if test="hb.st==0">--%>
            <%--汇报的头，表示简单的当前汇报信息--%>
            <div id="bott3">
                <table width="1100px;">
                    <tr>
                        <td width="160px;"></td>
                        <td width="90px" >当前状态：</td>
                        <td width="400px;">&nbsp;&nbsp;新建</td>
                        <td width="100px;">当前处理人：</td>
                        <td width="400px">${sessionScope.name}</td>
                     </tr>
                </table>
            </div>
            <%--当前需要汇报的详细内容--%>
            <div id="bott4">
                <form action="" method="post" name="form1">
                    <%--隐藏数据区域，表示这些数据需要提交，但不需要显示--%>
                    <input type="hidden" name="hb.id" value="0"/>
                    <input type="hidden" name="hb.bm_name" value="${hb.bm_name}"/>
                    <input type="hidden" name="hb.rq" value="${hb.rq}"/>
                    <input type="hidden" name="hb.m_name" value="${hb.m_name}"/>
                    <input type="hidden" name="hb.zyys" value="${hb.zyys}"/>
                    <table id="subtree1" width="1100px;">
                        <tr>
                            <td class="td" width="16%" bgcolor="#63ebfb">公司</td>
                            <td class="td" width="35%">&nbsp;&nbsp;伟大的晓庄</td>
                            <td class="td" width="4%" bgcolor="#63ebfb">部门</td>
                            <td class="td" width="45%" style="border-right: thin dashed gray;">&nbsp;&nbsp;${hb.bm_name}</td>
                        </tr>
                        <tr>
                            <td class="td" bgcolor="#63ebfb">汇报上级</td>
                            <td class="td" >&nbsp;&nbsp;${hb.m_name}</td>
                            <td class="td" bgcolor="#63ebfb">月份</td>
                            <td class="td" style="border-right: thin dashed gray;">&nbsp;&nbsp;${hb.zyys}</td>
                        </tr>
                        <tr>
                            <td class="id" bgcolor="#63ebfb">上月工作重点</td>
                            <td class="id" style="border-right: thin dashed gray;" colspan="3">
                                <table id="td_table">
                                    <tbody id="n">
                                        <tr align="center">
                                            <td class="td" width="6%" bgcolor="#63ebfb">序号</td>
                                            <td class="td" width="74%" bgcolor="#63ebfb">承担的任务</td>
                                            <td class="td" width="20%" bgcolor="#63ebfb" style="border-right: thin dashed gray;">预计完成日期</td>
                                        </tr>
                                        <s:iterator value="pts" status="status" var="info">
                                            <tr align="center">
                                                <td class="td">
                                                    <s:property value="#status.count"/>
                                                </td>
                                                <td class="td">
                                                    <textarea style="resize: none;margin-top: 5px;" disabled="disabled" rows="1" cols="67" name="precdt"><s:property value="#info.cdtask"/> </textarea>
                                                </td>
                                                <%--时间拾取器要求id成对出现d4311和d4312--%>
                                                <td class="td" style="border-right: thin dashed gray;">
                                                    <input name="prerq1" id="d4311" value="<s:property value="#info.wcrq"/>"class="Wdate" disabled="disabled" type="text" onfocus="f1()" style="height: 33px; width: 175px; margin-top: 4px;font-size: 21px;"/>
                                                    <div style="display:none;">
                                                        <input name="returnDate" id="d4312" value="<s:property value="#info.wcrq"/>"class="Wdate" type="text" onfocus="f2()" style="height: 33px; width: 175px; margin-top: 4px;font-size: 21px;"/>
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
                    </table>
                </form>
            </div>
        <%--</s:if>--%>
        <%--当前汇报已经发送--%>
        <s:if test="hb.st==1">
            <s:if test="hb.ty==0">
                <div id="bott7">
                    <div class="bott9">周报已发送</div>
                </div>
            </s:if>
            <s:if test="hb.ty==1">
                <div id="bott7">
                    <div class="bott9">月报已发送</div>
                </div>
            </s:if>
            <s:if test="hb.ty==2">
                <div id="bott7">
                    <div class="bott9">年报已发送</div>
                </div>
            </s:if>
        </s:if>
        <%--当前汇报已经编辑存在草稿箱中--%>
        <s:if test="hb.st==2">
            <s:if test="hb.ty==0">
                <div id="bott7">
                    <div class="bott8">月报已保存</div>
                </div>
            </s:if>
            <s:if test="hb.ty==1">
                <div id="bott7">
                    <div class="bott8">周报已保存</div>
                </div>
            </s:if>
            <s:if test="hb.ty==2">
                <div id="bott7">
                    <div class="bott8">年报已保存</div>
                </div>
            </s:if>
        </s:if>
    </div>
</body>
</html>
