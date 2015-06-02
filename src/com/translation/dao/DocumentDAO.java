package com.translation.dao;

import com.translation.bean.Document;
import com.translation.bean.DocumentExample;

import java.util.List;

public interface DocumentDAO {
	
	
	/**
	 * @author 浩然
	 * @param startCount
	 * @param maxCount
	 * @param example
	 * @return
	 */
	public List selectByPage(int startCount,int maxCount,DocumentExample example);
	
	
	/**
	 * @author 浩然
	 * @param record
	 * @return
	 */
	public Integer insertSelectiveRet(Document record);
	
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    int countByExample(DocumentExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    int deleteByExample(DocumentExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    int deleteByPrimaryKey(Integer docid);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    void insert(Document record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    void insertSelective(Document record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    List selectByExample(DocumentExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    Document selectByPrimaryKey(Integer docid);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    int updateByExampleSelective(Document record, DocumentExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    int updateByExample(Document record, DocumentExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    int updateByPrimaryKeySelective(Document record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table document
     *
     * @ibatorgenerated Thu Apr 09 21:28:14 CST 2015
     */
    int updateByPrimaryKey(Document record);
}