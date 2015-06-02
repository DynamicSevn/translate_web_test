package com.translation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.translation.bean.Love;
import com.translation.bean.User;
import com.translation.service.LoveService;


@Controller
@RequestMapping("/love")
public class LoveController {
	
	
	@Autowired
	private LoveService likeService;

	@RequestMapping(params="method=add_ajax",method=RequestMethod.GET)
	public String addAjax(HttpSession session,Love love,HttpServletResponse response) throws IOException{
		User user = (User) session.getAttribute("user");
		if(user!=null){
			love.setUserid(user.getUserid());
			likeService.add(love);
			String count = likeService.CountByComment(love.getCommid())+"";
	        //将List转化为JSON
//	        JSONArray json=JSONArray.fromObject(count);
	        //设置编码
	        response.setContentType("text/html;charset=utf-8");
	        //写入到前台
	        PrintWriter out = response.getWriter();
	        out.println(count);
			return null;
		}
		else return "error";
	}
}
