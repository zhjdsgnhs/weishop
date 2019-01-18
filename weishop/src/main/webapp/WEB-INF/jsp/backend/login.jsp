<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<title>微商城管理后台</title>
	 <link rel="icon" href="${pageContext.request.contextPath }/statics/img/assets/img/favicon.ico">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/pages-login-manage.css" />
</head>

<body>
	<div class="loginmanage">
		<div class="py-container">
			<h4 class="manage-title">微商城管理后台</h4>
			<div class="loginform">

				<ul class="sui-nav nav-tabs tab-wraped">
					<li>
						<a href="#index" data-toggle="tab">
							<h3>扫描登录</h3>
						</a>
					</li>
					<li class="active">
						<a href="#profile" data-toggle="tab">
							<h3>账户登录</h3>
						</a>
					</li>
				</ul>
				<div class="tab-content tab-wraped">
					<div id="index" class="tab-pane">
						<p>二维码登录，暂为官网二维码</p>
						<img src="${pageContext.request.contextPath }/statics/img/wx_cz.jpg" />
					</div>
					<div id="profile" class="tab-pane  active">
						<form class="sui-form" action="tbUserLogin">
							<div class="input-prepend"><span class="add-on loginname"></span>
								<input id="prependedInput" type="text" name="username" placeholder="邮箱/用户名/手机号" required="" class="span2 input-xfat">
							</div>
							<div class="input-prepend"><span class="add-on loginpwd"></span>
								<input id="prependedInput" type="password" name="password" placeholder="请输入密码" required="" class="span2 input-xfat">
							</div>
							<div class="setting">
								 <div id="slider">
									<div id="slider_bg"></div>
									<span id="label">>></span> <span id="labelTip">拖动滑块验证</span>
									</div>
							</div>
							<span>${error}</span>
							<div class="logined">
								<!-- <a class="sui-btn btn-block btn-xlarge btn-danger" href="login" target="_blank">登&nbsp;&nbsp;录</a> -->
								<button type="submit" class="sui-btn btn-block btn-xlarge btn-danger">登&nbsp;&nbsp;录</button>
              					<button type="reset" class="sui-btn btn-block btn-xlarge btn-danger">重&nbsp;&nbsp;填</button>
							</div>
						</form>

					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>


	<!--foot-->
	<div class="py-container copyright">
		<ul>
			<li>关于我们</li>
			<li>联系我们</li>
			<li>联系客服</li>
			<li>商家入驻</li>
			<li>营销中心</li>
			<li>手机品优购</li>
			<li>销售联盟</li>
			<li>品优购社区</li>
		</ul>
		<div class="address">地址：北京市昌平区建材城西路金燕龙办公楼一层 邮编：100096 电话：400-618-4000 传真：010-82935100</div>
		<div class="beian">京ICP备08001421号京公网安备110108007702
		</div>
	</div>


<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/pages/jquery.slideunlock.js"></script>
<script>
	$(function(){
		var slider = new SliderUnlock("#slider",{
				successLabelTip : "欢迎访问微商城"	
			},function(){
				// alert("验证成功,即将跳转至首页");
            	// window.location.href="index.html"
        	});
        slider.init();
	})
	</script>
</body>

</html>