package com.park.einvoice.h5.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 获取开票申请页面信息
 * @author WangYuefei
 *
 */
@Repository(value="invMainService")
public interface InvMainService {
	
	/**
	 * 获取申请开票页面的相关信息
	 * @param requestJsonStr 传入JSON字符串参数，内包含一个|订单号tradeNo
	 * @return 返回结果集map
	 */
	public Map<String, String> getOrderInvoice(String requestJsonStr);
	
}
