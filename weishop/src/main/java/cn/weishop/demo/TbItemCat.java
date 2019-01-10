package cn.weishop.demo;

import java.util.List;

import lombok.Data;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author jeddden
 * @since 2018-12-28
 */
@Data

public class TbItemCat {

    /**
     * 类目ID
     */
   
    private int id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private int parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类型id
     */
    private int typeId;
    private String typeName;
    
   

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
		switch (this.typeId) {
		case 1:
			this.typeName="一级分类";
			break;
		case 2:
			this.typeName="二级分类";
			break;
		case 3:
			this.typeName="三级分类";
			break;

		default:
			break;
		}
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	
     
   
}
