package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.CampingProductVO;
import com.sist.web.vo.CampingVO;

public interface MainService {
	public List<CampingVO> mainCampingData();
	public List<CampingProductVO> mainCampingProductData();
}
