<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript" src="${staticPath}/js/jquery.2.0.0.min.js"></script>
<script type="text/javascript" src="${staticPath}/js/index.js"></script>
<!-- GrowingIO Analytics code version 2.1 -->
<!-- Copyright 2015-2017 GrowingIO, Inc. More info available at http://www.growingio.com -->
<script type='text/javascript'>
!function(e,t,n,g,i){e[i]=e[i]||function(){(e[i].q=e[i].q||[]).push(arguments)},n=t.createElement("script"),tag=t.getElementsByTagName("script")[0],n.async=1,n.src=('https:'==document.location.protocol?'https://':'http://')+g,tag.parentNode.insertBefore(n,tag)}(window,document,"script","assets.growingio.com/2.1/gio.js","gio");
  gio('init', 'b8217ab4cd46bf06', {});

  var success = $("div[data-type]").attr("data-type");
  if(success == 0){
	  gio('track','rechargeFail',{'failReason':'网络超时'});
  }else if(success == 1){
	  gio('track','rechargeSuccess',{'initMoney':1000,'actMoney':900});
  }

  gio('send');
</script>
<!-- End GrowingIO Analytics code version: 2.1 -->
</head>
<body>
	<div data-type="0"></div>
</body>
</html>