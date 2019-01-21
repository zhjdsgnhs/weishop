package cn.weishop.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.weishop.demo.TbOrder;

import cn.weishop.demo.TbOrderItem;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface TbOrderMapper extends BaseMapper<TbOrder> {
    
	
	
	@Select("<script>"+
		"  SELECT o.order_id,u.username,s.name,o.status,o.create_time,o.end_time,o.consign_time,"
		+ "t.s_type,o.payment,o.receiver ,o.receiver_area_name,o.user_id  FROM  `tb_user` u , `tb_seller` s ,"
		+ " `tb_seller_type` t, `tb_order` o" 
         +"  WHERE  o.user_id=u.id  AND  o.seller_id=s.seller_id  AND  o.shoptype=t.s_typeid    "
		+ "<if test='ew!=null'><if test='ew.sqlSegment!=null'> AND ${ew.sqlSegment} </if> </if>"
		+ "  order by o.order_id   limit ${star},${size}     " 
			+"</script>")	
	List<Map<String,Object>> selectorder(@Param("star")int num,@Param("size") int pagesize,@Param("ew")Wrapper  wrapper);
	
	@Select("<script>"+
			"  SELECT   count(1)  FROM  `tb_user` u , `tb_seller` s ,"
			+ " `tb_seller_type` t, `tb_order` o  "
			+ "  WHERE  o.user_id=u.id  AND  o.seller_id=s.seller_id  AND  o.shoptype=t.s_typeid  " 
	         +"<if test='ew!=null'> <if test='ew.sqlSegment!=null'> and ${ew.sqlSegment} </if> </if>"+
			"</script>")
    int countorder(@Param("ew")Wrapper wrapper);
	
	@Update("Update tb_order Set  status=${status}  Where order_id=${id}  ")
	int updateStatus (@Param("status")int status,@Param("id")int id);
	
	
	@Select("SELECT (SELECT goods_name FROM tb_goods t WHERE t.id=i.goods_id) AS goodsName,"
			+ "goods_id,pic_path,num,total_fee FROM tb_order_item i WHERE order_id = #{orderId}")
	List<TbOrderItem> OrderSelect(@Param("orderId")Long orderId);

	@Select("SELECT receiver,receiver_area_name,order_id,(SELECT SUM(i.total_fee) FROM tb_order_item i WHERE i.order_id=o.order_id) AS cost FROM tb_order o WHERE o.user_id = #{userid}")
	List<TbOrder> chakan(@Param("userid")Integer userid);
	
	@Select("<script>"+
			"  SELECT o.order_id,u.username,s.name,o.status,o.create_time,o.end_time,o.consign_time,"
			+ "t.s_type,o.payment,o.receiver ,o.receiver_area_name,o.user_id  FROM  `tb_user` u , `tb_seller` s ,"
			+ " `tb_seller_type` t, `tb_order` o" 
	         +"  WHERE  o.user_id=u.id  AND  o.seller_id=s.seller_id  AND  o.shoptype=t.s_typeid    "
			+ "<if test='ew!=null'><if test='ew.sqlSegment!=null'> AND ${ew.sqlSegment} </if> </if>"
			+ "  order by o.order_id     " 
				+"</script>")	
	List<TbOrder> selectorderd(@Param("ew")Wrapper  wrapper);

	
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



