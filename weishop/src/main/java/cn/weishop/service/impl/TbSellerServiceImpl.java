package cn.weishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weishop.demo.TbSeller;
import cn.weishop.mapper.TbSellerMapper;
import cn.weishop.service.ITbSellerService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbSellerServiceImpl implements ITbSellerService {
   @Autowired
	private TbSellerMapper tbSellerMapper;
	
   
	public List<TbSeller> selectSeller() {
		try {
			List<TbSeller> list = tbSellerMapper.selectSeller();
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
