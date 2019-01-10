package cn.weishop.mapper;
import cn.weishop.demo.TbUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbUserMapper{
   TbUser login(@Param("username") String username,@Param("password") String password);
   
}
