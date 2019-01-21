package cn.weishop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbGwcMapper {
    
	@Select(  " <script> "
			+ "  SELECT w.num,g.stock,u.username,g.small_pic,g.price,g.goods_name  "
			+ "  FROM  tb_gwc w ,tb_goods g ,tb_user u WHERE  w.userid=u.id AND w.goodid=g.id "
			+ "  <if test='userid!=null' > And u.id=${userid}     </if> "
			+ " </script> ")
	List<Map<String, Object>> select( @Param("userid") Integer userid);

}
