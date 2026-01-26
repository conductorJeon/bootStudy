package com.sist.web.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MovieVO;
import com.sist.web.vo.MusicVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MusicController {
	private final MusicService mService;
	
	@GetMapping("/")
	public String music_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		List<MusicVO> list = mService.musicListData((curpage - 1) * 20);
		int totalpage = mService.musicTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "list";
	}

	@GetMapping("/detail")
	public String music_detail(@RequestParam("no") int no, Model model) throws Exception {
		String title = mService.musicGetTitle(no);
		// Document doc = Jsoup.connect("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=28&q=" + title + "&type=video&key=AIzaSyDXjryVEBzNMR86WA1TTRhZNhPQmD-0nnY").get();
		URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=28&q=" + URLEncoder.encode(title, "UTF-8") + "&type=video&key=AIzaSyDXjryVEBzNMR86WA1TTRhZNhPQmD-0nnY");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		StringBuffer sb = new StringBuffer();
		if (conn != null) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			while(true) {
				String json = in.readLine();
				if (json == null) {
					break;
				}
				sb.append(json);
				//System.out.println(json);
			}
			conn.disconnect();
			in.close();
		}
		//System.out.println(sb.toString());
		org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
		JSONObject root = (JSONObject) parser.parse(sb.toString());
		//System.out.println(root.toJSONString());
		JSONArray arr = (JSONArray) root.get("items");
		
		List<MovieVO> list = new ArrayList<>();
		//System.out.println(arr.toJSONString());
		for(int i=0;i<arr.size();i++) {
			JSONObject obj = (JSONObject) arr.get(i);
			JSONObject snippet = (JSONObject) obj.get("snippet");
			title = (String) snippet.get("title");
			//System.out.println(title);
			JSONObject id = (JSONObject) obj.get("id");
			String key = (String) id.get("videoId");
			
			MovieVO vo = new MovieVO();
			vo.setTitle(title);
			vo.setKey(key);
			list.add(vo);
		}
		model.addAttribute("list", list);
		return "detail";
	}
}
