package com.exa.common.po;

import java.io.Serializable;

public class ExaYearPo extends BasePo implements Serializable{

	private static final long serialVersionUID = 4616968938790570808L;
	private String year;
	private String yearAlise;
	private Integer sequence;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getYearAlise() {
		return yearAlise;
	}
	public void setYearAlise(String yearAlise) {
		this.yearAlise = yearAlise;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	
	
}
