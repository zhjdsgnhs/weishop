package cn.weishop.service.impl;

import cn.weishop.demo.TbContent;
import cn.weishop.mapper.TbContentMapper;
import cn.weishop.service.ITbContentService;
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
public class TbContentServiceImpl extends ServiceImpl<TbContentMapper, TbContent> implements ITbContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	
	public List<TbContent> selectContent(String name, int currNo, int currSize) {
		return tbContentMapper.selectContent(name, currNo, currSize);
	}

	public int count(String name) {
		return tbContentMapper.count(name);
	}

	public int insertContent(TbContent content) {
		return tbContentMapper.insertContent(content);
	}

	public TbContent selContentId(Integer id) {
		return tbContentMapper.selContentId(id);
	}

	public int updContent(TbContent content) {
		return tbContentMapper.updContent(content);
	}

	public boolean delContent(Integer id) {
		try {
			int count = tbContentMapper.delContent(id);
			if (count>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
