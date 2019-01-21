package cn.weishop.mapper;

import cn.weishop.demo.TbTheme;

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
public interface TbThemeMapper extends BaseMapper<TbTheme> {
	@Select("<script>SELECT * from tb_theme where 1=1 "
			+ "<if test='themename!=null and themename!=\"\" '>"
			+"and themename like CONCAT ('%',#{themename},'%')</if>"
			+ "order by themeid limit #{currNo},#{currSize}</script>")
	List<TbTheme> selectTbTheme(@Param("themename") String themename,
			@Param("currNo") int currNo,@Param("currSize") int currSize);
	
	
	@Select("<script>SELECT count(1) from tb_theme where 1=1 "
			+ "<if test='themename!=null and themename!=\"\" '>"
			+"and themename like CONCAT ('%',#{themename},'%')</if>"
			+ "order by themeid</script>")
	int count(@Param("themename") String themename);
	
	
	@Insert("Insert tb_theme values(null,#{themename},#{picture},#{status},"
       		+"#{createTime},#{closeTime},#{person},NOW(),#{userid})")
    int insertTbTheme(TbTheme TbTheme);//新增主题
    
	
	@Select("<script>SELECT * from tb_theme where themeid=#{id}</script>")
    TbTheme selTbThemeId(@Param("id") Integer id);//根据Id查询(修改主题)
    
	
	@Update("Update tb_theme set themename=#{themename},picture=#{picture},"
			+ "status=#{status},create_time=#{createTime},close_time=#{closeTime},"
			+ "person=#{person},update_time=NOW() where themeid=#{themeid}")
    int updTbTheme(TbTheme TbTheme);//修改主题
    
	
	@Delete("Delete from tb_theme where themeid=#{id}")
    int delTbTheme(@Param("id") Integer id);//删除主题

}
