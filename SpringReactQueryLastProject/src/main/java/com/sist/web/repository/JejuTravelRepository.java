package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommonsDTO;
import com.sist.web.entity.JejuTravel;

public interface JejuTravelRepository extends JpaRepository<JejuTravel, Integer> {
	@Query(value = "SELECT contentid, title, address, image1, hit, contenttype, rownum " + "FROM jejutravel "
			+ "ORDER BY hit DESC " + "OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY", nativeQuery = true)
	public List<CommonsDTO> jejuMainListData();
	
	@Query(value = "SELECT j.contentid, title, address, image1, hit, j.contenttype, infocenter,"
			+ " restdate, usetime, parking, DBMS_LOB.SUBSTR(msg, 48000, 1) as msg, x, y "
			+ "FROM jejutravel j JOIN attraction a ON j.contentid = a.contentid "
			+ "ORDER BY contentid ASC OFFSET :start ROWS FETCH NEXT 12 ROWS ONLY", nativeQuery = true)
	public List<AttractionDTO> jejeuAttractionData(@Param("start") int start);
	
	@Query(value = "SELECT CEIL(COUNT(*) / 12.0) FROM jejutravel WHERE contenttype = :contenttype", nativeQuery = true)
	public int jejuTotalPage(@Param("contenttype") int contenttype);
	
	@Query(value = """
			  SELECT 
			    j.contentid   AS contentid,
			    j.title       AS title,
			    j.address     AS address,
			    j.image1      AS image1,
			    j.hit         AS hit,
			    j.contenttype AS contenttype,
			    j.x           AS x,
			    j.y           AS y,
			    TO_CHAR(a.infocenter) AS infocenter,
			    a.restdate    AS restdate,
			    a.usetime     AS usetime,
			    a.parking     AS parking,
			    CAST(DBMS_LOB.SUBSTR(a.msg,4000,1) AS VARCHAR2(4000)) AS msg
			  FROM jejutravel j
			  JOIN attraction a
			    ON j.contentid = a.contentid
			  WHERE j.contentid = :contentid
			""", nativeQuery = true)
			AttractionDTO jejuAttractionDetailData(@Param("contentid") int contentid);
}
