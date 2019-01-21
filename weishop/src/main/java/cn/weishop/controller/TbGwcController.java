package cn.weishop.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.weishop.service.ITbGwcService;


@Controller
@RequestMapping("/gwc")
public class TbGwcController {
 
	@Autowired
	ITbGwcService ITbGwcService;
	
	
   @RequestMapping("select")
   public String select (HttpSession session,HttpServletRequest request ,
		   @RequestParam(value="username",required=false ) Integer  userid
		   ){
	      String num=null;
	       Double num1=null;
	      Double s=null;
	      BigDecimal price =new BigDecimal("10");
	   List<Map<String, Object>> list=   ITbGwcService.select(userid);
	   for (Map<String,Object> map :  list) {
		   
    	   Iterator<String> it=  map.keySet().iterator();
    	   while(it.hasNext()){
                String key = it.next();
              if(key.equals("price") ){
            	  price=(BigDecimal) map.get(key);
            	 s =price.doubleValue();
              }if(key.equals("num")){
            	  num= (map.get(key)).toString();
            	 
              }
              if(num!=null && s!=null){
            	num1=  Double.valueOf(num);
              System.out.println(num1*s);
              }
      }
	   }
	     request.setAttribute("list",list);
	   return "/jsp2/cart";
   }
}
