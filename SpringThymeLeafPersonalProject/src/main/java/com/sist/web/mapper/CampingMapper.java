package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.CampingVO;

@Mapper
@Repository
public interface CampingMapper {
	@Select("SELECT id, name, image, street_address, rownum "
		  + "FROM camping "
		  + "WHERE rownum <= 4"
		  + "ORDER BY id DESC ")
	public List<CampingVO> mainCampingData();
	
	
	@Select("SELECT id, name, image "
		  + "FROM camping "
		  + "ORDER BY id ASC "
		  + "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<CampingVO> campingListData(int start);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM camping")
	public int campingTotalPage();
	
	@Update("UPDATE camping SET "
		  + "hit = hit + 1 "
		  + "WHERE id = #{id}")
	public void campingHitIncrement(int id);
	
	@Select("SELECT * FROM camping "
		  + "WHERE id = #{id}")
	public CampingVO campingDetailData(int id);
	
}
