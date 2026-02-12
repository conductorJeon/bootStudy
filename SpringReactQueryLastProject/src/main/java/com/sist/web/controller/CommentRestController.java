package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.CommentDTO;
import com.sist.web.entity.CommentEntity;
import com.sist.web.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CommentRestController {
	private final CommentService commentService;

	@PostMapping("/comment/insert")
	ResponseEntity<Map<String, Object>> commentInsert(@RequestBody CommentEntity vo) {
		try {
			Map<String, Object> map = new HashMap<>();
			List<CommentDTO> list = commentService.commentInsert(vo);
			map.put("comments", list);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/comment/delete/{no}/{cno}")
	ResponseEntity<Map<String, Object>> commentDelete(@PathVariable("no") int no, @PathVariable("cno") int cno) {
		try {
			Map<String, Object> map = new HashMap<>();
			List<CommentDTO> list = commentService.commentDelete(no, cno);
			map.put("comments", list);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/comment/update")
	ResponseEntity<Map<String, Object>> commentUpdate(@RequestBody CommentEntity vo) {
		try {
			Map<String, Object> map = new HashMap<>();
			List<CommentDTO> list = commentService.commentUpdate(vo.getNo(), vo.getMsg());
			map.put("comments", list);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
