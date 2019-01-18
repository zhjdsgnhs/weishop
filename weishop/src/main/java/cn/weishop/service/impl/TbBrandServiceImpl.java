package cn.weishop.service.impl;

import cn.weishop.demo.TbBrand;
import cn.weishop.mapper.TbBrandMapper;
import cn.weishop.service.ITbBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



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
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements ITbBrandService {
 
	 @Autowired
	TbBrandMapper TbBrandMapper;
	
	public int Qiyong(int id) {
		
		return TbBrandMapper.Qiyong(id);
	}

	public int Jinyong(int id) {
		
		return TbBrandMapper.Jinyong(id);
	}

}
