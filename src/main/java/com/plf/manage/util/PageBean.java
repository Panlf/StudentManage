package com.plf.manage.util;

import java.util.List;

public class PageBean<T> {
	private int page;	// 当前页数
	private int totalCount; // 总记录数
	private int totalPage; // 总页数
	private int limit;	// 每页显示的记录数
	private List<T> list; // 每页显示数据的集合.
	private boolean isNext;//是否有下一页
	private boolean isPre;//是否有上一页
	
	public boolean isNext() {
		return isNext;
	}
	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}
	public boolean isPre() {
		return isPre;
	}
	public void setPre(boolean isPre) {
		this.isPre = isPre;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}	
}