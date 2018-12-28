package cn.weishop.mapper;

import cn.weishop.demo.TbGoods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbGoodsMapper{
	List<TbGoods> selectAll(
            @Param("brand_id")int brand_id,
            @Param("category1_id")int category1_id,
    		@Param("category2_id")int category2_id,
    		@Param("category3_id")int category3_id,
    		@Param("status_id")int status_id,
    		@Param("promotion_id")int promotion_id,
    		@Param("price1")int price1,
    		@Param("price2")int price2,
    		@Param("stock1")int stock1,
    		@Param("stock2")int stock2,
    		@Param("goods_name")String goods_name,
    		@Param("currNo")int currNo,
    		@Param("currSize")int currSize
           );
int count(@Param("brand_id")int brand_id,@Param("category1_id")int category1_id,
@Param("category2_id")int category2_id,
@Param("category3_id")int category3_id,
@Param("status_id")int status_id,
@Param("promotion_id")int promotion_id,
@Param("price1")int price1,
@Param("price2")int price2,
@Param("stock1")int stock1,
@Param("stock2")int stock2,
@Param("goods_name")String goods_name);
}
