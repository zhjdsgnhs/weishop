<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                
                    <div class="box-header with-border">
                        <h3 class="box-title">商品分类</h3>
                    </div>

                    <div class="box-body">
                     
                     <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" id="tian" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" ><i class="fa fa-file-o"></i> 新建</button>
                                    </div>
                                </div>
                            </div>

                        <!-- 数据表格 -->
                         <div class="table-box">
			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                              
										  <th class="sorting_asc">商品ID</th>
									      <th class="sorting">分类名称</th>
									      <th class="sorting">分类级别</th>
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                          <c:forEach items="${list}" var="lists">
									  
									   <tr>
			                             
			                              <td>${lists.id}</td>			                              
				                          <td>${lists.name}</td>
									      <td>${lists.typeName}</td>
		                                  	 
		                                  	 
		                                  <td class="text-center">         
		                                  <button type="button" onclick="xiu(${lists.id})" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" class="btn bg-olive btn-xs" ><i class="fa fa-file-o"></i>修改</button>                                  
		                                 
		                                 	  <a href="JavaScript:void(0);" onclick="shan(${lists.id})"><button type="button" class="btn bg-olive btn-xs">删除</button></a>                                             
		                                  </td>	                                  
		                                 
			                          </tr>
			                          </c:forEach>
			                          
			                          <tr align="center">
								          <td colspan="5">
								            <a href="${ctx}/selectAllParentId?num=1">首页</a>
								            <a href="${ctx}/selectAllParentId?num=${page.currNo-1}">上页</a>
								            <a href="${ctx}/selectAllParentId?num=${page.currNo+1}">下页</a>
								            <a href="${ctx}/selectAllParentId?num=${page.countCurrNo}">末页</a>
								          </td>
       								  </tr>
			                      </tbody>
			                  </table>
			                  <!--数据列表/-->                        
							  
							 
                        </div>
                        <!-- 数据表格 /-->
                        
                        
                     </div>
                    <!-- /.box-body -->



<!-- 添加窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
	<form action=""></form>
		
		<div class="modal-body">		
			<table class="table table-bordered table-striped"  width="800px">
			   	<tr>
			       <td colspan="2"><h3>添加分类</h3></td>
			    </tr> 
			   	<tr>
		      		<td>级别选择</td>
		      		<td>
		      		 <select class="form-control" name="typeId" id="ji" class="select" onchange="er()">
	                    <option value="1">一级分类</option>
	                    <option value="2">二级分类</option>
	                    <option value="3">三级分类</option>
                     </select>
		      		</td>
		      	</tr>	
		      	
		      	<tr id="yi2">
		      	  <td>一级分类:</td>
		      	  <td>
		      	    <select class="form-control" id="yi" name="parentId" onchange="test()">
		      	      <option value="0">请选择</option>
		      	    </select>
		      	  </td>
		      	</tr>
		      	
		      	<tr id="er2">
		      	  <td>二级分类:</td>
		      	  <td>
		      	    <select class="form-control" id="er" name="parentId2">
		      	      <option value="0">请选择</option>
		      	    </select>
		      	  </td>
		      	</tr>
			
		      	<tr>
		      		<td>商品名称</td>
		      		<td>
		      		<input  class="form-control" placeholder="分类名称" name="name" id="name"> 
		      		<input type="hidden" class="form-control"  name="id" id="id">
		      		 </td>
		      	</tr>		      	
		      	      	
			 </table>				
		</div>
		<div class="modal-footer">						
			<button id="ti" class="btn btn-success"  aria-hidden="true" onclick="yan()">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true" onclick="closea()">关闭</button>
		</div>
	  </div>
	</div>
</div>
</body>
  
</html>
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(function(){
       $("#yi").css("display","none");
       $("#er").css("display","none");
       $("#yi2").css("display","none");
       $("#er2").css("display","none");
       
       $("#ji").change(function(){
         var ji = $(this).val();
         if(ji<=1){
                 a1();   
         }
         if(ji==2){
                 a2();
         }
         if(ji==3){
                 a3();
           
         }
      })
    });
    
    function a1(){
           $("#er").css("display","none"); 
           $("#yi").css("display","none");
           $("#yi2").css("display","none");
           $("#er2").css("display","none");
    }
    
    function a2(){
            $("#yi").css("display","block");
          $("#yi2").css("display","block");
          $("#er").css("display","none"); 
          $("#er2").css("display","none");
    }
    
    function a3(){
           $("#yi").css("display","block");
          $("#yi2").css("display","block");
          $("#er").css("display","block");
          $("#er2").css("display","block");
    }
    

   function er(parentId){
  
    var type_id = $("[name=typeId]").val();
   
     if(type_id==3||type_id==2){
    
      $.post("${pageContext.request.contextPath}/SelectTypeId1",null,function(data){
     
       if(data.length>0){
          var htl = "<option value='0'>请选择</option>";
          for(var i=0;i<data.length;i++){
           htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
          } 
          $("#yi").html(htl);
         
        }else{
          alert("一级加载失败");
        }
     }); 
    }    
  }   
     
     function test(){
        var parentId = $("[name=parentId]").val();
    
     $.post("${pageContext.request.contextPath}/SelectTypeId2","parentId="+parentId,function(data){
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
     
     function yan(){//表单验证
          var id=$("[name=id]").val();
          var typeId = $("[name=typeId]").val();
          var parentId = $("[name=parentId]").val();
          var parentId2= $("[name=parentId2]").val();
          var name= $("#name").val();  
       if(typeId==null || typeId==""){
            alert("级别不能为空");
             return false;
          }
         
            if(parentId==null || parentId==""){
              alert("一级分类不能为空")
              return false;
             }
             
            if(parentId2==null || parentId2==""){
              alert("二级分类不能为空")
              return false;
             }
           
           if(name==null || name==""){
             alert("名称不能为空");
             return false;
          }
          return true;
      
         /*  if(typeId==2 || typeId==3){
            if(parentId=="0"){
            alert("一级分类不能为空")
            
             }
             if(parentId2=="0"){
            alert("二级分类不能为空")
            
             }
             return false;
          } */
          
          /* if(typeId==3){
              if(parentId2=="0"){
            alert("二级分类不能为空")
            return false;
             }

          }
           */
     }
     
     
     $(function(){
          $("#tian").click(function(){
          $("#myModalLabel").html('品牌添加');
          $("[name=typeId]").val(" ");
          $("[name=parentId]").val(" ");
          $("[name=parentId2]").val(" ");
          $("[name=name]").val(" ");
          $("[name=id]").val(" ");
          a1(); 
        
          
       });
     
      $("#ti").click(function(){//提交
          var id=$("[name=id]").val();
          var typeId = $("[name=typeId]").val();
          var parentId = $("[name=parentId]").val();
          var parentId2= $("[name=parentId2]").val();
          var name= $("[name=name]").val();          
        
          if(id==null || id==" "){//为空为添加
                 if(typeId==1){
		            $.post("${pageContext.request.contextPath}/add1",
		                   "parentId=0&name="+name+"&typeId="+typeId
		                   ,function(data){
		            if(data=="true"){
		              alert("添加成功");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		              /* $("#editModal").modal('hide'); */
		            }else if(data=="false"){
		              alert("添加失败");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }
		           })
		          }
		          
		          if(typeId==2){
		            $.post("${pageContext.request.contextPath}/add1",
		                   "parentId="+parentId+"&name="+name+"&typeId="+typeId
		                   ,function(data){
		            if(data=="true"){
		            
		              alert("添加成功");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }else if(data=="false"){
		              alert("添加失败");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }
		          
		           })
		          }
		          
		          
		          if(typeId==3){
		          $.post("${pageContext.request.contextPath}/add1",
		                   "parentId="+parentId2+"&name="+name+"&typeId="+typeId
		                   ,function(data){
		            if(data=="true"){
		              alert("添加成功");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }else if(data=="false"){
		              alert("添加失败");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }
		           })
		          }
		         
		          
          }else if(id!=null || id!=" "){//id不为空为修改
                if(typeId==1){
		            $.post("${pageContext.request.contextPath}/update",
		                   "parentId=0&name="+name+"&typeId="+typeId+"&id="+id
		                   ,function(data){
		            if(data=="true"){
		              alert("修改成功");
		            }else if(data=="false"){
		              alert("修改失败");
		            }
		           })
		          }
		          
		          if(typeId==2){
		            $.post("${pageContext.request.contextPath}/update",
		                   "parentId="+parentId+"&name="+name+"&typeId="+typeId+"&id="+id
		                   ,function(data){
		            if(data=="true"){
		            
		              alert("修改成功");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }else if(data=="false"){
		              alert("修改失败");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }
		          
		           })
		          }
		          
		          if(typeId==3){
		          $.post("${pageContext.request.contextPath}/update",
		                   "parentId="+parentId2+"&name="+name+"&typeId="+typeId+"&id="+id
		                   ,function(data){
		            if(data=="true"){
		              alert("修改成功");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }else if(data=="false"){
		              alert("修改失败");
		              location.href="${pageContext.request.contextPath}/selectAllParentId";
		            }
		           })
		          }
           }
          
 
      });
     
});

function shan(id){
   if(confirm("是否确认删除?")){//删除时查询是否存在子级
      $.post("${pageContext.request.contextPath}/selectIds","id="+id,function(data){
         if(data=="falg1"){
           alert("不能删除该分类下还有子级数据");
         }else if(data=="falg2"){
          $.post("${pageContext.request.contextPath}/getItemCatBycategory3_id","id="+id,function(data2){
              if(data2=="falgs1"){
                 alert("不能删除,该分类下还有商品");
             }else if(data2=="falgs2"){
                 $.post("${pageContext.request.contextPath}/delete","id="+id,function(data3){
		               if(data3=="true"){
		                 alert("删除成功");
		                 location.href="${pageContext.request.contextPath}/selectAllParentId";
		              }else if(data3=="false"){
		                alert("删除失败");
		                 location.href="${pageContext.request.contextPath}/selectAllParentId";
		              }
		          }); 
               }
           });
        }
      });
   }
}

	var catId;
	
 function queryTwo(parentId){//查询出所有第二级分类的元素
    var type_id = $("[name=typeId]").val();
  		
      $.post("${pageContext.request.contextPath}/SelectAllTypeId2",null,function(data){
     
       if(data.length>0){
          var htl = "<option value='0'>请选择</option>";
          for(var i=0;i<data.length;i++){
          if(data[i].id == parentId){
          	 htl+="<option selected='selected' value='"+data[i].id+"'>"+data[i].name+"</option>";
          	 catId = data[i].parentId;
          }else{
          	 htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
          }
           
          } 
          $("#er").html(htl);
         
        }else{
          alert("二级加载失败");
        }
     });
       
  }   
  function queryOne(parentId){//查询出所有第一级分类的元素
    var type_id = $("[name=typeId]").val();
  
      $.post("${pageContext.request.contextPath}/SelectTypeId1",null,function(data){
     
       if(data.length>0){
       
          var htl = "<option value='0'>请选择</option>";
          
          for(var i=0;i<data.length;i++){
           if(data[i].id == catId || data[i].id==parentId){
          	 htl+="<option selected='selected' value='"+data[i].id+"'>"+data[i].name+"</option>";
           
           }else{
          	 htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
           }
           
           
          } 
          
          
          $("#yi").html(htl);
         
        }else{
          alert("一级加载失败");
        }
     }); 
       
  }   

function xiu(id){//修改查询ID   先通过三级Id查询二级再根据ID查询一级
     
	 $.post("${pageContext.request.contextPath}/selectCatId","id="+id,function(data){
	 
	  $("[name=typeId]").find("option[value='"+data.typeId+"']").attr("selected",true);
	  $("#id").val(data.id);	
	  $("#name").val(data.name);
	  	
	 	if(data.typeId == 1){//为1级
	 		a1();
	 	}else if(data.typeId == 2){//为二级
	 		a2();
	 		queryOne(data.parentId);
	 	}else {//为三级
	 		a3();
	 		queryTwo(data.parentId);
	 		queryOne(data.parentId);
	 	}
   });
   }
   
   function closea(){
      location.reload();
   }
   
   
   
   

   
   
</script>
