package com.translation.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.translation.bean.Comment;
import com.translation.bean.CommentExample;
import com.translation.bean.CommentExample.Criteria;
import com.translation.dao.CommentDAO;




/**
 * CommentService
 * @author 浩然
 *
 */
@Service
public class CommentService {
	
	@Resource
	private CommentDAO commentDAO;
	
	/**
	 * 添加一个评论
	 * @param comment
	 */
	@Transactional
	public void add(Comment comment){
		commentDAO.insertSelective(comment);
	}
	
	
	@Transactional
	public void update(Comment comment){
		commentDAO.updateByPrimaryKeySelective(comment);
	}
	
	@Transactional
	public void delete(Integer comid){
		commentDAO.deleteByPrimaryKey(comid);
	}
	/**
	 * 根据主键获取一条记录
	 * @param commid
	 * @return
	 */
	public Comment getById(Integer commid){
		return commentDAO.selectByPrimaryKey(commid);
	}
	
	/**
	 * 获取该文档所有评论数
	 * @param docid
	 * @return
	 */
	public int getAllCount(Integer docid){	
		CommentExample commentExample = new CommentExample();
		Criteria criteria = commentExample.createCriteria();
		criteria.andDocidEqualTo(docid);
		return commentDAO.countByExample(commentExample);
	}
	

	/**
	 * 获取该用户的所有评论数
	 * @param userid
	 * @return
	 */
	public int getAllCount4User(Integer userid){	
		CommentExample commentExample = new CommentExample();
		Criteria criteria = commentExample.createCriteria();
		criteria.andUseridEqualTo(userid);
		return commentDAO.countByExample(commentExample);
	}
		
	
	/**
	 * 获取该用户文档的所有新的评论数
	 * @param userid
	 * @return
	 */
	public int getAllNewCount4Doc(Integer docid){	
		CommentExample commentExample = new CommentExample();
		Criteria criteria = commentExample.createCriteria();
		criteria.andDocidEqualTo(docid);
		criteria.andIsnewEqualTo("0");
		return commentDAO.countByExample(commentExample);
	}
	
	/**
	 * 分页获取同一文档的评论
	 * @param startCount
	 * @param maxCount
	 * @param docid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getByPage(int startCount,int maxCount,Integer docid){
		CommentExample commentExample = new CommentExample(); 
		Criteria criteria = commentExample.createCriteria();
		criteria.andDocidEqualTo(docid);
		
		commentExample.setOrderByClause("edittime desc");
		return commentDAO.selectByPage(startCount, maxCount, commentExample);
	}	
	
	
	
	
	/**
	 * 分页获取同一文档的评论
	 * @param startCount
	 * @param maxCount
	 * @param List docIdList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getByPage(int startCount,int maxCount,List<Integer> docIdList){
		List<Comment> commentList = new ArrayList<Comment>();
		if(!docIdList.isEmpty()){
			CommentExample commentExample = new CommentExample(); 
			Criteria criteria = commentExample.createCriteria();
			criteria.andDocidIn(docIdList);
			
			commentExample.setOrderByClause("edittime desc");
			commentList =  commentDAO.selectByPage(startCount, maxCount, commentExample);
		}
		return commentList;
	}
	
	
	
	/**
	 * 分页获取同一文档的新评论
	 * @param startCount
	 * @param maxCount
	 * @param docid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getNewByPage(int startCount,int maxCount,Integer docid){
		CommentExample commentExample = new CommentExample(); 
		Criteria criteria = commentExample.createCriteria();
		criteria.andDocidEqualTo(docid);
		criteria.andIsnewEqualTo("0");
		return commentDAO.selectByPage(startCount, maxCount, commentExample);
	}
	
	
	
	/**
	 * 分页获取同一用户的评论
	 * @param startCount
	 * @param maxCount
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getByPage4User(int startCount,int maxCount,Integer userid){
		CommentExample commentExample = new CommentExample(); 
		Criteria criteria = commentExample.createCriteria();
		criteria.andUseridEqualTo(userid);
		return commentDAO.selectByPage(startCount, maxCount, commentExample);
	}
	
	
	/**
	 * 分页获取同一用户<b>新的</b>评论
	 * @param startCount
	 * @param maxCount
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getByPage4UserNew(int startCount,int maxCount,Integer userid){
		CommentExample commentExample = new CommentExample(); 
		Criteria criteria = commentExample.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andIsnewEqualTo("0");
		return commentDAO.selectByPage(startCount, maxCount, commentExample);
	}


	/**
	 * 获取文档的Accept翻译
	 * @param docid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Comment getByDocAndAc(Integer docid) {
		CommentExample commentExample = new CommentExample();
		Criteria criteria = commentExample.createCriteria();
		criteria.andIsacceptEqualTo("1");
		criteria.andDocidEqualTo(docid);
		
		List<Comment> commentList =  commentDAO.selectByExample(commentExample);
		if(!commentList.isEmpty())
			return commentList.get(0);
		else return null;
		
	}

	/**
	 * 获取新的接受信息
	 * @param userid
	 * @return
	 */
	public int countAccNew(Integer userid) {
		CommentExample commentExample = new CommentExample();
		Criteria criteria = commentExample.createCriteria();
		criteria.andIsacceptEqualTo("1");
		criteria.andAcceptnewEqualTo("0");
		criteria.andUseridEqualTo(userid);
		return commentDAO.countByExample(commentExample);
	}
	
	/**
	 * 时间顺序获取所有接受信息
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getAccComment(Integer userid){
		CommentExample commentExample = new CommentExample();
		Criteria criteria = commentExample.createCriteria();
		criteria.andIsacceptEqualTo("1");
		criteria.andUseridEqualTo(userid);
		commentExample.setOrderByClause("edittime desc");
		return commentDAO.selectByExample(commentExample);
	}


	/**
	 * 更新accept的comment状态为已阅
	 */
	public void updateAcc(Integer userid) {
		Comment comment = new Comment();
		comment.setAcceptnew("1");
		CommentExample commentExample = new CommentExample();
		Criteria criteria = commentExample.createCriteria();
		criteria.andIsacceptEqualTo("1");
		criteria.andAcceptnewEqualTo("0");
		criteria.andUseridEqualTo(userid);
		
		commentDAO.updateByExampleSelective(comment, commentExample);
	}
	
}
