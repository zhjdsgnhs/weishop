package cn.weishop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weishop.demo.TbUser;
import cn.weishop.mapper.TbUserMapper;
import cn.weishop.service.ITbUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbUserServiceImpl implements ITbUserService {
	@Autowired
    private TbUserMapper tbUserMapper;
	@Override
	public TbUser login(String username, String password) {
		try {
			TbUser tbUser = tbUserMapper.login(username, password);
			if(tbUser!=null){
				return tbUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
