import java.io.*;
import java.util.Scanner;

class Student {
	int CIN;
	String name;
	int age;
	String major;
	int undergraduate = 1;

	Student() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input CIN, Name, Age, Major, (Undergraduate [1], Graduate [0]):");
		CIN = Integer.parseInt(input.next());
		name = input.next();
		age = Integer.parseInt(input.next());
		major = input.next();
		undergraduate = Integer.parseInt(input.next());
	}

	Student(int CIN, String name, int age, String major, int undergraduate) {
		this.CIN = CIN;
		this.name = name;
		this.age = age;
		this.major = major;
		this.undergraduate = undergraduate;
	}

	public void outputInformation() {
		System.out.println("");
		System.out.println("CIN: " + CIN);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Major: " + major);
		System.out.println("Undergraduate[1] Graduate[0]: " + undergraduate);
		
	}

	public boolean equals(Student s) {

		if ((this.CIN == s.CIN) && (this.name == s.name) &&
		(this.age == s.age) && (this.major == s.major)) {
			return true;
		}

		else {
			return false;
		}
	}

	public String toString() {
		String tmp = String.valueOf(CIN);
		tmp = tmp + " " + name;
		tmp = tmp + " " + String.valueOf(age);
		tmp = tmp + " " + major;
		return tmp;
	}

	public void saveStudent(PrintWriter pw) {
		pw.println(CIN);
		pw.println(name);
		pw.println(age);
		pw.println(major);
		pw.println(undergraduate);
	}
}

// Graduate Student process
class GraduateStudent extends Student {
	String thesis;

	GraduateStudent() {
		super();
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.print("Graduate Student, Input Thesis:");
		thesis = sc.nextLine();
	}

	GraduateStudent(int CIN, String name, int age, String major, int undergraduate, String thesis) {
		super(CIN, name, age, major, undergraduate);
		this.thesis = thesis;
	}

	public void outputInformation() {
		super.outputInformation();
		System.out.print("Thesis: " + thesis);
		System.out.println("");
	}

	public void saveStudent(PrintWriter pw) {
		super.saveStudent(pw);
		pw.println(thesis);
	}
}

class UnderGraduateStudent extends Student {
	String seniorDesign;

	UnderGraduateStudent() {
		super();
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Undergraduate Student, Input Senior Design:");
		seniorDesign = sc.nextLine();

	}

	UnderGraduateStudent(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
		super(CIN, name, age, major, undergraduate);
		this.seniorDesign = seniorDesign;
	}

	public void outputInformation() {
		super.outputInformation();
		System.out.print("Senior Design: " + seniorDesign);
		System.out.println("");
	}

	public void saveStudent(PrintWriter pw) {
		super.saveStudent(pw);
		pw.println(seniorDesign);
	}
}

class StudentList {
	Student[] studentList;
	int studentNum;

	public StudentList() {
	    studentList = new Student[100];
	    studentNum = 0;
		studentList[studentNum] = new GraduateStudent(356485924, "Jorge Ramirez", 19, "Computer Science", 0, "Study of Artificial Inteligence");
		studentNum ++;
		studentList[studentNum] = new GraduateStudent(315468257, "Mary Johnson", 18, "Civil Engenieer", 0, "Study of 3D Image");
		studentNum ++;
		studentList[studentNum] = new UnderGraduateStudent(312546857, "Bobby Smith", 20, "Mathematics", 1, "Implementation of Library System");
		studentNum ++;
		studentList[studentNum] = new UnderGraduateStudent(305469273, "Kevin Crespin", 19, "Computer Science", 1, "Development of CSU Portal");
		studentNum ++;
	}
	

	public void loadStudents() {
		File studentFile = new File("C:\\Users\\Owner\\Desktop\\CS 2012-01\\04 Class Projects\\P_2_Students\\studentFile.txt");

		try {
			Scanner fileScanner = new Scanner(studentFile);
			String tmp = fileScanner.nextLine();
			studentNum = Integer.parseInt(tmp);

			for (int i = 0; i < studentNum; i++) {
				tmp = fileScanner.nextLine();
				int CIN = Integer.parseInt(tmp);
				String name = fileScanner.nextLine();
				tmp = fileScanner.nextLine();
				int age = Integer.parseInt(tmp);	
				String major = fileScanner.nextLine();
				tmp = fileScanner.nextLine();
				int undergraduate = Integer.parseInt(tmp);

				if (undergraduate == 1) {
					String seniorDesign = fileScanner.nextLine();
					studentList[i] = new UnderGraduateStudent(CIN, name, age, major, 1, seniorDesign);
				}
				else {
					String thesis = fileScanner.nextLine();
					studentList[i] = new GraduateStudent(CIN, name, age, major, 0, thesis);
				}
			}
			fileScanner.close();
		} catch (Exception e) { 		}
	}
	
	
	public void outputStudentList() {
		System.out.println();
		for (int i = 0; i < studentNum; i++) {
			studentList[i].outputInformation();
			System.out.println();
		}
		System.out.println();
	}
	
	
    public void addStudent() {
    	int undergraduate = 1;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("");
    	System.out.println("What kind student do you need to add?");
    	System.out.print("Undergraduate [0] OR Graduate [1]:");
    	undergraduate = Integer.parseInt(sc.nextLine());

    	if (undergraduate == 1) {
    		studentList[studentNum] = new UnderGraduateStudent();
    		studentNum++;
    	}
    	else {
    		studentList[studentNum] = new GraduateStudent();
    		studentNum++;
    	}
   
    }
    
    
    public int findIndex() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Student's CIN: ");
		String tmpCIN = sc.nextLine();
		int CIN = Integer.parseInt(tmpCIN);

		int index = -1;
		for (int i = 0; i < studentNum; i++) {
			if (CIN == studentList[i].CIN) {
				index = i;
				return index;
			}
		}
		return index;
	}
    

	public void deleteStudent() {
		int sIndex = findIndex();
		for (int j = sIndex; j < studentNum - 1; j++) {
			studentList[j] = studentList[j+1];
		}
		studentNum--;
	}
	

	public void modifyStudent() {
		int sIndex = findIndex();		
		int undergraduate = 1;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("");
    	System.out.println("What kind student do you need to modify?");
    	System.out.print("Undergraduate [1] OR Graduate [0]:");
    	undergraduate = Integer.parseInt(sc.nextLine());

    	if (undergraduate == 1) {
    		studentList[sIndex] = new UnderGraduateStudent();
    	}
    	else {
    		studentList[sIndex] = new GraduateStudent();
    	}
	}
	

	public void saveStudents() {
		File studentFile = new File("C:\\Users\\Owner\\Desktop\\CS 2012-01\\04 Class Projects\\P_2_Students\\studentFile.txt");
		try {
			PrintWriter pw = new PrintWriter(studentFile);
			pw.println(studentNum);
			for (int i = 0; i < studentNum; i++) {
				studentList[i].saveStudent(pw);
			}
			pw.flush();
			pw.close();
		} catch (Exception e) { 		}
	}
	
}

public class P_02_08_09 Student_Manager{

	public static void main(String[] args) {
		StudentList students = new StudentList();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("[0] Load Students");
			System.out.println("[1] Show Students");
			System.out.println("[2] Add Student");
			System.out.println("[3] Delete Student");
			System.out.println("[4] Modify Student");
			System.out.println("[5] Save Students");
			System.out.println("[6] Exit");
			System.out.println();
			System.out.print("Choose an option: ");
			String option = input.nextLine();
			switch(option) {
				case "0": students.loadStudents();
					System.out.println("Done!");
			        break;
				case "1": students.outputStudentList();
					System.out.println("Done!");
		            break;
				case "2": students.addStudent();
					System.out.println("Done!");
		            break;
				case "3": students.deleteStudent();
					System.out.println("Done!");
		            break;
				case "4": students.modifyStudent();
					System.out.println("Done!");
					break;
				case "5": students.saveStudents();
					System.out.println("Done!");
		            break;
				case "6": 
					System.out.println("Good Bye!");
					System.exit(0);
			}
			System.out.println();
		}
	}
	
}