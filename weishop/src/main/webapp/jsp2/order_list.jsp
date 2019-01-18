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
<title>订单列表</title>
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
</head>
<body>
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>订单列表</h1>
</header>
<div style="height:1rem;"></div>
<!--异步处理，此处不做TAB形式,注意当前状态样式currStyle-->
<aside class="orderSift">
 <a class="currStyle">待付款</a>
 <a>待发货</a>
 <a>已完成</a>
</aside>
<!--订单列表-->
<ul class="orderList">
 <!--订单循环li-->
 <li>
  <dl>
   <dt>
    <span>订单：201512130108</span>
    <span>待付款</span>
   </dt>
   <!--订单产品循环dd-->
   <dd>
    <h2>优质牛肉5kg散装</h2>
    <strong>
     <em>0.00</em>
     <span>1</span>
    </strong>
   </dd>
   <dd>
    <h2>新疆葡萄干散装</h2>
    <strong>
     <em>0.00</em>
     <span>1</span>
    </strong>
   </dd>
   <dd>
    <span>商品数量：<b>2</b></span>
    <span>实付：<b>0.00</b></span>
   </dd>
   <dd>
    <a class="order_delBtn">删除订单</a>
    <a class="order_payBtn">付款</a>
   </dd>
  </dl>
 </li>
 <!--订单循环li-->
 <li>
  <dl>
   <dt>
    <span>订单：201512130108</span>
    <span>待发货</span>
   </dt>
   <!--订单产品循环dd-->
   <dd>
    <h2>优质牛肉5kg散装</h2>
    <strong>
     <em>0.00</em>
     <span>1</span>
    </strong>
   </dd>
   <dd>
    <span>商品数量：<b>1</b></span>
    <span>实付：<b>0.00</b></span>
   </dd>
   <dd>
    <a class="order_payBtn">待发货</a>
   </dd>
  </dl>
 </li>
 <!--订单循环li-->
 <li>
  <dl>
   <dt>
    <span>订单：201512130108</span>
    <span>已完成</span>
   </dt>
   <!--订单产品循环dd-->
   <dd>
    <h2>优质牛肉5kg散装</h2>
    <strong>
     <em>0.00</em>
     <span>1</span>
    </strong>
   </dd>
   <dd>
    <span>商品数量：<b>1</b></span>
    <span>实付：<b>0.00</b></span>
   </dd>
   <dd>
    <a class="order_delBtn">已完成</a>
   </dd>
  </dl>
 </li>
</ul>
<div style="height:1.2rem;"></div>
<nav>
 <a href="${ctx}/jsp2/index.jsp" class="homeIcon">首页</a>
 <a href="${ctx}/jsp2/category.jsp" class="categoryIcon">分类</a>
 <a href="${ctx}/jsp2/cart.jsp" class="cartIcon">购物车</a>
 <a href="${ctx}/jsp2/user.jsp" class="userIcon">我的</a>
</nav>
<script>
  document.oncontextmenu=new Function("event.returnValue=false;");
  document.onselectstart=new Function("event.returnValue=false;"); 
</script>

</body>
</html>
