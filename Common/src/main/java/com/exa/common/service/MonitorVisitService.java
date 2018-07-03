package com.exa.common.service;

import com.exa.common.bean.MonitorVisitVo;
import com.exa.common.po.MonitorVisitPo;

public interface MonitorVisitService {
	public Integer getMonitorVisitCount(MonitorVisitVo mvv);
	
	public Integer saveMonitorVisit(MonitorVisitPo mvp);
}
