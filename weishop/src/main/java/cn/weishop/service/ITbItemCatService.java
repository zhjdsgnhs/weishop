package cn.weishop.service;

import cn.weishop.demo.TbItemCat;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbItemCatService{
	   List<TbItemCat> selectAllParentId(int currNo,int currSize);
	   int count();
	   boolean add(TbItemCat item);
	   boolean update(TbItemCat item);
	   TbItemCat selectCatId(int id);
	   boolean delete(int id);
	   List<TbItemCat> SelectTypeId1();//查询1分类页面数据
	   List<TbItemCat> SelectTypeId2(int parentId);
	   List<TbItemCat> SelectTypeId3(int parentId);
	   List<TbItemCat> selectIds(int id);
	   List<TbItemCat> SelectAllTypeId2();
}
