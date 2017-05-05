package cn.posolft.framework.web.jdbc;

import java.util.LinkedList;

import cn.posolft.manage.pojo.SortCond;

/**
 * 公共参数
 * @author Galen.Zhou
 */
public class CommonParam {

	private int page = 1;

	private int rows = 10;
	
	private int pageStart = 0;
	
	private int MAX_ROWS = Integer.MAX_VALUE;

	private LinkedList<SortCond> sortConds = new LinkedList<SortCond>();
	

	public CommonParam() {
		super();
	}
	
	public CommonParam(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
		this.pageStart = (page-1)*rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page > 0){
			this.page = page;
			this.pageStart = (page-1)*rows;
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		if (rows > 0){
			this.rows = rows;
			this.pageStart = (page-1)*rows;
		}
	}

	public LinkedList<SortCond> getSortConds() {
		return sortConds;
	}

	public void setSortConds(LinkedList<SortCond> sortConds) {
		this.sortConds = sortConds;
	}
	
	public void addSortCond(SortCond sortCond) {
        if (this.sortConds != null) {
        	this.sortConds = new LinkedList<SortCond>();
        	this.sortConds.add(sortCond);
        }
    }
	
	public void setMaxRows(){
		this.rows=this.MAX_ROWS;
	}

	public int getPageStart() {
		return pageStart;
	}
}

