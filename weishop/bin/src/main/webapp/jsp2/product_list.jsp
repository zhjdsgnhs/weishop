﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>家用电器</title>
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
  $(".des_icon").click(function(){
	  $(this).toggleClass("asc_icon");
	  });
  $(".drop_icon").click(function(){
	  $(".drop_list").toggle();
	  $(".drop_list li a").click(function(){
		  $(this).parents(".drop_list").hide();
		  });
	  });
   //飞入动画，具体根据实际情况调整
   $(".addToCart").click(function(){
	        $(".hoverCart a").html(parseInt($(".hoverCart a").html())+1);/*测试+1*/
            var shopOffset = $(".hoverCart").offset();
            var cloneDiv = $(this).parent().siblings(".goodsPic").clone();
            var proOffset = $(this).parent().siblings(".goodsPic").offset();
            cloneDiv.css({ "position": "absolute", "top": proOffset.top, "left": proOffset.left });
            $(this).parent().siblings(".goodsPic").parent().append(cloneDiv);
            cloneDiv.animate({
				width:0,
				height:0,
                left: shopOffset.left,
                top: shopOffset.top,
				opacity:1
            },"slow");
	   });
});
</script>
</head>
<body style="background:white;">
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>家用电器</h1>
 <a href="${ctx}/jsp2/search.jsp" class="rt_searchIcon">&#63;</a>
</header>
<div style="height:1rem;"></div>
 <!--asc->1[升序asc_icon];des->0[降序des_icon]-->
 <ul class="sift_nav">
  <li><a class="des_icon">价格</a></li>
  <li><a class="des_icon">销量优先</a></li>
  <li>
   <a class="nav_li drop_icon">品牌筛选</a>
   <ul class="drop_list">
    <li><a>品牌名</a></li>
    <li><a>品牌名</a></li>
    <li><a>品牌名</a></li>
    <li><a>品牌名</a></li>
   </ul>
  </li>
 </ul>
<!--productList-->
<section class="productList">
  <ul>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
     <img src="${ctx}/statics/qiantai/upload/goods001.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">北美电器（ACA）面包机全自动家用 厨神 一机八能面点电饭煲AB-IPN16</a>
     </h2>
     <p>
      <del>1280</del>
     </p>
     <p>
      <strong class="price">1280</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
     <img src="${ctx}/statics/qiantai/upload/goods002.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">北美电器（ACA） 多功能面包机 时尚彩钢 升级款19项菜单 AB-K20RC</a>
     </h2>
     <p>
      <del>1280</del>
     </p>
     <p>
      <strong class="price">1280</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
     <img src="${ctx}/statics/qiantai/upload/goods003.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">北美电器（ACA）多士炉AT-P0802C 时尚雅白多档位 烤面包机</a>
     </h2>
     <p>
      <del>1280</del>
     </p>
     <p>
      <strong class="price">1280</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
     <img src="${ctx}/statics/qiantai/upload/goods009.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">北美电器（ACA）电烤箱家用 36L电子式 高端智能电脑控制ATO-36A8</a>
     </h2>
     <p>
      <del>1280</del>
     </p>
     <p>
      <strong class="price">1280</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
     <img src="${ctx}/statics/qiantai/upload/goods008.jpg"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">北美电器（ACA） 电烤箱家用 45L 高配款双层门多功能烘焙ATO-HB45HT</a>
     </h2>
     <p>
      <del>1280</del>
     </p>
     <p>
      <strong class="price">1280</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
  </ul>
  <a class="more_btn">加载更多</a>
</section>
<!--floatCart-->
<div class="hoverCart">
 <a href="${ctx}/jsp2/cart.jsp">0</a>
</div>
</body>
</html>
