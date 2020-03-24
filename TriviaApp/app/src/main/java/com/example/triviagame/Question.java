package com.example.triviagame;

public class Question {
	
	private String text;
	private String answer;
	
	public Question(String questionText, String questionAnswer)  {
		text = questionText;
		answer = questionAnswer;
	}
	
	public Question(String questionText)  {
		text = questionText;
		answer = "";
	}
	
	public String getAnswer()  {
		return answer;
	}
	
	public String getQuestion()  {
		return text;
	}
	
	public void setAnswer(String correctResponse)  {
		answer = correctResponse;
	}
	
	public void display()  {
		System.out.println(text);
	}
	
	public boolean checkAnswer(String response)  {
		return response.equals(answer);
	}

}
