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
 <a href="${ctx}/selectUserOrder?userId=1">全部订单</a>
 <a href="${ctx}/selectDaiOrder?userId=1">待付款</a>
 <a href="${ctx}/selectDaiFaOrder?userId=1">待发货</a>
</aside>
<!--订单列表-->

<ul class="orderList">
<c:forEach items="${orderWan}" var="o">
 <!--订单循环li-->
 <li>
  <dl>
   <dt>
    <span>订单：${o.orderId}</span>
    <c:if test="${o.status==5}">
       <span>交易成功</span>
	</c:if>
   </dt>
   <!--订单产品循环dd-->
   <c:forEach items="${o.orderItemList}" var="order">
   <dd>
    <h2>${order.goodsName}</h2>
    <strong>
     <em>${order.price}</em>
     <span>${order.num}</span>
    </strong>
   </dd>
   </c:forEach>
   
   <dd>
    <span>实付：<b>${o.payment}</b></span>
   </dd>
   <dd>
   <c:if test="${o.status==5}">
	   <a class="order_delBtn">交易成功</a>
	</c:if>
   </dd>
  </dl>
 </li>
 </c:forEach>
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
