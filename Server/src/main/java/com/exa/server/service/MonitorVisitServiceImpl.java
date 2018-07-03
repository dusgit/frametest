package com.exa.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.exa.common.bean.MonitorVisitVo;
import com.exa.common.po.MonitorVisitPo;
import com.exa.common.service.MonitorVisitService;
import com.exa.server.dao.MonitorVisitDao;

@Service(interfaceClass = MonitorVisitService.class)
@Component
public class MonitorVisitServiceImpl implements MonitorVisitService {

	@Autowired
	private MonitorVisitDao monitorVisitDao;
	@Override
	public Integer getMonitorVisitCount(MonitorVisitVo mv) {
		return monitorVisitDao.getMonitorVisitCount(mv);
	}
	@Override
	public Integer saveMonitorVisit(MonitorVisitPo mvp) {
		// TODO Auto-generated method stub
		return monitorVisitDao.saveMonitorVisit(mvp);
	}


}
