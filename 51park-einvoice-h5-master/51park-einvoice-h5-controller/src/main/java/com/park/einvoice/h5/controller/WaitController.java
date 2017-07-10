package com.park.einvoice.h5.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.einvoice.h5.common.ResultTools;
import com.park.einvoice.h5.common.constants.CodeConstants;
import com.park.einvoice.h5.service.WaitService;

@Controller
@RequestMapping("/wait")
public class WaitController {
	
	@Resource(name="waitServiceImpl")
	private WaitService waitService;
	
	@ResponseBody
	@RequestMapping("/waitinvoice")
	public String waitInvoice(HttpServletRequest request, Model model){
		String invoiceReqSerialNo = request.getParameter("invoiceReqSerialNo");
		if(invoiceReqSerialNo == null || invoiceReqSerialNo.equals("")){
			return ResultTools.setResponse(CodeConstants.参数为空.getCode());
		}
		Map<String, String> successMap = waitService.waitInvoice(invoiceReqSerialNo);
		return ResultTools.setObjectResponse(CodeConstants.成功.getCode(), successMap);
	}
	
}
