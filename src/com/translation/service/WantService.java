package com.translation.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.translation.bean.Want;
import com.translation.bean.WantExample;
import com.translation.bean.WantExample.Criteria;
import com.translation.dao.WantDAO;


@Service
public class WantService {
	@Resource
	private WantDAO wantDAO;
	
	/**
	 * 添加want
	 * @param want
	 */
	@Transactional
	public void add(Want want){
		wantDAO.insertSelective(want);
		
	}
	
	/**
	 * 更新为不new
	 */
	public void update(){
		Want want = new Want();
		want.setIsnew("1");
		WantExample wantExample = new WantExample();
		Criteria criteria = wantExample.createCriteria();
		criteria.andIsnewEqualTo("0");
		wantDAO.updateByExampleSelective(want, wantExample);
	}
	
	/**
	 * 根据docid获取文档同求数量
	 * @param docid
	 * @return
	 */
	public int countByDoc(Integer docid){
		WantExample wantExample = new WantExample();
		Criteria criteria = wantExample.createCriteria();
		criteria.andDocidEqualTo(docid);
		return wantDAO.countByExample(wantExample);
		
	}
	
	
	/**
	 * 根据docid获取新的文档同求数量
	 * @param docid
	 * @return
	 */
	public int countByDocNew(Integer docid){
		WantExample wantExample = new WantExample();
		Criteria criteria = wantExample.createCriteria();
		criteria.andIsnewEqualTo("0");
		criteria.andDocidEqualTo(docid);
		return wantDAO.countByExample(wantExample);
		
	}
	
	
	/**
	 * 由want数量获取want信息(前5)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Want> getByGroup(){
		WantExample wantExample = new WantExample();
		wantExample.setOrderByClause("count(*) desc");
		return wantDAO.selectByGroup(wantExample, 0, 5);
	}
	
	
	
	/**
	 * 分页查询新的Want
	 * @param startCount
	 * @param maxCount
	 * @param docid
	 * @return
	 */
	public List<Want> getByPage(int startCount,int maxCount,List<Integer> docList){
		WantExample wantExample = new WantExample();
		wantExample.setOrderByClause("creattime desc");
		Criteria criteria = wantExample.createCriteria();
		List<Want> wantList = new ArrayList<Want>();
		if(!docList.isEmpty()){
			criteria.andDocidIn(docList);
			wantList = wantDAO.selectByPage(startCount,maxCount,wantExample);
		}
		return wantList;
	}
}
