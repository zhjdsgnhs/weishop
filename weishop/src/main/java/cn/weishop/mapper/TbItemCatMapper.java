package cn.weishop.mapper;

import cn.weishop.demo.TbItemCat;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Select("<script>select * from tb_item_cat limit #{currNo},#{currSize}</script>")
	   List<TbItemCat> selectAllParentId(@Param("currNo") int currNo,@Param("currSize") int currSize);
	   
	@Insert("<script>"
			+ "insert tb_item_cat"
			+ "<trim prefix='(' suffix=')' suffixOverrides=','>"
			+ "<if test='id!=null and id!=\"\" and id=!0 '>id,</if>"
			+ "<if test='parentId!=null and parentId!=0 '>parent_id,</if>"
			+ "<if test='name!=null and name!=\"\" '>name,</if>"
			+ "<if test='typeId!=null and typeId!=0 '>type_id</if>"
			+ "</trim>"
			+ "<trim prefix=' values(' suffix=')' suffixOverrides=','>"
			+ "<if test='id!=null and id!=\"\" and id=!0 '>NULL,</if>"
			+ "<if test='parentId!=null and parentId!=0 '>#{parentId},</if>"
			+ "<if test='name!=null and name!=\"\" '>#{name},</if>"
			+ "<if test='typeId!=null and typeId!=0 '>#{typeId}</if>"
			+ "</trim>"
			+ "</script>")
	   int add(TbItemCat item);
	
	
	@Update("<script>"
			+ "update tb_item_cat set"
			+ " <if test='parentId!=null and parentId!=0 '>parent_id=#{parentId},</if>"
			+ "<if test='name!=null and name!=\"\" '>name=#{name},</if>"
			+ "<if test='typeId!=null and typeId!=0 '>type_id=#{typeId}</if>"
			+ "where id=#{id}"
			+ "</script>")
	   int update(TbItemCat item);
	   
	
	@Select("<script> select * from tb_item_cat where id=#{id}</script>")
	   TbItemCat selectCatId(@Param("id") int id);
	   
	   @Delete("<script>delete from tb_item_cat where id=#{id}</script>")
	   int delete(@Param("id") int id);
	   
	   @Select("<script>select count(1) from tb_item_cat</script>")
	   int count();
	   
	   @Select("<script>select * from tb_item_cat where type_id=1</script>")
	   List<TbItemCat> SelectTypeId1();
	   
	   @Select("<script>select * from tb_item_cat where parent_id=#{parentId}</script>")
	   List<TbItemCat> SelectTypeId2(@Param("parentId") int parentId);
	   
	   @Select("<script>select * from tb_item_cat where parent_id=#{parentId}</script>")
	   List<TbItemCat> SelectTypeId3(@Param("parentId") int parentId);
	   
	   @Select("<script>select * from tb_item_cat where parent_id=#{id}</script>")
	   List<TbItemCat> selectIds(@Param("id") int id);
	   
	   @Select("<script>select * from tb_item_cat where type_id=2</script>")
	   List<TbItemCat> SelectAllTypeId2();
}
