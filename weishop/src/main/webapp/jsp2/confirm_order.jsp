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
<title>确认订单</title>
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
	 //payment style
	$(".payment dd label input[type='radio']").click(function(){
		$(this).parent().addClass("isTrue");
		$(this).parent().siblings().removeClass("isTrue");
		});
    //测试流程效果，程序对接可将其删除！
	$(".btmNav a:last").click(function(){
		alert("点击提交订单后跳转支付接口，再返回支付状态！");
		location.href="${ctx}/jsp2/return_state.jsp";
		});
 });
</script>
</head>
<body>
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>确认订单</h1>
</header>
<div style="height:1rem;"></div>
<aside class="confirmAddr">
 <p>
  <span>收货人：DeathGhost</span>
  <span>1830927**73</span>
 </p>
 <address>陕西省西安市雁塔区某某大厦</address>
 <a href="${ctx}/jsp2/address.jsp" class="iconfont">&#60;</a>
</aside>
<dl class="payment">
 <dt>选择支付方式</dt>
 <dd>
  <label><input type="radio" name="pay"/>支付宝支付</label>
  <label><input type="radio" name="pay"/>微信支付</label>
 </dd>
</dl>
<section class="order_msg">
 <h2>我要留言</h2>
 <textarea placeholder="选填(亲可以在这里添加想说的话)"></textarea>
</section>
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
 <a style="background:#64ab5b;color:white;text-shadow:none;">合计：￥0.00</a>
 <a style="background:#6bc75f;color:white;text-shadow:none;">提交订单</a>
</aside>
</body>
</html>
