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

import com.translation.bean.Comment;
import com.translation.bean.Document;
import com.translation.bean.User;
import com.translation.service.CommentService;
import com.translation.service.DocumentService;
import com.translation.service.UserService;
import com.translation.utils.Pager;

/**
 * 评论Controller
 * @author 浩然
 *
 */

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	static int maxCount = 50;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired 
	private DocumentService documentService;

	@Autowired 
	private UserService userService;
	
	@RequestMapping(params="method=delete",method=RequestMethod.GET)
	public String delete(HttpSession session,Model model,Integer comid,Integer docid){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			commentService.delete(comid);
			return "redirect:document?method=show&docid="+docid;
		}else return "error";
	}
	
	/**
	 * 添加评论
	 * @param session
	 * @param model
	 * @param comment
	 * @return
	 */
	@RequestMapping(params="method=add",method=RequestMethod.POST)
	public String add(HttpSession session,Model model,Comment comment){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			comment.setUserid(user.getUserid());
			commentService.add(comment);
			return "redirect:document?method=show&docid="+comment.getDocid();
		}
		else{
			model.addAttribute("msg", "请登录");
			return "error";
		}
	}
	
	
	/**
	 * 获取用户评论列表
	 * @param session
	 * @param model
	 * @param paraPage
	 * @return
	 */
	@RequestMapping(params="method=list",method=RequestMethod.GET)
	public String list(HttpSession session,Model model,Pager<Comment> paraPage){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			if(paraPage==null)
				paraPage = new Pager<Comment> ();
			int totleCount = commentService.getAllCount4User(user.getUserid());
			Pager<Comment> page = new Pager<Comment> (totleCount,paraPage.getCurPage(),paraPage.getCountPerPage());
			List<Comment> commentList = commentService.getByPage4User(page.getStartCount(), page.getCountPerPage(), user.getUserid());
			if(!commentList.isEmpty()){
				for(Comment comm:commentList){
					comm.setDocument(documentService.getById(comm.getDocid()));
				}
				model.addAttribute("msg", "评论列表");
			}
			else model.addAttribute("msg", "当前还没有评论");
			
			page.settList(commentList);
			model.addAttribute("page", page);
			model.addAttribute("user", user);
			return "templet/user/my_comm";
		}
		else return "error";
	}
	
	
	/**
	 * 获取其他用户comment列表
	 * @param model
	 * @param userid
	 * @return
	 */
	@RequestMapping(params="method=guest_user_list",method=RequestMethod.GET)
	public String guestUserList(Model model,Integer userid){
		List<Comment> guestCommentList =commentService.getByPage4User(0, maxCount, userid);
		for(Comment comm:guestCommentList){
			comm.setDocument(documentService.getById(comm.getDocid()));
		}
		model.addAttribute("guest", userService.getByKey(userid));
		model.addAttribute("guestCommentList", guestCommentList);
		return "templet/guest_user/comment";
	}
	
	
	/**
	 * 接受评论
	 * @param session
	 * @param comid
	 * @param model
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=accept",method=RequestMethod.GET)
	public String accept(HttpSession session,Integer comid,Model model,HttpServletResponse response) throws IOException{
		User user = (User) session.getAttribute("user");
		if(user!=null){
			Comment comment = commentService.getById(comid);
			comment.setIsaccept("1");
			commentService.update(comment);
			Document document = documentService.getById(comment.getDocid());
			int point = document.getPoint();
			if(point!=0){
				User newUser = userService.getByKey(comment.getUserid());
				newUser.setPoint(newUser.getPoint()+point);
				userService.update(newUser);
			}


	        response.setContentType("text/html;charset=utf-8");
	        //写入到前台
	        PrintWriter out = response.getWriter();
	        out.println("success");	
		}
        return null;
	}
	
	
	/**
	 * 获得接受消息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=show_accept",method=RequestMethod.GET)
	public String showAccept(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Comment> accCommentList = commentService.getAccComment(user.getUserid());
			for(Comment comm:accCommentList){
				comm.setDocument(documentService.getById(comm.getDocid()));
				comm.setUser(userService.getByKey(comm.getDocument().getUserid()));
			}
			
			commentService.updateAcc(user.getUserid());
			
			model.addAttribute("accCommentList", accCommentList);
			//将当前的session值加入model
			model.addAttribute("sessionUser", userService.getByKey(user.getUserid()));
			return "templet/user/new_accept";
		}
		
		return "error";
	}
	
}
