package cn.weishop.qtcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.weishop.demo.Page;
import cn.weishop.demo.TbBrand;
import cn.weishop.demo.TbGoods;
import cn.weishop.demo.TbGoodsDesc;
import cn.weishop.demo.TbItemCat;
import cn.weishop.service.ITbBrandService;
import cn.weishop.service.ITbGoodsDescService;
import cn.weishop.service.ITbGoodsService;
import cn.weishop.service.ITbItemCatService;

@Controller
public class QtTbItemCatController {
	 @Autowired
	 private ITbItemCatService iTbItemCatService;
	 @Autowired
     private ITbGoodsService iTbGoodsService;
	 @Autowired
	 private ITbBrandService iTbBrandService;
	 @Autowired
	 private ITbGoodsDescService iTbGoodsDescService;
	
	@RequestMapping("/QTindex")//前台首页
	public String QTindex(Model model,HttpSession session){
		 try {
			 List<TbItemCat> list = iTbItemCatService.SelectTypeId1();
			 List<TbGoods> listRX = iTbGoodsService.selectReiXiao();
			 
			 if(list!=null){
					model.addAttribute("list",list);
					model.addAttribute("listRX",listRX);
					return "jsp2/index";
				}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@RequestMapping("/productList")//前台首页点击进入相关商品
	public String productList(@RequestParam(value="id",required=false) Integer id,
			@RequestParam(value="num",required=false,defaultValue="1") int num,
			@RequestParam(value="brandId",required=false,defaultValue="0") int brandId,
			Model model,HttpServletRequest request){
		 try {
			 
			 int count = iTbGoodsService.QTcount(id,brandId);
			 Page page = new Page();
			 page.setCountCurrSize(count);
			 page.setCurrNo(num);
			 request.setAttribute("id", id);
			 int pageNum = (page.getCurrNo()-1)*page.getCurrSize();
			 List<TbGoods> listGood = iTbGoodsService.ListselectCatId(id,brandId,pageNum,page.getCurrSize());
			 List<TbBrand> listBrand = iTbBrandService.selectBrand();
			 if(listGood!=null){
				 model.addAttribute("listGood",listGood);
				 model.addAttribute("listBrand",listBrand);
				 model.addAttribute("brandId",brandId);
				 model.addAttribute("page",page);
				 return "jsp2/product_list";
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("/QTfenlei")//前台首页
	public String QTfenlei(Model model,HttpSession session){
		 try {
			 List<TbItemCat> list = iTbItemCatService.SelectTypeId1();
				if(list!=null){
					model.addAttribute("list",list);
					return "jsp2/category";
				}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("/productAll")//前台分类点击全部查询所有
	public String productAll( @RequestParam(value="brandId",required=false,defaultValue="0") int brandId,
			   @RequestParam(value="category1Id",required=false,defaultValue="0") int category1Id,
			   @RequestParam(value="category2Id",required=false,defaultValue="0") int category2Id,
			   @RequestParam(value="category3Id",required=false,defaultValue="0") int category3Id,
			   @RequestParam(value="statusId",required=false,defaultValue="0") int statusId,
			   @RequestParam(value="promotionId",required=false,defaultValue="0") int promotionId,
			   @RequestParam(value="price1",required=false,defaultValue="0") int price1,
			   @RequestParam(value="price2",required=false,defaultValue="0") int price2,
			   @RequestParam(value="stock1",required=false,defaultValue="0") int stock1,
			   @RequestParam(value="stock2",required=false,defaultValue="0") int stock2,
			   @RequestParam(value="goodsName",required=false) String goodsName,
			   @RequestParam(value="num",required=false,defaultValue="0") int num,Model model,HttpServletRequest request){
		try {
			int count = iTbGoodsService.count(brandId, category1Id, category2Id, category3Id, statusId, promotionId, price1, price2, stock1, stock2, goodsName);
			Page page = new Page();
			page.setCountCurrSize(count);
			page.setCurrNo(num);
			
			int pageNum = (page.getCurrNo()-1)*page.getCurrSize();
			
			List<TbBrand> listBrand = iTbBrandService.selectBrand();

			List<TbGoods> listGood= iTbGoodsService.selectAll(brandId, category1Id, category2Id, category3Id, statusId, promotionId, price1, price2, stock1, stock2, goodsName, pageNum,page.getCurrSize());
			if(listGood!=null){
				model.addAttribute("listGood",listGood);
				
				model.addAttribute("brandId",brandId);
			
				model.addAttribute("listBrand",listBrand);
				
				model.addAttribute("page",page);
				return "jsp2/product_list2";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("/productView")//通过点击图片获取ID显示商品详情
	public String productView(@RequestParam(value="goodsId",required=false) Integer goodsId,
			Model model,HttpServletRequest request){
		  try {
			  TbGoodsDesc descs = iTbGoodsDescService.selectDescId(goodsId);
			  if(descs!=null){
				  model.addAttribute("descs",descs);
				  return "jsp2/product";
			  }else{
				  return "jsp2/404";
			  }
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("/ReiXiao")//热销
	public String ReiXiao(Model model){
		try {
			 List<TbItemCat> list = iTbItemCatService.SelectTypeId1();
			List<TbGoods> listRX = iTbGoodsService.selectReiXiao();
			if(listRX!=null){
				model.addAttribute("listRX",listRX);
				model.addAttribute("list",list);
				return "jsp2/index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/XinPin")//新品
	public String XinPin(Model model){
		try {
			 List<TbItemCat> list = iTbItemCatService.SelectTypeId1();
			List<TbGoods> listXP = iTbGoodsService.selectlistXP();
			if(listXP!=null){
				model.addAttribute("listRX",listXP);
				model.addAttribute("list",list);
				return "jsp2/index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/Zhekou")//热销
	public String Zhekou(Model model){
		try {
			 List<TbItemCat> list = iTbItemCatService.SelectTypeId1();
			List<TbGoods> listZK = iTbGoodsService.selectZhekou();
			if(listZK!=null){
				model.addAttribute("listRX",listZK);
				model.addAttribute("list",list);
				return "jsp2/index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
