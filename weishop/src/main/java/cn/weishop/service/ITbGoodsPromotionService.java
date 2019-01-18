package cn.weishop.service;

import cn.weishop.demo.TbGoodsPromotion;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbGoodsPromotionService{

	List<TbGoodsPromotion> selectPromotion();

}
