package cn.weishop.service;

import cn.weishop.demo.TbGoods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	List<TbGoods> selectAll(int brandId,
				            int category1Id,
				    		int category2Id,
				    		int category3Id,
				    		int statusId,
				    		int promotionId,
				    		int price1,
				    		int price2,
				    		int stock1,
				    		int stock2,
				    		String goodsName,
				    		int currNo,
				    		int currSize
				           );
		  int count(int brandId,
		            int category1Id,
		    		int category2Id,
		    		int category3Id,
		    		int statusId,
		    		int promotionId,
		    		int price1,
		    		int price2,
		    		int stock1,
		    		int stock2,
		    		String goodsName);
		List<TbGoods> getItemCatBycategory3_id(@Param("itemId")int itemId);//删除分类表的时候判断商品表是否有三级分类的数据
		boolean add(TbGoods tbGoods);
		TbGoods selectUpId(int id);
		boolean update(TbGoods tbGoods);
		boolean deleteGId(int id);
		boolean SelectStylenumber(String stylenumber);
		boolean shangjia(int id);
		boolean xiajia(int id);

}
