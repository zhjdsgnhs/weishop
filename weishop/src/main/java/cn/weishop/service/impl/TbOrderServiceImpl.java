package cn.weishop.service.impl;

import cn.weishop.demo.TbOrder;
import cn.weishop.mapper.TbOrderMapper;
import cn.weishop.service.ITbOrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbOrderServiceImpl implements ITbOrderService {

	@Autowired
	private TbOrderMapper tbOrderMapper;
	
	@Override
	public List<TbOrder> selectUserOrder(Integer userId) {
		try {
			return tbOrderMapper.selectUserOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectDaiOrder(Integer userId) {
		try {
			return tbOrderMapper.selectDaiOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectDaiFaOrder(Integer userId) {
		try {
			return tbOrderMapper.selectDaiFaOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectWanOrder(Integer userId) {
		try {
			return tbOrderMapper.selectWanOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectXQ(Integer orderId) {
		try {
			return tbOrderMapper.selectXQ(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean orderDelete(Integer orderId) {
		try {
			int count=tbOrderMapper.orderDelete(orderId);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
