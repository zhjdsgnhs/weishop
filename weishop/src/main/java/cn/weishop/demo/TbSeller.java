package cn.weishop.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;
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
public class TbSeller implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "seller_id", type = IdType.AUTO)
    private Integer sellerId;

    /**
     * 公司名
     */
    private String name;

    /**
     * 店铺名称
     */
    private String nickName;

    /**
     * 公司电话
     */
    private String telephone;

    /**
     * 状态  1.启用0.禁用
     */
    private int status;
    private String statusName;

    /**
     * 联系人
     */
    private String linkmanName;

    /**
     * 联系人电话
     */
    private String linkmanMobile;

    /**
     * 联系人EMAIL
     */
    private String linkmanEmail;

    /**
     * 公司地址
     */
    private Integer address;
    
    private String addressName;

    /**
     * 公司LOGO图
     */
    private String logoPic;

    /**
     * 简介
     */
    private String brief;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 开户行账号名称
     */
    private String bankUser;

    /**
     * 店铺类型
     */
    private Integer sellerType;
    private String typeName;

    /**
     * 购买总量
     */
    private Integer number;

    /**
     * 消费额度
     */
    private Float price;

    private Integer userId;

    /**
     * 分级
     */
    private Integer parentId;
    
    private List<TbSeller> sList;//查询子店铺
    
   
	
	public List<TbSeller> getsList() {
		return sList;
	}

	public void setsList(List<TbSeller> sList) {
		this.sList = sList;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
		switch (this.status) {
		case 0:
			statusName="禁用";
			break;
		case 1:
			statusName="启用";
			break;
		default:
			break;
		}
	}
	

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanMobile() {
		return linkmanMobile;
	}

	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}

	public String getLinkmanEmail() {
		return linkmanEmail;
	}

	public void setLinkmanEmail(String linkmanEmail) {
		this.linkmanEmail = linkmanEmail;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	public String getLogoPic() {
		return logoPic;
	}

	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getBankUser() {
		return bankUser;
	}

	public void setBankUser(String bankUser) {
		this.bankUser = bankUser;
	}

	public Integer getSellerType() {
		return sellerType;
	}

	public void setSellerType(Integer sellerType) {
		this.sellerType = sellerType;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	


}
