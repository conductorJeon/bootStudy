package com.sist.web.vo;

import lombok.Data;

@Data
public class MusicVO {
	private int no, cno, idcrement, hit, likecount;
	private String title, singer, album, poster, state, key;
}
