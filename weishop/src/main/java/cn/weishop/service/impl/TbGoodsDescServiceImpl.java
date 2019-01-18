package cn.weishop.service.impl;

import cn.weishop.demo.TbGoodsDesc;
import cn.weishop.mapper.TbGoodsDescMapper;
import cn.weishop.service.ITbGoodsDescService;
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
public class TbGoodsDescServiceImpl implements ITbGoodsDescService {
    @Autowired
	private TbGoodsDescMapper tbGoodsDescMapper;
	@Override
	public TbGoodsDesc selectDescId(Integer goodsId) {
		try {
			TbGoodsDesc desc = tbGoodsDescMapper.selectDescId(goodsId);
			if(desc!=null){
				return desc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
