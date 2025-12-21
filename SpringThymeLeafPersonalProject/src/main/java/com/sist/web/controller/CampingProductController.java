package com.sist.web.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.CampingProductService;
import com.sist.web.vo.CampingProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/")
public class CampingProductController {
	private final CampingProductService cpService;
	
	@GetMapping("list")
	public String cp_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage - 1) * 12;
		
		List<CampingProductVO> list = cpService.campingProductListData(start);
		DecimalFormat df = new DecimalFormat("###,###,###");
		for(CampingProductVO vo: list) {
			vo.setPrice((String) df.format(Integer.parseInt(vo.getPrice())));
		}
		
		int totalpage = cpService.campingProductTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
		if (endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "product/list");
		return "main/main";
	}
}
