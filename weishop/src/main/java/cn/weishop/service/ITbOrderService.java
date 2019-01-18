package cn.weishop.service;

import cn.weishop.demo.TbOrder;
import cn.weishop.demo.TbOrderItem;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbOrderService extends IService<TbOrder> {
      
	  int updateStatus (int status,int id);
     List selectorder(int num,int pagesize,QueryWrapper<TbOrder> wrapper);
     int countorder(QueryWrapper<TbOrder> wrapper);
     
     List<TbOrder> selectorderd(QueryWrapper<TbOrder> wrapper);
     
     List<TbOrder> chakan(Integer userid);
     
     List<TbOrderItem> OrderSelect(Long orderId);


}
