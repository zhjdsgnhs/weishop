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
<title>分类</title>
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
</head>
<body style="background:white;">
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>动态分类名称</h1>
 <a href="search.html" class="rt_searchIcon">&#37;</a>
</header>
<div style="height:1rem;"></div>
<!--category list-->
<!--模板不变，异步处理，链接传参数，静态写过于累赘-->
<aside class="class_tree">
 <ul>
  <li class="current_style">
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_01.png"/>
    <strong>家居生活</strong>
   </a>
  </li>
  <li>
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_06.png"/>
    <strong>商务馈赠</strong>
   </a>
  </li>
  <li>
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_10.png"/>
    <strong>3C数码</strong>
   </a>
  </li>
  <li>
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_14.png"/>
    <strong>健康食品</strong>
   </a>
  </li>
  <li>
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_03.png"/>
    <strong>线下体验</strong>
   </a>
  </li>
  <li>
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_07.png"/>
    <strong>礼品定制</strong>
   </a>
  </li>
  <li>
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_11.png"/>
    <strong>限时促销</strong>
   </a>
  </li>
  <li>
   <a>
    <img src="${ctx}/statics/qiantai/upload/menu_bg_15.png"/>
    <strong>团购</strong>
   </a>
  </li>
 </ul>
</aside>
<!--category content-->
<ul class="category_cont">
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">全部</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">家纺</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">厨具</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">生活用品</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">厨房电器</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">生活电器</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">个护健康</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">妈咪宝贝</a>
 </li>
 <li>
  <a href="${ctx}/jsp2/product_list.jsp">运动休闲</a>
 </li>
  <li>
  <a href="${ctx}/jsp2/product_list.jsp">户外装备</a>
 </li>
  <li>
  <a href="${ctx}/jsp2/product_list.jsp">汽车用品</a>
 </li>
  <li>
  <a href="${ctx}/jsp2/product_list.jsp">美妆清洁</a>
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
