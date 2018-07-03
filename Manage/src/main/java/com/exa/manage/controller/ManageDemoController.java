package com.exa.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exa.common.bean.ResultModel;
import com.exa.common.po.ExaYearPo;
import com.exa.common.service.ExaYearService;

@Controller
@RequestMapping("managedemo")
public class ManageDemoController {

	@Autowired
	ExaYearService exaYearService;
	
	@ResponseBody
	@RequestMapping("index")
	public ResultModel index(){
		List<ExaYearPo> result = exaYearService.getExaYearList();
		Map<String,Object> resultsMap = new HashMap<String,Object>();
		resultsMap.put("results", result);
		ResultModel rm  = ResultModel.success("查询成功2",resultsMap);
		return rm;
	}
}
