package cn.weishop.service.impl;

import cn.weishop.demo.TbOrderItem;
import cn.weishop.mapper.TbOrderItemMapper;
import cn.weishop.service.ITbOrderItemService;
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
public class TbOrderItemServiceImpl implements ITbOrderItemService {
	
	@Autowired
	private TbOrderItemMapper tbOrderItemMapper;

	@Override
	public List<TbOrderItem> selectOrderItem(Integer orderId) {
		try {
			return tbOrderItemMapper.selectOrderItem(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean orderItemDelete(Integer orderId) {
		try {
			int count=tbOrderItemMapper.orderItemDelete(orderId);
			if(count>0){
				return true;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
