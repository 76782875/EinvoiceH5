package com.park.einvoice.h5.domain;

public class HasInvoiceDetail {
	private String code, msg;
	private HasInvoiceDetailData data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HasInvoiceDetailData getData() {
		return data;
	}
	public void setData(HasInvoiceDetailData data) {
		this.data = data;
	}
}
