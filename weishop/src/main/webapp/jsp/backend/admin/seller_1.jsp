<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>商家审核</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
   
       
</head>
<body class="hold-transition skin-red sidebar-mini"  >
<form action="selectSellerAll">
  <!-- .box-body -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">商家管理</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                          <div class="box-tools pull-right">
                                                                                                                              
                                </div>
                            </div>
                            <!--工具栏/-->

			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                            <td colspan="11">
			                                                                                         店铺名称： <input width="10px" type="text" name="nickName" value="${nickName}">
			                                                                                         
                                                                                                                              店铺类型:<select name="sellerType">
									               <option value="0">---请选择---</option>
									                  <c:forEach var="t" items="${serTypeList}">
									                     <%-- <c:if test="${t.sTypeid==sellerType}">selected="selected"</c:if> --%>
									   		             <option value="${t.sTypeid}">${t.sType}</option>
									                  </c:forEach>
									            </select>
									            
                                                                                                                             店铺状态:<select name="status">
									               <option value="-1">---请选择---</option>
									   		       <option value="0">禁用</option>
									   		       <option value="1">启用</option>
									            </select><br/>
									            	
                                                                                                                                  销量范围:<input type="text" name="number" value="${number}">~<input type="text" name="number1" value="${number1}"><br/>
									             
									              销售金额范围:<input type="text" name="price" value="${price}">~<input type="text" name="price1" value="${price1}">	
                                         <button type="submit" class="btn btn-default" >查询</button>
			                            </td>
			                          </tr>
			                          <tr>
										  <th class="sorting_asc">商家ID</th>
									      <th class="sorting">店铺名称</th>
									      <th class="sorting">联系人姓名</th>
									      <th class="sorting">公司地址</th>
									      <th class="sorting">开店日期</th>
									      <th class="sorting">店铺销量</th>
									      <th class="sorting">总销售额</th>
									      <th class="sorting">店铺状态</th>
									      <th class="sorting">店铺类型</th>
									      <th class="sorting">店铺LOGO</th>
									     							
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                          <c:forEach items="${sellerList}" var="s">
			                             <tr>
			                              <td>${s.sellerId}</td>			                              
				                          <td>${s.nickName}</td>
									      <td>${s.linkmanMobile}</td>
									      <td>${s.addressName}</td>
									      <td>${s.createTime}</td>
									      <td>${s.number}</td>
									      <td>${s.price}</td>
									      <td>${s.statusName}</td>
									      <td>${s.typeName}</td>
									      <td><img src="${ctx}/${s.logoPic}" width="30" height="30"/></td>
		                                  <td class="text-center">                                           
		                                      <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal" onclick="return xiu(${s.sellerId})">修改</button>
		                                      <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal2" onclick="return order(${s.sellerId})">查看订单</button>
		                                      <a href="selectParent?sellerId=${s.sellerId}"><button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal2">审核</button></a>
		                                  </td>
			                          </tr>
			                          </c:forEach>
			                          <tr align="center">
			                            <td colspan="11">
			                            <a href="selectSellerAll?pageIndex=1&nickName=${nickName}&number=${number}&number1=${number1}
			                               &price=${price}&price1=${price1}&sellerType=${sellerType}
			                               &status=${status}">首页</a>
			                            <a href="selectSellerAll?pageIndex=${page.currNo-1}
			                               &nickName=${nickName}&number=${number}&number1=${number1}&price=${price}&price1=${price1}
			                               &sellerType=${sellerType}
			                               &status=${status}">上一页</a>
			                            <a href="selectSellerAll?pageIndex=${page.currNo+1}
			                               &nickName=${nickName}&number=${number}&number1=${number1}&price=${price}&price1=${price1}
			                               &sellerType=${sellerType}
			                               &status=${status}">下一页</a>
			                            <a href="selectSellerAll?pageIndex=${page.countCurrNo}
			                               &nickName=${nickName}&number=${number}&number1=${number1}&price=${price}&price1=${price1}
			                               &sellerType=${sellerType}
			                               &status=${status}">末页</a>
			                            <span>第${page.currNo}页/共${page.countCurrNo}页</span>
			                            </td>
			                          </tr>
			                      </tbody>
			                  </table>
			                  <!--数据列表/-->                        
							 
                        </div>
                        <!-- 数据表格 /-->
                        </form>
                     </div>
                    <!-- /.box-body -->
                    
	          
					    
                                
<!-- 商家详情 -->
<form action="updateSeller" method="post" enctype="multipart/form-data">
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">商铺详情</h3>
		</div>
		<div class="modal-body">							
			
			<table class="table table-bordered table-striped"  width="800px">
		      	<tr>
		      		<td>店铺名称：</td>
		      		<td>
		      		    <input type="hidden" name="sellerId" id="sellerId">
		      		    <input  class="form-control" placeholder="店铺名称" name="nickName" id="nickName">  
		      		</td>
		      	</tr>
		      	<tr>
		      	
		      		<td>店铺联系人：</td>
		      		<td><input  class="form-control" placeholder="店铺联系人" name="linkmanName" id="linkmanName">  </td>
		      	</tr>	
		      	<tr>
		      	
		      		<td>联系人电话：</td>
		      		<td><input  class="form-control" placeholder="联系人电话" name="linkmanMobile" id="linkmanMobile">  </td>
		      	</tr>
		      	<tr>
		      	
		      		<td>店铺地址：</td>
		      		<td>
		      		  <select name="address" id="address">
                          <c:forEach items="${addressList}" var="a">
                              <option value="${a.id}">${a.address}</option>
                          </c:forEach>
                       </select>
		      		</td>
		      	</tr>
		      	<tr>
		      	
		      		<td>店铺LOGO：</td>
		      		<td>
		      		<img name="logoPic"  id="logoPic" src="data:image/png;base64" width="30" height="30"/>
		      		<input type="hidden" id="myfile"  name="myfile">
		      		<input type="file" name="path" id="inFile" >
		      		</td>
		      	</tr>
			 </table>				
		</div>
		<div class="modal-footer">						
			<button type="submit">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div> 
	  </div>
	</div>
</div>
</form>

</body>

</html>
<script type="text/javascript" src="${ctx}/jsp/jquery-1.12.4.js"></script>
<script type="text/javascript">

    function xiu(sellerId){
       $.post("/selectId","sellerId="+sellerId,function(data){
         if(data!=null){
           $("#sellerId").val(data.tbSeller.sellerId);
           $("#nickName").val(data.tbSeller.nickName);
           $("#linkmanName").val(data.tbSeller.linkmanName);
           $("#linkmanMobile").val(data.tbSeller.linkmanMobile);
           $("#address").find("option[value='"+data.tbSeller.address+"']").attr("selected",true);
           $("#logoPic").attr("src",data.tbSeller.logoPic)
           $("#myfile").val(data.tbSeller.logoPic)
         }
       })
     }
     
     function order(sellerId){
     window.location.href="/selectOrder?sellerId="+sellerId;
     }
     
     $(function(){
		$("#inFile").on("change",function () {
	        var $file = $(this);
	        var fileObj = $file[0];
 
	        var windowURL = window.URL || window.webkitURL;
	        var dataURL;
	        var $img = $("#logoPic");
 
	        if (fileObj && fileObj.files && fileObj.files[0]) {
	            dataURL = windowURL.createObjectURL(fileObj.files[0]);
	            $img.attr('src', dataURL);
	        } else {
	            dataURL = $file.val();
	            var imgObj = document.getElementById("logoPic");
	            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
 
	        }
	    });
	});
    
   </script>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>