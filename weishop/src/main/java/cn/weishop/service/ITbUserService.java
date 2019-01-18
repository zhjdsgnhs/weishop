package cn.weishop.service;

import cn.weishop.demo.TbUser;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbUserService{
	TbUser login(String username,String password);
}
