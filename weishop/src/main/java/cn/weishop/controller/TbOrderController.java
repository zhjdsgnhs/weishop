package cn.weishop.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.weishop.demo.TbOrder;
import cn.weishop.demo.TbOrderItem;
import cn.weishop.demo.TbSellerType;
import cn.weishop.service.ITbOrderService;
import cn.weishop.service.ITbSellerTypeService;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author jeddden
 * @since 2018-12-28
 */
@Controller
@RequestMapping("/order")
public class TbOrderController {
     
	@Autowired
	ITbOrderService ITbOrderService;
	
	@Autowired
	ITbSellerTypeService ITbSellerTypeService;
	
	@RequestMapping("select")
	public String  lala (HttpServletRequest request,
			@RequestParam(value="message",required=false,defaultValue="0") String message,
			@RequestParam(value="status",required=false,defaultValue="0") Integer status,
			@RequestParam(value="shoptype",required=false,defaultValue="0") Integer shoptype,
			@RequestParam(value="create_time",required=false) String create_time,
			@RequestParam(value="endtime",required=false) String endtime,
			@RequestParam(value="payment_time",required=false) String payment_time,
			@RequestParam(value="payend_time",required=false) String payend_time,
			@RequestParam(value="consign_time",required=false) String consign_time,
			@RequestParam(value="conend_time",required=false) String conend_time,
			@RequestParam(value="payment",required=false) Double payment,
			@RequestParam(value="payment2",required=false) Double payment2,
			@RequestParam(value="num",required=false,defaultValue="1") Integer num,
			@RequestParam(value="username",required=false) String  username
		){ 
		 	int no=(num-1)*6;
		
		     QueryWrapper<TbSellerType> wrapper=new QueryWrapper<TbSellerType>();
		     QueryWrapper<TbOrder> queryWrapper =new QueryWrapper<TbOrder>();
		    if( status!=0 && status!=null )queryWrapper.eq("o.status",status);
		    if(shoptype!=null && shoptype!=0)queryWrapper.eq("o.shoptype",shoptype);
		    if(create_time!=null && !create_time.isEmpty() &&  endtime!=null  && !endtime.isEmpty() 
		    		) queryWrapper.between("o.create_time", create_time, endtime);		    
		    if(payment_time!=null && !payment_time.isEmpty() &&  !payend_time.isEmpty() && payend_time!=null
		    		) queryWrapper.between("o.payment_time", payment_time, payend_time);
		    if(consign_time!=null &&!consign_time.isEmpty() &&  !conend_time.isEmpty() && conend_time!=null
		    		) queryWrapper.between("o.consign_time", consign_time, conend_time);
		    if(payment!=null && payment!=0 && payment2!=null && payment2!=0 
		    		) queryWrapper.between("o.payment", payment, payment2);
		    if(username!=null && !username.equals("") ){
		    	queryWrapper.like("u.username", username);
		    }
		
		    		    
		    List<Map<String,Object>>  list = ITbOrderService.selectorder(no,6,queryWrapper);
		       
		    int count  =ITbOrderService.countorder(queryWrapper);
		    List<TbSellerType> type = ITbSellerTypeService.list(wrapper);
		      request.setAttribute("shoplist", type);
		      request.setAttribute("num", num);
			  request.setAttribute("list", list);
			  request.setAttribute("status", status);
			  request.setAttribute("shoptype", shoptype);
			  request.setAttribute("create_time", create_time);
			  request.setAttribute("endtime", endtime);
			  request.setAttribute("payment_time", payment_time);
			  request.setAttribute("pageIndex", payend_time);			 
			  request.setAttribute("pageNum", count%6==0?count/6:count/6+1);
			  request.setAttribute("pageCount", count);
		  	  request.setAttribute("consign_time", consign_time);
			  request.setAttribute("conend_time", conend_time);
			  request.setAttribute("payment", payment);          
			  request.setAttribute("payment2", payment2);
		      request.setAttribute("username", username);
		      request.setAttribute("message", message);
		return "jsp/backend/admin/order";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public  String update(@RequestParam(value="status",required=false,defaultValue="0") Integer status,
			@RequestParam(value="id",required=false,defaultValue="0") Integer id
			){
	      int  count =	 ITbOrderService.updateStatus(status,id);
		 if(count>0){ 
			 
			 return "true";
		 }
		return "false";
	}
	
	@RequestMapping("chakan")
	public String  chakan(HttpServletRequest request  ,
			@RequestParam("userid")Integer userid
			) {
		List<TbOrder> orderList = ITbOrderService.chakan(userid);
		for (int i = 0; i < orderList.size(); i++) {
			TbOrder tbOrder = orderList.get(i);
			List<TbOrderItem> list = ITbOrderService.OrderSelect(tbOrder.getOrderId());
			tbOrder.setTbOrderItemList(list);
		}
		request.setAttribute("username",userid);
		request.setAttribute("list",orderList);
		return "jsp/backend/admin/order_details";
	}
	
	@RequestMapping("daochu")
    public String poiWirte(HttpSession session,
    		@RequestParam(value="status",required=false,defaultValue="0") Integer status,
			@RequestParam(value="shoptype",required=false,defaultValue="0") Integer shoptype,
			@RequestParam(value="create_time",required=false) String create_time,
			@RequestParam(value="endtime",required=false) String endtime,
			@RequestParam(value="payment_time",required=false) String payment_time,
			@RequestParam(value="payend_time",required=false) String payend_time,
			@RequestParam(value="consign_time",required=false) String consign_time,
			@RequestParam(value="conend_time",required=false) String conend_time,
			@RequestParam(value="payment",required=false) Double payment,
			@RequestParam(value="payment2",required=false) Double payment2,
			@RequestParam(value="num",required=false,defaultValue="1") Integer num,
			@RequestParam(value="username",required=false) String  username,
			HttpServletRequest request 
    		){
        HashMap<String, String> map = new HashMap<String, String>();
        try {
        Long id = (long) 1;
        //创建一个EXCEL  
        Workbook wb = new HSSFWorkbook();

        DataFormat format = wb.createDataFormat();
        CellStyle style;

        QueryWrapper<TbOrder> queryWrapper =new QueryWrapper<TbOrder>();
	    if( status!=0 && status!=null )queryWrapper.eq("o.status",status);
	    if(shoptype!=null && shoptype!=0)queryWrapper.eq("o.shoptype",shoptype);
	    if(create_time!=null && !create_time.isEmpty() &&  endtime!=null  && !endtime.isEmpty() 
	    		) queryWrapper.between("o.create_time", create_time, endtime);		    
	    if(payment_time!=null && !payment_time.isEmpty() &&  !payend_time.isEmpty() && payend_time!=null
	    		) queryWrapper.between("o.payment_time", payment_time, payend_time);
	    if(consign_time!=null &&!consign_time.isEmpty() &&  !conend_time.isEmpty() && conend_time!=null
	    		) queryWrapper.between("o.consign_time", consign_time, conend_time);
	    if(payment!=null && payment!=0 && payment2!=null && payment2!=0 
	    		) queryWrapper.between("o.payment", payment, payment2);
	    if(username!=null && !username.equals("") ){
	    	queryWrapper.like("u.username", username);
	    }
	
	    		    
	    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    List<TbOrder>  list = ITbOrderService.selectorderd(queryWrapper);

        
        //创建一个SHEET
        Sheet sheet1 = wb.createSheet("订单详情");
        String[] title = {"订单编号", "用户名", "订单金额", "商铺名", "订单状态", "下单时间", "订单完成时间","收货人","发货时间","商铺类型"};
        int i = 0;
        //创建一行
        Row row = sheet1.createRow((short) 0);
            sheet1.setDefaultColumnWidth(10);
            sheet1.setColumnWidth(0, 35*256);
            sheet1.setColumnWidth(1, 35*256);
            sheet1.setColumnWidth(2, 15*256);
            sheet1.setColumnWidth(4, 35*256);
        //填充标题
        for (String s : title) {
            Cell cell = row.createCell(i);
            cell.setCellValue(s);
            i++;
        }
        for (int c =0;c<list.size();c++){
            TbOrder tborder = list.get(c);
            Row row1 = sheet1.createRow((short) c+1);
            //下面是填充数据
            for (int n=0;n<10;n++){
            switch (n){
                case 0:row1.createCell(n).setCellValue(tborder.getOrderId());
                break;
                case 1:row1.createCell(n).setCellValue(tborder.getUsername());break;
                case 2://创建一个单元格子
                    Cell cell2 = row1.createCell(n);
                    // 填充软件大小(单位:M)
                    cell2.setCellValue(tborder.getPayment());
                    style = wb.createCellStyle();
                    style.setDataFormat(format.getFormat("#.##"));
                    //设定样式
                    cell2.setCellStyle(style);
                    break;
                case 3:
                    // 填充产品数量
                    row1.createCell(n).setCellValue(tborder.getName());break;
                case 4://状态
                	if(tborder.getStatus()=="1"){
                		row1.createCell(n).setCellValue("已发货");break;               		
                	}else if(tborder.getStatus()=="2"){
                		row1.createCell(n).setCellValue("已取消");break;   
                	}else if(tborder.getStatus()=="3"){
                		row1.createCell(n).setCellValue("已完成");break;   
                	}else if(tborder.getStatus()=="4"){
                		row1.createCell(n).setCellValue("已退款");break;   
                	}else if(tborder.getStatus()=="5"){
                		row1.createCell(n).setCellValue("异常");break;   
                	}else if(tborder.getStatus()=="6"){
                		row1.createCell(n).setCellValue("待付款");break;   
                	}else if(tborder.getStatus()=="7"){
                		row1.createCell(n).setCellValue("待发货");break;   
                	}
                	
                
                	          LocalDateTime time = LocalDateTime.now();
                	          String localTime = df.format(tborder.getCreateTime());               	        
                    row1.createCell(n).setCellValue(localTime);break;
                case 6:   //下载次数
                
       	     
       	          String end = df.format(tborder.getEndTime());       
                    row1.createCell(n).setCellValue(end); break;
                case 7: //最新版本号
                    row1.createCell(n).setCellValue(tborder.getReceiver());break;

                case 8: //最新版本号
                	 String con = df.format(tborder.getConsignTime()); 
                    row1.createCell(n).setCellValue(con);break;
                case 9: //最新版本号
                	
                   row1.createCell(n).setCellValue(tborder.getStype());break;
            }


            }

        }


        FileOutputStream fileOut = new FileOutputStream("d:\\订单详情.xls");
        wb.write(fileOut);
        fileOut.close();
        map.put("message","true");
       }catch (Exception e){
           e.printStackTrace();
           map.put("message","false");
           return "redirect:/order/select?message=false";
       }
       
        return "redirect:/order/select?message=true";
    }
	
}
