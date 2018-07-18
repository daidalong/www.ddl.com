<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript" src="${staticPath}/js/jquery.2.0.0.min.js"></script>
<script type="text/javascript" src="${staticPath}/js/index.js"></script>
</head>
<body>
	<h1 id="h1">
		您好<span style="color: red;">胖子</span>，欢迎您！
	</h1>

	<span class="user-span"> 用户名：<input type="text" name="name" value="1" /> 手机号：<input type="text" name="mobile" value="1" /></span>
	<br>
	<span class="user-span"> 用户名：<input type="text" name="name" value="2" /> 手机号：<input type="text" name="mobile" value="2" /></span>
	<br>
	<span class="user-span"> 用户名：<input type="text" name="name" value="3" /> 手机号：<input type="text" name="mobile" value="3" /></span>
	<br>
	<br>
	<input type="button" onclick="add()" value="  添加  " />

	<br>
	<br> 手机号：
	<input id="mphone" type="text" name="mobile" value="3" />
	<br>
	<br>
	<input type="button" onclick="get()" value="  查询  " />
	<br>
	<br>
	<table cellpadding="0" cellspacing="0" border="1" width="600" style="overflow: scroll;"></table>

	<br>
	<br>
</body>
</html>