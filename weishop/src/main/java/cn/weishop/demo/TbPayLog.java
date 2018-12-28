package cn.weishop.demo;

import java.time.LocalDateTime;
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
public class TbPayLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付订单号
     */
    private String outTradeNo;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 支付完成时间
     */
    private LocalDateTime payTime;

    /**
     * 支付金额（分）
     */
    private Long totalFee;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 交易号码
     */
    private String transactionId;

    /**
     * 交易状态
     */
    private String tradeState;

    /**
     * 订单编号列表
     */
    private String orderList;

    /**
     * 支付类型
     */
    private String payType;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getPayTime() {
		return payTime;
	}

	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getOrderList() {
		return orderList;
	}

	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}


}
