package cn.weishop.mapper;

import cn.weishop.demo.TbContent;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbContentMapper extends BaseMapper<TbContent> {
	@Select("<script>SELECT * from tb_content tbc inner join tb_content_category tbcc "
		+" on tbc.category_id=tbcc.id where 1=1 "
		+ "<if test='name!=null and name!=\"\"'>"
		+"and name like CONCAT ('%',#{name},'%')</if> order by tbc.id "
		+ " limit #{currNo},#{currSize}</script>")
	List<TbContent> selectContent(@Param("name") String name,
			                      @Param("currNo") int currNo,@Param("currSize") int currSize);
	
	
	@Select("<script>SELECT count(1) from tb_content tbc inner join "
			+ " tb_content_category tbcc on tbc.category_id=tbcc.id where 1=1 "
			+ "<if test='name!=null and name!=\"\"'>   "
			+ "and name like CONCAT ('%',#{name},'%')</if> order by tbc.id </script>")
	int count(@Param("name") String name);
	
	
	@Insert("Insert tb_content values(null,#{categoryId},#{title},"
			+ "#{url},#{pic},#{sortOrder},#{name},NOW())")
	int insertContent(TbContent content);//新增广告
    
	
	@Select("<script>SELECT * from tb_content where id=#{id}</script>")
	TbContent selContentId(@Param("id") Integer id);//根据Id查询(修改广告)
    
	
	@Update("Update tb_content set category_id=#{categoryId},title=#{title},"
			+"url=#{url},pic=#{pic},sort_order=#{sortOrder},name=#{name},"
			+"updateTime=NOW() where id=#{id}")
    int updContent(TbContent content);//修改广告
    
	
	@Delete("Delete from tb_content where id=#{id}")
    int delContent(@Param("id") Integer id);//删除广告

}
