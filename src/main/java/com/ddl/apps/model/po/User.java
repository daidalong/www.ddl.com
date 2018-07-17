/**
 * 
 */
package com.ddl.apps.model.po;

import java.util.Date;

import com.ddl.core.utils.DateUtil;

/**
 * @author daidalong
 *
 */
public class User {
	private Integer id;
	private String name;
	private String mobile;
	private Date createTime;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDateStr() {
		return DateUtil.getDateStr(createTime == null ? new Date() : createTime);
	}

	public String toString() {
		return "id=" + id + ",name=" + name + ",mobile=" + mobile + ",dateStr=" + getDateStr();
	}
}
