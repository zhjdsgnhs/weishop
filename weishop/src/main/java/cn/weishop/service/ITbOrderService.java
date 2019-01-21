package cn.weishop.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.weishop.demo.TbOrder;
	
import cn.weishop.demo.TbOrderItem;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ITbOrderService extends IService<TbOrder> {
      
	  int updateStatus (int status,int id);
     List selectorder(int num,int pagesize,QueryWrapper<TbOrder> wrapper);
     int countorder(QueryWrapper<TbOrder> wrapper);
     
     List<TbOrder> selectorderd(QueryWrapper<TbOrder> wrapper);
     
     List<TbOrder> chakan(Integer userid);
     
     List<TbOrderItem> OrderSelect(Long orderId);


	//查询该用户下的所有订单
	List<TbOrder> selectUserOrder(Integer userId);
	//查询该用户下的代付款订单
	List<TbOrder> selectDaiOrder(Integer userId);
	//查询该用户下的代发货订单
	List<TbOrder> selectDaiFaOrder(Integer userId);
	//查询该用户下的已完成订单
	List<TbOrder> selectWanOrder(Integer userId);
	//查询订单详情
	List<TbOrder> selectXQ(Integer orderId);
	//根据订单号删除订单
	public boolean orderDelete(Integer orderId);

}
