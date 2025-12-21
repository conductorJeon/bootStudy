package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.CampingMapper;
import com.sist.web.mapper.CampingProductMapper;
import com.sist.web.vo.CampingProductVO;
import com.sist.web.vo.CampingVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
	private final CampingMapper cMapper;
	private final CampingProductMapper cpMapper;

	@Override
	public List<CampingVO> mainCampingData() {
		// TODO Auto-generated method stub
		return cMapper.mainCampingData();
	}

	@Override
	public List<CampingProductVO> mainCampingProductData() {
		// TODO Auto-generated method stub
		return cpMapper.mainCampingProductData();
	}

}
