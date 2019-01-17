package cn.weishop.mapper;

import cn.weishop.demo.TbGoods;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	
	@Select("<script>SELECT *,se.name AS sellerName,b.name AS brandName,p.promotion_status as proName,c.name AS category1IdName,c1.name AS category2IdName,c2.name AS category3IdName FROM tb_goods g"
			+ " LEFT JOIN tb_brand b ON b.id=g.brand_id"
			+ " LEFT JOIN tb_goods_promotion p ON p.promotion_id=g.promotion_id"
			+ " LEFT JOIN tb_goods_status s ON s.status_id=g.status_id"
			+ " LEFT JOIN tb_item_cat c ON c.id = g.category1_id"
			+ " LEFT JOIN tb_item_cat c1 ON c1.id = g.category2_id"
			+ " LEFT JOIN tb_item_cat c2 ON c2.id = g.category3_id"
			+ " LEFT JOIN tb_seller se ON se.seller_id = g.seller_id where 1=1"
			+ "<if test='brandId!=null and brandId!=0'> and g.brand_id = #{brandId}</if>"
			+ "<if test='category1Id!=null and category1Id!=0'> and g.category1_id = #{category1Id}</if>"
			+ "<if test='category2Id!=null and category2Id!=0'> and g.category2_id = #{category2Id}</if>"
			+ "<if test='category3Id!=null and category3Id!=0'> and g.category3_id = #{category3Id}</if>"
			+ "<if test='statusId!=null and statusId!=0'> and g.status_id = #{statusId}</if>"
			+ "<if test='promotionId!=null and promotionId!=0'> and g.promotion_id = #{promotionId}</if>"
			+ "<if test='price1!=null and price1!=0 and price2!=null and price2!=0'> and g.price BETWEEN #{price1} AND #{price2}</if>"
			+ "<if test='stock1!=null and stock1!=0 and stock2!=null and stock2!=0'> and g.stock BETWEEN #{stock1} AND #{stock2}</if>"
			+ "<if test='goodsName!=null and goodsName!=\"\" '> and g.goods_name like CONCAT ('%',#{goodsName},'%')</if>"
			+ " and is_delete=0"
			+ " LIMIT #{currNo},#{currSize}"
			+ "</script>"
			)
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
	@Select("<script>SELECT count(1) FROM tb_goods g"
			+ " LEFT JOIN tb_brand b ON b.id=g.brand_id"
			+ " LEFT JOIN tb_goods_promotion p ON p.promotion_id=g.promotion_id"
			+ " LEFT JOIN tb_goods_status s ON s.status_id=g.status_id"
			+ " LEFT JOIN tb_item_cat c ON c.id = g.category1_id"
			+ " LEFT JOIN tb_item_cat c1 ON c1.id = g.category2_id"
			+ " LEFT JOIN tb_item_cat c2 ON c2.id = g.category3_id"
			+ " LEFT JOIN tb_seller se ON se.seller_id = g.seller_id where 1=1"
			+ "<if test='brandId!=null and brandId!=0'> and g.brand_id = #{brandId}</if>"
			+ "<if test='category1Id!=null and category1Id!=0'> and g.category1_id = #{category1Id}</if>"
			+ "<if test='category2Id!=null and category2Id!=0'> and g.category2_id = #{category2Id}</if>"
			+ "<if test='category3Id!=null and category3Id!=0'> and g.category3_id = #{category3Id}</if>"
			+ "<if test='statusId!=null and statusId!=0'> and g.status_id = #{statusId}</if>"
			+ " <if test='promotionId!=null and promotionId!=0'> and g.promotion_id = #{promotionId}</if>"
			+ "<if test='price1!=null and price1!=0 and price2!=null and price2!=0'> and g.price BETWEEN #{price1} AND #{price2}</if>"
			+ "<if test='stock1!=null and stock1!=0 and stock2!=null and stock2!=0'> and g.stock BETWEEN #{stock1} AND #{stock2}</if>"
			+ "<if test='goodsName!=null and goodsName!=\"\" '> and g.goods_name like CONCAT ('%',#{goodsName},'%')</if>"
			+ "and is_delete=0</script>"
			)
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

	
	
	@Select("<script>"
			+ "SELECT *,c.id AS goods FROM tb_goods g"
			+ " LEFT JOIN tb_item_cat c ON g.category3_id=c.id"
			+ " WHERE g.category3_id = #{itemId} "
			+ "</script>")
    List<TbGoods> getItemCatBycategory3_id(@Param("itemId")int itemId);//删除分类表的时候判断商品表是否有三级分类的数据
    
	
	@Insert("<script>"
			+ "INSERT tb_goods"
			+ "<trim prefix='(' suffix=')' suffixOverrides=','>"
			+ "<if test='sellerId!=null and sellerId!=\"0\" '>seller_id,</if>"
			+ "<if test='goodsName!=null and goodsName!=\"\" '>goods_name,</if>"
			+ "<if test='statusId!=null and statusId!=\"0\" '>status_id,</if>"
			+ "<if test='promotionId!=null and promotionId!=\"0\" '>promotion_id,</if>"
			+ "<if test='brandId!=null and brandId!=\"0\" '>brand_id,</if>"
			+ "<if test='category1Id!=null and category1Id!=\"0\" '>category1_id,</if>"
			+ "<if test='category2Id!=null and category2Id!=\"0\" '>category2_id,</if>"
			+ "<if test='category3Id!=null and category3Id!=\"0\" '>category3_id,</if>"
			+ "<if test='smallPic!=null and smallPic!=\"\" '>small_pic,</if>"
			+ "<if test='price!=null and price!=\"\" '>price,</if>"
			+ "is_delete,"
			+ "<if test='stock!=null and stock!=\"\" '>stock,</if>"
			+ "sales,"
			+ "<if test='stylenumber!=null and stylenumber!=\"\" '>stylenumber</if>"
			+ "</trim>"
			+ "<trim prefix='values (' suffix=')' suffixOverrides=','>"
			+ "<if test='sellerId!=null and sellerId!=\"0\" '>#{sellerId},</if>"
			+ " <if test='goodsName!=null and goodsName!=\"\" '>#{goodsName},</if>"
			+ "<if test='statusId!=null and statusId!=\"0\" '>#{statusId},</if>"
			+ "<if test='promotionId!=null and promotionId!=\"0\" '>#{promotionId},</if>"
			+ "<if test='brandId!=null and brandId!=\"0\" '>#{brandId},</if>"
			+ "<if test='category1Id!=null and category1Id!=\"0\" '>#{category1Id},</if>"
			+ "<if test='category2Id!=null and category2Id!=\"0\" '>#{category2Id},</if>"
			+ "<if test='category3Id!=null and category3Id!=\"0\" '>#{category3Id},</if>"
			+ "<if test='smallPic!=null and smallPic!=\"\" '>#{smallPic},</if>"
			+ "<if test='price!=null and price!=\"\" '>#{price},</if>"
			+ "'0',"
			+ " <if test='stock!=null and stock!=\"\" '>#{stock},</if>"
			+ "0,"
			+ "<if test='stylenumber!=null and stylenumber!=\"\" '>#{stylenumber}</if>"
			+ "</trim>"
			+ "</script>")
	int add(TbGoods tbGoods);
	
	@Select("<script>"
			+ "select * from tb_goods where id=#{id}"
			+ "</script>")
    TbGoods selectUpId(@Param("id") int id);
	
	
	@Update("<script>"
    		+ "update tb_goods set"
    		+ "<if test='sellerId!=null and sellerId!=\"0\" '>seller_id=#{sellerId},</if>"
    		+ "<if test='goodsName!=null and goodsName!=\"\" '>goods_name=#{goodsName},</if>"
    		+ "<if test='statusId!=null and statusId!=\"0\" '>status_id=#{statusId},</if>"
    		+ "<if test='promotionId!=null and promotionId!=\"0\" '>promotion_id=#{promotionId},</if>"
    		+ "<if test='brandId!=null and brandId!=\"0\" '>brand_id=#{brandId},</if>"
    		+ "<if test='category1Id!=null and category1Id!=\"0\" '>category1_id=#{category1Id},</if>"
    		+ "<if test='category2Id!=null and category2Id!=\"0\" '>category2_id=#{category2Id},</if>"
    		+ "<if test='category3Id!=null and category3Id!=\"0\" '>category3_id=#{category3Id},</if>"
    		+ "<if test='smallPic!=null and smallPic!=\"\" '>small_pic=#{smallPic},</if>"
    		+ "<if test='price!=null and price!=\"\" '>price=#{price},</if>"
    		+ "<if test='stock!=null and stock!=\"\" '>stock=#{stock},</if>"
    		+ "<if test='stylenumber!=null and stylenumber!=\"\" '>stylenumber=#{stylenumber}</if>"
    		+ "where id=#{id}"
    		+ "</script>")
    int update(TbGoods tbGoods);
    
    @Delete("<script>"
    		+ "update tb_goods set is_delete=1 where id=#{id}"
    		+ "</script>")
	int deleteGId(@Param("id") int id);
    
    @Select("<script>"
			+ "select * from tb_goods where stylenumber=#{stylenumber}"
			+ "</script>")
	TbGoods SelectStylenumber(@Param("stylenumber") String stylenumber);
    
    @Update("<script>"
    		+ "update tb_goods set status_id=4 where id=#{id}"
    		+ "</script>")
	int shangjia(@Param("id") int id);
    
    @Update("<script>"
    		+ "update tb_goods set status_id=2 where id=#{id}"
    		+ "</script>")
	int xiajia(@Param("id") int id);
    
    @Select("<script>SELECT *,se.name AS sellerName,b.name AS brandName,p.promotion_status as proName,c.name AS category1IdName,c1.name AS category2IdName,c2.name AS category3IdName FROM tb_goods g"
			+ " LEFT JOIN tb_brand b ON b.id=g.brand_id"
			+ " LEFT JOIN tb_goods_promotion p ON p.promotion_id=g.promotion_id"
			+ " LEFT JOIN tb_goods_status s ON s.status_id=g.status_id"
			+ " LEFT JOIN tb_item_cat c ON c.id = g.category1_id"
			+ " LEFT JOIN tb_item_cat c1 ON c1.id = g.category2_id"
			+ " LEFT JOIN tb_item_cat c2 ON c2.id = g.category3_id"
			+ " LEFT JOIN tb_seller se ON se.seller_id = g.seller_id where 1=1"
			+ " <if test='brandId!=null and brandId!=0'> and g.brand_id = #{brandId}</if>"
			+ " and category1_id=#{id}"
			+ " LIMIT #{currNo},#{currSize}"
			+ "</script>"
			)
	List<TbGoods> ListselectCatId(@Param("id") int id,@Param("brandId")int brandId,@Param("currNo")int currNo,@Param("currSize")int currSize);
    
    @Select("<script>SELECT count(1) FROM tb_goods g"
			+ " LEFT JOIN tb_brand b ON b.id=g.brand_id"
			+ " LEFT JOIN tb_goods_promotion p ON p.promotion_id=g.promotion_id"
			+ " LEFT JOIN tb_goods_status s ON s.status_id=g.status_id"
			+ " LEFT JOIN tb_item_cat c ON c.id = g.category1_id"
			+ " LEFT JOIN tb_item_cat c1 ON c1.id = g.category2_id"
			+ " LEFT JOIN tb_item_cat c2 ON c2.id = g.category3_id"
			+ " LEFT JOIN tb_seller se ON se.seller_id = g.seller_id where 1=1"
			+ "<if test='brandId!=null and brandId!=0'> and g.brand_id = #{brandId}</if>"
			+ " and category1_id=#{id}</script>"
			)
	int QTcount(@Param("id") int id,@Param("brandId")int brandId);
    
    
    @Select("<script> select * from tb_goods order by id desc LIMIT 0,4</script>")
	List<TbGoods> selectlistXP();
    @Select("<script> SELECT * FROM tb_goods WHERE promotion_id=1 LIMIT 0,4</script>")
    List<TbGoods> selectZhekou();
    @Select("<script> SELECT * FROM tb_goods ORDER BY sales DESC LIMIT 0,4</script>")
	List<TbGoods> selectReiXiao();
    
    
}




