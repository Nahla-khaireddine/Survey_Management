package com.cgm.QuestionCgmApp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cgm.QuestionCgmApp.cgmUtils.CgmUtils;

public class CgmUtilsTest {

	@Test
	public void testIsValidQuotationMark() {

		assertEquals(true, CgmUtils.isValidQuotationMark("“<answer1>”"));
		assertEquals(false, CgmUtils.isValidQuotationMark("<answer1>"));
		assertEquals(true, CgmUtils.isValidQuotationMark("“<answer1>” “<answer2>” “<answerX>”"));
		assertEquals(false, CgmUtils.isValidQuotationMark("“<answer1>” “<answer2>” “<answerX>"));
		assertEquals(false, CgmUtils.isValidQuotationMark("<answer1>” “<answer2>” “<answerX>"));
	}

	@Test
	public void testIsMax255Chars() {

		String hasMoreThan255 = null;

		for (int i = 0; i < 300; i++) {
			hasMoreThan255 += "a";
		}
		assertEquals(false, CgmUtils.isMax255Chars(hasMoreThan255));
		assertEquals(true, CgmUtils.isMax255Chars("Has less than 255"));
	}

}
