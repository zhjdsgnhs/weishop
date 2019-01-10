package cn.weishop.service;
import cn.weishop.demo.TbGoodsStatus;
import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
public interface ITbGoodsStatusService{
	List<TbGoodsStatus> selectStatus();
}
