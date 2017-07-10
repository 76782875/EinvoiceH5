package com.park.einvoice.h5.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.einvoice.h5.common.DataChangeTools;
import com.park.einvoice.h5.common.HttpTools;
import com.park.einvoice.h5.common.properties.Invoiceh5;
import com.park.einvoice.h5.domain.AppInvoice;
import com.park.einvoice.h5.domain.AppInvoiceData;
import com.park.einvoice.h5.service.AppInvService;

@Repository(value="appInvServiceImpl")
public class AppInvServiceImpl extends BaseService implements AppInvService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Invoiceh5 invoiceh5;
	
	private String preUrl;
	private String url4AppInv;
	
	@Override
	public String applyInvoice(Map<String, String> paramMap) {
		try {
			getInvoiceh5Info();
			//校验参数map是否为空
			if(paramMap == null || paramMap.isEmpty()){
				return "";
			}
			String paramJson = DataChangeTools.bean2gson(paramMap);
			String url = preUrl + url4AppInv;
			logger.info("** 申请开票的请求参数：" + paramJson);
			//准备请求数据并发送请求
			Map<String,String> headers = getHeaders(paramJson,url);
			String result=HttpTools.HttpClientPost(url, paramJson, headers);
			logger.info("** 申请开票返回的结果：" + result);
			AppInvoice appInvoice = DataChangeTools.gson2bean(result, AppInvoice.class);
			AppInvoiceData appInvoiceData = appInvoice.getData();
			return DataChangeTools.bean2gson(appInvoiceData);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("** 申请开票出现异常：" + e.getMessage());
			return "";
		}
	}

	private void getInvoiceh5Info(){
		preUrl = invoiceh5.getPreUrl();
		url4AppInv = invoiceh5.getUrl4AppInv();
	}
	
}
