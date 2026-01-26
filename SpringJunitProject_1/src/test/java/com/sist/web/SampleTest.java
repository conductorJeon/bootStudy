package com.sist.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * 	JUnit 5
 * 	Spring Test
 * 	AssertJ
 * 
 * 	assertEquals 같은 값
 * 	assertTrue ture
 * 	assertNotNull null 판단
 */

public class SampleTest {
	
	@Test
	void testSum() {
		int result = 10;
		assertEquals(30, result);
	}
}
