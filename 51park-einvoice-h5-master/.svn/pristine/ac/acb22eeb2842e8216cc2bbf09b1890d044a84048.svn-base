package com.park.einvoice.h5.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.park.einvoice.h5.domain.HasInvoice;

/**
 * 获取已开票页面信息的Service
 * @author WangYuefei
 *
 */
@Repository(value="hasInvoice")
public interface HasInvService {

	/**
	 * 获取已开票列表
	 * @param tradeNo 传入订单号
	 * @return 返回已开票返回消息对象
	 */
	public HasInvoice getHasInvoice(String tradeNo);

	/**
	 * 获取已开票项详情
	 * @param invoiceReqSerialNo 传入发票请求流水号
	 * @return 返回已开票项详情map
	 */
	public Map<String, String> getHasInvoiceDetail(String invoiceReqSerialNo);

	/**
	 * 发送电子发票邮件
	 * @param email 邮箱地址
	 * @param invoiceReqSerialNo 发票请求流水号
	 * @return 
	 */
	public Map<String, String> sendEmail(String email, String invoiceReqSerialNo);
	
}
