package com.exa.common.bean;

import java.util.Map;

public class ResultModel {

	private String status;
	private String message;
	private Map<String,Object> results;
	
	public static ResultModel success(){
		 ResultModel rm = new ResultModel();
		 rm.setStatus("success");
		 return rm;
	}
	
	public static ResultModel success(String message){
		 ResultModel rm = new ResultModel();
		 rm.setMessage(message);
		 rm.setStatus("success");
		 return rm;
	}
	
	public static ResultModel success(String message,Map<String,Object> result){
		 ResultModel rm = new ResultModel();
		 rm.setMessage(message);
		 rm.setResults(result);
		 rm.setStatus("success");
		 return rm;
	}

	public static ResultModel error(){
		ResultModel rm = new ResultModel();
		rm.setStatus("false");
		return rm;
	}
	
	public static ResultModel error(String message){
		ResultModel rm = new ResultModel();
		rm.setStatus("false");
		rm.setMessage(message);
		return rm;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getResults() {
		return results;
	}
	public void setResults(Map<String, Object> results) {
		this.results = results;
	}
	
	
}
