package iVoteSimulator;

import java.util.Hashtable;
import java.util.Map;

public class IVoteService  {
	private Map<String, String> submissions;
	private int count;
	
	public IVoteService(){}
	
	public IVoteService(Questions q){
		submissions = new Hashtable<String, String>();
		count = 0;
	}
	
	public Map<String, String> getSubmissions(){
		return submissions;
	}
	
	public int getCount(){
		return count;
	}
	
	public void setCount(int c){
		count = c;
	}
	
	public void printHeader(){
		System.out.println("----------------------------------------");
		System.out.println("           Submission Results");
		System.out.println("----------------------------------------");
	}
}
