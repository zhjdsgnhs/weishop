package cn.weishop.service.impl;

import cn.weishop.demo.TbTheme;
import cn.weishop.mapper.TbThemeMapper;
import cn.weishop.service.ITbThemeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbThemeServiceImpl extends ServiceImpl<TbThemeMapper, TbTheme> implements ITbThemeService {
	@Autowired
	private TbThemeMapper tbThemeMapper;

	public List<TbTheme> selectTbTheme(String themename, int currNo, int currSize) {
		return tbThemeMapper.selectTbTheme(themename, currNo, currSize);
	}

	public int count(String themename) {
		return tbThemeMapper.count(themename);
	}

	public int insertTbTheme(TbTheme TbTheme) {
		return tbThemeMapper.insertTbTheme(TbTheme);
	}

	public TbTheme selTbThemeId(Integer id) {
		return tbThemeMapper.selTbThemeId(id);
	}

	public int updTbTheme(TbTheme TbTheme) {
		return tbThemeMapper.updTbTheme(TbTheme);
	}

	public boolean delTbTheme(Integer id) {
		try {
			int count =  tbThemeMapper.delTbTheme(id);
			if (count>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
