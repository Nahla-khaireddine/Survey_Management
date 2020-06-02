package com.cgm.QuestionCgmApp.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.cgm.QuestionCgmApp.domain.Answer;
import com.cgm.QuestionCgmApp.domain.Question;
import com.cgm.QuestionCgmApp.cgmConstants.SurveyConstant;
import com.cgm.QuestionCgmApp.cgmUtils.CgmUtils;

public class SurveyService {

	/**
	 * 
	 * @param question
	 * @param listQuestions
	 * @return String This return null in case the question was added successfully,
	 *         otherwise it returns the exception checked
	 */
	public String addQuestionAndAnswers(String question, ArrayList<Question> listQuestions) {

		ArrayList<Answer> listAnswers = new ArrayList<Answer>();

		if (CgmUtils.isMax255Chars(question)) {

			if (verifValidQuestion(question) == null) {

				String[] multipleAnswer = question.split("”");

				for (String singleAnswer : multipleAnswer)
					listAnswers.add(
							new Answer(singleAnswer.substring(singleAnswer.indexOf('“') + 1, singleAnswer.length())));

				listQuestions.add(new Question(question.substring(0, question.indexOf("?") + 1), listAnswers));

				return SurveyConstant.QST_ADDED;

			} else {
				return verifValidQuestion(question);
			}
		} else
			return SurveyConstant.QST_MAX_255_CHARS;
	}

	/**
	 * This method prints all answers for a given question
	 * 
	 * @param question
	 * @param listQuestions
	 * @return String This return null if the question exists, otherwise it returns
	 *         the checked exception
	 */
	public void askQuestion(String question, ArrayList<Question> listQuestions) {

		int indice = getIndiceAnswer(question, listQuestions);

		if (indice != -1) {

			for (int i = 0; i < listQuestions.get(indice).getListAnswers().size(); i++) {
				System.out.println(listQuestions.get(indice).getListAnswers().get(i).getContent());
			}

		} else
			System.out.println(SurveyConstant.HITCHHICKER_GUIDE_GALAXY);

		
	}

	/**
	 * @param answer
	 * @param listQuestions
	 * @return Int This return the index of a given question in the ListQuestion in
	 *         case the question exists, otherwise it returns -1
	 */
	public int getIndiceAnswer(String question, ArrayList<Question> listQuestions) {
		return listQuestions.stream().map(element -> element.getContent()).collect(Collectors.toList()).indexOf(question);
	}

	/**
	 * @param question
	 * @return String This return null in case the question is valid otherwise
	 *         return the checked exception
	 */

	public String verifValidQuestion(String question) {

		if (!question.contains("?")) {
			return SurveyConstant.QST_MARK;

		} else {

			// Verify if the question has answers
			String addedAnswer = question.substring(question.indexOf("?") + 1, question.length()).trim();

			if (CgmUtils.isMax255Chars(addedAnswer)) {

				if ("".equals(addedAnswer)) {

					return SurveyConstant.MIN_ANSWER;

				} else if (!CgmUtils.isValidQuotationMark(addedAnswer)) {

					return SurveyConstant.ANSWER_BTW_QUOTATION;
				}
			} else
				return SurveyConstant.ANS_MAX_255_CHARS;

		}

		return null;
	}

}
