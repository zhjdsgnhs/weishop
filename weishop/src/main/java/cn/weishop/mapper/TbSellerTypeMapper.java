package cn.weishop.mapper;

import cn.weishop.demo.TbSellerType;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Mapper
public interface TbSellerTypeMapper extends BaseMapper<TbSellerType>{
	public List<TbSellerType> selectSeller();
	public int updateSellerType(TbSellerType tbSellerType);

}
