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
import com.sist.web.dto.CommonsDTO;
import com.sist.web.dto.MemberDTO;
import com.sist.web.service.MemberService;
import com.sist.web.service.TravelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MainController {
	private final TravelService travelService;
	private final MemberService memberService;
	
	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> mainPage() {
		try {
			Map<String, Object> map = new HashMap<>();
			
			CommonsDTO mainData = travelService.seoulMainData();
			List<CommonsDTO> seoulList = travelService.seoulMainListData();
			List<CommonsDTO> busanList = travelService.busanMainListData();
			List<CommonsDTO> jejuList = travelService.jejuMainListData();
			
			map.put("mainData", mainData);
			map.put("seoulList", seoulList);
			map.put("busanList", busanList);
			map.put("jejuList", jejuList);
			
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/member/login/{id}/{pwd}")
	public ResponseEntity<MemberDTO> member_login(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
		try {
			MemberDTO dto = memberService.memberLogin(id, pwd);
			
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
