package cn.weishop.service;
import cn.weishop.demo.TbSeller;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbSellerService{
	//查询所有店铺
	public List<TbSeller> selectSellerAll(
			String nickName,
			Integer number,
			Integer number1,
			Integer price,
			Integer price1,
			Integer sellerType,
			Integer status,
			Integer num,Integer currSize);
	
	//查询总数据
	public int counts(
			String nickName,
			Integer number,
			Integer number1,
			Integer price,
			Integer price1,
			Integer sellerType,
			Integer status);
	
	//根据id查询
	public TbSeller selectId(Integer sellerId);
	
	//修改商铺
	public int updateSeller(TbSeller tbSeller);
	
	//根据id查询子公司
	public List<TbSeller> parentId(Integer sellerId);
	
	//改变商铺状态为审核通过
    public boolean statusYes(Integer sellerId);
	
    //改变商铺状态为审核未通过
	public boolean statusNo(Integer sellerId); 
	
	//根据id查询
	public List<TbSeller> selectSellerId(Integer sellerId);
	
	//根据id查询商铺对应的订单
	List selectOrder(Integer sellerId);

	List<TbSeller> selectSeller();
}
