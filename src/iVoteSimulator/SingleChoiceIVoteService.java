package iVoteSimulator;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class SingleChoiceIVoteService extends IVoteService implements Service {
	private Hashtable<String, Integer> statistics;
	private Map<String, String> submissions;
	private Set<String> studentIds;

	public SingleChoiceIVoteService(Questions q){
		submissions = new Hashtable<String, String>();
		statistics = new Hashtable<String, Integer>();
		studentIds = submissions.keySet();

		for (int i = 0; i <= q.getNumberofAnswers(); i++){
			statistics.put(q.getAnswers().get(i), 0);
		}
	}
	
	public void submitAnswer(Student s){
		submissions.put(s.getId(), s.getAnswer());
	}
	
	//for single question
	public void displayStatistics(Questions q){
		System.out.println("\nQuestion: " + q.getQuestion());
		printHeader();

		//REMOVE LATER - FOR TESTING
		System.out.println(submissions.size());
		
		//Go through all the submissions
		for(String id: studentIds){			

			//compare the student's submission to each candidate answer
			for (int i = 0; i <= q.getNumberofAnswers(); i++){
				//if submission matches a candidate answer
				if (submissions.get(id).compareTo(q.getAnswers().get(i)) == 0){
					//increment appropriate statistic value
					this.setCount(statistics.get(q.getAnswers().get(i))+1);;
					statistics.put(q.getAnswers().get(i), this.getCount());
					this.setCount(0);
				}
			}
		}
		
		//Print the statistics
		//REMOVE LATER - FOR TESTING
		//System.out.println(statistics.toString());
		
		for (int i = 0; i <= q.getNumberofAnswers(); i++){
			System.out.println(q.getAnswers().get(i) + ": " + statistics.get(q.getAnswers().get(i)));
		}
	}
}
