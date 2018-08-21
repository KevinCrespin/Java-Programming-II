import java.util.Scanner;

class CalStateStudent2 {
    int CIN;
	String name;
	int age;
	String major;
	int units;
	String GraduateORUndergraduate;
	
	CalStateStudent2() {
		try {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter student's CIN: ");
		CIN = Integer.parseInt(input.nextLine());
		System.out.print("Enter student's name: ");
		name = input.nextLine();
		System.out.print("Enter student's age: ");
		age = Integer.parseInt(input.nextLine());
		System.out.print("Enter student's major: ");
		major = input.nextLine();
		System.out.print("Enter student's units: ");
		units = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		}
	}
	
	public CalStateStudent2(int CIN, String name, int age, String major, int units, String GraduateORUndergraduate) {
		this.CIN = CIN;
		this.name = name;
		this.age = age;
		this.major = major;
		this.units = units;
		this.GraduateORUndergraduate = GraduateORUndergraduate;
	}
	
	public void showStudents() {
		System.out.println();
		System.out.println("CIN: " + CIN);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Major: " + major);
		System.out.println("Units: " + units);
	}

}

class CalStateGraduateStudent extends CalStateStudent2 {
	String BSBAUniversity = GraduateORUndergraduate;
	final double GraduateFee = 700.00;
	
	CalStateGraduateStudent() {
		super();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter student's University: ");
		BSBAUniversity = input.nextLine();
		System.out.println("\nDone!");
	}
	
	
	CalStateGraduateStudent(int CIN, String name, int age, String major, int units, String BSBAUniversity) {
		super(CIN, name, age, major, units, BSBAUniversity);
		this.BSBAUniversity = BSBAUniversity;
	}
	
	public void showStudents() {
		super.showStudents();
		System.out.println("University: " + BSBAUniversity);
		System.out.println("Fee: $" + String.format("%,.2f", (units * GraduateFee)));
	}

}

class CalStateUndergraduateStudent extends CalStateStudent2 {
	String HighSchool = GraduateORUndergraduate;
	final double UndergraduateFee = 600.00;
	
	CalStateUndergraduateStudent() {
		super();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter student's HighSchool: ");
		HighSchool = input.nextLine();
		System.out.println("\nDone!");
	}

	CalStateUndergraduateStudent(int CIN, String name, int age, String major, int units, String HighSchool) {
		super(CIN, name, age, major, units, HighSchool);
		this.HighSchool = HighSchool;
	}
	
	public void showStudents() {
		super.showStudents();
		System.out.println("HighSchool: " + HighSchool);
		System.out.println("Fee: $" + String.format("%,.2f", (units * UndergraduateFee)));
	}

}

class StudentList {
	CalStateStudent2[] studentList;
	int studentNumber = 0;
	
	public StudentList() {
		studentList = new CalStateStudent2[100];
		studentList[studentNumber++] = new CalStateUndergraduateStudent(305469273, "Kevin Crespin", 19, "B.S Computer Science", 18, "Manual Arts High School");
		studentList[studentNumber++] = new CalStateUndergraduateStudent(305685425, "Deserie Trejo", 20, "B.A Graphic Design", 15, "Manual Arts High School");
		studentList[studentNumber++] = new CalStateUndergraduateStudent(308956524, "Juana Martinez", 21, "B.A Graphic Design", 12, "Manual Arts High School");
		studentList[studentNumber++] = new CalStateGraduateStudent(307525653, "Tanzie Harris", 24, "M.S Civil Engineer", 18, "Cal State LA");
		studentList[studentNumber++] = new CalStateGraduateStudent(309856241, "Miguel Crespin", 27, "M.S Mechanical Engineer", 11, "Cal State LA");
		studentList[studentNumber++] = new CalStateGraduateStudent(305465846, "Joseph Mark", 29, "M.S Electrical Engineer", 14, "Cal State LA");
		studentList[studentNumber++] = new CalStateGraduateStudent(300232000, "Cristian Crespin", 25, "M.S Mathematics", 18, "Cal State LA");
	}
	
	public void showStudents() {
		for (int i = 0; i < studentNumber; i++) {
			studentList[i].showStudents();
		}
		System.out.println();
	}
	
	public void addStudent() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	System.out.print("\nEnter the student level [GRADUATE or UNDERGRADUATE]: ");
    	String studentLevel = input.nextLine();
    	studentLevel = studentLevel.toUpperCase();
		System.out.println();
    	if (studentLevel.equals("UNDERGRADUATE")) {
    		studentList[studentNumber++] = new CalStateUndergraduateStudent();
    	}
    	else if (studentLevel.equals("GRADUATE")) {
    		studentList[studentNumber++] = new CalStateGraduateStudent();
    	}
    	else {
    		System.out.print("ERROR! Invalid input.");
    		System.out.println("\nReturning to USER_MENU...");
    	}
	}
	

	public void deleteStudent() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter student's CIN: ");
		int index = 0;
		try{
		int CIN = Integer.parseInt(input.nextLine());
		for (int i = 0; i < studentNumber; i++) {
			if (CIN == studentList[i].CIN) {
				index = i;
				System.out.println("\nDone!");
			}
			else if (i == studentNumber - 1) {
				System.out.println("\nStudent NOT found!");
			    System.out.println("Returning to USER_MENU...");
			}
		}
		
		for (int j = index; j < studentNumber - 1; j++) {
			studentList[j] = studentList[j + 1];
		}
		studentNumber--;
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		}
		
	}
	
	
	public void modifyStudent() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter student's CIN: ");
		int index = 0;
		try{
		int CIN = Integer.parseInt(input.nextLine());
		for (int i = 0; i < studentNumber; i++) {
			if (CIN == studentList[i].CIN) {
				index = i;
				System.out.print("\nModifying [" + studentList[index].name + "] enter NEW information... ");
			}
			else if (i == studentNumber - 1) {
				System.out.println("\nStudent NOT found!");
			    System.out.println("Returning to USER_MENU...");
			}
		}
    	System.out.print("\nEnter the student's level [GRADUATE or UNDERGRADUATE]: ");
    	String studentLevel = input.nextLine();
    	studentLevel = studentLevel.toUpperCase();
    	if (studentLevel.equals("UNDERGRADUATE")) {
    		studentList[index] = new CalStateUndergraduateStudent();
    	}
    	else if (studentLevel.equals("GRADUATE")) {
    		studentList[index] = new CalStateGraduateStudent();
    	}
    	else {
    		System.out.print("\nERROR! Invalid input.");
    		System.out.println("\nReturning to USER_MENU...");
    	}
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		}
	}
}

public class Project_5 {
	public static void main(String[] args) {
		StudentList studentList = new StudentList();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("\n[1] Print all students infomation");
			System.out.println("[2] Add student infomation");
			System.out.println("[3] Delete student infomation");
			System.out.println("[4] Modify student infomation");
			System.out.println("[5] Exit");
			System.out.print("Select an option: ");
			int option = input.nextInt();
			
			switch(option) {
				case 1: studentList.showStudents();
					System.out.println("Done!");
					break;
				case 2:	studentList.addStudent();
					break;
				case 3: studentList.deleteStudent();
					break;
				case 4: studentList.modifyStudent();
					break;
				case 5: 
					input.close();
					System.out.println();
					System.out.print("Bye!");
					System.exit(1);
			}
		}
	}

}