package cn.weishop.controller;



import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import cn.weishop.demo.TbBrand;
import cn.weishop.service.ITbBrandService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
@RequestMapping("/brand")
public class TbBrandController {
	 
	@Autowired
	private ITbBrandService ITbBrandService;
	
	@RequestMapping("index")
	public String lala(){
		return "jsp/backend/admin/index";
		
		
	}
	 
	@RequestMapping("select")
	public String select(
			@RequestParam(value="name",required=false)String name,
			@RequestParam(value="num",required=false)Integer num,
			HttpServletRequest request
			) {
	 	if(num==null){
	 		num=1;
    	}
        QueryWrapper<TbBrand> query = new QueryWrapper<TbBrand>();
    	   
    	 if(name!=null  && !name.equals("")){
    		 query.like("name", name);
    	 }  	 
        request.setAttribute("list", ITbBrandService.page(new Page<TbBrand>(num,5),query).getRecords());
    	int count=ITbBrandService.count(query);
    
        int pagenum = count%5==0 ? count/5  : count/5+1; 
        request.setAttribute("count", count);
      	request.setAttribute("pageNum", pagenum);
		request.setAttribute("name", name);
		request.setAttribute("num",num);
    	return "jsp/backend/admin/brand";	  	    
	}
	
	
	@RequestMapping("update")
	@ResponseBody
	public TbBrand entity(	
			@RequestParam(value="id",required=false)Integer id,
			HttpServletRequest request 
			){
		  QueryWrapper<TbBrand> queryWrapper =new QueryWrapper<TbBrand>();
		   TbBrand ban =  ITbBrandService.getOne(queryWrapper.eq("id", id));
		  
		
		return ban;
	} 
    @RequestMapping("delete")
	public String  shanchu(@RequestParam(value="id",required=false) Integer id,
			HttpServletRequest request ,HttpServletResponse response 
			) {
    	    response.setCharacterEncoding("utf-8");
        	if( ITbBrandService.removeById(id)){
        		
        		try {
					response.getWriter().print("<script>alert('删除成功！');location='select'</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		
        	}else {
        		try {
					response.getWriter().print("<script>alert('删除失败！');location='select'</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	return null;
	}
	
	@RequestMapping("SaveOrUpdate")
    public String sou(
    		TbBrand brand,BindingResult bindingResult,
			HttpServletRequest request ,HttpServletResponse response
    		){
		   response.setCharacterEncoding("utf-8");
		     Date date;
		     LocalDate localDate = null;
             String  publishTime= request.getParameter("publishTime");
             DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = format1.parse(publishTime);
				Instant instant =date.toInstant();
				 ZoneId zoneId = ZoneId.systemDefault();
			 localDate = instant.atZone(zoneId).toLocalDate();
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             
             
	      	if(brand!=null && brand.getId()!=null){
	      		try {
	      			 brand.setPublishTime(localDate);
	 				brand.setStatus(1);
	      			QueryWrapper<TbBrand> updateWrapper =new QueryWrapper<TbBrand>();
				if(	ITbBrandService.update(brand, updateWrapper.eq("id", brand.getId()))){
					response.getWriter().print("<script>alert('修改成功！');location='select'</script>");
				}else {
					response.getWriter().print("<script>alert('修改失败！');location='select'</script>");
				}
				
				}  catch (IOException e) {
					e.printStackTrace();
				}
	      		
	      		
	      	}else{
	      		 brand.setPublishTime(localDate);
	 				brand.setStatus(1);
	      		if(ITbBrandService.save(brand)){
	      			try {
						response.getWriter().print("<script>alert('添加成功！');location='select'</script>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	      		}else {
	      			try {
						response.getWriter().print("<script>alert('添加失败！');location='select'</script>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	      		
	      	}
		
		return null;
	}
	
	@RequestMapping("qiyong")
	public String qiyong(HttpServletRequest request,@RequestParam("id")Integer id){
		int count = ITbBrandService.Qiyong(id);
		
		return "redirect:/brand/select";
	}
	
	@RequestMapping("jinyong")
	public String jinyong(HttpServletRequest request,@RequestParam("id")Integer id){
		int count = ITbBrandService.Jinyong(id);
	
		return "redirect:/brand/select";
	}
	
	
}
