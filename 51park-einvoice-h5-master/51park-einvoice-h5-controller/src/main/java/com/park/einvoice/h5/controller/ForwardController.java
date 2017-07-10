package com.park.einvoice.h5.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
	
	@RequestMapping("/emailsended")
	public String emailSended(){
		return "h5_email_sended";
	}
	
	@RequestMapping("/gowait")
	public String goWait(HttpServletRequest request, Model model){
		String invoiceReqSerialNo = request.getParameter("invoiceReqSerialNo");
		model.addAttribute("invoiceReqSerialNo", invoiceReqSerialNo);
		return "h5_inv_wait";
	}
	
	@RequestMapping("/errorpage")
	public String goError(){
		return "h5_error";
	}
	
}
