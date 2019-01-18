package cn.weishop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weishop.demo.Page;
import cn.weishop.demo.TbGoods;
import cn.weishop.demo.TbItemCat;
import cn.weishop.service.ITbGoodsService;
import cn.weishop.service.ITbItemCatService;

/**
 * <p>
 * 商品类目 前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
/*@RequestMapping("/tb-item-cat")*/
public class TbItemCatController {

    @Autowired
    public ITbItemCatService iTbItemCatService;
    
    @Autowired
    public ITbGoodsService iTbGoodsService;
    
    @RequestMapping("/login")
    public String aa(){
    	return "jsp/backend/admin/index";
    }
    
    @RequestMapping("/selectAllParentId")
    public String selectAllParentId(@RequestParam(value="num",required=false,defaultValue="0") int num,Model model){
		try {
			int count = iTbItemCatService.count();
			
			Page page = new Page();
			
			page.setCountCurrSize(count);
			page.setCurrNo(num);
			
			
			int pageNum = (page.getCurrNo()-1)*page.getCurrSize();
			
			List<TbItemCat> list = iTbItemCatService.selectAllParentId(pageNum,page.getCurrSize());
		    
			if(list!=null){
				 model.addAttribute("list",list);
				 model.addAttribute("page",page);
				return "jsp/backend/admin/tbItemCatalist";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    	
    }
    
    @ResponseBody
    @RequestMapping("/SelectTypeId1")//查询出所有第一级分类的元素
    public List<TbItemCat> SelectTypeId1(Model model){
    	try {
			List<TbItemCat> list = iTbItemCatService.SelectTypeId1();
			if(list!=null){
				model.addAttribute("list",list);
				return list;
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    @ResponseBody
    @RequestMapping("/SelectAllTypeId2")//查询出所有第二级分类的元素
    public List<TbItemCat> SelectAllTypeId2(Model model){
    	try {
			List<TbItemCat> listAllType2 = iTbItemCatService.SelectAllTypeId2();
			if(listAllType2!=null){
				model.addAttribute("listAllType2",listAllType2);
				return listAllType2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    	
    }
    
    @ResponseBody
    @RequestMapping("/SelectTypeId2")
    public List<TbItemCat> SelectTypeId2(@RequestParam(value="parentId",required=false) int parentId,Model model){
    	try {
    		List<TbItemCat> list = iTbItemCatService.SelectTypeId1();
    		List<TbItemCat> list2 = iTbItemCatService.SelectTypeId2(parentId);
    		model.addAttribute("list",list);
    		model.addAttribute("list2",list2);
			return list2;
			
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    	
    }
    
    @RequestMapping("/add1")
    @ResponseBody
    public String Insert(TbItemCat tb){
    	try {
			boolean falg = iTbItemCatService.add(tb);
			if(falg==true){
				return "true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "false";
    }
    
    
    @RequestMapping("/update")
    @ResponseBody
    public String update(TbItemCat tb){
    	try {
			boolean falg = iTbItemCatService.update(tb);
			if(falg==true){
				return "true";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "false";
    }
    
    
    @RequestMapping("/selectIds")
    @ResponseBody
    public String selectIds(@RequestParam(value="id",required=false) int id){
		try {
			List<TbItemCat> list = iTbItemCatService.selectIds(id);
			if(list.size()>0){
				return "falg1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return "falg2";
    	
    	
    }
    
    @RequestMapping("/getItemCatBycategory3_id")
    @ResponseBody
    public String getItemCatBycategory3_id(@RequestParam(value="id",required=false) int id){
		try {
			List<TbGoods> lists = iTbGoodsService.getItemCatBycategory3_id(id); 
			if(lists.size()>0){
				    return "falgs1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "falgs2";
    }
    
    
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value="id",required=false) int id){
		try {
				   boolean falg = iTbItemCatService.delete(id);
				   if(falg==true){
					return "true";
				   }else if(falg==false){
					   return "false";
				   }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "";
    	
    }
    
    
    @ResponseBody
    @RequestMapping("/selectCatId")
    public TbItemCat selectCatId(@RequestParam(value="id",required=false) int id,Model model){
    	try  {
    		TbItemCat cat = iTbItemCatService.selectCatId(id);
    		model.addAttribute("cat",cat);
    		return cat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    	
    }
   


}
