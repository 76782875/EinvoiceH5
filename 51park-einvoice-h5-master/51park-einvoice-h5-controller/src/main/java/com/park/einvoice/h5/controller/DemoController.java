package com.park.einvoice.h5.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/get")
	public String getPage(HttpServletRequest request,Model model){
		model.addAttribute("msg", "测试");
		return "demo";
	}

}
