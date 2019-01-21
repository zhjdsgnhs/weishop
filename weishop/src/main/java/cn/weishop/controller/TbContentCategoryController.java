package cn.weishop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.weishop.demo.TbContent;
import cn.weishop.demo.TbContentCategory;
import cn.weishop.service.ITbContentCategoryService;

/**
 * <p>
 * 内容分类 前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@RestController
/*@RequestMapping("/tb-content-category")*/
public class TbContentCategoryController {
	@Autowired
	private ITbContentCategoryService iTbContentCategoryService;
	
	@RequestMapping("/selectCategory")
	@ResponseBody
	public List<TbContentCategory> selectContentCategory(){
		List<TbContentCategory> categoryList = iTbContentCategoryService.selectCategory();
		return categoryList;
		
	}

}
