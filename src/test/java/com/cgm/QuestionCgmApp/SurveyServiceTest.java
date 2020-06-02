package com.cgm.QuestionCgmApp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.cgm.QuestionCgmApp.cgmConstants.SurveyConstant;
import com.cgm.QuestionCgmApp.domain.Answer;
import com.cgm.QuestionCgmApp.domain.Question;
import com.cgm.QuestionCgmApp.services.SurveyService;

public class SurveyServiceTest {

	SurveyService ss = new SurveyService();

	@Test
	public void testAddQuestionAndAnswers() {

		ArrayList<Question> listQuestions = new ArrayList<Question>();

		assertEquals(SurveyConstant.QST_ADDED, ss
				.addQuestionAndAnswers("What is Peters favorite food? “Pizza” “Spaghetti” “Ice cream”", listQuestions));

	}

	@Test
	public void testAskQuestion() {

		ArrayList<Answer> listAnswers = new ArrayList<Answer>();
		ArrayList<Question> listQuestions = new ArrayList<Question>();

		listAnswers.add(new Answer("Pizza"));
		listAnswers.add(new Answer("Spaghetti"));
		listAnswers.add(new Answer("Ice cream"));

		listQuestions.add(new Question("What is Peters favorite food?", listAnswers));

		assertEquals(null, ss.askQuestion("What is Peters favorite food?", listQuestions));

		assertEquals(SurveyConstant.HITCHHICKER_GUIDE_GALAXY,
				ss.askQuestion("What is Nahla favorite food?", listQuestions));

	}

	@Test
	public void testGetIndiceAnswer() {

		ArrayList<Answer> listAnswers = new ArrayList<Answer>();
		ArrayList<Question> listQuestions = new ArrayList<Question>();

		listAnswers.add(new Answer("Pizza"));
		listAnswers.add(new Answer("Spaghetti"));
		listAnswers.add(new Answer("Ice cream"));

		listQuestions.add(new Question("What is Peters favorite food?", listAnswers));

		assertEquals(0, ss.getIndiceAnswer("What is Peters favorite food?", listQuestions));
		assertEquals(-1, ss.getIndiceAnswer("What is Nahla favorite food?", listQuestions));
	}

	@Test
	public void testVerifValidQuestion() {

		assertEquals(SurveyConstant.QST_MARK, ss.verifValidQuestion("Question without question mark"));

		assertEquals(SurveyConstant.MIN_ANSWER, ss.verifValidQuestion("Question without answer ?"));

		assertEquals(null, ss.verifValidQuestion("Question with one answer ? “<answer1>” "));

		assertEquals(null,
				ss.verifValidQuestion("Question with multiple answers ? “<answer1>” “<answer2>” “<answerX>”"));
	}
}
