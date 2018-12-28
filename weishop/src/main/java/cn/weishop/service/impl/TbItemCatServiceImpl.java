package cn.weishop.service.impl;

import cn.weishop.demo.TbItemCat;
import cn.weishop.mapper.TbItemCatMapper;
import cn.weishop.service.ITbItemCatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbItemCatServiceImpl implements ITbItemCatService {

	   
	@Autowired
	private  TbItemCatMapper tbItemCatMapper;
    
	public List<TbItemCat> selectAllParentId(int currNo,int currSize) {
		try {
			List<TbItemCat> list = tbItemCatMapper.selectAllParentId(currNo,currSize);
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TbItemCat> selectParentId1() {
		try {
			List<TbItemCat> list = tbItemCatMapper.selectParentId1();
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TbItemCat> selectParentId2(int parentId) {
		try {
			List<TbItemCat> list = tbItemCatMapper.selectParentId2(parentId);
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TbItemCat> selectParentId3(int parentId) {
		try {
			List<TbItemCat> list = tbItemCatMapper.selectParentId3(parentId);
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean add(TbItemCat item) {
		try {
			int count = tbItemCatMapper.add(item);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(TbItemCat item) {
		try {
			int count = tbItemCatMapper.update(item);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public TbItemCat selectId(int id) {
		try {
			TbItemCat count = tbItemCatMapper.selectId(id);
			if(count!=null){
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		try {
			int count = tbItemCatMapper.delete(id);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int count() {
		try {
			int count = tbItemCatMapper.count();
			if(count>0){
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<TbItemCat> SelectTypeId1(int type_id) {
		try {
			List<TbItemCat> list = tbItemCatMapper.SelectTypeId1(type_id);
			if(list!=null){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
