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
public class TbGoodsPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "promotion_id", type = IdType.AUTO)
    private Integer promotionId;

    private String promotionStatus;

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionStatus() {
		return promotionStatus;
	}

	public void setPromotionStatus(String promotionStatus) {
		this.promotionStatus = promotionStatus;
	}

    
}
