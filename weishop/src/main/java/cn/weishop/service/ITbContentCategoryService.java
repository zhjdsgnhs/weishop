package cn.weishop.service;

import cn.weishop.demo.TbContentCategory;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 内容分类 服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbContentCategoryService extends IService<TbContentCategory> {
	List<TbContentCategory> selectCategory();

}
