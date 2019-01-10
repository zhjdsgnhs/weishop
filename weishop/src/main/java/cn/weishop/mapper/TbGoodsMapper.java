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
            @Param("brandId")int brandId,
            @Param("category1Id")int category1Id,
    		@Param("category2Id")int category2Id,
    		@Param("category3Id")int category3Id,
    		@Param("statusId")int statusId,
    		@Param("promotionId")int promotionId,
    		@Param("price1")int price1,
    		@Param("price2")int price2,
    		@Param("stock1")int stock1,
    		@Param("stock2")int stock2,
    		@Param("goodsName")String goodsName,
    		@Param("currNo")int currNo,
    		@Param("currSize")int currSize
           );
int count(@Param("brandId")int brandId,
        @Param("category1Id")int category1Id,
		@Param("category2Id")int category2Id,
		@Param("category3Id")int category3Id,
		@Param("statusId")int statusId,
		@Param("promotionId")int promotionId,
		@Param("price1")int price1,
		@Param("price2")int price2,
		@Param("stock1")int stock1,
		@Param("stock2")int stock2,
		@Param("goodsName")String goodsName);

    List<TbGoods> getItemCatBycategory3_id(@Param("itemId")int itemId);//删除分类表的时候判断商品表是否有三级分类的数据
    int add(TbGoods tbGoods);
    TbGoods selectUpId(@Param("id") int id);
    int update(TbGoods tbGoods);
	int deleteGId(@Param("id") int id);
	TbGoods SelectStylenumber(@Param("stylenumber") String stylenumber);
	int shangjia(@Param("id") int id);
	int xiajia(@Param("id") int id);
}




