package com.exa.common.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class BasePo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3214630891480006120L;
	private Long id;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreateTime() {
		System.out.println(createTime.toString());
		return createTime.toString();
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime.toString();
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
