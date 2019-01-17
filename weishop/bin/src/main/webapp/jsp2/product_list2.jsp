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
<title>产品列表</title>
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
 <h1>数码生活</h1>
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
        <img src="${ctx}/statics/qiantai/upload/productlist/gl1.jpg" />
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">GoPro 摄录相机HERO6 Black</a>
     </h2>
     <p>
      <del>5.90</del>
     </p>
     <p>
      <strong class="price">3.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
        <img src="${ctx}/statics/qiantai/upload/productlist/gl2.jpg" />
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">GoPro 摄录相机HERO5 Black</a>
     </h2>
     <p>
      <del>12.90</del>
     </p>
     <p>
      <strong class="price">8.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
        <img src="${ctx}/statics/qiantai/upload/productlist/gl3.jpg" />
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">GoPro 摄录相机HERO6 Black旅行套装</a>
     </h2>
     <p>
      <del>9.90</del>
     </p>
     <p>
      <strong class="price">6.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
        <img src="${ctx}/statics/qiantai/upload/productlist/gl4.jpg" />
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">GoPro 三向支架</a>
     </h2>
     <p>
      <del>9.90</del>
     </p>
     <p>
      <strong class="price">6.90</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   <li>
    <a href="${ctx}/jsp2/product.jsp" class="goodsPic">
        <img src="${ctx}/statics/qiantai/upload/productlist/gl5.jpg" />
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/jsp2/product.jsp">Beats Solo3 Wireless 头戴式 蓝牙无线耳机</a>
     </h2>
     <p>
      <del>9.90</del>
     </p>
     <p>
      <strong class="price">6.90</strong>
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
