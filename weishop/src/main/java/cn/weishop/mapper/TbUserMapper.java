package cn.weishop.mapper;

import cn.weishop.demo.TbUser;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbUserMapper extends BaseMapper<TbUser> {
	@Select("<script>SELECT * from tb_user where username=#{username} "
			+ "and password=#{password}</script>")
	TbUser tbUserLogin(@Param("username") String username,@Param("password") String password);

}
