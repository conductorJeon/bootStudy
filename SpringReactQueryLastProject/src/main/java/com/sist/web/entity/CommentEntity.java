package com.sist.web.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comment_3")
@Data
@DynamicInsert
@DynamicUpdate
public class CommentEntity {
	@Id
	private int no;
	
	@Column(updatable = false, insertable = true)
	private int cno;
	
	@Column(updatable = false, insertable = true)
	private String id;
	
	@Column(updatable = false, insertable = true)
	private String name;
	private String msg;
	
	@Column(updatable = false, insertable = true)
	private Date regdate;
}
