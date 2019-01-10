package cn.weishop.mapper;

import cn.weishop.demo.TbItemCat;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品类目 Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbItemCatMapper{
	   List<TbItemCat> selectAllParentId(@Param("currNo") int currNo,@Param("currSize") int currSize);
	   
	   int add(TbItemCat item);
	   int update(TbItemCat item);
	   TbItemCat selectCatId(@Param("id") int id);
	   int delete(@Param("id") int id);
	   int count();
	   List<TbItemCat> SelectTypeId1();
	   List<TbItemCat> SelectTypeId2(@Param("parentId") int parentId);
	   List<TbItemCat> SelectTypeId3(@Param("parentId") int parentId);
	   List<TbItemCat> selectIds(@Param("id") int id);
	   List<TbItemCat> SelectAllTypeId2();
}
