package cn.weishop.mapper;

import cn.weishop.demo.TbOrderItem;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbOrderItemMapper{

    @Select("<script>SELECT tboi.pic_path,tboi.price,tboi.order_id,tboi.price,tboi.num,tbg.goods_name AS goodsName"
		+ " FROM tb_order_item tboi INNER JOIN tb_goods tbg ON tbg.id=tboi.goods_id"
		+ " WHERE tboi.order_id=#{orderId}"
		+ "</script>")
	List<TbOrderItem> selectOrderItem(@Param("orderId")Integer orderId);
    
    @Delete("DELETE FROM tb_order_item WHERE order_id=#{orderId}")
	public int orderItemDelete(@Param("orderId")Integer orderId);

}
