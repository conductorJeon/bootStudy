package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.CommentMapper;
import com.sist.web.vo.CommentVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentMapper mapper;

	@Override
	public List<CommentVO> commentListData(Integer cno, Integer type) {
		// TODO Auto-generated method stub
		return mapper.commentListData(cno, type);
	}

	@Override
	public void commentInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		mapper.commentInsert(vo);
	}

	@Override
	public void commentUpdate(Integer no, String msg) {
		// TODO Auto-generated method stub
		mapper.commentUpdate(no, msg);
	}

	@Override
	public void commentDelete(int no) {
		// TODO Auto-generated method stub
		mapper.commentDelete(no);
	}
}
