package com.translation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.translation.bean.Invite;
import com.translation.bean.InviteExample;
import com.translation.bean.InviteExample.Criteria;
import com.translation.dao.InviteDAO;


@Service
public class InviteService {

	@Resource
	private InviteDAO inviteDAO;
	
	/**
	 * 添加一个Invite消息
	 * @param invite
	 */
	@Transactional
	public void add(Invite invite){
		inviteDAO.insertSelective(invite);
	}

	
	/**
	 * 获取新的invite信息数量
	 * @param userid
	 * @return
	 */
	public int countNew(Integer userid) {
		InviteExample inviteExample = new InviteExample();
		Criteria criteria = inviteExample.createCriteria();
		criteria.andGuestidEqualTo(userid);
		criteria.andIsnewEqualTo("0");
		return inviteDAO.countByExample(inviteExample);
	}

	

	/**
	 * 获取邀请用户的信息
	 * @param userid 这里是guestId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Invite> getByGuestId(Integer userid) {
		InviteExample inviteExample = new InviteExample();
		Criteria criteria = inviteExample.createCriteria();
		criteria.andGuestidEqualTo(userid);
		return inviteDAO.selectByExample(inviteExample);
	}


	/**
	 * 更新为已阅
	 */
	@Transactional
	public void updateIsNew() {
		Invite invite = new Invite();
		invite.setIsnew("1");
		InviteExample inviteExample = new InviteExample();
		Criteria criteria = inviteExample.createCriteria();
		criteria.andIsnewEqualTo("0");
		inviteDAO.updateByExampleSelective(invite, inviteExample);
		
	}
}
