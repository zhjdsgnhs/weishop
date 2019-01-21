package cn.weishop.service;

import cn.weishop.demo.TbTheme;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbThemeService extends IService<TbTheme> {
	List<TbTheme> selectTbTheme(String themename,int currNo,int currSize);
	
	int count(String themename);
	
    int insertTbTheme(TbTheme TbTheme);//新增主题
    
    TbTheme selTbThemeId(Integer id);//根据Id查询(修改主题)
    
    int updTbTheme(TbTheme TbTheme);//修改主题
    
    boolean delTbTheme(Integer id);//删除主题

}
