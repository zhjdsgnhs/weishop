package cn.weishop.service;

import cn.weishop.demo.TbUser;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbUserService extends IService<TbUser> {
	TbUser tbUserLogin(String username,String password);

}
