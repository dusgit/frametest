package com.exa.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exa.common.bean.ResultModel;
import com.exa.common.po.ExaYearPo;
import com.exa.common.service.ExaYearService;
import com.exa.common.tools.MonitorTool;

@Controller
@RequestMapping("clientdemo")
public class ClientDemoController {

	@Autowired
	ExaYearService exaYearService;
	@Autowired
	private MonitorTool monitorTool;
	
	@RequestMapping("index")
	@ResponseBody
	public ResultModel index(Model model){
		List<ExaYearPo> result = exaYearService.getExaYearList();
		Map<String,Object> resultsMap = new HashMap<String,Object>();
		resultsMap.put("results", null);
		resultsMap.put("name", "my first demo");
		model.addAllAttributes(resultsMap);
//		monitorTool.addMonitor("clientdemo.index");
		return ResultModel.success("查询成功", resultsMap);
	}
	
	@RequestMapping("canvas")
	public String canvas(Model model){
		return "canvas";
	}
	
	@RequestMapping("timeholl")
	public String timeholl(Model model){
		return "timeholl";
	}
}
