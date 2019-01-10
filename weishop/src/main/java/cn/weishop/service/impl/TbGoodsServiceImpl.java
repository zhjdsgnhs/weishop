package cn.weishop.service.impl;

import cn.weishop.demo.TbGoods;
import cn.weishop.mapper.TbGoodsMapper;
import cn.weishop.service.ITbGoodsService;
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
public class TbGoodsServiceImpl implements ITbGoodsService {

	@Autowired
	 private TbGoodsMapper tbGoodsMapper;

	public List<TbGoods> getItemCatBycategory3_id(int itemId) {
		try {
			List<TbGoods> list = tbGoodsMapper.getItemCatBycategory3_id(itemId);
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	public List<TbGoods> selectAll(int brandId, int category1Id, int category2Id, int category3Id, int statusId,
			int promotionId, int price1, int price2, int stock1, int stock2, String goodsName, int currNo,
			int currSize) {
		try {
			List<TbGoods> list = tbGoodsMapper.selectAll(brandId, category1Id, category2Id, category3Id, statusId, promotionId, price1, price2, stock1, stock2, goodsName, currNo, currSize);
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	public int count(int brandId, int category1Id, int category2Id, int category3Id, int statusId, int promotionId,
			int price1, int price2, int stock1, int stock2, String goodsName) {
		try {
			int count = tbGoodsMapper.count(brandId, category1Id, category2Id, category3Id, statusId, promotionId, price1, price2, stock1, stock2, goodsName);
			if(count>0){
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}




	@Override
	public boolean add(TbGoods tbGoods) {
		try {
			int count = tbGoodsMapper.add(tbGoods);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public TbGoods selectUpId(int id) {
		try {
			TbGoods goods = tbGoodsMapper.selectUpId(id);
			if(goods!=null){
				return goods;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public boolean update(TbGoods tbGoods) {
		try {
			int count = tbGoodsMapper.update(tbGoods);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteGId(int id) {
		try {
			int count = tbGoodsMapper.deleteGId(id);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean SelectStylenumber(String stylenumber) {
		try {
			TbGoods goods = tbGoodsMapper.SelectStylenumber(stylenumber);
			if(goods!=null){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public boolean shangjia(int id) {
		try {
			int count = tbGoodsMapper.shangjia(id);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean xiajia(int id) {
		try {
			
			int count = tbGoodsMapper.xiajia(id);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
