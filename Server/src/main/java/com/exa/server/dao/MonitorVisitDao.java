package com.exa.server.dao;

import com.exa.common.po.MonitorVisitPo;

public interface MonitorVisitDao {
	public Integer getMonitorVisitCount(MonitorVisitPo mv);
	public Integer saveMonitorVisit(MonitorVisitPo mvp);
}
