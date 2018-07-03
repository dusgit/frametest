package com.exa.common.bean;

import java.sql.Timestamp;

import com.exa.common.po.MonitorVisitPo;

public class MonitorVisitVo extends MonitorVisitPo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7320649253699864586L;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
	
}
