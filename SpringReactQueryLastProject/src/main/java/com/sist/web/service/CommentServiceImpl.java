package com.sist.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.CommentDTO;
import com.sist.web.entity.CommentEntity;
import com.sist.web.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;

	@Override
	public List<CommentDTO> commentListData(int contentid) {
		// TODO Auto-generated method stub
		return commentRepository.commentListData(contentid);
	}

	@Override
	public List<CommentDTO> commentInsert(CommentEntity vo) {
		// TODO Auto-generated method stub
		int no = commentRepository.maxNo();
		vo.setNo(no);
		vo.setRegdate(new Date());
		commentRepository.save(vo);
		return commentRepository.commentListData(vo.getCno());
	}

	@Override
	public List<CommentDTO> commentDelete(int no, int cno) {
		// TODO Auto-generated method stub
		CommentEntity vo = commentRepository.findByNo(no);
		commentRepository.delete(vo);
		return commentRepository.commentListData(cno);
	}

	@Override
	public List<CommentDTO> commentUpdate(int no, String msg) {
		// TODO Auto-generated method stub
		CommentEntity vo = commentRepository.findByNo(no);
		vo.setMsg(msg);
		commentRepository.save(vo);
		return commentRepository.commentListData(vo.getCno());
	}

}
