package cn.weishop.mapper;

import cn.weishop.demo.TbGoodsDesc;

import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbGoodsDescMapper{

	@Select("<script>"
			+ "select *,g.price as goodprice,g.small_pic AS goodSmallPic from tb_goods_desc d left join tb_goods g on g.id = d.goodsId where d.goodsId=#{goodsId}"
			+ "</script>")
	TbGoodsDesc selectDescId(Integer goodsId);
	
}
