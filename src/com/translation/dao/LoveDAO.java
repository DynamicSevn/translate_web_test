package com.translation.dao;

import com.translation.bean.Love;
import com.translation.bean.LoveExample;
import java.util.List;

public interface LoveDAO {
	
	
	
	/**
	 * @author 浩然
	 * @param example
	 * @param startCounts
	 * @param maxCounts
	 * @return
	 */
	public List selectByGroup(LoveExample example,int startCounts,int maxCounts);
	
	
	/**
	 * @author 浩然
	 * @param example
	 * @param startCounts
	 * @param maxCounts
	 * @return
	 */
	public List selectByPage(LoveExample example,int startCounts,int maxCounts);
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    int countByExample(LoveExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    int deleteByExample(LoveExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    int deleteByPrimaryKey(Integer likeid);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    void insert(Love record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    void insertSelective(Love record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    List selectByExample(LoveExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    Love selectByPrimaryKey(Integer likeid);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    int updateByExampleSelective(Love record, LoveExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    int updateByExample(Love record, LoveExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    int updateByPrimaryKeySelective(Love record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table love
     *
     * @ibatorgenerated Thu Apr 16 22:47:44 CST 2015
     */
    int updateByPrimaryKey(Love record);
}