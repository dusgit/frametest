package com.exa.common.tools;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exa.common.po.MonitorVisitPo;
import com.exa.common.service.MonitorVisitService;

@Component
public class MonitorTool {

	@Autowired
	private MonitorVisitService monitorVisitService;
	
	public boolean addMonitor(String method){
		MonitorVisitPo mvp = new MonitorVisitPo();
		mvp.setMethod(method);
		mvp.setVisitTime(new Timestamp(System.currentTimeMillis()));
		if(monitorVisitService.saveMonitorVisit(mvp) > 0){
			return true;
		}else{
			return false;
		}
		
	}
}
