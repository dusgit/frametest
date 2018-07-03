package com.exa.client.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exa.common.bean.MonitorVisitVo;
import com.exa.common.bean.ResultModel;
import com.exa.common.service.MonitorVisitService;
import com.exa.common.tools.MonitorTool;
import com.exa.common.tools.RedisTool;
import com.exa.common.tools.StringTool;

@Controller
@RequestMapping("mornitor")
public class MornitorController {

	@Autowired
	private MonitorVisitService monitorVisitService;
	@Autowired
	private RedisTool redisTool;
	
	
	@RequestMapping("index")
	public String index(){
		return "mornitor/index";
	}
	
	@RequestMapping("getData")
	@ResponseBody
	public ResultModel getData(Integer seconds,Model model){
		ArrayList<Integer> keyArray = new ArrayList<Integer>();
		ArrayList<Integer> valueArray = new ArrayList<Integer>();
		if(seconds == null){
			seconds = 60;
		}
		Integer currentKey = StringTool.getCurrentKey(seconds);
		for(int i=0;i<30;i++){
			keyArray.add(currentKey - (i * seconds));
			valueArray.add(getData(keyArray.get(i),seconds));
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyArray", keyArray);
		map.put("valueArray", valueArray);
		ResultModel result = ResultModel.success("查询成功",map);
		return result;
	}
	
	private Integer getData(Integer keyTime,Integer seconds){
		//判断redis是否存在
		if(redisTool.exist(keyTime.toString())){
			return Integer.valueOf(redisTool.get(keyTime+""));
		}else{
			MonitorVisitVo mvv = new MonitorVisitVo();
			mvv.setStartTime(new Timestamp(Long.valueOf(keyTime)*1000));
			mvv.setEndTime(new Timestamp(Long.valueOf(keyTime + seconds)*1000));
			Integer visitCount = monitorVisitService.getMonitorVisitCount(mvv);
			//判断是否当前时间，当前时间不保存
			if((StringTool.getCurrentKey(seconds)).intValue() != keyTime.intValue()){
				redisTool.set(keyTime+"", visitCount+"");
			}
			return visitCount;
		}
	}
	
}
