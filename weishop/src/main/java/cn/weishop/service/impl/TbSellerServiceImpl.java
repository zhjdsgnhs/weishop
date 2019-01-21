package cn.weishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weishop.demo.TbSeller;
import cn.weishop.mapper.TbSellerMapper;
import cn.weishop.service.ITbSellerService;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbSellerServiceImpl implements ITbSellerService {

   @Autowired
	private TbSellerMapper tbSellerMapper;
	
   
	public List<TbSeller> selectSeller() {
		try {
			List<TbSeller> list = tbSellerMapper.selectSeller();
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TbSeller> selectSellerAll(String nickName, Integer number, Integer number1, Integer price,
			Integer price1, Integer sellerType, Integer status, Integer num, Integer currSize) {
		try {
			return tbSellerMapper.selectSellerAll(nickName, number, number1, price, price1, sellerType, status, num, currSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int counts(String nickName, Integer number, Integer number1, Integer price, Integer price1,
			Integer sellerType, Integer status) {
		try {
			return tbSellerMapper.counts(nickName, number, number1, price, price1, sellerType, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public TbSeller selectId(Integer sellerId) {
		try {
			return tbSellerMapper.selectId(sellerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateSeller(TbSeller tbSeller) {
		try {
			int count=tbSellerMapper.updateSeller(tbSeller);
			if(count>0){
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<TbSeller> parentId(Integer sellerId) {
		try {
			List<TbSeller> tbSellerList=tbSellerMapper.parentId(sellerId);
			return tbSellerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean statusYes(Integer sellerId) {
		try {
			int count=tbSellerMapper.statusYes(sellerId);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean statusNo(Integer sellerId) {
		try {
			int count=tbSellerMapper.statusNo(sellerId);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TbSeller> selectSellerId(Integer sellerId) {
		try {
			return tbSellerMapper.selectSellerId(sellerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List selectOrder(Integer sellerId) {
		try {
			return tbSellerMapper.selectOrder(sellerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
