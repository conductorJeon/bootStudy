package com.sist.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sist.web.service.MailService;

import jakarta.mail.MessagingException;

@SpringBootTest
class SpringJunitProject2ApplicationTests {
	@Autowired
	private MailService mService;
	
	/*
	 * @Test public void mailTextSend() {
	 * mService.sendTextMail("hotsushi3021@naver.com", "메일 보내기 연습", "메일 전송 성공"); }
	 */
	
	@Test
	public void mailHtmlSend() throws MessagingException {
		String html = """
				<html>
				<body>
					<h2>회원 가입을 축하합니다</h2>
					<img src="">
					<a href="/">클릭</a>
				</body>
				</html>
				""";
		//mService.sendHtmlMain("vcandjava@naver.com", "중번당 회원가입을 축하합니다", html);
	}

	/*
	 * @Test void contextLoads() { }
	 */

}
