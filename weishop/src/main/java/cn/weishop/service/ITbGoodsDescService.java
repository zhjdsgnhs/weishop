package cn.weishop.service;

import cn.weishop.demo.TbGoodsDesc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbGoodsDescService {

	TbGoodsDesc selectDescId(Integer goodsId);

}
