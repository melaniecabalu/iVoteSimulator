package iVoteSimulator;

import java.util.Random;
import java.util.UUID;

public class SimulationDriver {

	public static void main(String[] args) {
		Random rand = new Random();
		String choices;
		
		//Single Question with no resubmissions
		//Create question type
		Questions q1 = new SingleChoiceQuestion("Hey?");
		
		//Configure answers
		q1.addAnswer("A");
		q1.addAnswer("B");
		q1.addAnswer("C");
		q1.addAnswer("D");
		q1.addAnswer("E");

		//Configure question for iVoteService
		Service service1 = new SingleChoiceIVoteService(q1);
		
		//Randomly generate a number students and the answers
	    int randomNum = rand.nextInt(51);
		Student[] students = new Student[randomNum];

	    for (int i = 0; i < randomNum; i++){
	    	String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	    	students[i] = new Student(uuid);
	    }
	    
	    //Students choose random answer (SINGLE CHOICE)
	    for (int i = 0; i < randomNum; i++){
		    choices = "ABCDE";
		    int randomAnswer = rand.nextInt(choices.length());

	    	students[i].setAnswer(Character.toString(choices.charAt(randomAnswer)));
	    }
	    
	    //Submit all the students' answers to iVote Service
	    for (int i = 0; i < randomNum; i++){
		   service1.submitAnswer(students[i]);
	    }
	    
	    //REMOVE LATER - FOR TESTING
	    //service1.printTable();
	    
	    //Display statistics for q1
	    service1.displayStatistics(q1);
	    
		/////////Single Question with random number of resubmissions
		//Create question type
	    Questions q2 = new SingleChoiceQuestion("What's up?");
		
		//Configure answers
		q2.addAnswer("1");
		q2.addAnswer("2");
		q2.addAnswer("3");
		q2.addAnswer("4");
		q2.addAnswer("5");

		//Configure question for iVoteService
		Service service2 = new SingleChoiceIVoteService(q2);
		
		//Randomly generate a number students
	    randomNum = rand.nextInt(51);
	    
	    //Randomly generate how many students will resubmit an answer
		Student[] students2 = new Student[randomNum];
	    int numOfResubmissions = rand.nextInt(students2.length);
	    System.out.println("\n\nnumber of resubmissions = " + numOfResubmissions);
		
		//Randomly generate answers
	    for (int i = 0; i < randomNum; i++){
	    	String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	    	students2[i] = new Student(uuid);
	    }
	    
	    //Students choose random answer, some make multiple submissions(SINGLE CHOICE)
	    choices = "12345";
	    int randomAnswer = rand.nextInt(choices.length());

	    for (int i = 0; i < randomNum; i++){
	    	
		    randomAnswer = rand.nextInt(choices.length());
		    
	    	students2[i].setAnswer(Character.toString(choices.charAt(randomAnswer)));
	    }
	    
    	//Random resubmission    	
    	for (int j = 0; j < numOfResubmissions; j++){
        	int randomStudentIndex = rand.nextInt(students2.length);
		    randomAnswer = rand.nextInt(choices.length());

    		if (j == randomStudentIndex)
    			students2[j].setAnswer(Character.toString(choices.charAt(randomAnswer)));    		
    	}
	    	    
	    //Submit all the students' answers to iVote Service
	    for (int i = 0; i < randomNum; i++){
		    service2.submitAnswer(students2[i]);
	    }
	    
	    //REMOVE LATER - FOR TESTING
	    //service2.printTable();
	    
	    //Display statistics for q2
	    service2.displayStatistics(q2);

	    //Multiple type question with no resubmissions
	    //Create question type
	    Questions q3 = new MultipleChoiceQuestion("Is this a question?");
	    
		//Configure answers
		q3.addAnswer("A");
		q3.addAnswer("B");
		q3.addAnswer("C");
		q3.addAnswer("D");
		q3.addAnswer("E");
		
		//Configure question for iVote Service
		Service service3 = new MultipleChoiceIVoteService(q3);
		
		//Randomly generate a number students
	    randomNum = rand.nextInt(51);
		Student[] students3 = new Student[10];
		
		choices = "ABCDE";
		
		//Randomly generate student IDs
	    for (int i = 0; i < students3.length; i++){
	    	String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	    	students3[i] = new Student(uuid);
	    }
	    
	    students3[0].setAnswer("ACD");
	    students3[1].setAnswer("BCE");
	    students3[2].setAnswer("E");
	    students3[3].setAnswer("BCDE");
	    students3[4].setAnswer("CD");
	    students3[5].setAnswer("AC");
	    students3[6].setAnswer("AE");
	    students3[7].setAnswer("BC");
	    students3[8].setAnswer("ACE");
	    students3[9].setAnswer("B");

	    for (int i = 0; i < 10; i++){
	    	service3.submitAnswer(students3[i]);
	    }
	    
	    service3.displayStatistics(q3);

	    /*
	    for(int i = 0; i < students3.length; i++){
		    randomAnswerLength= rand.nextInt(choices.length()) + 1;
		    for (int j = 0; j < randomAnswerLength; j++){
		    	
		    }
	    }*/
	    
	    

		/*
		Student Melanie = new Student("009129484");
		Student Michelle = new Student("002145");
		Melanie.setAnswer("123");
		Melanie.setAnswer("122");
		Michelle.setAnswer("125");

		service3.submitAnswer(Melanie);
		//service3.submitAnswer(Michelle);
		service3.displayStatistics(q3);
		*/
	}

}
