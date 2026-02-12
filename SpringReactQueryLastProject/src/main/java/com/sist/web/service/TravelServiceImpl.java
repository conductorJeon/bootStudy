package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommonsDTO;
import com.sist.web.repository.BusanTravelRepository;
import com.sist.web.repository.JejuTravelRepository;
import com.sist.web.repository.SeoulTravelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {
	private final SeoulTravelRepository seoulTravelRepository;
	private final BusanTravelRepository busanTravelRepository;
	private final JejuTravelRepository jejuTravelRepository;

	@Override
	public CommonsDTO seoulMainData() {
		// TODO Auto-generated method stub
		return seoulTravelRepository.seoulMainData();
	}

	@Override
	public List<CommonsDTO> seoulMainListData() {
		// TODO Auto-generated method stub
		return seoulTravelRepository.seoulMainListData();
	}

	@Override
	public List<CommonsDTO> busanMainListData() {
		// TODO Auto-generated method stub
		return busanTravelRepository.busanMainListData();
	}

	@Override
	public List<CommonsDTO> jejuMainListData() {
		// TODO Auto-generated method stub
		return jejuTravelRepository.jejuMainListData();
	}

	@Override
	public List<AttractionDTO> jejeuAttractionData(int start) {
		// TODO Auto-generated method stub
		return jejuTravelRepository.jejeuAttractionData(start);
	}

	@Override
	public int jejuTotalPage(int contenttype) {
		// TODO Auto-generated method stub
		return jejuTravelRepository.jejuTotalPage(contenttype);
	}

	@Override
	public AttractionDTO jejuAttractionDetailData(int contentid) {
		// TODO Auto-generated method stub
		System.out.println(jejuTravelRepository.jejuAttractionDetailData(contentid));
		return jejuTravelRepository.jejuAttractionDetailData(contentid);
	}
}
