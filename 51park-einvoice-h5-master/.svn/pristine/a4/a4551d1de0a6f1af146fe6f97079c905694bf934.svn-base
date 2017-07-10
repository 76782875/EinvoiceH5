package com.park.einvoice.h5.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.park.einvoice.h5.service.InvMainService;

@Controller
@RequestMapping("/invmain")
public class InvMainController {
	
	@Resource(name="invMainServiceImpl")
	private InvMainService invMainService;
	
	@RequestMapping("/get")
	public String getPage(HttpServletRequest request,Model model){
		String requestJsonStr = request.getParameter("params");
		Map<String, String> resultMap = invMainService.getOrderInvoice(requestJsonStr);
		//如果resultMap为空，直接跳到错误页
		if(resultMap == null || resultMap.isEmpty()){
			return "h5_error";
		}
		//如果resultMap包含code参数，将错误消息放入model，并跳到错误页
		boolean containsCode = resultMap.containsKey("code");
		if(containsCode){
			model.addAttribute("code", resultMap.get("code"));
			model.addAttribute("msg", resultMap.get("msg"));
			return "h5_error";
		}
		//如果resuleMap正常，则放入页面需要参数，跳到inv_main页
		model.addAttribute("tradeNo", resultMap.get("tradeNo"));
		model.addAttribute("parkId", resultMap.get("parkId"));
		model.addAttribute("parkName", resultMap.get("parkName"));
		model.addAttribute("plateNumber", resultMap.get("plateNumber"));
		model.addAttribute("costAfter", resultMap.get("costAfter"));
		model.addAttribute("hasInvoice", resultMap.get("hasInvoice"));
		model.addAttribute("noInvoice", resultMap.get("noInvoice"));
		return "h5_inv_main";
	}

}
