package cn.weishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.weishop.demo.TbGoodsStatus;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbGoodsStatusMapper{
	
	@Select("<script>select * from tb_goods_status</script>")
   List<TbGoodsStatus> selectStatus();
}
