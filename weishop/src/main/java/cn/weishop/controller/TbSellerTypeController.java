package cn.weishop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.weishop.demo.TbSellerType;
import cn.weishop.service.ITbSellerTypeService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
/*@RequestMapping("/tb-seller-type")*/
public class TbSellerTypeController {
	
	@Autowired
	private ITbSellerTypeService iTbSellerTypeService;

	@RequestMapping("/selectSellerType")
	public String selectSellerType(Model model){
	    try {
			List<TbSellerType> typeList=iTbSellerTypeService.selectSeller();
		    model.addAttribute("typeList", typeList);
		    return "backend/admin/index";
	    } catch (Exception e) {
			e.printStackTrace();
		}
		return "backend/admin/seller";
	}
	
	@RequestMapping("/updateSellerType")
	public String updateSellerType(TbSellerType tbSellerType,Model model){
		try {
			boolean falg=iTbSellerTypeService.updateSellerType(tbSellerType);
			if(falg==true){
				model.addAttribute("tbSellerType", tbSellerType);
				return "index";
			}else{
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
