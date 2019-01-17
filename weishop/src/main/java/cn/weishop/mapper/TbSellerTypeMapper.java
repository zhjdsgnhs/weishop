package cn.weishop.mapper;

import cn.weishop.demo.TbSellerType;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
	
	public int updateSellerType(TbSellerType tbSellerType);

}
