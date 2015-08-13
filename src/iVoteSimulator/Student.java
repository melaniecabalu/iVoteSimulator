package iVoteSimulator;

public class Student {
	private String Id;
	private String answer;
	
	public Student(String s){
		Id = s;
	}
	
	public void setId(Student stu, String str){
		stu.Id = str;
	}
		
	public String getId(){
		return this.Id;
	}
	
	public String getAnswer(){
		return answer;
	}
		
	public void setAnswer(String s){
		answer = s;
	}
}
