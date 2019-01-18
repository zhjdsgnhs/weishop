package cn.weishop.demo;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class TbGoodsDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * SPU_ID
     */
    private int goodsDesc_idgoodsDesc_id;

    /**
     * 描述
     */
    private String introduction;

    /**
     * 规格结果集，所有规格，包含isSelected
     */
    private String specificationItems;

    /**
     * 自定义属性（参数结果）
     */
    private String customAttributeItems;

    private String itemImages1;
    
    private String itemImages2;
    
    private String itemImages3;
    
    private String itemImages4;

    /**
     * 包装列表
     */
    private String packageList;

    /**
     * 售后服务
     */
    private String saleService;
    
    private int goodsId;
    
    private BigDecimal goodprice;
    private String goodSmallPic;



	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSpecificationItems() {
		return specificationItems;
	}

	public void setSpecificationItems(String specificationItems) {
		this.specificationItems = specificationItems;
	}

	public String getCustomAttributeItems() {
		return customAttributeItems;
	}

	public void setCustomAttributeItems(String customAttributeItems) {
		this.customAttributeItems = customAttributeItems;
	}

	

	public int getGoodsDesc_idgoodsDesc_id() {
		return goodsDesc_idgoodsDesc_id;
	}

	public void setGoodsDesc_idgoodsDesc_id(int goodsDesc_idgoodsDesc_id) {
		this.goodsDesc_idgoodsDesc_id = goodsDesc_idgoodsDesc_id;
	}

	public String getItemImages1() {
		return itemImages1;
	}

	public void setItemImages1(String itemImages1) {
		this.itemImages1 = itemImages1;
	}

	public String getItemImages2() {
		return itemImages2;
	}

	public void setItemImages2(String itemImages2) {
		this.itemImages2 = itemImages2;
	}

	public String getItemImages3() {
		return itemImages3;
	}

	public void setItemImages3(String itemImages3) {
		this.itemImages3 = itemImages3;
	}

	public String getItemImages4() {
		return itemImages4;
	}

	public void setItemImages4(String itemImages4) {
		this.itemImages4 = itemImages4;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPackageList() {
		return packageList;
	}

	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}

	public String getSaleService() {
		return saleService;
	}

	public void setSaleService(String saleService) {
		this.saleService = saleService;
	}

	public BigDecimal getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(BigDecimal goodprice) {
		this.goodprice = goodprice;
	}

	public String getGoodSmallPic() {
		return goodSmallPic;
	}

	public void setGoodSmallPic(String goodSmallPic) {
		this.goodSmallPic = goodSmallPic;
	}


	

    
}
