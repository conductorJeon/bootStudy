package com.sist.web.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DataBoardVO {
	private Date regdate;
	private int no, hit, filecount;
	private String name, subject, content, pwd, filename, filesize, dbday;
	private List<MultipartFile> files;
}
