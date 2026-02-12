package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommentDTO;
import com.sist.web.service.CommentService;
import com.sist.web.service.TravelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class jejuRestController {
	private final TravelService travelService;
	private final CommentService commentService;
	
	@GetMapping("/jeju/attraction/{page}")
	public ResponseEntity<Map<String, Object>> jeju_attraction(@PathVariable("page") int page) {
		try {
			Map<String, Object> map = new HashMap<>();
			
			List<AttractionDTO> list = travelService.jejeuAttractionData((page - 1) * 12);
			int totalpage = travelService.jejuTotalPage(12);
			
			final int BLOCK = 10;
			
			int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
			int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;
			
			if (endPage > totalpage) {
				endPage = totalpage;
			}
			
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("curpage", page);
			map.put("startPage", startPage);
			map.put("endPage", endPage);

			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/jeju/detail_react/{contentid}")
	public ResponseEntity<Map<String, Object>> jeju_detail(@PathVariable("contentid") int contentid) {
		try {
			Map<String, Object> map = new HashMap<>();
			AttractionDTO dto = travelService.jejuAttractionDetailData(contentid);
			List<CommentDTO> list = commentService.commentListData(contentid);
			
			map.put("dto", dto);
			map.put("comments", list);
			
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}





















