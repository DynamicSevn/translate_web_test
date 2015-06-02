package com.translation.controller;

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

/**
 * 用户controller
 * @author 浩然
 *
 */
@Controller
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;

	
	@Autowired
	private FriendService friendService;
	
	/**
	 * 显示vo主页
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=index",method=RequestMethod.GET)
	public String index(HttpSession session,Model model){
		model.addAttribute("user", session.getAttribute("user"));
		return "redirect:/document?method=index";
	}
	
	
	/**
	 * 添加一个用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=add",method=RequestMethod.POST)
	public String add(User user,Model model,HttpSession session){
		Integer userId = userService.addRet(user);
		
		session.setAttribute("user", userService.getByKey(userId));
		
		return "redirect:/document?method=index";
	}
	
	/**
	 * 根据userid获得user
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=show",method=RequestMethod.POST)
	public String getById(Integer userid,Model model,HttpSession session){
		User user = userService.getByKey(userid);
		if(user!=null)
			session.setAttribute("user", user);
		return "success";
	}
	
	
	/**
	 * 登陆控制
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(params="method=log",method=RequestMethod.POST)
	public String log(User user,Model model,HttpSession session){
		User tempUser = userService.getByNameAndPass(user);
		if(tempUser!=null)
		{
			session.removeAttribute("user");
			session.setAttribute("user", tempUser);
			return "redirect:/document?method=index";
		}
		else{
			model.addAttribute("msg", "登陆失败,请检查用户名或密码！");
			return "index";
		}
	}
	
	/**
	 * 注销账号
	 * @param session
	 * @return
	 */
	@RequestMapping(params="method=cancel",method=RequestMethod.GET)
	public String cancel(HttpSession session){
		session.removeAttribute("user");
		return "index";
	}
	
	
	/**
	 * 显示用户信息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=show",method=RequestMethod.GET)
	public String show(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			
			model.addAttribute("user", userService.getByKey(user.getUserid()));
			return "templet/user/user_info";
		}
		else return "error";
	}
	
	
	/**
	 * 显示其他用户的主页
	 * @param session
	 * @param model
	 * @param userid
	 * @return
	 */
	@RequestMapping(params="method=guest_user_index",method=RequestMethod.GET)
	public String showGuestIndex(HttpSession session,Model model,Integer userid){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			if(user.getUserid().equals(userid)){
				return "redirect:/document?method=list";
			}else {
				model.addAttribute("guestUser", userService.getByKey(userid));
				
				Friend friend = friendService.getBy2Id(user.getUserid(), userid);
				if(friend!=null)
					model.addAttribute("isFriend", "1");
				model.addAttribute("user", user);
				return "user/guest_index";
			}
		}else return "error";
	}
	
	
	/**
	 * 显示其他用户信息
	 * @param model
	 * @param userid
	 * @return
	 */
	@RequestMapping(params="method=guest_user_info",method=RequestMethod.GET)
	public String showGuestInfo(Model model,Integer userid){
		User guestUser = userService.getByKey(userid);
		model.addAttribute("guestUser", guestUser);
		return "templet/guest_user/info";
	}
	
	
	/**
	 * 修改转发
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=modify",method=RequestMethod.GET)
	public String modify(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			model.addAttribute("user", user);
			return "templet/user/modify";
		}
		else return "error";
	}
	
	
	/**
	 * 修改主流程
	 * @param session
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(params="method=modify",method=RequestMethod.POST)
	public String modify(HttpSession session,Model model,User user){
		User userSession = (User) session.getAttribute("user");
		if(userSession!=null){
			user.setUserid(userSession.getUserid());
			userService.update(user);
			session.removeAttribute("user");
			session.setAttribute("user", userService.getByKey(user.getUserid()));
			model.addAttribute("msg", "修改成功!");
			return "redirect:/document?method=list";
		}
		else return "error";
	}
	
}
