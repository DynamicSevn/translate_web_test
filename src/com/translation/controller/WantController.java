package com.translation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.translation.bean.User;
import com.translation.bean.Want;
import com.translation.service.WantService;


@Controller("/want")
public class WantController {
	@Autowired
	private WantService wantService;
	
	@RequestMapping(params="method=add_ajax",method=RequestMethod.GET)
	public String addAjax(HttpSession session,HttpServletResponse response,Want want) throws IOException
	{
		User user = (User) session.getAttribute("user");
		if(user!=null){
			want.setUserid(user.getUserid());
			wantService.add(want);
			String count = wantService.countByDoc(want.getDocid())+"";
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(count);
			
			return null;
			
		}else return "error";
	}
}
