package com.exa.server.controller;

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
@RequestMapping("demo")
public class DemoController {
	@Autowired
	private ExaYearService exaYearService;
	@ResponseBody
	@RequestMapping("index")
	public ResultModel index(){
		List<ExaYearPo> result = exaYearService.getExaYearList();
		Map<String,Object> results = new HashMap<String,Object>();
		results.put("results", result);
		ResultModel rm = ResultModel.success("查询成功", results);
		return rm;
	}
}
