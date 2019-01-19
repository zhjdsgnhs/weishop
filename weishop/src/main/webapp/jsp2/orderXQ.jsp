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
 <h1>订单详情</h1>
 <a href="${ctx}/jsp2/search.jsp" class="rt_searchIcon">&#63;</a>
</header>
<div style="height:1rem;"></div>
<!--productList-->
<section class="productList">
  <ul>
  <c:forEach items="${orderXQ}" var="o">
   <li>
     <dl>
       <dt>
         <dd>
          <span>${o.username}</span>&nbsp&nbsp
          <span>${o.phone}</span>
         </dd>
         <dd>
          <span>${o.receiverAreaName}</span>
         </dd>
       </dt>
     </dl>
     <c:forEach items="${o.orderItemList}" var="order">
     <dl>
       <td>
          <img src="${ctx}/${order.picPath}" width="90px" height="90px"/>
          ${order.goodsName} &nbsp&nbsp&nbsp
                             ￥${order.price}
       </td>
     </dl>  
     </c:forEach> 
     <dl>
       <dt>
         <dd>
         <span>订单信息</span><br>
         <span>订单编号：${o.orderId}</span><br>
         <span>创建时间：${o.createTime}</span><br>
         <span>付款时间：${o.paymentTime}</span>
         </dd>
       </dt>
     </dl>
   </li>
   </c:forEach>
  </ul>
</section>
<!--floatCart-->
<div class="hoverCart">
</div>
</body>
</html>
