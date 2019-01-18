package cn.weishop.service.impl;

import cn.weishop.demo.TbGoodsPromotion;
import cn.weishop.mapper.TbGoodsPromotionMapper;
import cn.weishop.service.ITbGoodsPromotionService;
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
public class TbGoodsPromotionServiceImpl implements ITbGoodsPromotionService {
    @Autowired
	private TbGoodsPromotionMapper tbGoodsPromotionMapper;
	
	public List<TbGoodsPromotion> selectPromotion() {
		try {
			List<TbGoodsPromotion> list = tbGoodsPromotionMapper.selectPromotion();
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
