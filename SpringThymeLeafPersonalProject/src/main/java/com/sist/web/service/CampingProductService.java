package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.CampingProductVO;

public interface CampingProductService {
	public List<CampingProductVO> campingProductListData(int start);
	public int campingProductTotalPage();
}
