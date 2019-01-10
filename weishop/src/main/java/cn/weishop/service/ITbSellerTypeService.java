package cn.weishop.service;

import cn.weishop.demo.TbSellerType;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbSellerTypeService {
	public List<TbSellerType> selectSeller();
	public boolean updateSellerType(TbSellerType tbSellerType);
	public TbSellerType selectSellerId(int sTypeid);

}
