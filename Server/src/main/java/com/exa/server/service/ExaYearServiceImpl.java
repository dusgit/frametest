package com.exa.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.exa.common.bean.BeanBox;
import com.exa.common.po.ExaYearPo;
import com.exa.common.service.ExaYearService;
import com.exa.common.tools.RedisTool;
import com.exa.server.dao.ExaYearDao;

@Service(interfaceClass = ExaYearService.class)
@Component
public class ExaYearServiceImpl implements ExaYearService {

	public ExaYearServiceImpl(){
		System.out.println("--- ---- 初始化 ExaYearServiceImpl");
	}
	
	@Autowired
	private ExaYearDao exaYearDao;
	@Autowired
	private RedisTool redisTool;
	
	@Override
	public List<ExaYearPo> getExaYearList() {
		//判断redis是否存在
//		try {
//			if(redisTool.exist("yearList")){
//				return (List<ExaYearPo>)redisTool.getObject("yearList");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		List<ExaYearPo> list = exaYearDao.getExaYearList();
//		try {
//			redisTool.setObject("yearList", list);//beanBox);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return list;
//		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().hashCode());
		RedisTool redisTool = new RedisTool();
		long start = System.currentTimeMillis();
		Integer exist = 0;
		for(int i=0;i<10;i++){
			if(redisTool.exist("yearList")){
				exist ++;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("总计消耗:"+(end - start)+",exist:"+exist);
	}

}
