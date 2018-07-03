package com.exa.common.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BeanBox implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7204954171602797527L;
	private Map<String,Object> map;
	
	public boolean setObject(String key,Object object){
		if(map == null){
			map = new HashMap<String,Object>();
		}
		map.put(key, object);
		return true;
	}
	public Object getObject(String key){
		if(map == null){
			return null;
		}
		return map.get(key);
	}
}
