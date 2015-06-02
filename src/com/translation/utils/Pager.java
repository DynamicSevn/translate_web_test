package com.translation.utils;

import java.util.List;


/**
 * 分页工具类
 * @author 浩然
 *
 * @param <T>
 */
public class Pager<T> {
	private List<T> tList=null;  //试题对象表
	private int totleCount = 0;  //总数
	private int countPerPage = 10; //默认每页显示数为10
	private int totlePage = 1; //总页数，空时为1
	private int curPage = 1; //当前页，默认为1，要作为参数传入构造函数
	private int startCount = 0; //当前页开始数，从0开始
	
	private boolean isFirstPage = false;//是否是第一页
	private boolean isLastPage = false;//是否是最后一页
	private boolean hasNextPage = true;//是否含有下一页
	private boolean hasFrontPage = true;//是否含有上一页
	
	
	/**
	 * 
	 */
	public Pager()
	{}
	
	/**
	 * 
	 * @param paraTotleCount 总记录数
	 * @param paraCurPage 当前页数
	 */
	public Pager(int paraTotleCount,int paraCurPage){
		init(paraTotleCount,paraCurPage,countPerPage);
	}
	
	/**
	 * 
	 * @param paraTotleCount 总记录数
	 * @param paraCurPage 当前页数
	 * @param paraCountPerPage 每页记录数
	 */
	public Pager(int paraTotleCount,int paraCurPage,int paraCountPerPage){
		init(paraTotleCount,paraCurPage,paraCountPerPage);
	}
	
	
	private void init(int paraTotleCount,int paraCurPage,int paraCountPerPage){
		totleCount = paraTotleCount;
		curPage = paraCurPage;
		countPerPage = paraCountPerPage;
		totlePage = (totleCount-1)/countPerPage+1;
		startCount = (curPage-1)*countPerPage;
		if(curPage==1){
			isFirstPage = true;
			hasFrontPage = false;
		}
		if(curPage==totlePage){
			isLastPage = true;
			hasNextPage = false;
		}
		
	}
	
	
	
	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasFrontPage() {
		return hasFrontPage;
	}

	public void setHasFrontPage(boolean hasFrontPage) {
		this.hasFrontPage = hasFrontPage;
	}

	public List<T> gettList() {
		return tList;
	}

	public void settList(List<T> tList) {
		this.tList = tList;
	}

	public int getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getTotlePage() {
		return totlePage;
	}

	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	
	
}
