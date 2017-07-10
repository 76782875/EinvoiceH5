package com.park.einvoice.h5.domain;

/**
 * 已开票页信息单个内容的bean
 * @author WangYuefei
 *
 */
public class HasInvoiceSimple {
	private String invoiceReqSerialNo,buyerName,
		invoiceAmount,invoiceTime,invoiceStatus;

	public String getInvoiceReqSerialNo() {
		return invoiceReqSerialNo;
	}

	public void setInvoiceReqSerialNo(String invoiceReqSerialNo) {
		this.invoiceReqSerialNo = invoiceReqSerialNo;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceTime() {
		return invoiceTime;
	}

	public void setInvoiceTime(String invoiceTime) {
		this.invoiceTime = invoiceTime;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	@Override
	public String toString() {
		return "HasInvoiceSimple [invoiceReqSerialNo=" + invoiceReqSerialNo + ", buyerName=" + buyerName
				+ ", invoiceAmount=" + invoiceAmount + ", invoiceTime=" + invoiceTime + ", invoiceStatus="
				+ invoiceStatus + "]";
	}
}
