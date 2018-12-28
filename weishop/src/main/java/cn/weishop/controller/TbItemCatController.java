package cn.weishop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weishop.demo.Page;
import cn.weishop.demo.TbItemCat;
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
    
    @RequestMapping("/login")
    public String aa(){
    	return "backend/admin/index";
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
				return "backend/admin/tbItemCatalist";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    	
    }
    
    @ResponseBody
    @RequestMapping("/SelectTypeId1")
    public List<TbItemCat> SelectTypeId1(@RequestParam(value="type_id",required=false) int type_id){
    	try {
			List<TbItemCat> list = iTbItemCatService.SelectTypeId1(type_id);
			if(list!=null){
				return list;
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    	
    }
    
   


}
