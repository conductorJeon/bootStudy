package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> commentListData(Integer cno, Integer type);
	
	public void commentInsert(CommentVO vo);
	
	public void commentUpdate(Integer no, String msg);
	
	public void commentDelete(int no);
}
