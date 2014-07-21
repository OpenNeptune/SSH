package core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Summary: 
 * 		一个通用的分页信息类实体
 * 
 */

@SuppressWarnings("unused")
public class EntryPage {
	
	// 要返回的某一页的记录列表
	private List<Object> list = new ArrayList<Object>(); 

	// 总记录数
	private int allRow =0; 
	
	// 总页数
	private int totalPage =0; 
	
	// 当前页
	private int currentPage =1;
	
	// 每页记录数
	private int pageSize =100;
	
	// 链接增加的字符参数
	private String strpage; 

	// 是否为第一页
	private boolean isFirstPage =false;
	
	// 是否为最后一页
	private boolean isLastPage = false;
	
	// 是否有前一页
	private boolean hasPreviousPage =false;
	
	// 是否有下一页
	private boolean hasNextPage = false;
	
	private int offset = 1;
	

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getStrpage() {
		return strpage;
	}

	public void setStrpage(String strpage) {
		this.strpage = strpage;
	} 

	
    public boolean isFirstPage() {
        return currentPage == 1;    // 如是当前页是第1页
    }
    public boolean isLastPage() {
        return currentPage == totalPage;    //如果当前页是最后一页
    }
    public boolean isHasPreviousPage() {
        return currentPage != 1;        //只要当前页不是第1页
    }
    public boolean isHasNextPage() {
    	if(totalPage == 0){
    		return false;
    	}else{
    		return currentPage != totalPage; 
    	}
    }
    
    
    public void init(){
        this.isFirstPage = isFirstPage();
        this.isLastPage = isLastPage();
        this.hasPreviousPage = isHasPreviousPage();
        this.hasNextPage = isHasNextPage();
        totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1;
        offset = pageSize*(currentPage-1);
    }
}
