package cn.weishop.service;

import cn.weishop.demo.TbBrand;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbBrandService extends IService<TbBrand> {
	   
	 int Qiyong (int id);
	 
	 int Jinyong (int id);
}
