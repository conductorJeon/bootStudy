package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.MusicVO;

@Mapper
@Repository
public interface MusicMapper {
	public List<MusicVO> muiscListData(int start);
	public int musicTotalPage();
	public String musicGetTitle(int no);
}
