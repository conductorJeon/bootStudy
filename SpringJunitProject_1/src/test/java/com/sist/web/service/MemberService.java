package com.sist.web.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	String hello(String name) {
		return "Hello " + name;
	}
}
