package cn.weishop.mapper;

import cn.weishop.demo.TbGoodsPromotion;
import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbGoodsPromotionMapper{

	
	@Select("<script>select * from tb_goods_promotion</script>")
	List<TbGoodsPromotion> selectPromotion();

}
