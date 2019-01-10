package cn.weishop.controller;


import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.weishop.demo.Page;
import cn.weishop.demo.TbBrand;
import cn.weishop.demo.TbGoods;
import cn.weishop.demo.TbGoodsPromotion;
import cn.weishop.demo.TbGoodsStatus;
import cn.weishop.demo.TbItemCat;
import cn.weishop.demo.TbSeller;
import cn.weishop.service.ITbBrandService;
import cn.weishop.service.ITbGoodsPromotionService;
import cn.weishop.service.ITbGoodsService;
import cn.weishop.service.ITbGoodsStatusService;
import cn.weishop.service.ITbItemCatService;
import cn.weishop.service.ITbSellerService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
/*@RequestMapping("/tb-goods")*/
public class TbGoodsController {
   @Autowired
   private ITbGoodsService iTbGoodsService;
   @Autowired
   private ITbBrandService iTbBrandService;
   @Autowired
   private ITbGoodsStatusService iTbGoodsStatusService;
   @Autowired
   private ITbGoodsPromotionService iTbGoodsPromotionService;
   @Autowired
   private ITbItemCatService iTbItemCatService;
   @Autowired
   private ITbSellerService iTbSellerService;
   
   
   @RequestMapping("/selectGoodsAll")
   public String selectAll(
		   @RequestParam(value="brandId",required=false,defaultValue="0") int brandId,
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
		   @RequestParam(value="num",required=false,defaultValue="0") int num
		   ,Model model
		   ){
	        try {
				int count = iTbGoodsService.count(brandId, category1Id, category2Id, category3Id, statusId, promotionId, price1, price2, stock1, stock2, goodsName);
				Page page = new Page();
				page.setCountCurrSize(count);
				page.setCurrNo(num);
				
				int pageNum = (page.getCurrNo()-1)*page.getCurrSize();
				
				List<TbBrand> listBrand = iTbBrandService.selectBrand();
				
				List<TbGoodsStatus> listStatus = iTbGoodsStatusService.selectStatus();
				
				List<TbGoodsPromotion> listPromotion = iTbGoodsPromotionService.selectPromotion();
				
				List<TbItemCat> category1IdNameList1 = iTbItemCatService.SelectTypeId1();
				
				List<TbItemCat> category1IdNameList2 = iTbItemCatService.SelectTypeId2(category1Id);
				
				List<TbItemCat> category1IdNameList3 = iTbItemCatService.SelectTypeId3(category2Id);
				
				List<TbGoods> list= iTbGoodsService.selectAll(brandId, category1Id, category2Id, category3Id, statusId, promotionId, price1, price2, stock1, stock2, goodsName, pageNum,page.getCurrSize());
				if(list!=null){
					model.addAttribute("list",list);
					model.addAttribute("brandId",brandId);
					model.addAttribute("category1Id",category1Id);
					model.addAttribute("category3Id",category3Id);
					model.addAttribute("category2Id",category2Id);
					model.addAttribute("statusId",statusId);
					model.addAttribute("promotionId",promotionId);
					model.addAttribute("price1",price1);
					model.addAttribute("price2",price2);
					model.addAttribute("stock1",stock1);
					model.addAttribute("stock2",stock2);
					model.addAttribute("listBrand",listBrand);
					model.addAttribute("listStatus",listStatus);
					model.addAttribute("listPromotion",listPromotion);
					model.addAttribute("category1IdNameList1",category1IdNameList1);
					model.addAttribute("category1IdNameList2",category1IdNameList2);
					model.addAttribute("category1IdNameList3",category1IdNameList3);
					model.addAttribute("page",page);
					return "jsp/backend/admin/goods";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
   }  	   
	   
			@ResponseBody
		    @RequestMapping("/category1Id")
		    public List<TbItemCat> category1Id(@RequestParam(value="category1Id",required=false) int category1Id,Model model){
		    	try {
					List<TbItemCat> list2 = iTbItemCatService.SelectTypeId2(category1Id);
					if(list2!=null){
						model.addAttribute("list2",list2);
						return list2;
					}
		    		
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
		    	
		    }
			
			@ResponseBody
		    @RequestMapping("/category2Id")
		    public List<TbItemCat> category2Id(@RequestParam(value="category2Id",required=false) int category2Id,Model model){
		    	try {
					List<TbItemCat> list3 = iTbItemCatService.SelectTypeId3(category2Id);
					if(list3!=null){
						model.addAttribute("list3",list3);
						return list3;
					}
		    		
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
		    	
		    }
			
			@RequestMapping("/selectAdd")
			public String selectAdd(Model model){
				try {
					List<TbBrand> listBrand = iTbBrandService.selectBrand();
					
					List<TbGoodsStatus> listStatus = iTbGoodsStatusService.selectStatus();
					
					List<TbSeller> listSeller = iTbSellerService.selectSeller();
					
					List<TbGoodsPromotion> listPromotion = iTbGoodsPromotionService.selectPromotion();
					
					List<TbItemCat> category1IdNameList1 = iTbItemCatService.SelectTypeId1();
				
				    
					model.addAttribute("listBrand",listBrand);
					
					model.addAttribute("listStatus",listStatus);
					
					model.addAttribute("listSeller",listSeller);
					
					model.addAttribute("listPromotion",listPromotion);
					
					model.addAttribute("category1IdNameList1",category1IdNameList1);
				    
					return "jsp/backend/admin/goodsAdd";
				   
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			
			@RequestMapping(value="/goodAdd",method=RequestMethod.POST)
			public String goodAdd(TbGoods tbGoods,@RequestParam(value="sPic_Iamge",required=false) MultipartFile multipartFile,HttpSession session,Model model){
					if(!multipartFile.isEmpty()){
						String name = multipartFile.getOriginalFilename();
						String path = session.getServletContext().getRealPath("/upload");
						String prefix = FilenameUtils.getExtension(name);
						if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") || prefix.equalsIgnoreCase("jpeg")
								|| prefix.equalsIgnoreCase("pneg")) {
						    String num = name.substring(name.lastIndexOf("."), name.length());
						    
						    String fileName = System.currentTimeMillis()+new Random().nextInt(1000000)+"_tbGoods"+num;
						    
						    File file = new File(path,fileName);
						    
						  /*  if(!file.exists()){
						    	file.mkdirs();
						    }
						    */
						    try {
								name = path+File.separator+name;
								multipartFile.transferTo(file);
								tbGoods.setSmallPic(fileName);
								
							} catch (Exception e) {
								e.printStackTrace();
								model.addAttribute("FileError", "上传失败");
								return "redirect:/selectAdd";
							}
						    
						}else{
							model.addAttribute("FileError", "文件只能是图片");
							return "redirect:/selectAdd";
						}
					}
					try {
						boolean falg = iTbGoodsService.add(tbGoods);
						
						if(falg==true){
							model.addAttribute("FileOK","添加成功");
							return "redirect:/selectGoodsAll";  
							
						}else if(falg==false){
							model.addAttribute("FileError","添加失败");
							return "redirect:/selectAdd";  
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				return null;
			}
			
			
			@RequestMapping("/selectUpId")
			public String selectUpId(
					@RequestParam(value="id",required=false) int id,
					Model model){
				try {
					TbGoods goods = iTbGoodsService.selectUpId(id);
					
					int category1Id = goods.getCategory1Id();
					
					int category2Id = goods.getCategory2Id();
					
                    List<TbBrand> listBrand = iTbBrandService.selectBrand();
					
					List<TbGoodsStatus> listStatus = iTbGoodsStatusService.selectStatus();
					
					List<TbSeller> listSeller = iTbSellerService.selectSeller();
					
					List<TbGoodsPromotion> listPromotion = iTbGoodsPromotionService.selectPromotion();
					
					List<TbItemCat> category1IdNameList1 = iTbItemCatService.SelectTypeId1();
					
					List<TbItemCat> category1IdNameList2 = iTbItemCatService.SelectTypeId2(category1Id);
					
					List<TbItemCat> category1IdNameList3 = iTbItemCatService.SelectTypeId3(category2Id);
					
					model.addAttribute("listBrand",listBrand);
					
					model.addAttribute("listStatus",listStatus);
					
					model.addAttribute("listSeller",listSeller);
					
					model.addAttribute("listPromotion",listPromotion);
					
					model.addAttribute("category1IdNameList1",category1IdNameList1);
					
					model.addAttribute("category1IdNameList2",category1IdNameList2);
					
					model.addAttribute("category1IdNameList3",category1IdNameList3);
					
					if(goods!=null){
						model.addAttribute("goods",goods);
						return "jsp/backend/admin/goodsUpdate";
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			
			@RequestMapping(value="/goodUpdate",method=RequestMethod.POST)
			public String goodUpdate(TbGoods tbGoods,
					@RequestParam(value="smallPic",required=false) String smallPic,
					@RequestParam(value="sPic_Iamge",required=false) MultipartFile multipartFile,HttpSession session,Model model){
					if(!multipartFile.isEmpty()){
						String name = multipartFile.getOriginalFilename();
						String path = session.getServletContext().getRealPath("/upload");
						String prefix = FilenameUtils.getExtension(name);
						if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") || prefix.equalsIgnoreCase("jpeg")
								|| prefix.equalsIgnoreCase("pneg")) {
						    String num = name.substring(name.lastIndexOf("."), name.length());
						    
						    String fileName = System.currentTimeMillis()+new Random().nextInt(1000000)+"_tbGoods"+num;
						    
						    File file = new File(path,fileName);
						    
						  /*  if(!file.exists()){
						    	file.mkdirs();
						    }
						    */
						    try {
								name = path+File.separator+name;
								multipartFile.transferTo(file);
								tbGoods.setSmallPic(fileName);
								
							} catch (Exception e) {
								e.printStackTrace();
								model.addAttribute("FileError", "上传失败");
								return "redirect:/selectAdd";
							}
						    
						}else{
							model.addAttribute("FileError", "文件只能是图片");
							return "redirect:/selectAdd";
						}
					}else{
						tbGoods.setSmallPic(smallPic);
					}
					
					try {
						boolean falg = iTbGoodsService.update(tbGoods);
						
						if(falg==true){
							session.setAttribute("FileOK","修改成功");
							return "redirect:/selectGoodsAll";  
							
						}else if(falg==false){
							session.setAttribute("FileError","修改失败");
							return "redirect:/selectAdd";  
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				return null;
			}
			
			@ResponseBody
			@RequestMapping("/deleteGId")
			public String deleteGId(@RequestParam(value="id",required=false) int id){
				try {
					boolean falg = iTbGoodsService.deleteGId(id);
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
			
			@ResponseBody
			@RequestMapping("/SelectStylenumber")
			public String SelectStylenumber(@RequestParam(value="stylenumber",required=false) String stylenumber){
				try {
					boolean falg = iTbGoodsService.SelectStylenumber(stylenumber);
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
			
			
	    @RequestMapping("/shangjia")
	    @ResponseBody
		public String shangjia(@RequestParam(value="id",required=false) int id){
	    	try {
				boolean falg = iTbGoodsService.shangjia(id);
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
	    
	    @RequestMapping("/xiajia")
	    @ResponseBody
		public String xiajia(@RequestParam(value="id",required=false) int id){
	    	try {
				boolean falg = iTbGoodsService.xiajia(id);
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
