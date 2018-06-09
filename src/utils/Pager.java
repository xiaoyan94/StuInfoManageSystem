package utils;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {
	private static final long serialVersionUID = 3036527896208983493L;
	private Long totalCount;//总记录数
	private int totalPage;//总页数
	private int currentPage;//当前页
	private int pageSize;//每页显示几条数据
	private List<T> dataList;//当前页的数据
	public Long getTotalCount() {
		return totalCount;
	}
	private void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	private void setTotalPage() {
		this.totalPage = (int) Math.ceil(1.0*totalCount / pageSize);;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	private void setCurrentPage(int currentPage) {
		if(currentPage < 1) {
			this.currentPage = 1;
		}else if(currentPage > totalPage){
			this.currentPage = totalPage;
		}else {
			this.currentPage = currentPage;
		}
		
	}
	public int getPageSize() {
		return pageSize;
	}
	private void setPageSize(int pageSize) {
		if(pageSize < 1) {
			this.pageSize = 10;
		}else {
			this.pageSize = pageSize;
		}
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	/**
	 * 
	 * @param totalCount 总记录数
	 * @param currentPage 当前页
	 * @param pageSize 每页记录数
	 */
	public Pager(Long totalCount, int currentPage, int pageSize) {
		super();
		setTotalCount(totalCount);
		setPageSize(pageSize);
		setTotalPage();
		setCurrentPage(currentPage);
	}
//	public Pager() {
//		
//	}
	@Override
	public String toString() {
		return "Pager [totalCount=" + totalCount + ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", dataList=" + dataList + "]";
	}
	
}
