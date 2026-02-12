package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	@Query(value = "SELECT COUNT(*) FROM member_3 "
		 + "WHERE id = :id", nativeQuery = true)
	public int memberIdCount(@Param("id") String id);
	
	// public int countById(String id)
	
	@Query(value = "SELECT id, name, pwd FROM member_3 "
			     + "WHERE id = :id", nativeQuery = true)
	public MemberEntity memberGetPassword(@Param("id") String id);
}
