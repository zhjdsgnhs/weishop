package cn.weishop.service.impl;

import cn.weishop.demo.TbAddress;
import cn.weishop.mapper.TbAddressMapper;
import cn.weishop.service.ITbAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbAddressServiceImpl implements ITbAddressService {
	@Autowired
	private TbAddressMapper tbAddressMapper;

	@Override
	public List<TbAddress> selectAddress() {
		return tbAddressMapper.selectAddress();
	}

}
