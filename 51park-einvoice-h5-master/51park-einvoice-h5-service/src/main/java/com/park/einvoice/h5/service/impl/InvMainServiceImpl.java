package com.park.einvoice.h5.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.einvoice.h5.common.DataChangeTools;
import com.park.einvoice.h5.common.HttpTools;
import com.park.einvoice.h5.common.properties.Invoiceh5;
import com.park.einvoice.h5.domain.OrderInvoice;
import com.park.einvoice.h5.domain.OrderInvoiceData;
import com.park.einvoice.h5.service.InvMainService;

@Repository(value="invMainServiceImpl")
public class InvMainServiceImpl extends BaseService implements InvMainService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Invoiceh5 invoiceh5;
	
	private String preUrl;
	private String url4OrdInv;
	
	@Override
	public Map<String, String> getOrderInvoice(String requestJsonStr) {
		try {
			//获取基本信息
			getInvoiceh5Info();
			String url = preUrl + url4OrdInv;
			logger.info("** 获取申请开票页信息，请求：" + requestJsonStr + "，url：" + url);
			//准备请求数据并发送请求
			Map<String,String> headers = getHeaders(requestJsonStr,url);
			String result=HttpTools.HttpClientPost(url, requestJsonStr, headers);
			//将结果解析为map
			logger.info("** 获取申请开票页信息，结果：" + result);
			OrderInvoice orderInvoice = DataChangeTools.gson2bean(result, OrderInvoice.class);
			if(orderInvoice == null){
				return null;
			}
			String code = orderInvoice.getCode();
			//根据map中的code判断是否获取成功
			if(code.equals("200")){
				//成功，则返回数据的map，不包含code、msg信息
				OrderInvoiceData data = orderInvoice.getData();
				String dataStr = DataChangeTools.bean2gson(data);
				Map<String, String> resultMap = DataChangeTools.json2Map(dataStr);
				logger.info("** 获取申请开票页信息成功，返回数据：" + dataStr);
				return resultMap;
			}
			//失败，则只返回包含code、msg的map
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("code", code);
			resultMap.put("msg", orderInvoice.getMsg());
			logger.info("** 获取申请开票页信息失败，返回数据：" + DataChangeTools.bean2gson(resultMap));
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("** 获取申请开票页信息出现异常：" + e.getMessage());
			return null;
		}
	}

	private void getInvoiceh5Info(){
		preUrl = invoiceh5.getPreUrl();
		url4OrdInv = invoiceh5.getUrl4OrdInv();
	}
	
}
