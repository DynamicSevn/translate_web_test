package com.translation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;








import com.translation.bean.User;
import com.translation.bean.UserExample;
import com.translation.bean.UserExample.Criteria;
import com.translation.dao.UserDAO;

@Service

public class UserService {	
	@Resource
	private UserDAO userDAO;
	
	/**
	 * 添加一个同户
	 * @param user
	 */
	@Transactional
	public void add(User user){
		userDAO.insertSelective(user);
	}
	
	
	/**
	 * 添加一个用户并返回主键
	 * @param user
	 * @return
	 */
	public Integer addRet(User user){
		return userDAO.insertSelectiveRet(user);
	}
	/**
	 * 更新用户
	 * @param user
	 */
	@Transactional
	public void update(User user){
		userDAO.updateByPrimaryKeySelective(user);
	}
	/**
	 * 由主键获得user
	 * @param userid
	 * @return
	 */
	public User getByKey(Integer userid){
		return userDAO.selectByPrimaryKey(userid);
	}
	
	
	/**
	 * 由用户名和密码查询user
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User getByNameAndPass(User user){
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> userList = userDAO.selectByExample(userExample);
		
		if(!userList.isEmpty())
			return userList.get(0);
		else return null;
	}
}
