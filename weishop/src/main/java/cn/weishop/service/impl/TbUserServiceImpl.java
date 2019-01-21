package cn.weishop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weishop.demo.TbSpecification;
import cn.weishop.demo.TbUser;
import cn.weishop.mapper.TbSpecificationMapper;
import cn.weishop.mapper.TbUserMapper;
import cn.weishop.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

	@Autowired
	private TbUserMapper tbUserMapper;
	
	public TbUser tbUserLogin(String username, String password) {
		return tbUserMapper.tbUserLogin(username, password);
	}

}
