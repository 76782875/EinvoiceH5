package com.park.einvoice.h5.domain;

import java.util.List;

/**
 * 已开票页信息内容的bean
 * @author WangYuefei
 *
 */
public class HasInvoiceData {
	private String tradeNo;
	private List<HasInvoiceSimple> invoiceList;
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public List<HasInvoiceSimple> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(List<HasInvoiceSimple> invoiceList) {
		this.invoiceList = invoiceList;
	}
	@Override
	public String toString() {
		return "HasInvoiceData [tradeNo=" + tradeNo + ", invoiceList=" + invoiceList + "]";
	}
}
