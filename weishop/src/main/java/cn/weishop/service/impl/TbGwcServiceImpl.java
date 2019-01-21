package cn.weishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weishop.mapper.TbGwcMapper;
import cn.weishop.service.ITbGwcService;

@Service
public class TbGwcServiceImpl implements ITbGwcService{

	@Autowired
	TbGwcMapper TbGwcMapper;
 
	@Override
	public List select(Integer userid) {
		// TODO Auto-generated method stub
		return TbGwcMapper.select(userid);
	}
	

}
