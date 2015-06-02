package com.translation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/share")
public class ShareController {

	@RequestMapping(params="method=index",method=RequestMethod.GET)
	public String index(){
		return "templet/share_redirect";
	}
}
