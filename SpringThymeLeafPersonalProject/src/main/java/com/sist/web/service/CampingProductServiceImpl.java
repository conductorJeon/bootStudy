package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.CampingProductMapper;
import com.sist.web.vo.CampingProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampingProductServiceImpl implements CampingProductService {
	private final CampingProductMapper mapper;

	@Override
	public List<CampingProductVO> campingProductListData(int start) {
		// TODO Auto-generated method stub
		return mapper.campingProductListData(start);
	}

	@Override
	public int campingProductTotalPage() {
		// TODO Auto-generated method stub
		return mapper.campingProductTotalPage();
	}

}
