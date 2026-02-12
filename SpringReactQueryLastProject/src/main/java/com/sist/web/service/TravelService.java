package com.sist.web.service;

import java.util.List;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommonsDTO;

public interface TravelService {
	public CommonsDTO seoulMainData();
	public List<CommonsDTO> seoulMainListData();
	public List<CommonsDTO> busanMainListData();
	public List<CommonsDTO> jejuMainListData();
	
	public List<AttractionDTO> jejeuAttractionData(int start);
	public int jejuTotalPage(int contenttype);
	public AttractionDTO jejuAttractionDetailData(int contentid);
}
