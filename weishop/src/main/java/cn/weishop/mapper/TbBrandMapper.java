package cn.weishop.mapper;

import cn.weishop.demo.TbBrand;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
public interface TbBrandMapper extends BaseMapper<TbBrand> {
       
	
	@Update("Update tb_brand set status=1 where id=#{id}")
	int Qiyong(@Param("id")Integer id);

	@Update("Update tb_brand set status=0 where id=#{id}")
	int Jinyong(@Param("id")Integer id);
	
}
