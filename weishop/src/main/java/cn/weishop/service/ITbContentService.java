package cn.weishop.service;

import cn.weishop.demo.TbContent;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbContentService extends IService<TbContent> {
	List<TbContent> selectContent(String name,int currNo,int currSize);
	
	int count(String name);
	
	int insertContent(TbContent content);//新增广告
    
	TbContent selContentId(Integer id);//根据Id查询(修改广告)
    
    int updContent(TbContent content);//修改广告
    
    boolean delContent(Integer id);//删除广告

}
