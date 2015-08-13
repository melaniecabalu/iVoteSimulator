package iVoteSimulator;

import java.util.ArrayList;

public class MultipleChoiceQuestion implements Questions{
	private String question;
	private ArrayList<String> answers;

	public MultipleChoiceQuestion(String question) {
		this.question = question;
		answers = new ArrayList<String>();
	}

	public void addAnswer(String s){
		answers.add(s);
	}
	
	public ArrayList<String> getAnswers(){
		return answers;
	}
	
	public int getNumberofAnswers(){
		return answers.size()-1;
	}
	
	public String getQuestion(){
		return question;
	}
	
}
