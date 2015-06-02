package com.translation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.translation.bean.Friend;
import com.translation.bean.User;
import com.translation.service.FriendService;
import com.translation.service.UserService;


@Controller
@RequestMapping("/friend")
public class FriendController {

	
	@Autowired
	private FriendService friendService;
	@Autowired
	private UserService userService;
	
	/**
	 * 转发friend消息主页
	 * @param session
	 * @return
	 */
	@RequestMapping(params="method=index",method=RequestMethod.GET)
	public String index(HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			return "templet/friend/index";
		}else return "error";
	}
	
	
	/**
	 * 获取我关注的用户
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=follow_list",method=RequestMethod.GET)
	public String followList(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Friend> friendList = friendService.getByPrimId(user.getUserid());
			for(Friend friend:friendList){
				friend.setGuestUser(userService.getByKey(friend.getGuestid()));
			}
			model.addAttribute("followFriendList", friendList);
			return "templet/friend/follow_list";
		}else return "error";
	}
	
	/**
	 * 获取关注我的用户
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=followed_list",method=RequestMethod.GET)
	public String followedList(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Friend> friendList = friendService.getByGuestId(user.getUserid());
			for(Friend friend:friendList){
				friend.setGuestUser(userService.getByKey(friend.getPrimid()));
			}
			model.addAttribute("followedFriendList", friendList);
			return "templet/friend/followed_list";
		}else return "error";
	}	
	
	
	/**
	 * 添加friend消息
	 * @param session
	 * @param model
	 * @param guestid
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(params="method=add",method = RequestMethod.GET)
	public String add(HttpSession session,Model model,Integer guestid,HttpServletResponse response) throws IOException{
		User user = (User) session.getAttribute("user");
		if(user!=null){
			Friend friend = new Friend();
			friend.setPrimid(user.getUserid());
			friend.setGuestid(guestid);
			friendService.add(friend);
	        response.setContentType("text/html;charset=utf-8");
	        //写入到前台
	        PrintWriter out = response.getWriter();
	        out.println("success");
			return null;
		}else return "error";
	}
	

	/**
	 * 删除friend消息
	 * @param session
	 * @param model
	 * @param guestid
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(params="method=delete",method = RequestMethod.GET)
	public String delete(HttpSession session,Integer friendid,HttpServletResponse response) throws IOException{
		User user = (User) session.getAttribute("user");
		if(user!=null){
			friendService.deleteById(friendid);
	        response.setContentType("text/html;charset=utf-8");
	        //写入到前台
	        PrintWriter out = response.getWriter();
	        out.println("success");
			return null;
		}else return "error";
	}
	
}
