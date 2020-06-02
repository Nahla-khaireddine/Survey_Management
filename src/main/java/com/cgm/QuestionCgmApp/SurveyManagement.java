package com.cgm.QuestionCgmApp;

import java.util.ArrayList;

import com.cgm.QuestionCgmApp.cgmConstants.SurveyConstant;
import com.cgm.QuestionCgmApp.cgmUtils.CgmUtils;
import com.cgm.QuestionCgmApp.domain.Question;
import com.cgm.QuestionCgmApp.services.SurveyService;

public class SurveyManagement {

	public static void main(String[] args) {

		SurveyService qstService = new SurveyService();

		ArrayList<Question> listQuestions = new ArrayList<Question>();

		String choice = null;

		while ((!"1".equals(choice)) || (!"2".equals(choice))) {

			System.out.println(SurveyConstant.OPTION1);
			System.out.println(SurveyConstant.OPTION2);

			choice = CgmUtils.getInputFromKeybord();

			if ("1".equals(choice)) {

				System.out.println(SurveyConstant.ADD_QST);

				System.out.println(qstService.addQuestionAndAnswers(CgmUtils.getInputFromKeybord(), listQuestions));

			} else if ("2".equals(choice)) {

				System.out.println(SurveyConstant.ASK_QST);

				qstService.askQuestion(CgmUtils.getInputFromKeybord(), listQuestions);
			}

			else
				System.out.println(SurveyConstant.OTHER_OPTION);

		}

	}

}
