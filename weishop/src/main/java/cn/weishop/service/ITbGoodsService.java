package cn.weishop.service;

import cn.weishop.demo.TbGoods;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbGoodsService{
	List<TbGoods> selectAll(int brand_id,int category1_id,
    		int category2_id,
    		int category3_id,
    		int status_id,
    		int promotion_id,
    		int price1,
    		int price2,
    		int stock1,
    		int stock2,
    		String goods_name,
    		int currNo,
    		int currSize
           );
		int count(int brand_id,int category1_id,
			int category2_id,
			int category3_id,
			int status_id,
			int promotion_id,
			int price1,
			int price2,
			int stock1,
			int stock2,
			String goods_name);

}
