package com.park.einvoice.h5.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.einvoice.h5.common.DataChangeTools;
import com.park.einvoice.h5.domain.HasInvoice;
import com.park.einvoice.h5.domain.HasInvoiceData;
import com.park.einvoice.h5.service.HasInvService;

@Controller
@RequestMapping("/hasinv")
public class HasInvController {
	
	@Resource(name="hasInvServiceImpl")
	private HasInvService hasInvService;
	
	@RequestMapping("/get")
	public String getHasInvoice(String tradeNo, Model model){
		//获取已开票列表信息
		HasInvoice hasInvoice = hasInvService.getHasInvoice(tradeNo);
		HasInvoiceData data = hasInvoice.getData();
		String code = hasInvoice.getCode();
		//若成功，返回订单号和已开票的list，并返回已开票列表页面
		if(code.equals("200")){
			model.addAttribute("tradeNo", data.getTradeNo());
			model.addAttribute("invoiceList", data.getInvoiceList());
			return "h5_inv_has";
		}
		//若失败，跳到错误页面
		return "h5_error";
	}
	
	@RequestMapping("/getdetail")
	public String getHasInvoiceDetail(String invoiceReqSerialNo, Model model){
		Map<String, String> resultMap = hasInvService.getHasInvoiceDetail(invoiceReqSerialNo);
		//若未得到数据，跳到错误页面
		if(resultMap == null || resultMap.isEmpty()){
			return "h5_error";
		}
		//若包含code，则回应数据不成功，返回错误信息并跳到错误页面
		if(resultMap.containsKey("code")){
			model.addAttribute("code", resultMap.get("code"));
			model.addAttribute("msg", resultMap.get("msg"));
			return "h5_error";
		}
		//若成功，返回需要参数，跳到已开票项详情页面
		model.addAttribute("invoiceReqSerialNo", resultMap.get("invoiceReqSerialNo"));
		model.addAttribute("invoiceImg", resultMap.get("invoiceImg"));
		model.addAttribute("downloadUrl", resultMap.get("downloadUrl"));
		return "h5_inv_has_det";
	}
	
	@ResponseBody
	@RequestMapping("/sendemail")
	public String sendEmail(HttpServletRequest request){
		String email = request.getParameter("email");
		String invoiceReqSerialNo = request.getParameter("invoiceReqSerialNo");
		Map<String, String> resultMap = hasInvService.sendEmail(email, invoiceReqSerialNo);
		if(resultMap.get("code").equals("200")){
			resultMap.put("url", "emailsended");
		}
		String resultJson = DataChangeTools.bean2gson(resultMap);
		return resultJson;
	}
	
}
