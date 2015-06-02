package com.translation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.translation.bean.Document;
import com.translation.bean.DocumentExample;
import com.translation.bean.DocumentExample.Criteria;
import com.translation.dao.DocumentDAO;
/**
 * 文档Service类
 * @author 浩然
 *
 */

@Service
public class DocumentService {
	@Resource
	private DocumentDAO documentDAO;
	
	/**
	 * 添加一个文档
	 * @param document
	 */
	@Transactional
	public void add(Document document){
		documentDAO.insertSelective(document);
	}
	
	
	/**
	 * 添加并返回主键
	 * @param document
	 * @return
	 */
	@Transactional
	public Integer addRet(Document document){
		return documentDAO.insertSelectiveRet(document);
	}
	
	/**
	 * 删除文档
	 * @param docid
	 * @return
	 */
	@Transactional
	public int delete(Integer docid){
		return documentDAO.deleteByPrimaryKey(docid);
	}
	
	
	/**
	 * 修改文档
	 * @param document
	 */
	@Transactional
	public void update(Document document){
		documentDAO.updateByPrimaryKeySelective(document);
	}
	
	
	/**
	 * 由主键获取document
	 * @param docid
	 * @return
	 */
	public Document getById(int docid){
		return documentDAO.selectByPrimaryKey(docid);
	}
	
	/**
	 * 获取用户所有博文
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Document> getAll(Integer userid){
		DocumentExample documentExample = new DocumentExample();
		Criteria criteria = documentExample.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andDelflagEqualTo("0");
		List<Document> documentList = documentDAO.selectByExample(documentExample);
		return documentList;
	}
	
	
	/**
	 * 根据时间顺序获得所有博文
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Document> getAll(){
		DocumentExample documentExample = new DocumentExample();
		Criteria criteria = documentExample.createCriteria();
		documentExample.setOrderByClause("creattime");
		criteria.andDelflagEqualTo("0");
		List<Document> documentList = documentDAO.selectByExample(documentExample);
		return documentList;
	}
	
	/**
	 * 获取用户的文档数量
	 * @param userid
	 * @return
	 */
	public int getAllCount(Integer userid){
		DocumentExample documentExample = new DocumentExample();
		Criteria criteria = documentExample.createCriteria();
		criteria.andDelflagEqualTo("0");
		criteria.andUseridEqualTo(userid);
		return documentDAO.countByExample(documentExample);
	}
	
	/**
	 * 获取搜索结果的数量
	 */
	public int getCountByStr(String str){
		DocumentExample documentExample = new DocumentExample();
		Criteria criteria = documentExample.createCriteria();
		criteria.andDelflagEqualTo("0");
		criteria.andTitleLike("%"+str+"%");
		return documentDAO.countByExample(documentExample);
	}
	
	
	/**
	 * 获取搜索的结果
	 */
	@SuppressWarnings("unchecked")
	public List<Document> getByStr(int startCount,int maxCount,String str){
		DocumentExample documentExample = new DocumentExample();
		documentExample.setOrderByClause("edittime desc");
		Criteria criteria = documentExample.createCriteria();
		criteria.andTitleLike("%"+str+"%");
		criteria.andDelflagEqualTo("0");
		return documentDAO.selectByPage(startCount, maxCount,documentExample);
	}
	
	
	/**
	 * 分页获取用户文档
	 * @param startCount
	 * @param maxCount
	 * @param userid
	 * @return List 该页的文档List
	 */
	@SuppressWarnings("unchecked")
	public List<Document> getByPage(int startCount,int maxCount,Integer userid){
		DocumentExample documentExample = new DocumentExample();
		documentExample.setOrderByClause("edittime desc");
		Criteria criteria = documentExample.createCriteria();
		criteria.andDelflagEqualTo("0");
		criteria.andUseridEqualTo(userid);
		return documentDAO.selectByPage(startCount, maxCount, documentExample);
	}
	
	
	/**
	 * 获取所有文档的数量
	 * @return
	 */
	public int getAllCount(){
		DocumentExample documentExample = new DocumentExample();
		Criteria criteria = documentExample.createCriteria();
		criteria.andDelflagEqualTo("0");
		return documentDAO.countByExample(documentExample);
	}
	
	
	/**
	 * 分页获取所有文档
	 * @param startCount
	 * @param maxCount
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Document> getByPage(int startCount,int maxCount){
		DocumentExample documentExample = new DocumentExample();
		documentExample.setOrderByClause("edittime desc");
		Criteria criteria = documentExample.createCriteria();
		criteria.andDelflagEqualTo("0");
		return documentDAO.selectByPage(startCount, maxCount, documentExample);
	}
	
	
}
