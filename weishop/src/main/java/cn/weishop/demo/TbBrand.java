package cn.weishop.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
public class TbBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌首字母
     */
    private String firstChar;

    /**
     * 1.启用 0.禁用
     */
    private Integer status;

    /**
     * 发布人
     */
    private String publish;

    /**
     * 发布时间
     */
    @TableField("publishTime")
    private LocalDate publishTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstChar() {
		return firstChar;
	}

	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public LocalDate getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(LocalDate publishTime) {
		this.publishTime = publishTime;
	}

    
}
