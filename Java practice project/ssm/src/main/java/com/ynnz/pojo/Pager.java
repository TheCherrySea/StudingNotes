package com.ynnz.pojo;

import java.util.List;

/**
 * 分页组件类
 * 
 * @author 吕琼华
 *
 */
public class Pager<T> {

	private Integer total;// 总记录数(从数据库查)
	private Integer totalPage;// 总页数（计算得来）
	private Integer pageSize;// 每页显示的记录数（可以固定或前端页面传递）
	private Integer pageNumber;// 当前页号前端页面传递（前端页面传递）
	private Integer startPage;// 前端页面显示的起始页（计算来）
	private Integer endPage;// 前端页面显示的末尾页（计算来）

	private List<T> list;// 存放分页的数据

	private int startIndex;// 数据库查询的起始行号（计算来的）

	// 构造方法
	public Pager(Integer total, Integer pageSize, Integer pageNumber) {
		super();
		this.total = total;
		this.pageSize = (pageSize == null ? 5 : pageSize);
		this.pageNumber = pageNumber == null ? 1 : pageNumber;

		// 计算总页数
		if (this.total % this.pageSize > 0) {// 有余数，则页数为整除结果加1
			this.totalPage = this.total / this.pageSize + 1;
		} else {// 没有余数，则页数为整除结果
			this.totalPage = this.total / this.pageSize;
		}

		// 计算页面显示的起始页号和尾页号
		if (this.totalPage <= 5) {// 总页数小于等于5
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {// 总页数大于5
			if (this.pageNumber <= 2) {// 当前页小于等于2
				this.startPage = 1;
				this.endPage = 5;
			} else if (this.pageNumber > 2 && this.pageNumber <= this.totalPage - 2) {
				// 当前页码大于2并小于等于总页数-2
				this.startPage = this.pageNumber - 2;
				this.endPage = this.pageNumber + 2;
			} else {
				// 当前页码大于总页数-2
				//////////////////////////
				this.startPage = this.totalPage - 5;
				this.endPage = this.totalPage;
			}
		}

		this.startIndex = (this.pageNumber - 1) * this.pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
