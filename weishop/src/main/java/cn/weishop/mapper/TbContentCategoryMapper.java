package cn.weishop.mapper;

import cn.weishop.demo.TbContentCategory;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 内容分类 Mapper 接口
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface TbContentCategoryMapper extends BaseMapper<TbContentCategory> {
	@Select("<script>SELECT * from tb_content_category</script>")
	List<TbContentCategory> selectCategory();

}
