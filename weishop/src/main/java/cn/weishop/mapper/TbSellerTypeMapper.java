package cn.weishop.mapper;

import cn.weishop.demo.TbSellerType;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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

public interface TbSellerTypeMapper extends BaseMapper<TbSellerType>{
	
	@Select("select s_typeid AS sTypeid,s_type AS sType,s_percent AS sPercent,status AS status from tb_seller_type")
	public List<TbSellerType> selectSeller();
	
	@Select("select * from tb_seller_type where s_typeid=#{sTypeid}")
	public TbSellerType selectSellerId(@Param("sTypeid")int sTypeid);
	
	@Update("Update tb_seller_type set status=1 where s_typeid=#{sTypeid}")
	public int sellerQi(@Param("sTypeid")int sTypeid);
	
	@Update("Update tb_seller_type set status=0 where s_typeid=#{sTypeid}")
	public int sellerJin(@Param("sTypeid")int sTypeid);
	
	@Update("<script>UPDATE tb_seller_type SET s_type=#{sType},"
    +"s_percent=#{sPercent}"
    +" WHERE s_typeid=#{sTypeid}</script>")
	public int updateSellerType(TbSellerType tbSellerType);

}
//=======
//package cn.weishop.mapper;
//
//import cn.weishop.demo.TbSellerType;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//
///**
// * <p>
// *  Mapper 接口
// * </p>
// *
// * @author jeddden
// * @since 2018-12-28
// */
//
//public interface TbSellerTypeMapper extends BaseMapper<TbSellerType>{
//	
//	@Select("select s_typeid AS sTypeid,s_type AS sType,s_percent AS sPercent,status AS status from tb_seller_type")
//	public List<TbSellerType> selectSeller();
//	
//	@Select("select * from tb_seller_type where s_typeid=#{sTypeid}")
//	public TbSellerType selectSellerId(@Param("sTypeid")int sTypeid);
//	
//	public int updateSellerType(TbSellerType tbSellerType);
//
//}
//>>>>>>> branch 'master' of https://github.com/zhjdsgnhs/weishop.git
