package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.BusanVO;

@Mapper
@Repository
public interface BusanMapper {
	public List<BusanVO> busanListData(Map map);
	public int busanTotalPage(Map map);
	
	@Update("UPDATE busantravel SET "
		  + "hit = hit + 1 "
		  + "WHERE no = #{no}")
	public void busanHitIncrement(int no);
	
	@Select("SELECT * FROM busantravel "
		  + "WHERE no = #{no}")
	public BusanVO busanDetailData(int no);
}
