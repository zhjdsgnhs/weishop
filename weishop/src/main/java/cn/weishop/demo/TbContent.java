package cn.weishop.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
public class TbContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 内容类目ID
     */
    private Integer categoryId;
    
    private String categoryName;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片绝对路径
     */
    private String pic;

    /**
     * 排序
     */
    private Integer sortOrder;
   
    
    private List<TbContentCategory> category;
    public List<TbContentCategory> getCategory() {
		return category;
	}

	public void setCategory(List<TbContentCategory> category) {
		this.category = category;
	}

	/**
     * 广告名
     */
    private String name;

    /**
     * 修改日期
     */
    @TableField("updateTime")
    private LocalDate updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}

    
}
