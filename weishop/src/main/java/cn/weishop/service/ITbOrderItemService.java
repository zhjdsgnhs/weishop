package cn.weishop.service;

import cn.weishop.demo.TbOrderItem;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbOrderItemService{
	List<TbOrderItem> selectOrderItem(Integer orderId);
	//根据订单号删除订单
	public boolean orderItemDelete(Integer orderId);

}
