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
<title></title>
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
<%--  <h1>${listGood.category1IdName}</h1> --%>
 <a href="${ctx}/jsp2/search.jsp" class="rt_searchIcon">&#63;</a>
</header>
<div style="height:1rem;"></div>
 <!--asc->1[升序asc_icon];des->0[降序des_icon]-->
 <ul class="sift_nav">
  <li><a class="des_icon" href="javaScript:void(0);" onclick="jia();">价格</a></li>
  <li><a class="des_icon">销量优先</a></li>
  <li>
   <a class="nav_li drop_icon">品牌筛选</a>
  
    <ul class="drop_list">
    <select name="brandId" onchange="QTSelectBrand()">
    <li><option value="0" >请选择</option></li>
    <c:forEach items="${listBrand}" var="brands">
    <c:if test="${brands.id==brandId}">selected</c:if>
      <li><option value="${brands.id}" >${brands.name}</option></li>
   </c:forEach> 
    <!-- <li><a>品牌名</a></li>
    <li><a>品牌名</a></li>
    <li><a>品牌名</a></li>
    <li><a>品牌名</a></li> -->
    </select>
   </ul>
   
  
  </li>
 </ul>
<!--productList-->
<section class="productList">
  <ul>
    <c:forEach items="${listGood}" var="goods">
     <li>
	    <a href="${ctx}/productView?goodsId=${goods.id}" class="goodsPic">
	     <img src="${ctx}/upload/${goods.smallPic}" width="100px" height="100px"/>
	    </a>
	    <div class="goodsInfor">
	     <h1>
	      <a href="${ctx}/jsp2/product.jsp" style="color: red">${goods.goodsName}</a>
	     </h1>
	     
	      <p>
	             品牌:<strong class="sales" style="color: threeddarkshadow;">${goods.brandName}</strong>
	     </p>
	     
	     <p>
	     <strong class="sales" style="color: threeddarkshadow;">销量:${goods.sales}</strong> 
	     </p>
	     <p>
	             价格:<strong class="price">${goods.price}</strong>
	     </p>
	     
	     <a class="addToCart">&#126;</a>
	    </div>
   </li>
    
    </c:forEach>
  </ul>
  
  <div align="center" style="font-size: 18px">
  <!-- <a class="more_btn">加载更多</a> -->
  <a href="${ctx}/productAll?num=1&brandId=${brandId}">首页</a>
  <a href="${ctx}/productAll?num=${page.currNo-1}&brandId=${brandId}">上页</a>
  <a href="${ctx}/productAll?num=${page.currNo+1}&brandId=${brandId}">下页</a>
  <a href="${ctx}/productAll?num=${page.countCurrNo}&brandId=${brandId}">末页</a>
</div>
</section>
<!--floatCart-->
<div class="hoverCart">
 <a href="${ctx}/jsp2/cart.jsp">0</a>
</div>
</body>
</html>

<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript">
     function QTSelectBrand(){
      var brandId = $("[name=brandId]").val();
     location.href="${ctx}/productAll?brandId="+brandId+"&num=1";
    
  } 

</script>