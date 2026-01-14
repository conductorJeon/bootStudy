package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.DataBoardVO;

public interface DataBoardService {
	public List<DataBoardVO> databoardListData(int start);
	
	public int databoardTotalPage();
	
	public void databoardInsert(DataBoardVO vo);
	
	public DataBoardVO databoardDetailData(int no);
	
	public String databoardDelete(int no, String pwd);
	
	public DataBoardVO databoardFileInfo(int no);
}
