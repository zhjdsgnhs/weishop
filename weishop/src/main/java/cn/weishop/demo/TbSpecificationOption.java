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
public class TbSpecificationOption implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 规格项ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规格项名称
     */
    private String optionName;

    /**
     * 规格ID
     */
    private Long specId;

    /**
     * 排序值
     */
    private Integer orders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	
}
