package com.translation.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







import com.translation.bean.Love;
import com.translation.bean.LoveExample;
import com.translation.bean.LoveExample.Criteria;
import com.translation.dao.LoveDAO;


@Service
public class LoveService {
	
	@Resource
	private LoveDAO loveDAO;
	
	/**
	 * 插入一条Like信息
	 * @param like
	 */
	@Transactional
	public void add(Love love){
		loveDAO.insertSelective(love);
		
	}
	
	
	/**
	 * 更新love信息
	 * @param love
	 */
	@Transactional
	public void update(Love love){
		loveDAO.updateByPrimaryKeySelective(love);
	}
	
	/**
	 * 由commid获取like的数量
	 * @param commid
	 * @return
	 */
	public int CountByComment(Integer commid){
		LoveExample likeExample = new LoveExample();
		Criteria criteria = likeExample.createCriteria();
		criteria.andCommidEqualTo(commid);
		return loveDAO.countByExample(likeExample);
	}
	
	/**
	 * 获取热门翻译
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Love> getByGroup(){
		LoveExample loveExample = new LoveExample();
		loveExample.setOrderByClause("count(*) desc");
		return loveDAO.selectByGroup(loveExample, 0, 5);
	}
	
	
	/**
	 * 获取新的comment数量
	 * @param commid
	 * @return
	 */
	public int CountByCommentNew(Integer commid){
		LoveExample likeExample = new LoveExample();
		Criteria criteria = likeExample.createCriteria();
		criteria.andCommidEqualTo(commid);
		criteria.andIsnewEqualTo("0");
		return loveDAO.countByExample(likeExample);
	}
	
	
	/**
	 * 根据commid获得新的Love
	 * @param commid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Love> getByComNew(Integer commid,int startCounts,int maxCounts){
		LoveExample likeExample = new LoveExample();
		Criteria criteria = likeExample.createCriteria();
		criteria.andCommidEqualTo(commid);
		criteria.andIsnewEqualTo("0");
		return loveDAO.selectByPage(likeExample, startCounts, maxCounts);
	}
	
	/**
	 * 根据commid获得新的Love
	 * @param commid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Love> getByCom(List<Integer> commIdList,int startCounts,int maxCounts){
		LoveExample likeExample = new LoveExample();
		Criteria criteria = likeExample.createCriteria();
		List<Love> loveList = new ArrayList<Love>();
		if(!commIdList.isEmpty()){
			criteria.andCommidIn(commIdList);
			likeExample.setOrderByClause("creattime desc");
			loveList = loveDAO.selectByPage(likeExample, startCounts, maxCounts);
		}
		return loveList;
	}
}
