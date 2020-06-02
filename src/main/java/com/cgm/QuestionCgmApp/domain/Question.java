package com.cgm.QuestionCgmApp.domain;

import java.util.ArrayList;

public class Question {

	private String content;
	private ArrayList<Answer> listAnswers;

	public Question() {
	}

	public Question(String content, ArrayList<Answer> listAnswers) {

		this.content = content;
		this.listAnswers = listAnswers;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<Answer> getListAnswers() {
		return listAnswers;
	}

	public void setListAnswers(ArrayList<Answer> listAnswers) {
		this.listAnswers = listAnswers;
	}

}
