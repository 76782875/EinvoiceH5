package com.park.einvoice.h5.domain;

/**
 * 已开票页信息的bean
 * @author WangYuefei
 *
 */
public class HasInvoice{
	private String code,msg;
	private HasInvoiceData data;
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
	public HasInvoiceData getData() {
		return data;
	}
	public void setData(HasInvoiceData data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "HasInvoice [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}
