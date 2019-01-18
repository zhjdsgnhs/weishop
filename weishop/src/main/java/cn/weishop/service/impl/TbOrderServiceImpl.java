package cn.weishop.service.impl;

import cn.weishop.demo.TbOrder;
import cn.weishop.demo.TbOrderItem;
import cn.weishop.mapper.TbOrderMapper;
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

}
