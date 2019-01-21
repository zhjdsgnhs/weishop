package cn.weishop.mapper;

import java.util.List;

import cn.weishop.demo.TbSeller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */

public interface TbSellerMapper{
	@Select("<script>SELECT tbs.*,tba.address AS addressName,tbt.s_type AS typeName FROM tb_seller tbs"
			+ " INNER JOIN tb_address tba ON tbs.address=tba.id"
			+ " INNER JOIN tb_seller_type tbt ON tbs.seller_type=tbt.s_typeid"
			+ " where 1=1 "
			+ "<if test='nickName!=null and nickName!=\"\"'> and tbs.nick_name like CONCAT ('%',#{nickName},'%') </if>"
			+ "<if test='number!=null and number!=0'> and tbs.number BETWEEN #{number} AND #{number1} </if>"
			+ "<if test='price!=null and price!=0'> and tbs.price BETWEEN #{price} AND #{price1} </if>"
			+ "<if test='sellerType!=null and sellerType!=0'> and tbs.seller_type=#{sellerType} </if>"
			+ "<if test='status!=null and status!=-1'> and tbs.status=#{status} </if>"
			+ "limit #{num},#{currSize}</script>")
	public List<TbSeller> selectSellerAll(
			@Param("nickName")String nickName,
			@Param("number")Integer number,
			@Param("number1")Integer number1,
			@Param("price")Integer price,
			@Param("price1")Integer price1,
			@Param("sellerType")Integer sellerType,
			@Param("status")Integer status,
			@Param("num")Integer num,@Param("currSize")Integer currSize);
	
	@Select("<script>SELECT count(1) FROM tb_seller tbs"
			+ " INNER JOIN tb_address tba ON tbs.address=tba.id"
			+ " INNER JOIN tb_seller_type tbt ON tbs.seller_type=tbt.s_typeid"
			+ " where 1=1 "
			+ "<if test='nickName!=null and nickName!=\"\"'> and tbs.nick_name like CONCAT ('%',#{nickName},'%') </if>"
			+ "<if test='number!=null and number!=0' > and tbs.number BETWEEN #{number} AND #{number1} </if>"
			+ "<if test='price!=null and price!=0'> and tbs.price BETWEEN #{price} AND #{price1} </if>"
			+ "<if test='sellerType!=null and sellerType!=0'> and tbs.seller_type=#{sellerType} </if>"
			+ "<if test='status!=null and status!=-1'> and tbs.status=#{status} </if>"
			+ "</script>")
	public int counts(
			@Param("nickName")String nickName,
			@Param("number")Integer number,
			@Param("number1")Integer number1,
			@Param("price")Integer price,
			@Param("price1")Integer price1,
			@Param("sellerType")Integer sellerType,
			@Param("status")Integer status);
	
	@Select("<script>SELECT tbs.*,tba.address AS addressName FROM  tb_seller tbs"
			+ " INNER JOIN tb_address tba ON tbs.address=tba.id"
			+ " where seller_id=#{sellerId}"
			+ "</script>")
	public TbSeller selectId(@Param("sellerId")Integer sellerId);
	
	@Select("<script>SELECT tbs.*,tba.address AS addressName FROM  tb_seller tbs"
			+ " INNER JOIN tb_address tba ON tbs.address=tba.id"
			+ " where seller_id=#{sellerId}"
			+ "</script>")
	public List<TbSeller> selectSellerId(@Param("sellerId")Integer sellerId);
	
	@Update("<script>UPDATE tb_seller SET nick_name=#{nickName},linkman_name=#{linkmanName},"
			+ "linkman_mobile=#{linkmanMobile},address=#{address},logo_pic=#{logoPic}"
			+ " where seller_id=#{sellerId}"
			+ "</script>")
	public int updateSeller(TbSeller tbSeller);
	
	@Select("<script>SELECT tbs.*,tba.address AS addressName FROM  tb_seller tbs"
			+ " INNER JOIN tb_address tba ON tbs.address=tba.id"
			+ " where parent_id=#{sellerId}"
			+ "</script>")
	public List<TbSeller> parentId(@Param("sellerId")Integer sellerId);
	
	@Update("UPDATE tb_seller SET status=1 WHERE seller_id=#{sellerId}")
	public int statusYes(@Param("sellerId")Integer sellerId);
	
	@Update("UPDATE tb_seller SET status=0 WHERE seller_id=#{sellerId}")
	public int statusNo(@Param("sellerId")Integer sellerId);
	
	@Select("<script>SELECT tba.address AS addressName,tbs.nick_name,tbs.linkman_name,tbs.linkman_mobile,tbo.order_id,tboi.title,tbo.status,tbo.create_time,"
			+ "tbo.payment_time,tbo.payment_type,tbo.receiver_area_name,tbo.receiver,tboi.num,tboi.total_fee"
			+ " FROM tb_seller tbs"
			+ " INNER JOIN tb_order tbo ON tbs.seller_id=tbo.seller_id"
			+ " INNER JOIN tb_order_item tboi ON tboi.order_id=tbo.order_id"
			+ " INNER JOIN tb_user tbu ON tbs.user_id=tbu.id"
			+ " INNER JOIN tb_address tba ON tbs.address=tba.id"
			+ " WHERE tbs.seller_id=#{sellerId}"
			+ "</script>")
	List<Map<String, Object>> selectOrder(@Param("sellerId")Integer sellerId);

	@Select("<script>"
			+ "select * from tb_seller"
			+ "</script>")
	List<TbSeller> selectSeller();
}
