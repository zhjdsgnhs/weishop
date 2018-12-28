package cn.weishop.service.impl;

import cn.weishop.demo.TbItem;
import cn.weishop.mapper.TbItemMapper;
import cn.weishop.service.ITbItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Service
public class TbItemServiceImpl extends ServiceImpl<TbItemMapper, TbItem> implements ITbItemService {

}
