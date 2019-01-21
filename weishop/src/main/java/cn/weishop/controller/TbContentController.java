package cn.weishop.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weishop.demo.Page;
import cn.weishop.demo.TbContent;
import cn.weishop.demo.TbContentCategory;
import cn.weishop.service.ITbContentCategoryService;
import cn.weishop.service.ITbContentService;
import cn.weishop.utils.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
/*@RequestMapping("/tb-content")*/
public class TbContentController {
	@Autowired
	private ITbContentService iTbContentService;
	@Autowired
	private  ITbContentCategoryService  ITbContentCategoryService;
	
	@RequestMapping("/selectContent")
	public String selectContent(@RequestParam(value="name",required=false) String name,
			@RequestParam(value="num",required=false,defaultValue="1") Integer num,
			Model model){
		try {
			int count = iTbContentService.count(name);
			
			Page page = new Page();
			page.setCountCurrSize(count);
			page.setCurrNo(num);
			
			int pageNum =((page.getCurrNo()-1)*page.getCurrSize());
			
			List<TbContent> tbContentList = iTbContentService.selectContent(name, pageNum, page.getCurrSize());
			
			model.addAttribute("tbContentList", tbContentList);
			model.addAttribute("page", page);
			model.addAttribute("name", name);
			
			return "backend/admin/tbContentList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	@RequestMapping("/selContentId")
	@ResponseBody
	public TbContent selContentId(@RequestParam(value="id",required=false) Integer id,Model model){
		TbContent tbContent = iTbContentService.selContentId(id);
		List<TbContentCategory> list = ITbContentCategoryService.selectCategory();
		tbContent.setCategory(list);
		return  tbContent;
		
	}
	
	@RequestMapping("/saveAndupdate")
	@ResponseBody
	public Result saveAndUpdate(
			@RequestParam("title") String title,
			@RequestParam("name") String name,
			@RequestParam("categoryId") Integer categoryId,
			@RequestParam("sortOrder") Integer sortOrder,
			@RequestParam("pic") String pic,
			@RequestParam(value="id",required=false,defaultValue="0") int id,
			HttpSession session){
		
		System.out.println("进入新增、修改方法———————————————————————————————");
		
		TbContent content=new TbContent();
		content.setTitle(title);
		content.setName(name);
		content.setCategoryId(categoryId);
		content.setSortOrder(sortOrder);
		content.setPic(pic);
		
		//判断是否是新增还是修改
		
		if(id!=0){
			content.setId(id);
			int count = iTbContentService.updContent(content);
			if (count>0) {
				return new Result(true,0,"修改成功");
			} else {
				return new Result(false,-1,"修改失败");
			}
		}else{
			int count = iTbContentService.insertContent(content);
			if (count>0) {
				return new Result(true,0,"新增成功");
			} else {
				return new Result(true,201,"新增失败");
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("delContent")
	public String delContent(@RequestParam("id") Integer id){
		try {
			boolean falg = iTbContentService.delContent(id);
			if(falg==true){
				 return "true";
			 }else if(falg==false){
				 return "false";
			 }  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
