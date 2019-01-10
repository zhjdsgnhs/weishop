package cn.weishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weishop.demo.TbGoodsStatus;
import cn.weishop.mapper.TbGoodsStatusMapper;
import cn.weishop.service.ITbGoodsStatusService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbGoodsStatusServiceImpl implements ITbGoodsStatusService {
   @Autowired
	private TbGoodsStatusMapper tbGoodsStatusMapper;
	
	public List<TbGoodsStatus> selectStatus() {
		try {
			List<TbGoodsStatus> list = tbGoodsStatusMapper.selectStatus();
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
