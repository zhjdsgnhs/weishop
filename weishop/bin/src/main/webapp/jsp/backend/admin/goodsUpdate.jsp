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

<body>
	<form action="${ctx}/goodUpdate" method="post" enctype="multipart/form-data">
		<div class="modal-body">		
			<table class="table table-bordered table-striped"  width="800px">
			    <tr>
			       <td colspan="2"><h3>添加商品</h3></td>
			    </tr>
			    
			    <tr>
		      		<td>商品款号:</td>
		      		<td>
		      		<input  class="form-control" placeholder="商品款号" name="stylenumber" value="${goods.stylenumber}" disabled="disabled"> 
		      		<input type="hidden"  class="form-control" placeholder="商品款号" name="stylenumber" value="${goods.stylenumber}"> 
		      		<input  class="form-control" type="hidden"  name="id" value="${goods.id}"> 
		      		 </td>
		      	</tr>	
		      	
		      	<tr>
		      		<td>商品名称:</td>
		      		<td><input  class="form-control" placeholder="商品名称" name="goodsName" value="${goods.goodsName}">  </td>
		      	</tr>	
		      	
		      	<tr>
		      		<td>商品价格:</td>
		      		<td><input  class="form-control" placeholder="商品价格" name="price" value="${goods.price}">  </td>
		      	</tr>	
		      	
		      	<tr id="yi2">
		      	  <td>一级分类:</td>
		      	  <td>
		      	    <select name="category1Id" class="form-control" onchange="test1()" id="yi">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${category1IdNameList1}" var="category1IdNameList1s">
                                      <option value="${category1IdNameList1s.id}" <c:if test="${category1IdNameList1s.id==goods.category1Id}">selected</c:if>>${category1IdNameList1s.name}</option>
                                    </c:forEach>
                                  </select>
		      	  </td>
		      	</tr>
		      	
		      	<tr id="er2">
		      	  <td>二级分类:</td>
		      	  <td>
		      	    <select name="category2Id" class="form-control" onchange="test2()" id="er">
                                    <option value="0">请选择</option>
                                    <c:forEach items="${category1IdNameList2}" var="category1IdNameList2s">
                                      <option value="${category1IdNameList2s.id}" <c:if test="${category1IdNameList2s.id==goods.category2Id}">selected</c:if>>${category1IdNameList2s.name}</option>
                                    </c:forEach>
                                  </select>
		      	  </td>
		      	</tr>
		      	
		      	<tr id="er2">
		      	  <td>三级分类:</td>
		      	  <td>
		      	    <select name="category3Id" class="form-control" id="san">
                               <option value="0">请选择</option>
                                 <c:forEach items="${category1IdNameList3}" var="category1IdNameList3s">
                                      <option value="${category1IdNameList3s.id}" <c:if test="${category1IdNameList3s.id==goods.category3Id}">selected</c:if>>${category1IdNameList3s.name}</option>
                                 </c:forEach>
                     </select>
		      	  </td>
		      	</tr>
		      	
		      	<tr>
		      		<td>所属店铺:</td>
		      		<td>
		      		  <select name="sellerId" class="form-control">
                            <option value="0">请选择</option>
                                <c:forEach items="${listSeller}" var="listSellers">
                                      <option value="${listSellers.sellerId}" <c:if test="${listSellers.sellerId==goods.sellerId}">selected</c:if>>${listSellers.name}</option>
                                </c:forEach>
                       </select>
                    </td>
		      	</tr>	
			
		      	<tr>
		      		<td>商品品牌:</td>
		      		<td>
		      		  <select name="brandId" class="form-control">
                            <option value="0">请选择</option>
                                <c:forEach items="${listBrand}" var="listBrands">
                                      <option value="${listBrands.id}" <c:if test="${listBrands.id==goods.brandId}">selected</c:if>>${listBrands.name}</option>
                                </c:forEach>
                       </select>
                    </td>
		      	</tr>	
		      	
		      	<tr>
		      		<td>在售状态:</td>
		      		<td>
		      		    <select name="statusId" class="form-control">
                              <option value="0">请选择</option>
                                 <c:forEach items="${listStatus}" var="listStatuss">
                                      <option value="${listStatuss.statusId}" <c:if test="${listStatuss.statusId==goods.statusId}">selected</c:if>>${listStatuss.statusName}</option>
                                 </c:forEach>
                        </select>
                    </td>
		      	</tr>	
		      	
		      	<tr>
		      		<td>促销商品:</td>
		      		<td>
		      		   <select name="promotionId" class="form-control">
                            <option value="0">请选择</option>
                                 <c:forEach items="${listPromotion}" var="listPromotions">
                                    <option value="${listPromotions.promotionId}" <c:if test="${listPromotions.promotionId==goods.promotionId}">selected</c:if>>${listPromotions.promotionStatus}</option>
                                 </c:forEach>
                       </select>
                    </td>
		      	</tr>	
		      	
		      	<tr>
		      		<td>商品库存:</td>
		      		<td><input  class="form-control" placeholder="商品库存" name="stock" value="${goods.stock}"></td>
		      	</tr>	
		      
		      	<tr>
		      		<td>商品图片:</td>
		      		<td>
		      		<img alt="" width="40" height="40" src="${pageContext.request.contextPath}/upload/${goods.smallPic}">
		      		<input type="file"  placeholder="商品图片" name="sPic_Iamge">
		      		<input type="hidden" name="smallPic" value="${goods.smallPic}">
		      		<span>${FileError}</span>
		      		</td>
		      	</tr>	
		      	      	
			 </table>				
		</div>
		<div class="modal-footer">						
			<button id="ti" type="submit" class="btn btn-success" data-dismiss="modal" aria-hidden="true">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
		</form>

</body>
</html>

<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript">
function test1(){
alert(1)
   var category1Id= $("[name=category1Id]").val();
   alert(category1Id)
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

$(function(){
 $("#ti").click(function(){
    
    var goodsName = $("[name=goodsName]").val();
    var price = $("[name=price]").val();
    var category1Id = $("[name=category1Id]").val();
    var category2Id = $("[name=category2Id]").val();
    var category3Id = $("[name=category3Id]").val();
    var sellerId = $("[name=sellerId]").val();
    var brandId = $("[name=brandId]").val();
    var statusId = $("[name=statusId]").val();
    var promotionId = $("[name=promotionId]").val();
    var stock = $("[name=stock]").val();
    var sPic_Iamge = $("[name=sPic_Iamge]").val();
    var shu = /^\d+$/;
    
    if(goodsName==""){
      alert("商品名称不能为空");
      return false;
    }
    
    if(price==""){
      alert("商品价格不能为空");
      return false;
    }
    
    if(category1Id=="0"){
      alert("一级分类不能为空");
      return false;
    }
    
    if(category2Id=="0"){
      alert("二级分类不能为空");
      return false;
    }
    
    if(category3Id=="0"){
      alert("三级分类不能为空");
      return false;
    }
    
    if(sellerId=="0"){
      alert("所属店铺不能为空 ");
      return false;
    }
    if(brandId=="0"){
      alert("商品品牌不能为空");
      return false;
    }
    
    if(statusId=="0"){
      alert("在售状态不能为空");
      return false;
    }
    
    if(promotionId=="0"){
      alert("促销商品不能为空");
      return false;
    }
    
    if(stock==""){
      alert("商品库存不能为空");
      return false;
    }else if(shu.test(stock)==false){
       alert("商品库存只能为数字");
       return false;
    }
    
   
    return true;           
 })
})
</script> 
