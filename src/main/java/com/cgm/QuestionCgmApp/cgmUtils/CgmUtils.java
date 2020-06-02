package com.cgm.QuestionCgmApp.cgmUtils;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Nahla.KHAIREDDINE
 * @since 02-06-2020
 */

public class CgmUtils {

	/**
	 * @return String This return the user input
	 */

	public static String getInputFromKeybord() {

		Scanner input = new Scanner(System.in);
		return input.nextLine().trim();
	}

	/**
	 * 
	 * @param answer
	 * @return Boolean This return true in case the answer is between a quotation
	 *         marks otherwise it returns false
	 */

	public static boolean isValidQuotationMark(String answer) {

		Stack<Character> st = new Stack<Character>();

		if (!answer.startsWith("“") || !answer.endsWith("”"))
			return false;

		for (int i = 0; i < answer.length(); i++) {

			if (answer.charAt(i) == '“')
				st.push(answer.charAt(i));

			if (answer.charAt(i) == '”') {

				if (st.isEmpty()) {
					return false;
				}

				else if (!(st.pop() == '“' && answer.charAt(i) == '”')) {
					return false;
				}
			}

		}

		if (st.isEmpty())
			return true;
		else {
			return false;
		}
	}

	/**
	 * 
	 * @param input
	 * @return Boolean This return true in case the string has max 255 chars,
	 *         otherwise it returns false
	 */
	public static boolean isMax255Chars(String input) {
		return input.length() < 255;
	}
}
