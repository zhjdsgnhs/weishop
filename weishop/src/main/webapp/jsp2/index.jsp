
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
<title>微商城</title>
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
<script src="${ctx}/statics/qiantai/js/swiper.min.js"></script>
<script>
$(document).ready(function(){
	var mySwiper = new Swiper('#slide',{
		  autoplay:5000,
		  visibilityFullFit : true,
		  loop:true,
		  pagination : '.pagination',
	  });
	//product list:Tab
	$(".tab_proList dd").eq(0).show().siblings(".tab_proList dd").hide();
	$(".tab_proList dt a").eq(0).addClass("currStyle");
	$(".tab_proList dt a").click(function(){
	var liindex = $(".tab_proList dt a").index(this);
	$(this).addClass("currStyle").siblings().removeClass("currStyle");
	$(".tab_proList dd").eq(liindex).fadeIn(150).siblings(".tab_proList dd").hide();
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
<body>
<!--header-->
<header>
 <a href="${ctx}/jsp2/location.jsp" class="location">岳阳市</a>
<div style="text-align:center;width:100%;">微商城</div>
 <a href="${ctx}/jsp2/search.jsp" class="rt_searchIcon">&#37;</a>
</header>
<div style="height:1rem;"></div>
<!--slide-->
<div id="slide">
  <div class="swiper-wrapper">
    <div class="swiper-slide">
     <a href="${ctx}/productView?goodsId=13">
      <img src="${ctx}/statics/qiantai/upload/裙子1.png"/>
     </a>
    </div>
    <div class="swiper-slide">
     <a href="${ctx}/productView?goodsId=36">
      <img src="${ctx}/statics/qiantai/upload/世界这么大只喜欢你1.png"/>
     </a>
    </div>
    <div class="swiper-slide">
     <a href="${ctx}/productView?goodsId=40">
      <img src="${ctx}/statics/qiantai/upload/羽绒服收腰.png"/>
     </a>
    </div>
  </div>
  <div class="pagination"></div>  
</div>
<!--categoryList-->
<ul class="categoryLiIcon">


<c:forEach items="${list}" var="lists">
<c:if test="${lists.id==1}">
  <li>
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_01.png" />
         <em>${lists.name}</em>
     </a>
  </li>
  </c:if>
    
   <c:if test="${lists.id==74}">
    <li>  
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_03.png" />
         <em>${lists.name}</em>
     </a>
    </li> 
   </c:if>
   
   
   <c:if test="${lists.id==161}">
   <li>  
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_06.png" />
         <em>${lists.name}</em>
     </a>
    </li> 
    </c:if>
    
    <c:if test="${lists.id==249}">
    <li> 
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_07.png" />
         <em>${lists.name}</em>
     </a>
    </li>
    </c:if>
    
    <c:if test="${lists.id==296}">
    <li>
      <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_10.png" />
         <em>${lists.name}</em>
      </a>
     </li>
     </c:if>
      
    <c:if test="${lists.id==558}">
    <li> 
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_11.png" />
         <em>${lists.name}</em>
     </a>
    </li>
    </c:if>
    
    <c:if test="${lists.id==558}"> 
    <li>
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_07.png" />
         <em>${lists.name}</em>
     </a>
    </li>
    </c:if>
    
    <c:if test="${lists.id==749}">
    <li>
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_14.png" />
         <em>${lists.name}</em>
     </a>
    </li>
    </c:if>
    
    <c:if test="${lists.id==1031}">
    <li>
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_06.png" />
         <em>${lists.name}</em>
     </a>
    </li>
    </c:if>
</c:forEach>

 
 <%-- <li>
     <a href="${ctx}/productList?id=${lists.id}">
         <img src="${ctx}/statics/qiantai/upload/menu_bg_15.png" />
         <em>更多惊喜</em>
     </a>
 </li> --%>
</ul>
<!--Tab:productList-->
<dl class="tab_proList">
 <dt>
  <a href="${ctx}/ReiXiao">热销</a>
  <a href="${ctx}/XinPin">新品</a>
  <a href="${ctx}/Zhekou">打折</a>
 </dt>
 <dd>
  <ul>
  <c:forEach items="${listRX}" var="listRX">
    <li>
    <a href="${ctx}/productView?goodsId=${listRX.id}" class="goodsPic">
     <img src="${ctx}/upload/${listRX.smallPic}"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/productView?goodsId=${listRX.id}">${listRX.goodsName}</a>
     </h2>
     <p>
      <del>1200</del>
     </p>
     <p>
      <strong class="price">${listRX.price}</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
  </c:forEach>
  </ul>
 </dd>
 
 
 <dd>
  <ul>
  <c:forEach items="${listXP}" var="listXP">
   <li>
    <a href="${ctx}/productView?goodsId=${listXP.id}" class="goodsPic">
     <img src="${ctx}/upload/${listXP.smallPic}"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/productView?goodsId=${listXP.id}">${listXP.goodsName}</a>
     </h2>
    <p>
      <del>800</del>
     </p>
     <p>
      <strong class="price">${listXP.price}</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
  </c:forEach>
  </ul>
 </dd>
 
 
 <dd>
  <ul>
    <c:forEach items="${listZK}" var="listZK">
   <li>
    <a href="${ctx}/productView?goodsId=${listZK.id}" class="goodsPic">
     <img src="${ctx}/upload/${listZK.smallPic}"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="${ctx}/productView?goodsId=${listZK.id}">${listZK.goodsName}</a>
     </h2>
     <p>
      <del>5000</del>
     </p>
     <p>
      <strong class="price">${listZK.price}</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
  </c:forEach>
   </ul>
 </dd>
</dl>
<!--floatCart-->
<div class="hoverCart">
 <a href="cart.jsp">0</a>
</div>
<div style="height:1.2rem;"></div>
<nav>
 <a href="${ctx}/QTindex" class="homeIcon">首页</a>
 <a href="${ctx}/QTfenlei" class="categoryIcon">分类</a>
 <a href="${ctx}/jsp2/cart.jsp" class="cartIcon">购物车</a>
 <a href="${ctx}/jsp2/user.jsp" class="userIcon">我的</a>
</nav>
<script>
  document.oncontextmenu=new Function("event.returnValue=false;");
  document.onselectstart=new Function("event.returnValue=false;"); 
</script>

</body>
</html>
