import java.util.Scanner;

class CalStateStudent {
	int CIN;
	String name;
	int age;
	String major;
	
	public CalStateStudent(int CIN, String name, int age, String major) {
		this.CIN = CIN;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	
	public int getCIN(){
		return this.CIN;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getMajor(){
		return this.major;
	}
}

public class Project_4 {
	public static void main(String[] args) {
		int studentNumber = 0;
		CalStateStudent studentList[] = new CalStateStudent[100];
		studentList[studentNumber] = new CalStateStudent(305469273, "Kevin Crespin", 19, "Computer Science");
		studentNumber++;
		studentList[studentNumber] = new CalStateStudent(305685425, "Deserie Trejo", 20, "Graphic Design");
		studentNumber++;
		studentList[studentNumber] = new CalStateStudent(308956524, "Juana Martinez", 21, "Graphic Design");
		studentNumber++;
		studentList[studentNumber] = new CalStateStudent(307525653, "Tanzie Harris", 20, "Civil Engineer");
		studentNumber++;
		studentList[studentNumber] = new CalStateStudent(309856241, "Miguel Crespin", 27, "Mechanical Engineer");
		studentNumber++;
		studentList[studentNumber] = new CalStateStudent(305465846, "Joseph Mark", 29, "Electrical Engineer");
		studentNumber++;
		studentList[studentNumber] = new CalStateStudent(300232000, "Cristian Crespin", 15, "Mathematics");
		studentNumber++;
		
		@SuppressWarnings("resource")
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
				case 1: printStudents(studentList, studentNumber);
					System.out.println("Done!");
					break;
				case 2:	addStudent(studentList, studentNumber);
					studentNumber++;
					break;
				case 3: deleteStudent(studentList, studentNumber);
					studentNumber--;
					break;
				case 4: modifyStudent(studentList, studentNumber);
					break;
				case 5: System.out.println();
					System.out.print("Bye!");
					System.exit(1);
			}
		}
	}
	
	public static void printStudents(CalStateStudent[] studentList, int studentNumber) {
		for (int i = 0; i < studentNumber; i++) {
			System.out.println();
			System.out.println("CIN: " + studentList[i].getCIN());
			System.out.println("Name: " + studentList[i].getName());
			System.out.println("Age: " + studentList[i].getAge());
			System.out.println("Major: " + studentList[i].getMajor());
		}
		System.out.println();
	}
	
	public static void addStudent(CalStateStudent[] studentList, int studentNumber) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int CIN;
		String name;
		int age;
		String major;
		System.out.println();
		try{
		System.out.print("Enter student's CIN: ");
		CIN = Integer.parseInt(input.next()); 
		System.out.print("Enter student's name: ");
		input.nextLine();
		name = input.nextLine();
		System.out.print("Enter student's age: ");
		age = Integer.parseInt(input.next()); 
		System.out.print("Enter student's major: ");
		input.nextLine();
		major = input.nextLine();
		System.out.println();
		System.out.println("Done!");
		studentList[studentNumber] = new CalStateStudent(CIN, name, age, major);
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		    System.out.println("Returning to USER_MENU...");
		}
		
	}
	
	public static void deleteStudent(CalStateStudent[] studentList, int studentNumber) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int index = 0;
		int CIN;
		System.out.println();
		System.out.print("Enter student's CIN: ");
		try{
		CIN = Integer.parseInt(input.next());
		
		for (int i = 0; i < studentNumber; i++) {
			if (CIN == studentList[i].getCIN()) {
				index = i;
				System.out.println("Done!");
			}
			if (i == studentNumber - 1) {
				System.out.println("\nStudent NOT found!");
			    System.out.println("Returning to USER_MENU...");
			}
		}
		
		for (int j = index; j < studentNumber - 1; j++) {
			studentList[j] = studentList[j + 1];
		}
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		    System.out.println("Returning to USER_MENU...");
		}
	}
	
	public static void modifyStudent(CalStateStudent[] studentList, int studentNumber) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int CIN;
		String name;
		int age;
		String major;
		System.out.println();
		try{
		System.out.print("Enter student's CIN: ");
		CIN = Integer.parseInt(input.next());
		for (int i = 0; i < studentNumber; i++) {
			if (CIN == studentList[i].getCIN()) {
				System.out.println("Modifying [" + studentList[i].getName()+ "]... ");
				System.out.print("Enter student's NEW CIN: ");
				CIN = Integer.parseInt(input.next());
				System.out.print("Enter student's NEW name: ");
				input.nextLine();
				name = input.nextLine();
				System.out.print("Enter student's NEW age: ");
				age = Integer.parseInt(input.next());
				System.out.print("Enter student's NEW major: ");
				input.nextLine();
				major = input.nextLine();
				System.out.println();
				studentList[i] = new CalStateStudent(CIN, name, age, major);
				System.out.println("Done!");
			}
			if (i == studentNumber - 1) {
				System.out.println("\nStudent NOT found!");
			    System.out.println("Returning to USER_MENU...");
			}
		}
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		    System.out.println("Returning to USER_MENU...");
		}
		
	}

}
