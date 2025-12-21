package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.CommentService;
import com.sist.web.vo.CommentVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentRestController {
	private final CommentService cService;
	
	public Map commonsData(int cno, int type) {
		Map map = new HashMap();
		List<CommentVO> list = cService.commentListData(cno, type);
		
		map.put("list", list);
		map.put("cno", cno);
		map.put("type", type);
		
		return map;
	}
	
	@GetMapping("/comment/list_vue/")
	public ResponseEntity<Map> comment_list(@RequestParam("cno") int cno, @RequestParam("type") int type) {
		Map map = new HashMap();
		
		try {
			map = commonsData(cno, type);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
