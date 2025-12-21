package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.CampingProductVO;

@Mapper
@Repository
public interface CampingProductMapper {
	@Select("SELECT main_image, name, price, rownum "
		  + "FROM (SELECT main_image, name, price "
		  + "FROM camping_product ORDER BY product_code) "
		  + "WHERE rownum <= 4")
	public List<CampingProductVO> mainCampingProductData();
	
	@Select("SELECT main_image, name, price "
		  + "FROM camping_product "
		  + "ORDER BY product_code ASC "
		  + "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<CampingProductVO> campingProductListData(int start);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM camping_product")
	public int campingProductTotalPage();
}
