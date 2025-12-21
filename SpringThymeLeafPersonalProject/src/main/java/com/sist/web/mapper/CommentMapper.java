package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.CommentVO;

@Mapper
@Repository
public interface CommentMapper {
	@Select("SELECT no, cno, type, id, name, msg, "
		  + "TO_CHAR(regdate, 'yyyy-mm-dd hh24:mi:ss') as dbday "
		  + "FROM comment_3 "
		  + "WHERE cno = #{cno} AND type = #{type} "
		  + "ORDER BY no DESC")
	public List<CommentVO> commentListData(@Param("cno") Integer cno, @Param("type") Integer type);
	
	@SelectKey(keyProperty = "no", resultType = int.class, before = true, statement = 
			"SELECT NVL(MAX(no) + 1, 1) FROM comment_3")
	@Insert("INSERT INTO comment_3 SET "
		  + "#{no}, #{cno}, #{type}, #{id}, #{name}, #{msg}, SYSDATE)")
	public void commentInsert(CommentVO vo);
	
	@Update("UPDATE comment_3 SET "
		  + "msg = #{msg} "
		  + "WHERE no = #{no}")
	public void commentUpdate(@Param("no") Integer no, @Param("msg") String msg);
	
	@Delete("DELETE FROM comment_3 "
		  + "WHERE no = #{no}")
	public void commentDelete(int no);
}
