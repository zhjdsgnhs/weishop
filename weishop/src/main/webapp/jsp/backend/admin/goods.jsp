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
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>

</head>

<body class="hold-transition skin-red sidebar-mini" >
  <!-- .box-body -->
                <form action="${pageContext.request.contextPath}/selectGoodsAll">
                    <div class="box-header with-border">
                        <h3 class="box-title">商品管理</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                           <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                      
                                                                                        品牌查询:
                                  <select name="brandId" class="form-control" style="width: 130px">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${listBrand}" var="listBrands">
                                      <option value="${listBrands.id}" <c:if test="${listBrands.id==brandId}">selected</c:if>>${listBrands.name}</option>
                                    </c:forEach>
                                    
                                    
                                    
                                  </select>
                                  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                                                                               在售状态: 
                                  <select name="statusId" class="form-control" style="width: 130px">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${listStatus}" var="listStatuss">
                                      <option value="${listStatuss.statusId}" <c:if test="${listStatuss.statusId==statusId}">selected</c:if>>${listStatuss.statusName}</option>
                                    </c:forEach>
                                    
                                  </select>
                                  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                                                                           促销商品:
                                  <select name="promotionId" class="form-control" style="width: 130px">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${listPromotion}" var="listPromotions">
                                      <option value="${listPromotions.promotionId}" <c:if test="${listPromotions.promotionId==promotionId}">selected</c:if>>${listPromotions.promotionStatus}</option>
                                    </c:forEach>
                                  </select>
                                  
                                    </div>
                                </div>
                            </div>
                            
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                                                                             一级分类:
                                  <select name="category1Id" class="form-control" style="width: 130px" onchange="test1()" id="yi">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${category1IdNameList1}" var="category1IdNameList1s">
                                      <option value="${category1IdNameList1s.id}" <c:if test="${category1IdNameList1s.id==category1Id}">selected</c:if>>${category1IdNameList1s.name}</option>
                                    
                                    </c:forEach>
                                  </select>
                               &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                                                                             二级分类:
                                  <select name="category2Id" class="form-control" style="width: 130px" onchange="test2()" id="er">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${category1IdNameList2}" var="category1IdNameList2s">
                                      <option value="${category1IdNameList2s.id}" <c:if test="${category1IdNameList2s.id==category2Id}">selected</c:if>>${category1IdNameList2s.name}</option>
                                    
                                    </c:forEach>
                                  </select>
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
                                                                                               三级分类:
                                  <select name="category3Id" class="form-control" style="width: 130px" id="san">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${category1IdNameList3}" var="category1IdNameList3s">
                                      <option value="${category1IdNameList3s.id}" <c:if test="${category1IdNameList3s.id==category3Id}">selected</c:if>>${category1IdNameList3s.name}</option>
                                    
                                    </c:forEach>
                                  </select>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                                                                                        价格 :<input class="form-control" type="text" name="price1" value="${price1}" style="width: 130px"> ~ <input class="form-control" type="text" name="price2" value="${price2} " style="width: 130px">
                                                                                                        库存 :<input class="form-control" type="text" name="stock1" value="${stock1}" style="width: 130px"> ~ <input class="form-control" type="text" name="stock2" value="${stock2}" style="width: 130px">
                                                                                                   商品名称:<input class="form-control" type="text" name="goodsName" value="${goodsName}" style="width: 130px">
									    <input type="submit" value="查询">
                                        <a href="${pageContext.request.contextPath}/selectAdd"><input type="button" value="添加" class="btn bg-olive btn-xs"></a>
                                     </div>
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
										  <th class="sorting_asc">商品ID</th>
										  <th class="sorting">商品图片</th>
									      <th class="sorting">商品名称</th>
									      <th class="sorting">商品品牌</th>
									      <th class="sorting">所属店铺</th>
									      <th class="sorting">一级分类</th>
									      <th class="sorting">二级分类</th>
									      <th class="sorting">三级分类</th>
									      <th class="sorting">在售状态</th>
									      <th class="sorting">商品价格</th>	
									      <th class="sorting">库存数量</th>
									      <th class="sorting">销售量</th>
									      <th class="sorting">促销商品?</th>								     						
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                      <c:forEach items="${list}" var="lists">
									   <tr>
			                              <!-- <td><input type="checkbox"></td>	 -->		                              
				                          
				                          <td>${lists.id}</td>
				                          <td><img alt="" width="30" height="30" src="${pageContext.request.contextPath}/upload/${lists.smallPic}"> </td>
									      <td>${lists.goodsName}</td>
									      <td>${lists.brandName}</td>
									      <td>${lists.sellerName}</td>
									      <td>${lists.category1IdName}</td>
									      <td>${lists.category2IdName}</td>
									      <td>${lists.category3IdName}</td>
									      <td>${lists.statusName}</td>
									      <td>${lists.price}</td>
									      <td>${lists.stock}</td>
									      <td>${lists.sales}</td>
									      <td>${lists.proName}</td>
		                                                                    
		                                  <td class="text-center" width="100">    
		                                                                           
		                                 	  <a href="javaScript:void(0);" onclick="shan(${lists.id})"><button type="button" class="btn bg-olive btn-xs" >删除</button></a>
					                          <c:choose>
													<c:when test="${lists.statusId == 2}">
													  <a href="javaScript:void(0);" onclick="return shangjia(${lists.id})" class="btn bg-olive btn-xs">上架</a>
													</c:when>
													<c:when test="${lists.statusId == 4}">
														<a href="javaScript:void(0);" onclick="return xiajia(${lists.id})" class="btn bg-olive btn-xs">下架</a>
													</c:when>
											  </c:choose>
		                                 	 <a href="${pageContext.request.contextPath}/selectUpId?id=${lists.id}"> <button type="button" class="btn bg-olive btn-xs" >修改</button> </a>
		                                  </td>
			                          </tr>
			                          </c:forEach>
			                          
			                          <tr align="center">
								          <td colspan="14">
								            <a href="${ctx}/selectGoodsAll?brandId=${brandId}&category1Id=${category1Id}&category2Id=${category2Id}&category3Id=${category3Id}&statusId=${statusId}&promotionId=${promotionId}&price1=${price1}&price2=${price2}&stock1=${stock1}&stock2=${stock2}&goodsName=${goodsName}&num=1">首页</a>
								            <a href="${ctx}/selectGoodsAll?brandId=${brandId}&category1Id=${category1Id}&category2Id=${category2Id}&category3Id=${category3Id}&statusId=${statusId}&promotionId=${promotionId}&price1=${price1}&price2=${price2}&stock1=${stock1}&stock2=${stock2}&goodsName=${goodsName}&num=${page.currNo-1}">上页</a>
								            <a href="${ctx}/selectGoodsAll?brandId=${brandId}&category1Id=${category1Id}&category2Id=${category2Id}&category3Id=${category3Id}&statusId=${statusId}&promotionId=${promotionId}&price1=${price1}&price2=${price2}&stock1=${stock1}&stock2=${stock2}&goodsName=${goodsName}&num=${page.currNo+1}">下页</a>
								            <a href="${ctx}/selectGoodsAll?brandId=${brandId}&category1Id=${category1Id}&category2Id=${category2Id}&category3Id=${category3Id}&statusId=${statusId}&promotionId=${promotionId}&price1=${price1}&price2=${price2}&stock1=${stock1}&stock2=${stock2}&goodsName=${goodsName}&num=${page.countCurrNo}">末页</a>
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
function test1(){
   var category1Id= $("[name=category1Id]").val();
  $.post("${pageContext.request.contextPath}/category1Id","category1Id="+category1Id,function(data){
       if(data.length>0){
          var htl = " <option value='0'>请选择</option>";
          for(var i=0;i<data.length;i++){
          htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
          }
          $("#er").html(htl);
        }else{
          alert("二级加载失败");
        }
     
     });
     }
     
     function test2(){
        var category2Id= $("[name=category2Id]").val();
        $.post("${pageContext.request.contextPath}/category2Id","category2Id="+category2Id,function(data){
          if(data.length>0){
	          var htl = " <option value='0'>请选择</option>";
	          for(var i=0;i<data.length;i++){
	          htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
	          }
	          $("#san").html(htl);
	        }else{
	          alert("三级加载失败");
	        }
     
     });

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


function shangjia(id){
   $.post("${pageContext.request.contextPath}/shangjia","id="+id,function(data){
      if(data=="true"){
        alert("上架成功");
        location.href="${pageContext.request.contextPath}/selectGoodsAll";
      }else if(data=="false"){
        alert("上架失败");
        location.href="${pageContext.request.contextPath}/selectGoodsAll";
      }
   })
}


function xiajia(id){
   $.post("${pageContext.request.contextPath}/xiajia","id="+id,function(data){
      if(data=="true"){
        alert("下架成功");
        location.href="${pageContext.request.contextPath}/selectGoodsAll";
      }else if(data=="false"){
        alert("下架失败");
        location.href="${pageContext.request.contextPath}/selectGoodsAll";
      }
   })
}

</script>
