import java.util.Scanner;
public class KUStudentTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Declares a new instance of the Scanner class
		KUStudent Student1 = new KUStudent(); // Declares a new instance of a KUStudent
		System.out.print("Please input the student's name (firstname lastname): ");
		String student_fname = input.next(); // Sets the variable student_fname to the value the user inputs
		String student_lname = input.next();// Sets the variable student_lname to the value the user inputs
		Student1.set_name(student_fname, student_lname);// Calls the set_name method of KUstudent to set the first name and lastname of the Student1 to the value the user inputs
		System.out.print("Please input the student's KUID and department: ");
		String student_kuid = input.next();// Sets the variable student_kuid to the value the user inputs
		String student_department = input.next();// Sets the variable student_department to the value the user inputs
		Student1.set_kuinfo(student_kuid, student_department);
		System.out.println("");
		System.out.println("Student: " + Student1.get_fname() + " " + Student1.get_lname());// Uses the get_fname and get_lname of the KUStudent class to print the firstname and lastname of Student1
		System.out.println("KUID: " + Student1.get_id()); // Uses the get_id  method of the KUStudent class to print the KUID of Student1
		System.out.println("Department: " + Student1.get_dept()); // Uses the get_dept of the KUStudent class to print the department of Student1
	}
}
