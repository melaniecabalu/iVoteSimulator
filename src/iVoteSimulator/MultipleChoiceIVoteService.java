package iVoteSimulator;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MultipleChoiceIVoteService extends IVoteService implements Service {
	private Hashtable<String, Integer> statistics;
	private Map<String, String> submissions;
	private Set<String> studentIds;

	public MultipleChoiceIVoteService(Questions q){
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
		int startPos; //starting position for substring calculation
		int endPos; //end position for substring calculation

		System.out.println("\nQuestion: " + q.getQuestion());
		printHeader();
		
		//REMOVE LATER - FOR TESTING
		//System.out.println(submissions.size());
	
		//Go through all the submissions
		for(String id: studentIds){				
			//System.out.println("random submission: " + submissions.toString());

			//compare the student's submission to each candidate answer
			for (int i = 0; i <= q.getNumberofAnswers(); i++){
				startPos = 0; //starting position for substring calculation
				endPos = 1; //end position for substring calculation
				
				//compare each character in Student answer to each candidate answer
				for (int j = 0; j < submissions.get(id).length(); j++){
					//if submission matches a candidate answer
					if (submissions.get(id).substring(startPos, endPos).compareTo(q.getAnswers().get(i)) == 0){
						this.setCount(statistics.get(q.getAnswers().get(i))+1);;
						statistics.put(q.getAnswers().get(i), this.getCount());
						this.setCount(0); //reinitializes count
					}
					
					startPos++; //increment starting position
					endPos++; //increment ending position
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
