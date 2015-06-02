package com.translation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.translation.bean.Comment;
import com.translation.bean.Document;
import com.translation.bean.Friend;
import com.translation.bean.Invite;
import com.translation.bean.Love;
import com.translation.bean.User;
import com.translation.bean.Want;
import com.translation.service.CommentService;
import com.translation.service.DocumentService;
import com.translation.service.FriendService;
import com.translation.service.InviteService;
import com.translation.service.LoveService;
import com.translation.service.UserService;
import com.translation.service.WantService;
import com.translation.utils.Pager;

/**
 * 文档Controller
 * @author 浩然
 *
 */
@Controller
@RequestMapping("/document")
public class DocumentController {
	
	static int maxCount = 50;
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LoveService loveService;
	
	@Autowired
	private WantService wantService;
	
	@Autowired
	private FriendService friendService;
	
	
	@Autowired
	private InviteService inviteService;
	/**
	 * 添加文档 转发
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=add",method=RequestMethod.GET)
	public String add(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			List<Friend> friendList = friendService.getByPrimId(user.getUserid());
			for(Friend friend:friendList)
			{
				friend.setGuestUser(userService.getByKey(friend.getGuestid()));
			}
			model.addAttribute("followList", friendList);
			model.addAttribute("user", userService.getByKey(user.getUserid()));
			return "document/add";
		}else
		{
			model.addAttribute("msg", "请登录！");
			return "error";
		}
	}
	
	/**
	 * 添加业务
	 * @param session
	 * @param model
	 * @param document
	 * @return
	 */
	@RequestMapping(params="method=add",method=RequestMethod.POST)
	public String add(HttpSession session,Model model,Document document,String guestIdStr){
		try{
			User user = (User) session.getAttribute("user");
			document.setUserid(user.getUserid());
			
			Integer docid = documentService.addRet(document);
			
			//为文档分配积分
			distribPoint(user,document);
			
			
			//添加邀请信息
			if(guestIdStr!="")
				invite(guestIdStr,docid);
			
			return "redirect:/document?method=list";
		}catch(Exception e){
			System.out.println(e);
			return "error";
		}
		
	}
	
	
	/**
	 * 用户减去相应的积分
	 * @param docid
	 */
	private void distribPoint(User user,Document document) {
		user.setPoint(user.getPoint()-document.getPoint());
		userService.update(user);
		
		
	}

	/**
	 * 获取vo列表
	 * @param session
	 * @param model
	 * @return
	 */
//	@RequestMapping(params="method=list",method=RequestMethod.GET)
//	public String list(HttpSession session,Model model){
//		User user = (User) session.getAttribute("user");
//		if(user!=null){
//			List<Document> documentList = documentService.getAll(user.getUserid());
//			model.addAttribute("documentList", documentList);
//			return "document/list";
//		}
//		return "error";
//	}
	
	
	/**
	 * 添加邀请信息
	 * @param guestIdStr
	 */
	private void invite(String guestIdStr,Integer docid) {
		String guestIdArray[] = guestIdStr.split(";");
		for(String guestId:guestIdArray){
			Integer guestid = new Integer(guestId);
			Invite invite = new Invite();
			invite.setGuestid(guestid);
			invite.setDocid(docid);
			inviteService.add(invite);
		}
		
	}

	/**
	 * 分页获取最新求译列表
	 * 登录后文档首页的转发
	 * @param session
	 * @param model
	 * @param paraPage
	 * @return
	 */
	@RequestMapping(params="method=index",method=RequestMethod.GET)
	public String index(HttpSession session,Model model,Pager<Document> paraPage){
		User user = (User) session.getAttribute("user");
		if(paraPage==null)
			paraPage = new Pager<Document>();
		if(user!=null){
			int totleCount = documentService.getAllCount();
			Pager<Document> page = new Pager<Document>(totleCount,paraPage.getCurPage(),paraPage.getCountPerPage());
			List<Document> documentList = documentService.getByPage(page.getStartCount(), page.getCountPerPage());
			page.settList(documentList);
			
			model.addAttribute("hotDocList", getHotDoc());
			model.addAttribute("hotComList", getHotCom());
			
			
			model.addAttribute("user", user);
			model.addAttribute("page", page);
			return "user/index";
		}
		return "error";
	}
	
	
	/**
	 * 获取热门翻译
	 * @return
	 */
	private List<Comment> getHotCom() {
		List<Love> loveList = loveService.getByGroup();
		List<Comment> commList = new ArrayList<Comment> ();
		for(Love love:loveList){
			commList.add(commentService.getById(love.getCommid()));
		}
		return commList;
	}

	/**
	 * 获取热门文档
	 * @return
	 */
	private List<Document> getHotDoc(){
		List<Want> wantList= wantService.getByGroup();
		List<Document> hotDocList = new ArrayList<Document>();
		for(Want want:wantList){
			hotDocList.add(documentService.getById(want.getDocid()));
		}
		return hotDocList;
	}
	
	/**
	 * vo分页获取文档列表
	 * @param session
	 * @param model
	 * @param curPage
	 * @param countPerPage
	 * @return
	 */
	@RequestMapping(params="method=list",method=RequestMethod.GET)
	public String list(HttpSession session,Model model,Pager<Document> paraPage,String target){
		User user = (User) session.getAttribute("user");
		
		//默认情况		
		if(paraPage==null){
			paraPage = new Pager<Document> ();
		}
		if(user!=null)
		{
			int totleCount = documentService.getAllCount(user.getUserid());
			
			Pager<Document> page = new Pager<Document> (totleCount,paraPage.getCurPage(),paraPage.getCountPerPage());
			
			List<Document> documentList = documentService.getByPage(page.getStartCount(), page.getCountPerPage(), user.getUserid());
			page.settList(documentList);
			model.addAttribute("user", user);
			model.addAttribute("page", page);
			model.addAttribute("target", target);
			return "user/vo_index";
		}
		else return "error";
		
	}
	
	
	/**
	 * 处理搜索请求
	 * @param session
	 * @param model
	 * @param str
	 * @return
	 */
	@RequestMapping(params="method=search",method=RequestMethod.POST)
	public String search(HttpSession session,Model model,String str,Pager<Document> paraPage){
		User user = (User) session.getAttribute("user");
		if(paraPage==null){
			paraPage = new Pager<Document> ();
		}
		if(user!=null){
			int totleCount = documentService.getCountByStr(str);
			Pager<Document> page = new Pager<Document> (totleCount,paraPage.getCurPage(),paraPage.getCountPerPage());
			List<Document> documentList = documentService.getByStr(page.getStartCount(), page.getCountPerPage(), str);
			if(documentList.isEmpty())
			{
				model.addAttribute("msg", "搜索不到'"+str+"'相关内容");
			}else {
				page.settList(documentList);
				model.addAttribute("msg", "搜索'"+str+"'相关的结果");
				model.addAttribute("page", page);
			}
			model.addAttribute("user", user);
			return "document/search_result";
			
		}
		else{
			model.addAttribute("msg", "请登录");
			return "error";
		}
	}
	
	/**
	 * 显示详细内容
	 * @param session
	 * @param model
	 * @param docid
	 * @return
	 */
	@RequestMapping(params="method=show",method=RequestMethod.GET)
	public String show(HttpSession session,Model model,int docid,Pager<Comment> paraPage){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			Document document = documentService.getById(docid);
			if(document!=null){
				if(paraPage==null)
					paraPage = new Pager<Comment>();
				int totleCount = commentService.getAllCount(docid);
				
					
				Pager<Comment> page = new Pager<Comment>(totleCount, paraPage.getCurPage(), paraPage.getCountPerPage());
				List<Comment> commentList = commentService.getByPage(page.getStartCount(), page.getCountPerPage(), docid);
				if(commentList.isEmpty())
					model.addAttribute("msg", "当前还没人翻译，译一下");
				else{
					//为comment设置User字段
					for(Comment comment:commentList){
						comment.setUser(userService.getByKey(comment.getUserid()));
						comment.setLikeTime(loveService.CountByComment(comment.getComid()));
						//如果当前session与该评论的user相同，则可以删除
						if(comment.getUserid().equals(user.getUserid()))
							comment.setCanDel("1");
					}
					

					Comment comment = commentService.getByDocAndAc(document.getDocid());
					//还没接受则可以接受
					if(comment==null){
						//如果当前session与此篇文档的用户相同，则可以进行接受操作
						if(document.getUserid().equals(user.getUserid()))
							model.addAttribute("canAcc", "1");							
					}else {
						comment.setUser(userService.getByKey(comment.getUserid()));
						comment.setLikeTime(loveService.CountByComment(comment.getComid()));
						if(comment.getUserid().equals(user.getUserid()))
							comment.setCanDel("1");
						model.addAttribute("accComment", comment);
					}

					
					
					page.settList(commentList);					
					model.addAttribute("msg", "已有翻译");
				}
				model.addAttribute("page", page);
				User author = userService.getByKey(document.getUserid());
				model.addAttribute("user", user);
				model.addAttribute("document", document);
				model.addAttribute("author", author);
				model.addAttribute("wantCount", wantService.countByDoc(docid));
				return "document/show";
			}
		}
		return "error";
	}
	
	
	/**
	 * 删除Controller
	 * @param session
	 * @param model
	 * @param docid
	 * @return
	 */
	@RequestMapping(params="method=delete",method=RequestMethod.GET)
	public String delete(HttpSession session,Model model,Integer docid){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			Document document = documentService.getById(docid);
			
			documentService.delete(docid);
			//回滚积分
			retPoint(user,document);
			
			model.addAttribute("user", user);
			return "redirect:document?method=list";
		}
		else return "error";
	}
	
	/**
	 * 回滚积分
	 * @param user
	 * @param document
	 */
	private void retPoint(User user, Document document) {
		user.setPoint(user.getPoint()+document.getPoint());
		userService.update(user);
		
		
	}

	/**
	 * 修改页面转发
	 * @param session
	 * @param model
	 * @param docid
	 * @return
	 */
	@RequestMapping(params="method=modify",method=RequestMethod.GET)
	public String modify(HttpSession session,Model model,Integer docid){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			Document document = documentService.getById(docid);
			model.addAttribute("document", document);
			model.addAttribute("user", user);
			return "document/modify";
		}else return "error";
	}
	
	/**
	 * 修改主流程
	 * @param session
	 * @param model
	 * @param document
	 * @return
	 */
	@RequestMapping(params="method=modify",method=RequestMethod.POST)
	public String modify(HttpSession session,Model model,Document document){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			document.setUserid(user.getUserid());
			documentService.update(document);
			model.addAttribute("user", user);
			model.addAttribute("msg", "更新成功!");
			return "redirect:document?method=list";
		}else return "error";
	}
	
	
	/**
	 * 获取其他用户document列表
	 * @param model
	 * @param userid
	 * @return
	 */
	@RequestMapping(params="method=guest_user_list",method=RequestMethod.GET)
	public String guestUserList(Model model,Integer userid){
		List<Document> guestDocumentList = documentService.getByPage(0, maxCount, userid);
		model.addAttribute("guestDocumentList", guestDocumentList);
		return "templet/guest_user/document";
	}
	
}
