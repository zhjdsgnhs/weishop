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
	   List<TbItemCat> selectParentId1();
	   List<TbItemCat> selectParentId2(@Param("parentId") int parentId);
	   List<TbItemCat> selectParentId3(@Param("parentId") int parentId);
	   int add(TbItemCat item);
	   int update(TbItemCat item);
	   TbItemCat selectId(@Param("id") int id);
	   int delete(@Param("id") int id);
	   int count();
	   
	   List<TbItemCat> SelectTypeId1(@Param("type_id") int type_id);
}
