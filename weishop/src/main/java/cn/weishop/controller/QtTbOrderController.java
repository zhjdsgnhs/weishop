package cn.weishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weishop.demo.TbOrder;
import cn.weishop.demo.TbOrderItem;
import cn.weishop.service.ITbOrderItemService;
import cn.weishop.service.ITbOrderService;
@Controller
public class QtTbOrderController {
	@Autowired
	private ITbOrderService iTbOrderService;
	
	@Autowired
	private ITbOrderItemService iTbOrderItemService;
	
	@RequestMapping("/selectUserOrder")
	public String selectUserOrder(@RequestParam(value="userId",required=false)Integer userId,
			Model model){
		try {
			List<TbOrder> order=iTbOrderService.selectUserOrder(userId);
			for (int i = 0; i < order.size(); i++) {
				TbOrder tbOrder=order.get(i);
				List<TbOrderItem> orderItemList=iTbOrderItemService.selectOrderItem(tbOrder.getOrderId());
				tbOrder.setOrderItemList(orderItemList);
			}
			model.addAttribute("order", order);
			return "jsp2/order_list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/selectDaiOrder")
	public String selectDaiOrder(@RequestParam(value="userId",required=false)Integer userId,
			Model model){
		try {
			List<TbOrder> orderDai=iTbOrderService.selectDaiOrder(userId);
			for (int i = 0; i < orderDai.size(); i++) {
				TbOrder tbOrder=orderDai.get(i);
				List<TbOrderItem> orderItemList=iTbOrderItemService.selectOrderItem(tbOrder.getOrderId());
				tbOrder.setOrderItemList(orderItemList);
			}
			model.addAttribute("orderDai", orderDai);
			return "jsp2/order_list2";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/selectDaiFaOrder")
	public String selectDaiFaOrder(@RequestParam(value="userId",required=false)Integer userId,
			Model model){
		try {
			List<TbOrder> orderDaiF=iTbOrderService.selectDaiFaOrder(userId);
			for (int i = 0; i < orderDaiF.size(); i++) {
				TbOrder tbOrder=orderDaiF.get(i);
				List<TbOrderItem> orderItemList=iTbOrderItemService.selectOrderItem(tbOrder.getOrderId());
				tbOrder.setOrderItemList(orderItemList);
			}
			model.addAttribute("orderDaiF", orderDaiF);
			return "jsp2/order_list3";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/selectWanOrder")
	public String selectWanOrder(@RequestParam(value="userId",required=false)Integer userId,
			Model model){
		try {
			List<TbOrder> orderWan=iTbOrderService.selectWanOrder(userId);
			for (int i = 0; i < orderWan.size(); i++) {
				TbOrder tbOrder=orderWan.get(i);
				List<TbOrderItem> orderItemList=iTbOrderItemService.selectOrderItem(tbOrder.getOrderId());
				tbOrder.setOrderItemList(orderItemList);
			}
			model.addAttribute("orderWan", orderWan);
			return "jsp2/order_list4";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/selectXQ")
	public String selectXQ(@RequestParam(value="orderId",required=false)Integer orderId,
			Model model){
		try {
			List<TbOrder> orderXQ=iTbOrderService.selectXQ(orderId);
			for (int i = 0; i < orderXQ.size(); i++) {
				TbOrder tbOrder=orderXQ.get(i);
				List<TbOrderItem> orderItemList=iTbOrderItemService.selectOrderItem(tbOrder.getOrderId());
				tbOrder.setOrderItemList(orderItemList);
			}
			model.addAttribute("orderXQ", orderXQ);
			return "jsp2/orderXQ";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/orderDelete")
	@ResponseBody
	public String orderDelete(@RequestParam(value="orderId",required=false)Integer orderId){
		try {
			boolean oi=iTbOrderItemService.orderItemDelete(orderId);
			boolean falg=iTbOrderService.orderDelete(orderId);
			if(falg==true){
				return "true";
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
