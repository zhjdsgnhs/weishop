package cn.weishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.weishop.demo.TbSeller;

/**
 * <p>
0 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbSellerMapper{
	@Select("<script>"
			+ "select * from tb_seller"
			+ "</script>")
	List<TbSeller> selectSeller();
}
