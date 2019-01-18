package cn.weishop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.weishop.demo.TbUser;
import cn.weishop.service.ITbUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
/*@RequestMapping("/tb-user")*/
public class TbUserController {
	@Autowired
    private ITbUserService ITbUserService;
	
	@RequestMapping("/Dlogin")
    public String bb(){
    	return "jsp2/login";
    }
	
	
	
	
	@RequestMapping("/logins")
	public String logins(@RequestParam(value="username",required=false)String username,@RequestParam(value="password",required=false)String password,Model model){
		try {
			TbUser tbUser = ITbUserService.login(username, password);
			if(tbUser!=null){
				if(tbUser.getUsername()==username && tbUser.getPassword()==password){
					return "qiantai/index.html";
				}else{
					model.addAttribute("用户名密码不正确","falgError");
					return "seller/shoplogin";
					
				}
				
			}else{
				return "seller/shoplogin";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
	
}
