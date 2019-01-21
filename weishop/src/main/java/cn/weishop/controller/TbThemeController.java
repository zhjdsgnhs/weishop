package cn.weishop.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weishop.demo.Page;
import cn.weishop.demo.TbTheme;
import cn.weishop.demo.TbUser;
import cn.weishop.service.ITbThemeService;
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
/*@RequestMapping("/tb-theme")*/
public class TbThemeController {
	@Autowired
	private ITbThemeService iTbThemeService;
	
	@RequestMapping("/selectTbTheme")
	public String selectTbTheme(@RequestParam(value="themename",required=false) String themename,
			@RequestParam(value = "num", required = false, defaultValue = "1") Integer num,
			Model model){
		try {
			int count = iTbThemeService.count(themename);
			
			Page page = new Page();
			page.setCountCurrSize(count);
			page.setCurrNo(num);
			
			int pageNum =((page.getCurrNo()-1)*page.getCurrSize());
			
			List<TbTheme> tbThemeList = iTbThemeService.selectTbTheme(themename, pageNum, page.getCurrSize());
			
			model.addAttribute("themename", themename);
			model.addAttribute("page", page);
			model.addAttribute("tbThemeList", tbThemeList);
			
			return "backend/admin/tbThemeList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	@RequestMapping("selTbThemeId")
	@ResponseBody
	public TbTheme selTbThemeId(@RequestParam("themeid") int id){
		try {
			TbTheme tbTheme  = iTbThemeService.selTbThemeId(id);
			if(tbTheme!=null){
				return tbTheme;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
		
	@ResponseBody
	@RequestMapping("delTbTheme")
	public String delTbTheme(@RequestParam("themeid") Integer id){
		try {
			boolean falg = iTbThemeService.delTbTheme(id);
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
	
	
	@PostMapping("/saveAndUpdate")
	@ResponseBody
	public Result saveAndUpdate(
			@RequestParam("themename") String themename,
			@RequestParam("status") String status,
			@RequestParam("picture") String picture,
			@RequestParam("createTime") String createTime,
			@RequestParam("closeTime") String closeTime,
			@RequestParam(value="themeid",required=false,defaultValue="0") int themeid,
			HttpSession session){
		
		System.out.println("进入新增、修改方法——————————————————————————————————————————");
		
		SimpleDateFormat sime=new SimpleDateFormat("yyyy-MM-dd");
		
		TbTheme tbTheme=new TbTheme();
		tbTheme.setStatus(status);
		tbTheme.setThemename(themename);
		tbTheme.setPicture(picture);
		try {
			tbTheme.setCreateTime(sime.parse(createTime));
			tbTheme.setCloseTime(sime.parse(closeTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		//获取到当前session中的用户id
		TbUser tbUser = (TbUser) session.getAttribute("tbUser");
		System.out.println(tbUser.getId());
		tbTheme.setUserid(tbUser.getId());
		tbTheme.setPerson(tbUser.getName());
		
		//判断是否是新增还是修改
		
		if(themeid!=0){
			tbTheme.setThemeid(themeid);
			int count = iTbThemeService.updTbTheme(tbTheme);
			if (count>0) {
				return new Result(true,0,"修改成功");
			} else {
				return new Result(false,-1,"修改失败");
			}
		}else{
			int count = iTbThemeService.insertTbTheme(tbTheme);
			if (count>0) {
				return new Result(true,0,"新增成功");
			} else {
				return new Result(true,201,"新增失败");
			}
		}
	}
}
