package cn.weishop.service.impl;

import cn.weishop.demo.TbSellerType;
import cn.weishop.mapper.TbSellerTypeMapper;
import cn.weishop.service.ITbSellerTypeService;
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
public class TbSellerTypeServiceImpl implements ITbSellerTypeService {
	
	@Autowired
	private TbSellerTypeMapper tbSellerTypeMapper;

	public List<TbSellerType> selectSeller() {
		
			return tbSellerTypeMapper.selectSeller();

		
	}

	public boolean updateSellerType(TbSellerType tbSellerType) {
		try {
			int count=tbSellerTypeMapper.updateSellerType(tbSellerType);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
