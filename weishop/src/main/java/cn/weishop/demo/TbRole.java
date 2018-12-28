package cn.weishop.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "u_typeid", type = IdType.AUTO)
    private Integer uTypeid;

    /**
     * 用户类型
     */
    private String uType;

    /**
     * 1.启用 0.禁用
     */
    private Integer typeStatus;

	public Integer getuTypeid() {
		return uTypeid;
	}

	public void setuTypeid(Integer uTypeid) {
		this.uTypeid = uTypeid;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	public Integer getTypeStatus() {
		return typeStatus;
	}

	public void setTypeStatus(Integer typeStatus) {
		this.typeStatus = typeStatus;
	}


}
