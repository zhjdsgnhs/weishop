package cn.weishop.demo;

import java.math.BigDecimal;
import java.util.List;

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

public class TbGoods{
    private int id;

    /**
     * 商家ID
     */
    private int sellerId;
    private String sellerName;
    

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
    private int statusId;
    private String statusName;

    /**
     * 是否是促销商品
     */
    private int promotionId;
    private String proName;

    /**
     * 品牌
     */
    private int brandId;
    private String brandName;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 一级类目
     */
    private int category1Id;
    private String category1IdName;

    /**
     * 二级类目
     */
    private int category2Id;
    private String category2IdName;

    /**
     * 三级类目
     */
    private int category3Id;
    private String category3IdName;

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
    private String stylenumber;

    /**
     * 销量
     */
    private Integer sales;
    
    private Integer userId;
    private String username;
    
    private List<TbGoods> goods;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
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

	

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public int getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(int category1Id) {
		this.category1Id = category1Id;
	}

	public int getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(int category2Id) {
		this.category2Id = category2Id;
	}

	public int getCategory3Id() {
		return category3Id;
	}

	public void setCategory3Id(int category3Id) {
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

	public String getStylenumber() {
		return stylenumber;
	}

	public void setStylenumber(String stylenumber) {
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

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getCategory1IdName() {
		return category1IdName;
	}

	public void setCategory1IdName(String category1IdName) {
		this.category1IdName = category1IdName;
	}

	public String getCategory2IdName() {
		return category2IdName;
	}

	public void setCategory2IdName(String category2IdName) {
		this.category2IdName = category2IdName;
	}

	public String getCategory3IdName() {
		return category3IdName;
	}

	public void setCategory3IdName(String category3IdName) {
		this.category3IdName = category3IdName;
	}

	public List<TbGoods> getGoods() {
		return goods;
	}

	public void setGoods(List<TbGoods> goods) {
		this.goods = goods;
	}
	
	
	
}
