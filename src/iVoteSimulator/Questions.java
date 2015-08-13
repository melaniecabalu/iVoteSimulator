package iVoteSimulator;

import java.util.ArrayList;

public interface Questions {
	public void addAnswer(String s);
	
	public ArrayList<String> getAnswers();
	
	public int getNumberofAnswers();
	
	public String getQuestion();
}
