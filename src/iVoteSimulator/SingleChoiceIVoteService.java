package iVoteSimulator;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class SingleChoiceIVoteService extends IVoteService implements Service {
	private Map<String, Integer> statistics;
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
	
	public void displayStatistics(Questions q){
		System.out.println("\nQuestion: " + q.getQuestion());
		printHeader();
		
		//Go through each submission
		for(String id: studentIds){			

			//compare the student's submission to each candidate answer
			for (int i = 0; i <= q.getNumberofAnswers(); i++){
				if (submissions.get(id).compareTo(q.getAnswers().get(i)) == 0){
					//increment appropriate statistic value
					this.setCount(statistics.get(q.getAnswers().get(i))+1);;
					statistics.put(q.getAnswers().get(i), this.getCount());
					this.setCount(0);
				}
			}
		}

		for (int i = 0; i <= q.getNumberofAnswers(); i++){
			System.out.println(q.getAnswers().get(i) + ": " + statistics.get(q.getAnswers().get(i)));
		}
	}
}