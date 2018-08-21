import java.util.Scanner;


class CalStateStudent3 {
    int CIN;
	String name;
	int age;
	String major;
	int units;
	String GraduateORUndergraduate;
	
	CalStateStudent3(int CIN, String name, int age, String major, int units, String GraduateORUndergraduate) {
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
	
	public int getCIN() {
		return this.CIN;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
}

class CalStateGraduateStudent2 extends CalStateStudent3 {
	String BSBAUniversity = GraduateORUndergraduate;
	final double GraduateFee = 700.00;
	
	
	CalStateGraduateStudent2(int CIN, String name, int age, String major, int units, String BSBAUniversity) {
		super(CIN, name, age, major, units, BSBAUniversity);
		this.BSBAUniversity = BSBAUniversity;
	}
	
	public void showStudents() {
		super.showStudents();
		System.out.println("University: " + BSBAUniversity);
		System.out.println("Fee: $" + String.format("%,.2f", (units * GraduateFee)));
	}

}

class CalStateUndergraduateStudent2 extends CalStateStudent3 {
	String HighSchool = GraduateORUndergraduate;
	final double UndergraduateFee = 600.00;
	

	CalStateUndergraduateStudent2(int CIN, String name, int age, String major, int units, String HighSchool) {
		super(CIN, name, age, major, units, HighSchool);
		this.HighSchool = HighSchool;
	}
	
	public void showStudents() {
		super.showStudents();
		System.out.println("HighSchool: " + HighSchool);
		System.out.println("Fee: $" + String.format("%,.2f", (units * UndergraduateFee)));
	}

}

class StudentList2 {
	CalStateStudent3[] studentList2;
	int studentNumber = 0;
	
	public StudentList2() {
		studentList2 = new CalStateStudent3[100];
		studentList2[studentNumber++] = new CalStateUndergraduateStudent2(305469273, "Kevin Crespin", 19, "B.S Computer Science", 18, "Manual Arts High School");	
		studentList2[studentNumber++] = new CalStateUndergraduateStudent2(305685425, "Deserie Trejo", 20, "B.A Graphic Design", 15, "Manual Arts High School");	
		studentList2[studentNumber++] = new CalStateUndergraduateStudent2(308956524, "Juana Martinez", 21, "B.A Graphic Design", 12, "Manual Arts High School");
		studentList2[studentNumber++] = new CalStateGraduateStudent2(300232000, "Cristian Crespin", 25, "M.S Mathematics", 18, "Cal State LA");
		studentList2[studentNumber++] = new CalStateGraduateStudent2(307525653, "Tanzie Harris", 24, "M.S Civil Engineer", 18, "Cal State LA");
		studentList2[studentNumber++] = new CalStateGraduateStudent2(309856241, "Miguel Crespin", 27, "M.S Mechanical Engineer", 11, "Cal State LA");
		studentList2[studentNumber++] = new CalStateGraduateStudent2(305465846, "Joseph Mark", 29, "M.S Electrical Engineer", 14, "Cal State LA");
		
	}
	
	public void showStudents() {
		for (int i = 0; i < studentNumber; i++) {
			studentList2[i].showStudents();
		}
		System.out.println();
	}
	
	public void showStudentByCIN() {
		CalStateStudent3 tempCIN; // Temporary object
		for (int i = 0; i < studentNumber - 1; i++) {
			for (int j = 0; j < studentNumber - i - 1; j++) {
				if (studentList2[j].getCIN() > studentList2[j + 1].getCIN()) {
					tempCIN = studentList2[j];
					studentList2[j] = studentList2[j + 1];
					studentList2[j + 1] = tempCIN;
				}
			}
		}
		showStudents();
		System.out.println();
	}
	
	public void showStudentByName() {
		CalStateStudent3 tempName; // Temporary object
		for (int i = 0; i < studentNumber - 1; i++) {
			for (int j = 0; j < studentNumber - i - 1; j++) {
				if (studentList2[j].getName().compareTo(studentList2[j + 1].getName()) > 0) {
					tempName = studentList2[j];
					studentList2[j] = studentList2[j + 1];
					studentList2[j + 1] = tempName;
				}
			}
		}
		showStudents();
		System.out.println();
	}
	
	public void showStudentByAge() {
		CalStateStudent3 tempAge; // Temporary object
		for (int i = 0; i < studentNumber - 1; i++) {
			for (int j = 0; j < studentNumber - i - 1; j++) {
				if (studentList2[j].getAge() > studentList2[j + 1].getAge()) {
					tempAge = studentList2[j];
					studentList2[j] = studentList2[j + 1];
					studentList2[j + 1] = tempAge;
				}
			}
		}
		showStudents();
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
    		System.out.println("Separate the data with ' ,'");
    		System.out.print("Enter student's CIN, name, age, major, units, and highschool: ");
    		String studentInformation = input.nextLine();
    		String[] information = studentInformation.split(", ");
    		int CIN = Integer.parseInt(information[0]);
    		String name = information[1];
    		int age = Integer.parseInt(information[2]);
    		String major = information[3];
    		int units = Integer.parseInt(information[4]);
    		String highschool = information[5];
    		studentList2[studentNumber++] = new CalStateUndergraduateStudent2(CIN, name, age, major, units, highschool);
    		System.out.println("\nDone!");
    	}
    	else if (studentLevel.equals("GRADUATE")) {
    		System.out.println("Separate the data with ' ,'");
    		System.out.print("Enter student's CIN, name, age, major, units, and university: ");
    		String studentInformation = input.nextLine();	
    		String[] information = studentInformation.split(", ");
    		int CIN = Integer.parseInt(information[0]);
    		String name = information[1];
    		int age = Integer.parseInt(information[2]);
    		String major = information[3];
    		int units = Integer.parseInt(information[4]);
    		String university = information[5];
    		studentList2[studentNumber++] = new CalStateGraduateStudent2(CIN, name, age, major, units, university);
    		System.out.println("\nDone!");
    	}
    	else {
    		System.out.print("ERROR! Invalid input.");
    		System.out.println("\nReturning to USER_MENU...");
    	}
	}
	

	public void deleteStudentByCIN() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter student's CIN: ");
		int index = 0;
		try{
		int CIN = Integer.parseInt(input.nextLine());
		for (int i = 0; i < studentNumber; i++) {
			if (CIN == studentList2[i].CIN) {
				index = i;
				System.out.println("\nDone!");
			}
			else if (i == studentNumber - 1) {
				System.out.println("\nStudent NOT found!");
			    System.out.println("Returning to USER_MENU...");
			}
		}
		
		for (int j = index; j < studentNumber - 1; j++) {
			studentList2[j] = studentList2[j + 1];
		}
		studentNumber--;
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		}
		
	}
	
	public void deleteStudentByName() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter student's name: ");
		int index = 0;
		String name = input.nextLine();
		name = name.toUpperCase();
		for (int i = 0; i < studentNumber; i++) {
			if (name.contains(studentList2[i].getName().toUpperCase())) {
				index = i;
				System.out.println("\nDone!");
			}
			else if (i == studentNumber - 1) {
				System.out.println("\nStudent NOT found!");
			    System.out.println("Returning to USER_MENU...");
			}
		}
		
		for (int j = index; j < studentNumber - 1; j++) {
			studentList2[j] = studentList2[j + 1];
		}
		studentNumber--;
	}
	
	
	public void modifyStudentByCIN() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter student's CIN: ");
		int index = 0;
		try{
			int CIN = Integer.parseInt(input.nextLine());
			for (int i = 0; i < studentNumber; i++) {
				if (CIN == studentList2[i].CIN) {
					index = i;
					System.out.print("\nModifying [" + studentList2[index].name + "]...");
					System.out.print("\nEnter the student's NEW level [GRADUATE or UNDERGRADUATE]: ");
					String studentLevel = input.nextLine();
					studentLevel = studentLevel.toUpperCase();
					if (studentLevel.equals("UNDERGRADUATE")) {
						System.out.println("Separate the data with ' ,'");
						System.out.print("Enter student's NEW CIN, name, age, major, units, and highschool: ");
						String studentInformation = input.nextLine();	
						String[] information = studentInformation.split(", ");
						CIN = Integer.parseInt(information[0]);

						String name = information[1];
						int age = Integer.parseInt(information[2]);
						String major = information[3];
						int units = Integer.parseInt(information[4]);
						String highschool = information[5];
						studentList2[index] = new CalStateUndergraduateStudent2(CIN, name, age, major, units, highschool);
						System.out.println("\nDone!");
					}
					else if (studentLevel.equals("GRADUATE")) {
						System.out.println("Separate the data with ' ,'");
						System.out.print("Enter student's NEW CIN, name, age, major, units, and university: ");
						String studentInformation = input.nextLine();	
						String[] information = studentInformation.split(", ");
						CIN = Integer.parseInt(information[0]);
						String name = information[1];
						int age = Integer.parseInt(information[2]);
		    			String major = information[3];
		    			int units = Integer.parseInt(information[4]);
		    			String university = information[5];
		    			studentList2[index] = new CalStateGraduateStudent2(CIN, name, age, major, units, university);
		    			System.out.println("\nDone!");
					}
					else {
						System.out.print("ERROR! Invalid input.");
			    		System.out.println("\nReturning to USER_MENU...");
					}
				}
			}
		} catch (NumberFormatException a){
		    System.out.println("\nERROR! Incorrect data type");
		}
	}
	
	public void modifyStudentByName() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter student's name: ");
		int index = 0;
		String name = input.nextLine();
		name = name.toUpperCase();
		for (int i = 0; i < studentNumber; i++) {
				if (name.contains(studentList2[i].getName().toUpperCase())) {
					index = i;
					System.out.print("\nModifying [" + studentList2[index].name + "]...");
					System.out.print("\nEnter the student's NEW level [GRADUATE or UNDERGRADUATE]: ");
					String studentLevel = input.nextLine();
					studentLevel = studentLevel.toUpperCase();
					if (studentLevel.equals("UNDERGRADUATE")) {
						System.out.println("Separate the data with ' ,'");
						System.out.print("Enter student's NEW CIN, name, age, major, units, and highschool: ");
						String studentInformation = input.nextLine();	
						String[] information = studentInformation.split(", ");
						int CIN = Integer.parseInt(information[0]);
						name = information[1];
						int age = Integer.parseInt(information[2]);
						String major = information[3];
						int units = Integer.parseInt(information[4]);
						String highschool = information[5];
						studentList2[index] = new CalStateUndergraduateStudent2(CIN, name, age, major, units, highschool);
						System.out.println("\nDone!");
					}
					else if (studentLevel.equals("GRADUATE")) {
						System.out.println("Separate the data with ' ,'");
						System.out.print("Enter student's NEW CIN, name, age, major, units, and university: ");
						String studentInformation = input.nextLine();	
						String[] information = studentInformation.split(", ");
						int CIN = Integer.parseInt(information[0]);
						name = information[1];
						int age = Integer.parseInt(information[2]);
		    			String major = information[3];
		    			int units = Integer.parseInt(information[4]);
		    			String university = information[5];
		    			studentList2[index] = new CalStateGraduateStudent2(CIN, name, age, major, units, university);
		    			System.out.println("\nDone!");
					}
					else {
						System.out.print("ERROR! Invalid input.");
			    		System.out.println("\nReturning to USER_MENU...");
					}
				}
			}
	}
}



public class Project_6 {
	public static void main(String[] args) {
		StudentList2 studentList2 = new StudentList2();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("\n[1] Print student infomation");
			System.out.println("[2] Add student infomation");
			System.out.println("[3] Delete student infomation");
			System.out.println("[4] Modify student infomation");
			System.out.println("[5] Exit");
			System.out.print("Select an option: ");
			int option = input.nextInt();
			
			switch(option) {
				case 1:
					System.out.println("\n[1] Print sorted");
					System.out.println("[2] Print NOT sorted");
					System.out.print("Select an option: ");
					int secondOption = input.nextInt();
					switch(secondOption) {
						case 1: 
							System.out.println("\n[1] Sorted by CIN");
							System.out.println("[2] Sorted by name");
							System.out.println("[3] Sorted by age");
							System.out.print("Select an option: ");
							int thirdOption = input.nextInt();
							switch(thirdOption) {
								case 1: studentList2.showStudentByCIN();
									System.out.println("Done!");
									break;
								case 2: studentList2.showStudentByName();
									System.out.println("Done!");
									break;
								case 3: studentList2.showStudentByAge();
									System.out.println("Done!");
									break;
							}
							break;
						case 2: 
							studentList2.showStudents();
							System.out.println("Done!");
							break;
					}
					break;
				case 2:	studentList2.addStudent();
					break;
				case 3: 
					System.out.println("\n[1] Delete student using CIN");
					System.out.println("[2] Delete student using name");
					System.out.print("Select an option: ");
					int secondOption2 = input.nextInt();
					switch(secondOption2) {
						case 1: studentList2.deleteStudentByCIN();
							break;
						case 2: studentList2.deleteStudentByName();
							break;
					}
					break;
				case 4: 
					System.out.println("\n[1] Modify student using CIN");
					System.out.println("[2] Modify student using name");
					System.out.print("Select an option: ");
					int secondOption3 = input.nextInt();
					switch(secondOption3) {
						case 1: studentList2.modifyStudentByCIN();
							break;
						case 2: studentList2.modifyStudentByName();
							break;
					}
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