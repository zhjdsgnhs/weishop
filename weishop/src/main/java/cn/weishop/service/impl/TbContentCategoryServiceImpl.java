package cn.weishop.service.impl;

import cn.weishop.demo.TbContentCategory;
import cn.weishop.mapper.TbContentCategoryMapper;
import cn.weishop.service.ITbContentCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbContentCategoryServiceImpl extends ServiceImpl<TbContentCategoryMapper, TbContentCategory> implements ITbContentCategoryService {
	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	
	public List<TbContentCategory> selectCategory() {
		return tbContentCategoryMapper.selectCategory();
	}

}
