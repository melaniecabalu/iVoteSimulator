package iVoteSimulator;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MultipleChoiceIVoteService extends IVoteService implements Service {
	private Map<String, Integer> statistics;
	private Map<String, String> submissions;
	private Set<String> studentIds;

	public MultipleChoiceIVoteService(Questions q){
		submissions = new Hashtable<String, String>();
		statistics = new Hashtable<String, Integer>();
		studentIds = submissions.keySet();

		//Stores candidate answers in Statistics map
		for (int i = 0; i <= q.getNumberofAnswers(); i++){
			statistics.put(q.getAnswers().get(i), 0);
		}
	}
	
	//Stores a Student's answer into Submission map
	public void submitAnswer(Student s){
		submissions.put(s.getId(), s.getAnswer());
	}
	
	public void displayStatistics(Questions q){
		int startPos;		//starting position for substring calculation
		int endPos;			//end position for substring calculation

		System.out.println("\nQuestion: " + q.getQuestion());
		printHeader();
	
		//Go through each student submission
		for(String id: studentIds){				

			//Compare the student's submission to each candidate answer
			for (int i = 0; i <= q.getNumberofAnswers(); i++){
				startPos = 0; 
				endPos = 1; 
				
				//Compare each character in student's answer to each candidate answer
				for (int j = 0; j < submissions.get(id).length(); j++){
					//If submission matches a candidate answer
					if (submissions.get(id).substring(startPos, endPos).compareTo(q.getAnswers().get(i)) == 0){
						//Increment appropriate statistic value and store back in Submissions map
						this.setCount(statistics.get(q.getAnswers().get(i))+1);;
						statistics.put(q.getAnswers().get(i), this.getCount());
						this.setCount(0); //reinitializes count
					}
					
					startPos++; //increment starting position
					endPos++; 	//increment ending position
				}
			}
		}

		//Print each candidate answer and statistics		
		for (int i = 0; i <= q.getNumberofAnswers(); i++){
			System.out.println(q.getAnswers().get(i) + ": " + statistics.get(q.getAnswers().get(i)));
		}
	}
}