package cn.weishop.service.impl;

import cn.weishop.demo.TbOrder;
import cn.weishop.demo.TbOrderItem;
import cn.weishop.demo.TbSellerType;
import cn.weishop.mapper.TbOrderMapper;
import cn.weishop.mapper.TbSellerTypeMapper;
import cn.weishop.service.ITbOrderService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder> implements ITbOrderService {


	 @Autowired
	 TbOrderMapper TbOrderMapper;
	
	public List selectorder(int num, int pagesize, QueryWrapper<TbOrder> wrapper) {
		// TODO Auto-generated method stub
		return TbOrderMapper.selectorder(num,pagesize,wrapper);
	}

	public int countorder(QueryWrapper<TbOrder> wrapper) {
		// TODO Auto-generated method stub
		return TbOrderMapper.countorder(wrapper);
	}

	public int updateStatus(int status, int id) {
		// TODO Auto-generated method stub
		return TbOrderMapper.updateStatus(status,id);
	}

	public List<TbOrder> chakan(Integer userid) {
		// TODO Auto-generated method stub
		return TbOrderMapper.chakan(userid);
	}

	public List<TbOrderItem> OrderSelect(Long orderId) {
		// TODO Auto-generated method stub
		return TbOrderMapper.OrderSelect(orderId);
	}

	public List<TbOrder> selectorderd(QueryWrapper<TbOrder> wrapper) {
		// TODO Auto-generated method stub
		return TbOrderMapper.selectorderd(wrapper);
	}


	
	@Override
	public List<TbOrder> selectUserOrder(Integer userId) {
		try {
			return TbOrderMapper.selectUserOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectDaiOrder(Integer userId) {
		try {
			return TbOrderMapper.selectDaiOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectDaiFaOrder(Integer userId) {
		try {
			return TbOrderMapper.selectDaiFaOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectWanOrder(Integer userId) {
		try {
			return TbOrderMapper.selectWanOrder(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TbOrder> selectXQ(Integer orderId) {
		try {
			return TbOrderMapper.selectXQ(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean orderDelete(Integer orderId) {
		try {
			int count=TbOrderMapper.orderDelete(orderId);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
