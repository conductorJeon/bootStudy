package com.sist.web.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.RecipeService;
import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeRestController {
	private final RecipeService rService;
	
	@GetMapping("/recipe/list_vue/")
	public ResponseEntity<Map<String, Object>> recipe_vlist(@RequestParam("page") int page) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<RecipeVO> list = rService.recipeListData((page - 1) * 12);
			int totalpage = rService.recipeTotalPage();
			
			final int BLOCK = 10;
			int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
			int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;
			
			if(endPage > totalpage) {
				endPage = totalpage;
			}
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/recipe/detail_vue/")
	public ResponseEntity<Map<String, Object>> recipe_detail_vue(
			@RequestParam("no") int no) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			RecipeDetailVO vo = rService.recipeDetailData(no);
			
			String[] datas = vo.getFoodmake().split("\n");
			
			List<String> tList = new ArrayList<>();
			List<String> iList = new ArrayList<>();

			for (String s:datas) {
				StringTokenizer st = new StringTokenizer(s, "^");
				
				tList.add(st.nextToken());
				iList.add(st.nextToken());
			}
			
			map.put("vo", vo);
			map.put("tList", tList);
			map.put("iList", iList);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
































