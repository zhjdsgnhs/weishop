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
<title>购物车</title>
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
  //show or hide:delBtn
  $(".edit").toggle(function(){
	  $(this).parent().siblings("dd").find(".delBtn").fadeIn();
	  $(this).html("完成");
	  $(".numberWidget").show();
	  $(".priceArea").hide();
	  },function(){
	  $(this).parent().siblings("dd").find(".delBtn").fadeOut();
	  $(this).html("编辑");
	  $(".numberWidget").hide();
	  $(".priceArea").show();
		  });
  //minus
  $(".minus").click(function(){
	  var currNum=$(this).siblings(".number");
	  if(currNum.val()<=1){
		  $(this).parents("dd").remove();
		  nullTips();
		  }else{
			  currNum.val(parseInt(currNum.val())-1);
			  }
	  });
  //plus
  $(".plus").click(function(){
	  var currNum=$(this).siblings(".number");
	  currNum.val(parseInt(currNum.val())+1);
	  });
  //delBtn
  $(".delBtn").click(function(){
	  $(this).parent().remove();
	  nullTips();
	  });
  //isNull->tips
  function nullTips(){
	  if($(".cart dd").length==0){
		  var tipsCont="<mark style='display:block;background:none;text-align:center;color:grey;'>购物车为空！</mark>"
		  $(".cart").remove();
		  $("body").append(tipsCont);
		  }
	  }
});
</script>
</head>
<body>
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>购物车</h1>
</header>
<div style="height:1rem;"></div>
<dl class="cart">
 <dt>
  <label><input type="checkbox"/>全选</label>
  <a class="edit">编辑</a>
 </dt>
 <dd>
  <input type="checkbox"/>
  <a href="${ctx}/jsp2/product.jsp" class="goodsPic"><img src="${ctx}/statics/qiantai/upload/goods008.jpg"/></a>
  <div class="goodsInfor">
   <h2>
    <a href="${ctx}/jsp2/product.jsp">IBOH艾铂赫煎锅H863</a>
    <span>1</span>
   </h2>
   <div class="priceArea">
    <strong>0.00</strong>
    <del>0.00</del>
   </div>
   <div class="numberWidget">
    <input type="button" value="-" class="minus"/>
    <input type="text" value="1" disabled  class="number"/>
    <input type="button" value="+"  class="plus"/>
   </div>
  </div>
  <a class="delBtn">删除</a>
 </dd>
 <dd>
  <input type="checkbox"/>
  <a href="${ctx}/jsp2/product.jsp" class="goodsPic"><img src="${ctx}/statics/qiantai/upload/goods009.jpg"/></a>
  <div class="goodsInfor">
   <h2>
    <a href="${ctx}/jsp2/product.jsp">IBOH艾铂赫煎锅H863</a>
    <span>1</span>
   </h2>
   <div class="priceArea">
    <strong>0.00</strong>
    <del>0.00</del>
   </div>
   <div class="numberWidget">
    <input type="button" value="-" class="minus"/>
    <input type="text" value="1" disabled class="number"/>
    <input type="button" value="+" class="plus"/>
   </div>
  </div>
  <a class="delBtn">删除</a>
 </dd>
 <dd>
  <input type="checkbox"/>
  <a href="${ctx}/jsp2/product.jsp" class="goodsPic"><img src="${ctx}/statics/qiantai/upload/goods007.jpg"/></a>
  <div class="goodsInfor">
   <h2>
    <a href="${ctx}/jsp2/product.jsp">IBOH艾铂赫煎锅H863</a>
    <span>1</span>
   </h2>
   <div class="priceArea">
    <strong>0.00</strong>
    <del>0.00</del>
   </div>
   <div class="numberWidget">
    <input type="button" value="-" class="minus"/>
    <input type="text" value="1" disabled  class="number"/>
    <input type="button" value="+" class="plus"/>
   </div>
  </div>
  <a class="delBtn">删除</a>
 </dd>
</dl>
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
 <a>合计：￥0.00</a>
 <a href="${ctx}/jsp2/confirm_order.jsp" style="background:#64ab5b;color:white;text-shadow:none;">立即下单</a>
</aside>
</body>
</html>
