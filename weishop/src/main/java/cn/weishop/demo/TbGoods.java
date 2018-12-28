package cn.weishop.demo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class TbGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商家ID
     */
    private Integer sellerId;

    /**
     * SPU名
     */
    private String goodsName;

    /**
     * 默认库存单位
     */
    private String sellerUnit;

    /**
     * 在售状态
     */
    private Integer statusId;

    /**
     * 是否是促销商品
     */
    private Integer promotionId;

    /**
     * 品牌
     */
    private Long brandId;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 一级类目
     */
    private Long category1Id;

    /**
     * 二级类目
     */
    private Long category2Id;

    /**
     * 三级类目
     */
    private Long category3Id;

    /**
     * 小图
     */
    private String smallPic;

    /**
     * 商城价
     */
    private BigDecimal price;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 款号
     */
    private Integer stylenumber;

    /**
     * 销量
     */
    private Integer sales;

    @TableField("userId")
    private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSellerUnit() {
		return sellerUnit;
	}

	public void setSellerUnit(String sellerUnit) {
		this.sellerUnit = sellerUnit;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Long getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(Long category1Id) {
		this.category1Id = category1Id;
	}

	public Long getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(Long category2Id) {
		this.category2Id = category2Id;
	}

	public Long getCategory3Id() {
		return category3Id;
	}

	public void setCategory3Id(Long category3Id) {
		this.category3Id = category3Id;
	}

	public String getSmallPic() {
		return smallPic;
	}

	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStylenumber() {
		return stylenumber;
	}

	public void setStylenumber(Integer stylenumber) {
		this.stylenumber = stylenumber;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    
}
