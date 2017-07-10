package com.park.einvoice.h5.domain;

/**
 * 申请开票返回信息内容bean
 * @author WangYuefei
 *
 */
public class AppInvoiceData {
	private String tradeNo, invoiceReqSerialNo;
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getInvoiceReqSerialNo() {
		return invoiceReqSerialNo;
	}
	public void setInvoiceReqSerialNo(String invoiceReqSerialNo) {
		this.invoiceReqSerialNo = invoiceReqSerialNo;
	}
}
