package com.translation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.translation.bean.Friend;
import com.translation.bean.FriendExample;
import com.translation.bean.FriendExample.Criteria;
import com.translation.dao.FriendDAO;


@Service
public class FriendService {
	@Resource
	private FriendDAO friendDAO;
	
	
	/**
	 * 添加一条friend信息
	 * @param friend
	 */
	@Transactional
	public void add(Friend friend){
		friendDAO.insertSelective(friend);
		
	}
	
	
	/**
	 * 由我和我关注用户的id获得Friend
	 * @param primid
	 * @param guestid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Friend getBy2Id(Integer primid,Integer guestid){
		FriendExample friendExample = new FriendExample();
		Criteria criteria = friendExample.createCriteria();
		criteria.andPrimidEqualTo(primid);
		criteria.andGuestidEqualTo(guestid);
		List<Friend> friendList = friendDAO.selectByExample(friendExample);
		if(friendList.size()>0)
			return friendList.get(0);
		else return null;
		
	}


	
	/**
	 * 获取我关注的信息
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Friend> getByPrimId(Integer userid) {
		FriendExample friendExample = new FriendExample();
		Criteria criteria = friendExample.createCriteria();
		criteria.andPrimidEqualTo(userid);
		List<Friend> friendList = friendDAO.selectByExample(friendExample);
		
		return friendList;
	}
	
	
	
	/**
	 * 获取关注我的信息
	 * @param userid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Friend> getByGuestId(Integer userid){
		FriendExample friendExample = new FriendExample();
		Criteria criteria = friendExample.createCriteria();
		criteria.andGuestidEqualTo(userid);
		List<Friend> friendList = friendDAO.selectByExample(friendExample);
		
		return friendList;
	}


	@Transactional
	public void deleteById(Integer friendid) {
		friendDAO.deleteByPrimaryKey(friendid);
		
	}
	
}
