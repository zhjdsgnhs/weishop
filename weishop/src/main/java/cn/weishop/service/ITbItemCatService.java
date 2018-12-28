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
	   List<TbItemCat> selectParentId1();
	   List<TbItemCat> selectParentId2(@Param("parentId") int parentId);
	   List<TbItemCat> selectParentId3(@Param("parentId") int parentId);
	   boolean add(TbItemCat item);
	   boolean update(TbItemCat item);
	   TbItemCat selectId(@Param("id") int id);
	   boolean delete(@Param("id") int id);
	   int count();
	   List<TbItemCat> SelectTypeId1(int type_id);//查询分类页面数据
}
