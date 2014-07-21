<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="Stylesheet" type="text/css" href="style/table.css">
</head>
<body>
</head>
<body>
<s:debug></s:debug>
<table>
	<tr>
		<th>用户ID</th>
		<th>用户名称</th>
		<th>注册邮箱</th>
		<th>操作</th>
	</tr>
	<s:iterator value="pageList.getList()">
		<tr>
			<td><s:property value="userid"/></td>
			<td><s:property value="username"/></td>
			<td><s:property value="email"/></td>
			<td><s:a href="user_edit.action?userid=%{userid }" >修改</s:a>
			&nbsp;&nbsp;<s:a href="user_delete.action?userid=%{userid }" >删除</s:a></td>
		</tr>
	</s:iterator>
</table>
<div class="nav">
	总记录:<s:property value="pageList.allRow"/> 
	当前页:<s:property value="pageList.totalPage"/>
	<s:if test="pageList.isHasPreviousPage()">
	<s:a href="user_list.action?pageList.currentPage=%{pageList.currentPage - 1}">上一页</s:a>
	</s:if>
	<s:if test="pageList.isHasNextPage()">
	<s:a href="user_list.action?pageList.currentPage=%{pageList.currentPage + 1}">下一页</s:a>
	</s:if>
	<s:a action="user_tregister.action">新增功能</s:a>
</div>
</body>
</html>