package cn.weishop.service.impl;

import cn.weishop.demo.TbGoods;
import cn.weishop.mapper.TbGoodsMapper;
import cn.weishop.service.ITbGoodsService;
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
public class TbGoodsServiceImpl implements ITbGoodsService {


	@Autowired
	 private TbGoodsMapper tbGoodsMapper;
	
	public List<TbGoods> selectAll(int brand_id,int category1_id, int category2_id, int category3_id, int status_id,
			int promotion_id, int price1, int price2, int stock1, int stock2, String goods_name, int currNo,
			int currSize) {
		try {
			List<TbGoods> list = tbGoodsMapper.selectAll(brand_id,category1_id, category2_id, category3_id, status_id, promotion_id, price1, price2, stock1, stock2, goods_name, currNo, currSize);
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int count(int brand_id,int category1_id, int category2_id, int category3_id, int status_id, int promotion_id, int price1,
			int price2, int stock1, int stock2, String goods_name) {
		try {
			int count = tbGoodsMapper.count(brand_id,category1_id, category2_id, category3_id, status_id, promotion_id, price1, price2, stock1, stock2, goods_name);
			if(count>0){
				return count;
			}
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


}
