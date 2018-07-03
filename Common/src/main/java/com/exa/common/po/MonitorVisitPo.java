package com.exa.common.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class MonitorVisitPo extends BasePo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8016054908984162900L;
	private String method;
	private Timestamp visitTime;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Timestamp getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Timestamp visitTime) {
		this.visitTime = visitTime;
	}
	
	
}
