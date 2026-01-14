package com.sist.web.controller;

import java.io.File;
import java.util.StringTokenizer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.DataBoardService;
import com.sist.web.vo.DataBoardVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DataBoardRestController {
	private final DataBoardService dService;
	
	@DeleteMapping("/databoard/delete_ok")
	public String databoard_delete_ok(@RequestParam("no") int no, @RequestParam("pwd") String pwd, HttpServletRequest request) {
		DataBoardVO vo = dService.databoardFileInfo(no);
		String res = dService.databoardDelete(no, pwd);
		
		try {
			if (vo.getFilecount() != 0 && res.equals("yes")) {
				String delDir = request.getServletContext().getRealPath("/upload");
				StringTokenizer st = new StringTokenizer(vo.getFilename(), ",");
				
				while (st.hasMoreTokens()) {
					File file = new File(delDir + "/" + st.nextToken());
					file.delete();
				}
			}
		} catch (Exception e) {}
		
		return res;
	}
}
