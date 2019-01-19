package cn.weishop.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.weishop.demo.Page;
import cn.weishop.demo.SellerAndAddress;
import cn.weishop.demo.TbAddress;
import cn.weishop.demo.TbSeller;
import cn.weishop.demo.TbSellerType;
import cn.weishop.service.ITbAddressService;
import cn.weishop.service.ITbSellerService;
import cn.weishop.service.ITbSellerTypeService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
/*@RestController
@RequestMapping("/tb-seller")*/
@Controller
public class TbSellerController {
	@Autowired
	private ITbAddressService iTbAddressService;
	
	@Autowired
	private ITbSellerService iTbSellerService;
	
	@Autowired
	private ITbSellerTypeService iTbSellerTypeService;
	
	@RequestMapping("/selectSellerAll")
	public String selectSellerAll(
			@RequestParam(value="nickName",required=false)String nickName,
			@RequestParam(value="number",required=false)Integer number,
			@RequestParam(value="number1",required=false)Integer number1,
			@RequestParam(value="price",required=false)Integer price,
			@RequestParam(value="price1",required=false)Integer price1,
			@RequestParam(value="sellerType",required=false)Integer sellerType,
			@RequestParam(value="status",required=false)Integer status,
			@RequestParam(value="pageIndex",required=false,defaultValue="1") int pageIndex,
			Model model){
		try {
			//查询地址
			List<TbAddress> addressList=iTbAddressService.selectAddress();
			//查询店铺类型
			List<TbSellerType> serTypeList=iTbSellerTypeService.selectSeller();
			int counts=iTbSellerService.counts(nickName, number, number1, price, price1, sellerType, status);
			Page page=new Page();
			page.setCountCurrSize(counts);
			page.setCurrNo(pageIndex);
			int num=(page.getCurrNo()-1)*page.getCurrSize();
			List<TbSeller> sellerList=iTbSellerService.selectSellerAll(nickName, number, number1, price, price1, sellerType, status, num, page.getCurrSize());
			model.addAttribute("counts", counts);
			model.addAttribute("page", page);
			model.addAttribute("addressList", addressList);
			model.addAttribute("serTypeList", serTypeList);
			model.addAttribute("sellerList", sellerList);
			model.addAttribute("nickName", nickName);
			model.addAttribute("number", number);
			model.addAttribute("number1", number1);
			model.addAttribute("price", price);
			model.addAttribute("price1", price1);
			model.addAttribute("sellerType", sellerType);
			model.addAttribute("status", status);
	
			return "jsp/backend/admin/seller_1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("/selectId")
	@ResponseBody
	public SellerAndAddress selectId(@RequestParam(value="sellerId",required=false)Integer sellerId,
			HttpServletResponse response){
		
		TbSeller tbSeller=iTbSellerService.selectId(sellerId);
		
		List<TbAddress> addressList=iTbAddressService.selectAddress();
		
		SellerAndAddress sAddress = new SellerAndAddress();
		
		sAddress.setTbSeller(tbSeller);
		
		sAddress.setAddressList(addressList);
		
		return sAddress;
	}
	
	@RequestMapping("/updateSeller")
	public String updateSeller(TbSeller tbSeller,
			HttpSession session,
			Model model,
			@RequestParam(value="myfile",required=false)String myfile,
			@RequestParam(value="path",required=false)MultipartFile attach){
           if (!attach.isEmpty()) {
			
			String name = attach.getOriginalFilename();//原文件名
			
			
			String paths = session.getServletContext().getRealPath("statics/img");//上传路径位置
			
			
			String prefix = FilenameUtils.getExtension(name);//获取原文件后缀			
			
            int fileSize = 500000;//获取原文件大小,并进行上传大小比较
			
			if(attach.getSize()>fileSize){
				  
				  model.addAttribute("uploadFileError","上传大小不能超过500kB");
				  
				  return "redirect:/selectSellerAll";
				  
			}else if(prefix.equalsIgnoreCase("jpg")|| prefix.equalsIgnoreCase("png") || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){
				
				String fileName = System.currentTimeMillis()+new Random().nextInt(1000000)+"."+prefix;
			    
				File targetFile = new File(paths,fileName);
			    
				try {
					attach.transferTo(targetFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*if(!targetFile.exists()){//判断目录是否存在
			    	targetFile.mkdirs();//创建目录
			    }*/
				name = "statics/img/"+fileName;
				tbSeller.setLogoPic(name);
			}
		}else{
			tbSeller.setLogoPic(myfile);
		}
            try {
            	iTbSellerService.updateSeller(tbSeller);
				model.addAttribute(tbSeller);
				return "redirect:/selectSellerAll";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("uploadFileError","上传失败");
				return "redirect:/selectSellerAll";
			}
	}
	
	@RequestMapping("/selectParent")
	public String selectParent(@RequestParam(value="sellerId",required=false)Integer sellerId,
			Model model){
		try {
			List<TbSeller> tbSellerList=iTbSellerService.selectSellerId(sellerId);
			for (int i = 0; i < tbSellerList.size(); i++) {
				TbSeller tbSeller=tbSellerList.get(i);
				List<TbSeller> sList=iTbSellerService.parentId(tbSeller.getSellerId());
				tbSeller.setsList(sList);
			}
			model.addAttribute("tbSellerList", tbSellerList);
			return "jsp/backend/admin/seller_2";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	@RequestMapping("/statusYes")
	@ResponseBody
	public String statusYes(@RequestParam(value="sellerId",required=false)Integer sellerId){
		try {
			boolean falg=iTbSellerService.statusYes(sellerId);
			if(falg==true){
				return "true";
			}else{
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/statusNo")
	@ResponseBody
	public String statusNo(@RequestParam(value="sellerId",required=false)Integer sellerId){
		try {
			boolean falg=iTbSellerService.statusNo(sellerId);
			if(falg==true){
				return "true";
			}else{
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/selectOrder")
	public String selectOrder(@RequestParam(value="sellerId",required=false)Integer sellerId,
			Model model){
		try {
			List orderList= iTbSellerService.selectOrder(sellerId);
			model.addAttribute("orderList", orderList);
			return "jsp/backend/admin/seller_3";
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
			return null;
	}
}
