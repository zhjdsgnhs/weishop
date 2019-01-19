package cn.weishop.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.weishop.demo.TbOrder;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbOrderService{
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
