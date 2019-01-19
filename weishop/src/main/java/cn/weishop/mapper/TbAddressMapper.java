package cn.weishop.mapper;

import cn.weishop.demo.TbAddress;

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
public interface TbAddressMapper{
	
	@Select("select * from tb_address")
	public List<TbAddress> selectAddress();

}
