package com.translation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.translation.bean.User;

@Controller
@RequestMapping("/trans")  
public class TransController {

	
	
	/**
	 * 机器翻译转发
	 * @return
	 */
	@RequestMapping(params="method=machine",method=RequestMethod.GET)
	public String machine(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return "translation/machine";
	}
	
}
