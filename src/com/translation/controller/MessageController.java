package com.translation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.translation.bean.Invite;
import com.translation.bean.Love;
import com.translation.bean.User;
import com.translation.bean.Want;
import com.translation.service.CommentService;
import com.translation.service.DocumentService;
import com.translation.service.InviteService;
import com.translation.service.LoveService;
import com.translation.service.UserService;
import com.translation.service.WantService;


@Controller
@RequestMapping("/message")
public class MessageController {

	private static String contentType="text/html;charset=utf-8";
	private static int maxCount=50;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LoveService loveService;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private WantService wantService;
	@Autowired
	private UserService userService;
	@Autowired
	private InviteService inviteService;	
	
	
	
	
	/**
	 * 消息首页默认展示获取到的评论
	 * @param session
	 * @return
	 */
	@RequestMapping(params="method=show_comment",method=RequestMethod.GET)
	public String showComment(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Document> documentList = documentService.getByPage(0, maxCount, user.getUserid());
			List<Integer> docIdList = new ArrayList<Integer>();
			for(Document document:documentList){
				docIdList.add(document.getDocid());
			}
			List<Comment> commentList = commentService.getByPage(0, maxCount, docIdList);
			for(Comment comm:commentList){
				comm.setUser(userService.getByKey(comm.getUserid()));//设置评论用户
				comm.setDocument(documentService.getById(comm.getDocid()));//设置评论文档
				
				if(comm.getIsnew().equals("0")){
					comm.setIsnew("1");
					commentService.update(comm);
				}
				
			}
			model.addAttribute("user", user);
			model.addAttribute("newComment", commentList);			
			
			return "templet/user/new_comment";
		}else return "error";
	}
	
	
	/**
	 * 获取我收到的赞消息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=show_love",method=RequestMethod.GET)
	public String showLove(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Comment> commentList = commentService.getByPage4User(0,maxCount,user.getUserid());
			List<Integer> commIdList = new ArrayList<Integer>();
			for(Comment comm:commentList){
				commIdList.add(comm.getComid());
			}
			List<Love> loveList = loveService.getByCom(commIdList, 0, maxCount);
			for(Love love:loveList){
				love.setComment(commentService.getById(love.getCommid()));
				love.setUser(userService.getByKey(love.getUserid()));
				if(love.getIsnew().equals("0"))
				{
					love.setIsnew("1");
					loveService.update(love);
				}
				
			}

			model.addAttribute("newLoveList", loveList);
			model.addAttribute("user", user);			
			return "templet/user/new_love";
			
		}else return "error";
	}
	
	
	/**
	 * 获取我收到的同求
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=show_want",method=RequestMethod.GET)
	public String showWant(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Document> documenttList = documentService.getByPage(0,maxCount,user.getUserid());
			List<Want> newWantList = new ArrayList<Want> ();
			List<Integer> docList = new ArrayList<Integer>();
			for(Document document:documenttList){
				docList.add(document.getDocid());
			}
			List<Want> wantList = wantService.getByPage(0, maxCount, docList);
			for(Want want:wantList){
				want.setUser(userService.getByKey(want.getUserid()));
				want.setDocument(documentService.getById(want.getDocid()));				
			}
			wantService.update();
			newWantList.addAll(wantList);

			model.addAttribute("newWantList", newWantList);
			model.addAttribute("user", user);			
			return "templet/user/new_want";
			
		}else return "error";
	}

	/**
	 * 获取邀请我的信息
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=show_invite",method=RequestMethod.GET)
	public String showInvite(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Invite> inviteList = inviteService.getByGuestId(user.getUserid());
			inviteService.updateIsNew();
			for(Invite invite:inviteList){
				invite.setDocument(documentService.getById(invite.getDocid()));
				invite.setUser(userService.getByKey(invite.getDocument().getUserid()));
			}
			model.addAttribute("inviteList", inviteList);
			return "templet/user/new_invite";
		}
		return "error";
	}
	

	
	/**
	 * 获取新消息数的Ajax请求服务端
	 * @param session
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=get_msg_count",method=RequestMethod.GET)
	public  String getMsgCount(HttpSession session,HttpServletResponse response) throws IOException{
		User user = (User) session.getAttribute("user");
		if(user!=null){
			int totleCount = getCommentCount(user)+getLoveCount(user)+getWantCount(user)+getAcceptCount(user)+getInviteCount(user);
			if(totleCount!=0)
			{
				String retCount = totleCount+"";
				response.setContentType(contentType);
				PrintWriter out = response.getWriter();
				out.println(retCount);
				
			}
			
		}return null;
	}

	
	/**
	 * 获取翻译获得的love数量
	 * @param user
	 * @return
	 */
	private int getLoveCount(User user) {
		List<Comment> commentList = commentService.getByPage4User(0, 100, user.getUserid());
		int count = 0;
		for(Comment comm:commentList){
			count = count + loveService.CountByCommentNew(comm.getComid());
		}
		
		return count;
	}

	/**
	 * 获取文档获得的Want数量
	 */
	private int getWantCount(User user) {
		List<Document> documentList = documentService.getByPage(0, maxCount, user.getUserid());
		int count = 0;
		for(Document document:documentList){
			count = count+wantService.countByDocNew(document.getDocid());
		}
		return count;
	}

	/**
	 * 获取新的接受信息数量
	 * @param user
	 * @return
	 */
	private int getAcceptCount(User user) {
		return commentService.countAccNew(user.getUserid());
	}

	/**
	 * 获取新的邀请信息数量
	 * @param user
	 * @return
	 */
	private int getInviteCount(User user) {
		return inviteService.countNew(user.getUserid());
	}

	/**
	 * 获取文档获得的评论数量
	 * @param user
	 * @return
	 */
	private int getCommentCount(User user) {
		List<Document> documentList = documentService.getByPage(0, maxCount, user.getUserid());
		int count = 0;
		for(Document document:documentList){
			count=count+commentService.getAllNewCount4Doc(document.getDocid());
		}
		return count;
	}
}
