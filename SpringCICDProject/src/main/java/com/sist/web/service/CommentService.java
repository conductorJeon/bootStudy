package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> replyListData(int cno, int type);
	public void replyInsert(CommentVO vo);
}
