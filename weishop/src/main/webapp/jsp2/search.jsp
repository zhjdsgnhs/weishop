<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8"/>
<title>搜索</title>
<meta name="keywords"  content="KEYWORDS..." />
<meta name="description" content="DESCRIPTION..." />
<meta name="author" content="DeathGhost" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name='apple-touch-fullscreen' content='yes'>
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="address=no">
<link rel="icon" href="${ctx}/statics/qiantai/images/icon/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon-precomposed" sizes="57x57" href="${ctx}/statics/qiantai/images/icon/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="120x120" href="${ctx}/statics/qiantai/images/icon/apple-touch-icon-120x120-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="196x196" href="${ctx}/statics/qiantai/images/icon/apple-touch-icon-196x196-precomposed.png">
<meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="${ctx}/statics/qiantai/css/style.css" />
<script src="${ctx}/statics/qiantai/js/jquery.js"></script>
<script>
$(document).ready(function(){
  $(".searchHistory dd:last a").click(function(){
	  var clear=confirm("确定清除搜索记录吗?");
	  if(clear==true){
		  $(this).parents(".searchHistory").find("dd").remove();
		  }
	  });	
});
</script>
</head>
<body>
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>搜索</h1>
</header>
<div style="height:1rem;"></div>
<aside class="searchArea">
 <input type="text" placeholder="寻找礼品、商品..."/>
 <input type="button" value="&#63;" class="searchBtn"/>
</aside>
<dl class="searchHistory">
 <dt>历史搜索</dt>
 <dd>
  <ul>
   <li><a href="${ctx}/jsp2/category.jsp">拉杆箱</a></li>
   <li><a href="${ctx}/jsp2/category.jsp">手机</a></li>
   <li><a href="${ctx}/jsp2/category.jsp">背包</a></li>
   <li><a href="${ctx}/jsp2/category.jsp">东北大米</a></li>
  </ul>
 </dd>
 <dd>
  <a>清空历史记录</a>
 </dd>
</dl>
</body>
</html>
