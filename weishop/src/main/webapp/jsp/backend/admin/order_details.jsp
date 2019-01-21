<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>账户管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>

</head>
<body class="hold-transition skin-red sidebar-mini" >
  <!-- .box-body -->
                
                    <div class="box-header with-border">
                        <h3 class="box-title">订单详情</h3>
                    </div>

                    <div class="box-body">
						<form action="/tb-user/select">
                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                           <!--  <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" onclick="xinzeng()"><i class="fa fa-file-o"></i> 新建</button>
                                        <button type="button" class="btn btn-default" title="刷新" ><i class="fa fa-check"></i> 刷新</button>
                                    </div>
                                </div>
                            </div> -->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                        <button type="button" class="btn btn-default" title="刷新" onclick="history.back();"><i class="fa fa-refresh"></i> 返回</button>
                                    </div>
                                </div>
                            </div>
                            <!--工具栏/-->

			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                      	<c:forEach items="${list}" var="temp">
				                      <tr style="background-color: pink">
							            <td>用户名:${temp.receiver}</td>
							            <td>订单号:${temp.orderId}</td>
							            <td>地址:${temp.receiverAreaName}</td>
							            <td>￥${temp.cost}</td>
							          </tr>
							          <tr>
          							  </tr>
          							  <tr>
          							  	<td colspan="4">
				                      		<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      				<thead>
			                      					<tr>
												      <td width="20%">商品名称</td>
												      <td width="20%">商品图片</td>
												      <td width="25%">数量</td>
												      <td width="25%">价格</td>
												    </tr>
												    <c:forEach items="${temp.tbOrderItemList}" var="temp">
									                  <tr>
									                    <td>${temp.goodsName}</td>
									                    <td>
									                        <img src="${temp.picPath}" width="50" height="50" />
									                    </td>
									                    <td>${temp.num}</td>
									                    <td>${temp.totalFee}</td>
									                  </tr>
									                </c:forEach>
			                      				</thead>
			                      			</table>
				                      	</td>
          							  </tr>
									</c:forEach>
			                      </thead>
			                      <%-- <tbody>
									<c:forEach items="${list}" var="list">
			                          <tr>
				                            <td>
								              <a href="${pageContext.request.contextPath }/Product?action=queryProductDeatil&id=${list.goodsId}" target="_blank">
								              	${list.goodsName}
								              </a>
								            </td>
								            <td>
								              <img src="${pageContext.request.contextPath }/${list.picPath}" width="50" height="50" />
								            </td>
								            <td>${list.num}</td>
								            <td>${list.totalFee}</td>
			                          </tr>
									 </c:forEach>
			                      </tbody> --%>
			                      <%-- <tr>
			                  		<td colspan="11" align="center">
								      	${count}条记录
								        <span  style="margin-left: 550">
								        	共${total} 页&nbsp;当前页第${pageNum}页
								        </span>
										&nbsp;&nbsp;&nbsp; <a href="/tb-user/select?num=1&username=${username}">首页</a>
										<c:if test="${pageNum>1}">
											<a href="/tb-user/select?pageNum=${pageNum-1}&username=${username}" >上一页</a>
										</c:if>
										<c:if test="${pageNum<total}">
											<a href="/tb-user/select?pageNum=${pageNum+1}&username=${username}">下一页</a>
										</c:if>
											<a href="/tb-user/select?pageNum=${total}&username=${username}">末页</a>
								        </td> 
								     </tr> --%>
			                  </table>
			                  <!--数据列表/-->                        
							 
                        </div>
                        <!-- 数据表格 /-->
                        </form>
                     </div>
                    <!-- /.box-body -->
                    
                      
<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">账户编辑</h3>
		</div>
		<div class="modal-body">					
			
			<table class="table table-bordered table-striped"  width="800px">
		      	<tr>
		      		<td>账户名：</td>
		      		<td><input  class="form-control" id="username" name="username" placeholder="账户名称">
		      			<input type="hidden" id="id" name="id"/>
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>用户名称：</td>
		      		<td><input  class="form-control" id="nickname" name="nickName" placeholder="用户名称">
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>用户密码：</td>
		      		<td><input  class="form-control" id="password" name="password" placeholder="用户密码">
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>性别：</td>
		      		<td><select id="sex" name="sex">
		      			<option value="">---请选择---</option>
		      			<option value="1">男</option>
		      			<option value="2">女</option>
		      		</select>
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>是否启用：</td>
		      		<td><select id="status" name="status">
		      			<option value="">---请选择---</option>
		      			<option value="0">禁用</option>
		      			<option value="1">启用</option>
		      		</select>
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>邮箱：</td>
		      		<td><input  class="form-control" id="email" name="email" placeholder="用户邮箱">
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>手机号：</td>
		      		<td><input  class="form-control" id="phone" name="phone" placeholder="用户手机号">
		      		</td>
		      	</tr>		  	      	
			</table>				
		</div>
		<div class="modal-footer">						
			<button class="btn btn-success" aria-hidden="true" onclick="SaveOrUpdate()">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	  </div>
	</div>
</div>

</body>

</html>