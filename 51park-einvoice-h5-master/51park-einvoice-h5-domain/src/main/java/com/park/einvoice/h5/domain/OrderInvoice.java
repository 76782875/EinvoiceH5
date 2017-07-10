package com.park.einvoice.h5.domain;

/**
 * 开票申请页信息的bean
 * @author WangYuefei
 *
 */
public class OrderInvoice{
	private String code,msg;
	private OrderInvoiceData data;
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
	public OrderInvoiceData getData() {
		return data;
	}
	public void setData(OrderInvoiceData data) {
		this.data = data;
	}
}
