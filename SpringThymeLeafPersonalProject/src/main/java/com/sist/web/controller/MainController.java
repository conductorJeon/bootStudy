package com.sist.web.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.MainService;
import com.sist.web.vo.CampingProductVO;
import com.sist.web.vo.CampingVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final MainService mService;
	
	@GetMapping("/")
	public String main_main(Model model) {
		List<CampingVO> cList = mService.mainCampingData();
		
		List<CampingProductVO> cpList = mService.mainCampingProductData();
		DecimalFormat df = new DecimalFormat("###,###,###");
		for(CampingProductVO vo:cpList) {
			vo.setPrice((String) df.format(Integer.parseInt(vo.getPrice())));
		}
		
		model.addAttribute("cList", cList);
		model.addAttribute("cpList", cpList);
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
	
	@GetMapping("/login")
	public String main_login(Model model) {
		model.addAttribute("main_html", "main/login");
		return "main/main";
	}
}
