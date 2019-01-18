package cn.weishop.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.weishop.demo.TbUser;
import cn.weishop.service.ITbUserService;
import cn.weishop.utils.Result;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
@RequestMapping("/tb-user")
public class TbUserController {
	
	@Autowired
	private ITbUserService iTbUserService;
	
	@RequestMapping("/login")
    public String login(){
    	return "backend/admin/index";
    }
	
	@RequestMapping("tbUserLogin")
	public String tbUserLogin(@RequestParam(value="username",required=false) String username,
			@RequestParam(value="password",required=false) String password,
			Model model,HttpSession session){
		try {
			TbUser tbUser = iTbUserService.tbUserLogin(username, password);
			if (tbUser!=null) {
				session.setAttribute("tbUser", tbUser);
				model.addAttribute("tbUser", tbUser);
				return "backend/admin/index";
			}else{
				model.addAttribute("error", "账号或密码不正确");
				return "backend/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
