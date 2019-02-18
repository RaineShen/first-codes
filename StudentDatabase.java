/**
 * 
 */
package ca.bcit.comp1451.Session3LabA;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

/**
 * @author A01080461
 *
 */
public class StudentDatabase {
	
	public static final int NUM_QUIZZES	= 10;
	public static final int MIN_GRADE = 0;
	public static final int MAX_GRADE = 100;

	private HashMap<String, int[]> quizMarks;

	/**
	 * @param quizMarks
	 */
	public StudentDatabase() {
		quizMarks = new HashMap<String,int[]>();

		showQuizMarks();
	}

	/**
	 * @return the properly-formatted name
	 */
	 private String formatName(String name) {
		 name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		 return name;
	 }

	 /**
	  * Add a student to the database and create a new array to hold that student's quiz marks 
	  */
	 public void addStudent(String studentName) {
		 
		 int[] quizzes = {MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE,
				 MIN_GRADE, MIN_GRADE, MIN_GRADE};
		 
		 if(quizMarks.containsKey(studentName)) {
			 System.out.println("key already exists in the map");
		 } else {
			 quizMarks.put(studentName, quizzes);
		 }
	 }
	 
	 /**
	  * displays the array of quiz marks for this student
	  */
	 public void displayQuizzes(String student) {
		 if(quizMarks.containsKey(student)) {
			 quizMarks.get(student);
			 // get the array from the hash map
			 // iterate through the array and display the values
				 System.out.println(quizMarks.get(student));
		 }
	 }
	 
	 /**
	  * Change the mark for the specified student
	  */
	 public void changeQuizMark(String studentName, int whichQuiz, int newMark) {
		 
		 if(quizMarks.containsKey(studentName) && (whichQuiz >= MIN_GRADE && whichQuiz < NUM_QUIZZES)
				 && (newMark >= MIN_GRADE && newMark <= MAX_GRADE)) {
			 int[] quizzes = {MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE,
					 MIN_GRADE, MIN_GRADE, MIN_GRADE};
			 
			 // get the quiz array from the hash map
			 // change the value of the provided index    marks[2]= 75
			 quizMarks.get(studentName);
			 quizzes [whichQuiz] = newMark;
		 } else {
			 System.out.println("the mark is not valid");
		 }
	 }
	 
	 /**
	  * Display the quiz marks for all students in the database
	  */
	 public void showQuizMarks() {
		 Set<Map.Entry<String, int[]>> theSet = quizMarks.entrySet();
			for(Map.Entry<String, int[]> s:theSet) {
				String key = s.getKey();
				
				s.getValue();
				System.out.println("The quiz marks for this student is "+ key.get);
			}
	 }
	 
	 public static void main(String[] args) {
		StudentDatabase database = new StudentDatabase();
		database.addStudent("Bob");
		database.displayQuizzes("Bob");
		
		database.addStudent("James");
		database.changeQuizMark("James",56,78);
		
		database.addStudent("Owen");
		database.changeQuizMark("Owen",96,90);
		
		database.showQuizMarks();
	 }
}
