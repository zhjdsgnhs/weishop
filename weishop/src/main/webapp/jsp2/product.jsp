

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
<title>产品详情</title>
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
  //效果测试，程序对接可将其删除
  $(".btmNav a:first").click(function(){
	  $(".topCart em").html(parseInt($(".topCart em").html())+1);
	  });
});
</script>
</head>
<body>
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>产品详情</h1>
 <a href="${ctx}/jsp2/cart.jsp" class="topCart"><em>0</em></a>
</header>
<div style="height:1rem;"></div>
<div class="pro_bigImg">
 <img src="${ctx}/upload/${descs.goodSmallPic}"/>
</div>

<section class="pro_baseInfor">
 <h2>${descs.introduction}</h2>
 <p>
  <strong>${descs.goodprice}</strong>
 </p>
</section>
<!--product attr-->
<dl class="pro_attr">
 <dt>产品属性信息</dt>
 <dd>
  <ul>
   <li>
    <span>上市时间</span>
    <em>2017年09月</em>
   </li>
   <li>
    <span>产品规格</span>
    <em>${descs.specificationItems}</em>
   </li>
   <li>
    <span>产品重量</span>
    <em>0.5kg</em>
   </li>
   <li>
    <span>包装方式</span>
    <em>散装</em>
   </li>
   <li>
    <span>保质期</span>
    <em>${descs.packageList}</em>
   </li>
  
  </ul>
 </dd>
</dl>
<img src="${ctx}/upload/${descs.itemImages1}" style="width:100%;"/>
<img src="${ctx}/upload/${descs.itemImages2}" style="width:100%;"/>
<img src="${ctx}/upload/${descs.itemImages3}" style="width:100%;"/>
<img src="${ctx}/upload/${descs.itemImages4}" style="width:100%;"/>
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
 <a style="background:#64ab5b;color:white;text-shadow:none;">加入购物车</a>
 <a style="background:#87a983;color:white;text-shadow:none;">加入常购单</a>
</aside>
</body>
</html>
