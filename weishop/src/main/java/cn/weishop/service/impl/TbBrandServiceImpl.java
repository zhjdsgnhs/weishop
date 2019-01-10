package cn.weishop.service.impl;

import cn.weishop.demo.TbBrand;
import cn.weishop.mapper.TbBrandMapper;
import cn.weishop.service.ITbBrandService;
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
public class TbBrandServiceImpl implements ITbBrandService {
  @Autowired	
  private TbBrandMapper tbBrandMapper;
	
	public List<TbBrand> selectBrand() {
		try {
			List<TbBrand> list = tbBrandMapper.selectBrand();
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
