package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ReplyMapper;
import com.sist.web.vo.CommentVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final ReplyMapper mapper;

	@Override
	public List<CommentVO> replyListData(int cno, int type) {
		// TODO Auto-generated method stub
		return mapper.replyListData(cno, type);
	}

	@Override
	public void replyInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		mapper.replyInsert(vo);
	}
	
}
