package cn.weishop.service.impl;

import cn.weishop.demo.TbUser;
import cn.weishop.mapper.TbUserMapper;
import cn.weishop.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
