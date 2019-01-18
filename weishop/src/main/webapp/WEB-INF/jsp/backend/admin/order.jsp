<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>商品管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath}/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/statics/plugins/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/statics/plugins/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/plugins/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/statics/plugins/bootstrap/js/moment-with-locales.js"></script>
    <style>
<!--
     a {
	   text-decoration: none;
	   
}
</style>
    
</head>
   
<body class="hold-transition skin-red sidebar-mini" >
  <!-- .box-body -->
                <form action="${pageContext.request.contextPath }/order/select">
                    <div class="box-header with-border">
                        <h3 class="box-title">订单管理</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                           <div class="pull-left">
                                <div class="form-group form-inline">
                                                                                        订单状态:  
                                    <div class="btn-group">
                                        <!-- <button type="button" class="btn btn-default" title="删除" ><i class="fa fa-trash-o"></i> 删除</button>
                                        <button type="button" class="btn btn-default" title="审核通过" ><i class="fa fa-check"></i> 审核通过</button>
                                        <button type="button" class="btn btn-default" title="驳回" ><i class="fa fa-ban"></i> 驳回</button>                                  
                                        <button type="button" class="btn btn-default" title="刷新" ><i class="fa fa-refresh"></i> 刷新</button> -->
                                                                                        
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=0">全部</a></button>
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=1">已发货</a></button>
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=2">已取消</a></button>
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=3">已完成</a></button>  
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=4">已退款</a></button>
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=5">异常</a></button>
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=6">待付款</a></button>
                                 <button type="button" class="btn btn-default"  ><a href="/order/select?status=7">待发货</a></button>
                                 
                                 <span style="margin-left: 30px">  商户类型:</span>        
                                  <select name="shoptype" class="form-control" style="width: 130px">
                                    <option value="0">全部</option>
                                    <c:forEach items="${shoplist}" var="listStatuss">
                                      <option value="${listStatuss.sTypeid}">${listStatuss.sType}</option>
                                    </c:forEach>
                                  </select>
                                  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                                                                         订单时间:
                                  <input type="date"  name="create_time" value="${create_time}" >   ~  <input type="date"  name="endtime" value="${endtime}"  >
                                
                                                                                           付款时间: <input type="date" name="payment_time"  value="${payment_time}" >   ~  <input type="date" name="payend_time" value="${payend_time }"  >
                                    </div>
                                </div>
                            </div>
                            
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                                                                             发货时间：
                                  <input type="date"  name="consign_time" value="${consign_time}" >   ~  <input type="date"  name="conend_time" value="${conend_time}"  >
                                    </div>
                                </div>
                            </div>
                            
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group" style="margin-left: 20px">
                         <span   style="margin-left: 200px"> 价格:</span><input class="form-control" type="text" name="payment" value="${payment}" style="width: 130px"> ~ <input class="form-control" type="text" name="payment2" value="${payment2} " style="width: 130px">
                       <span style="margin-left:200px" > 用户名:</span><input class="form-control" type="text" name="username" value="${username}" style="width: 130px">
									    <input type="submit" value="查询">     
                                    </div><button type="button" class="btn btn-default" style=" margin-left: 30px"  ><a href="/order/daochu?status=${status}&shoptype=${shoptype}&create_time=${create_time}&endtime=${endtime}&payment_time=${payment_time}&payend_time=${payend_time}&consign_time=${consign_time}&conend_time=${conend_time}&payment=${payment}&payment2=${payment2}&username=${username}">导出</a></button>
                                <span style="margin-left: 10px" ><c:if test="${message=='true'}">导出成功</c:if>
                                <c:if test="${message=='false'}">导出失败</c:if>
                                </span>
                                </div>
                            </div>
                            
                            <!--工具栏/-->
			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                              <!-- <th class="" style="padding-right:0px">
			                                  <input id="selall" type="checkbox" class="icheckbox_square-blue">
			                              </th>  -->
										  <th class="sorting_asc">订单ID</th>
										  <th class="sorting">用户名</th>
									      <th class="sorting">商铺名</th>
									      <th class="sorting">订单金额</th>						
									      <th class="sorting">订单状态</th>          
									      <th class="sorting">下单时间</th>
									      <th class="sorting">订单完成时间</th>          
									      <th class="sorting">收货人</th>	
									      <th class="sorting">发货时间</th>                     
									      <th class="sorting">商铺类型</th>                         
					                      <th class="text-center">操作</th>                       
			                          </tr>
			                      </thead>
			                      <tbody>
			                      <c:forEach items="${list}" var="lists"    >
									   <tr>
			                              <!-- <td><input type="checkbox"></td>	 -->		                              
				                          
				                          <td>${lists.order_id}</td>
				                          <td>${lists.username}</td>
									      <td>${lists.name}</td>
									      <td>${lists.payment}</td>
									      
									      <c:if test="${lists.status==1}">
									      <td>已发货</td>
									      </c:if>		
									        <c:if test="${lists.status==2}">
									      <td>已取消</td>
									      </c:if>	
									        <c:if test="${lists.status==3}">
									      <td>已完成</td>
									      </c:if>	
									        <c:if test="${lists.status==4}">
									      <td>已退款</td>
									      </c:if>	
									        <c:if test="${lists.status==5}">
									      <td>异常</td>
									      </c:if>	
									        <c:if test="${lists.status==6}">
									      <td>待付款</td>
									      </c:if>	
									        <c:if test="${lists.status==7}">
									      <td>待发货</td>
									      </c:if>	
									      
									      <td>${lists.create_time}</td>
									      <td>${lists.end_time}</td>
									      <td>${lists.receiver}</td>
									      <td>${lists.consign_time}</td>									
									      <td>${lists.s_type}</td>
									      
									      <td>
									        
									        <button type="button" class="btn btn-default"  ><a href="/order/chakan?userid=${lists.user_id}">查看</a></button>
									     
									        <select onchange="update(${lists.order_id},this.options[this.options.selectedIndex].value)"  name="statusid" id="statusid"  >									        
									      <c:if test="${lists.status==1}">
									      <option  value="1"  selected="selected">已发货</option>
									      <option  value="3"  >已完成</option>
									      <option  value="4"  >已退款</option>
									      <option  value="5"  >异常</option>
									      </c:if>	
									      <c:if test="${lists.status==2}">
									         <option  value="2"  selected="selected">已取消</option> 
									         <option value="4">已退款</option>
									      </c:if>
									      <c:if test="${lists.status==3}">
									      <option  value="3"  selected="selected" >已完成</option> 
									      </c:if>
									      <c:if test="${lists.status==4}">
									      <option  value="4"  selected="selected" >已退款</option> 
									      </c:if>
									      <c:if test="${lists.status==5}">
									      <option  value="5"  selected="selected" >异常</option> 
									      <option value="1">已发货</option>
									      <option value="2">已取消</option>
									      <option value="4">已退款</option>
									      </c:if>
									      <c:if test="${lists.status==6}">
									      <option  value="6"  selected="selected" >待付款</option> 
									      <option value="2">已取消</option>									    
									      <option value="7">待发货</option>	
									      </c:if>
									      <c:if test="${lists.status==7}">
									      <option  value="7"  selected="selected" >待发货</option> 
									      <option value="1">已发货</option>
									      <option value="4">已退款</option>
									      <option value="5">异常 </option>
									      
									      </c:if>
									       </select>
									   </td>
									      
									     
									      
									    
			                          </tr>
			                          </c:forEach>
			                          
			                          <tr align="center">
								          <td colspan="14">
								            <a href="${ctx}/order/select?status=${status}&shoptype=${shoptype}&create_time=${create_time}&endtime=${endtime}&payment_time=${payment_time}&payend_time=${payend_time}&consign_time=${consign_time}&conend_time=${conend_time}&payment=${payment}&payment2=${payment2}&username=${username}&num=1">首页</a>
								            <a href="${ctx}/order/select?status=${status}&shoptype=${shoptype}&create_time=${create_time}&endtime=${endtime}&payment_time=${payment_time}&payend_time=${payend_time}&consign_time=${consign_time}&conend_time=${conend_time}&payment=${payment}&payment2=${payment2}&username=${username}&num=${num-1}">上页</a>
								            <a href="${ctx}/order/select?status=${status}&shoptype=${shoptype}&create_time=${create_time}&endtime=${endtime}&payment_time=${payment_time}&payend_time=${payend_time}&consign_time=${consign_time}&conend_time=${conend_time}&payment=${payment}&payment2=${payment2}&username=${username}&num=${num+1}">下页</a>
								            <a href="${ctx}/order/select?status=${status}&shoptype=${shoptype}&create_time=${create_time}&endtime=${endtime}&payment_time=${payment_time}&payend_time=${payend_time}&consign_time=${consign_time}&conend_time=${conend_time}&payment=${payment}&payment2=${payment2}&username=${username}&num=${pageNum}">末页</a>
								          </td>
       								  </tr>
			                      </tbody>
			                  </table>
                        </div>
                     </div>
        </form>
</body>
</html>

<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript">
   function update(id,status){
      
         if(confirm("确认是否修改?")){
          $.get("/order/update","id="+id+"&status="+status,function(data){
              if(data=="true"){
                alert("修改成功！");
                   location.href="/order/select";
              }else if(data="false"){
                   alert("修改失败！");
                    location.href="/order/select";
              }
          
           });
         }else{
          location.href="/order/select";
         }
                    
     }
   

function shan(id){
   if(confirm("确认是否删除?")){
   $.post("${pageContext.request.contextPath}/deleteGId","id="+id,function(data){
     if(data=="true"){
       alert("删除成功");
       location.href="${pageContext.request.contextPath}/selectGoodsAll";
     }else if(data=="false"){
       alert("删除失败");
       location.href="${pageContext.request.contextPath}/selectGoodsAll";
     }
   });
   }
   
}

</script>
