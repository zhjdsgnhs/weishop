package cn.weishop.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.weishop.demo.TbOrder;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbOrderMapper{
	
	@Select("<script>SELECT tbo.payment,tbo.user_id,tbo.order_id,tbo.status"
			+ " FROM tb_order tbo INNER JOIN  tb_user tbu ON tbo.user_id=tbu.id"
			+ " WHERE tbo.user_id=#{userId}"
			+ "</script>")
	List<TbOrder> selectUserOrder(@Param("userId")Integer userId);
	
	@Select("<script>SELECT tbo.payment,tbo.user_id,tbo.order_id,tbo.status"
			+ " FROM tb_order tbo INNER JOIN  tb_user tbu ON tbo.user_id=tbu.id"
			+ " WHERE tbo.user_id=#{userId} AND tbo.status=1"
			+ "</script>")
	List<TbOrder> selectDaiOrder(@Param("userId")Integer userId);
	
	@Select("<script>SELECT tbo.payment,tbo.user_id,tbo.order_id,tbo.status"
			+ " FROM tb_order tbo INNER JOIN  tb_user tbu ON tbo.user_id=tbu.id"
			+ " WHERE tbo.user_id=#{userId} AND tbo.status=3"
			+ "</script>")
	List<TbOrder> selectDaiFaOrder(@Param("userId")Integer userId);
	
	@Select("<script>SELECT tbo.payment,tbo.user_id,tbo.order_id,tbo.status"
			+ " FROM tb_order tbo INNER JOIN  tb_user tbu ON tbo.user_id=tbu.id"
			+ " WHERE tbo.user_id=#{userId} AND tbo.status=5"
			+ "</script>")
	List<TbOrder> selectWanOrder(@Param("userId")Integer userId);
	
	@Select("<script>select tbo.payment,tbu.username,tbu.phone,tbo.receiver_area_name,tba.address AS addressName,"
			+ "tboi.total_fee,tbo.order_id,tbo.create_time,tbo.payment_time"
			+ " FROM tb_seller tbs "
			+ " INNER JOIN tb_order tbo ON tbs.seller_id=tbo.seller_id"
			+ " INNER JOIN tb_order_item tboi ON tboi.order_id=tbo.order_id"
			+ " INNER JOIN tb_user tbu ON tbs.user_id=tbu.id"
			+ " INNER JOIN tb_address tba ON tbs.address=tba.id"
			+ " WHERE tbo.order_id=#{orderId}"
			+ " GROUP BY tbo.order_id"
			+ "</script>")
	List<TbOrder> selectXQ(@Param("orderId")Integer orderId);
	
	@Delete("DELETE FROM tb_order WHERE order_id=#{orderId}")
	public int orderDelete(@Param("orderId")Integer orderId);
	
}
