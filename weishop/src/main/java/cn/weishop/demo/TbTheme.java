package cn.weishop.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
public class TbTheme implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "themeid", type = IdType.AUTO)
    private Integer themeid;

    /**
     * 主题名
     */
    private String themename;

    /**
     * 样式图
     */
    private String picture;

    /**
     * 是否启用
     */
    private String status;

    /**
     * 启动时间
     */
    private LocalDate createTime;

    /**
     * 截止时间
     */
    private LocalDate closeTime;

    /**
     * 操作人
     */
    private String person;

    /**
     * 操作时间
     */
    private LocalDate updateTime;

	public Integer getThemeid() {
		return themeid;
	}

	public void setThemeid(Integer themeid) {
		this.themeid = themeid;
	}

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public LocalDate getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalDate closeTime) {
		this.closeTime = closeTime;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public LocalDate getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}


}
