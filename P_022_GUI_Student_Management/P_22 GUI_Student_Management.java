import javafx.application.Application;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Scanner;
import java.io.*;

class Student {
	int CIN;
	String name;
	int age;
	String major;
	int undergraduate = 1;

	Student(int CIN, String name, int age, String major, int undergraduate) {
		
		this.CIN = CIN;
		this.name = name;
		this.age = age;
		this.major = major;
		this.undergraduate = undergraduate;
	}

	public String outputInformation() {
		String tmp = new String(); 
		tmp = null;
		tmp = CIN + " " + age +" " + name + " " + major + " " + undergraduate;
		return tmp;

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

	public void saveStudent(PrintWriter pw)


	{
		pw.println(CIN);
		pw.println(name);
		pw.println(age);
		pw.println(major);
		pw.println(undergraduate);

	}

}


class GraduateStudent extends Student {
	String thesis;
	
	GraduateStudent(int CIN, String name, int age, String major, int undergraduate, String thesis) {
		super(CIN, name, age, major, undergraduate);
		this.thesis = thesis;

	}

	public String outputInformation() {
		String tmp;
		tmp = new String();
		tmp = super.outputInformation() + " " + thesis;
		return tmp;

	}

	public void saveStudent(PrintWriter pw) {
		super.saveStudent(pw);
		pw.println(thesis);

	}

}



class UnderGraduateStudent extends Student {
	String seniorDesign;
	UnderGraduateStudent(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
		super(CIN, name, age, major, undergraduate);
		this.seniorDesign = seniorDesign;

	}

	public String outputInformation() {
		String tmp;
		tmp = new String();
		tmp = super.outputInformation() + " " + seniorDesign;
		return tmp;

	}

	public void saveStudent(PrintWriter pw)	{
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
		studentList[studentNum] = new GraduateStudent(305469273, "Kevin Crespin", 19, "Computer Science", 0, "Study of IoT");
		studentNum ++; 
		studentList[studentNum] = new UnderGraduateStudent(305569874, "Bobby Hernandez", 20, "Computer Science", 1, "Implementation of Library System");
		studentNum ++;
		studentList[studentNum] = new GraduateStudent(506015791, "Mary Fernandez", 18, "Computer Science", 0, "Study of 3D Image");
		studentNum ++;
		studentList[studentNum] = new UnderGraduateStudent(605486862, "Alice Trejo", 21, "Computer Science", 1, "Development of CSU Portal");
		studentNum ++;

	}

    public void addStudent(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
    	
		if (undergraduate == 1) {
			studentList[studentNum] = new UnderGraduateStudent(CIN, name, age, major, undergraduate, seniorDesign);
			studentNum++;

		}
		else {
			studentList[studentNum] = new GraduateStudent(CIN, name, age, major, undergraduate, seniorDesign);
			studentNum++;

		}
    }

	public String outputStudentList() {
        String tmp;
        tmp = new String();
		for (int i = 0; i < studentNum; i++) {
			tmp = tmp + studentList[i].outputInformation();
            tmp = tmp + "\n";

		}
        return tmp;

	}

	public void loadStudents() {
		File studentFile = new File("c:\\ttp\\studentFile.txt");
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

	public void saveStudents() {
		File studentFile = new File("c:\\ttp\\studentFile.txt");

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

	public int findIndex(int CIN) {
		int index = -1;
		for (int i = 0; i < studentNum; i++) {
			if (CIN == studentList[i].CIN) {
				index = i;
				return index;

			}

		}
		return index;
	}

	public void deleteStudent(int CIN) {
		int sIndex = findIndex(CIN);

		for (int j = sIndex; j < studentNum - 1; j++) {
			studentList[j] = studentList[j+1];
			
		}
		studentNum--;
	}

	public void modifyStudent(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
		int sIndex = findIndex(CIN);
		
		if (undergraduate == 1) {
			studentList[sIndex] = new UnderGraduateStudent(CIN, name, age, major, 1, seniorDesign);

		}
		
		else {
			studentList[sIndex] = new GraduateStudent(CIN, name, age, major, 1, seniorDesign);
			
		}

	}

}


public class P_22 GUI_Student_Management extends Application {
	Label lable_CIN;
	Label label_name;
	Label label_age;
	Label label_major;
	Label label_thesis_senior;
	
	TextField field_CIN;
	TextField field_name;
	TextField field_age;
	TextField field_major;
	TextField field_thesis_senior;

	Button addButton;
	Button showButton;
	Button deleteButton;
	Button modifyButton;
	Button loadButton;
	Button saveButton;

	RadioButton undergraduate;
	RadioButton graduate;

	TextArea displayArea;

	StudentList cs2012 = new StudentList();

public void start(Stage primaryStage) throws Exception {
		lable_CIN = new Label("CIN: ");
		label_name = new Label("Name: ");
		label_age = new Label("Age: ");
		label_major = new Label("Major: ");
		label_thesis_senior = new Label("Thesis/Senior Design:");

		field_CIN = new TextField();
		field_name = new TextField();
		field_age = new TextField();
		field_major = new TextField();
		field_thesis_senior = new TextField();

		addButton = new Button("Add Student");
		showButton = new Button("Show Student");
		deleteButton = new Button("Delete Student");
		modifyButton = new Button("Modify Student");
		loadButton = new Button("Load Student");
		saveButton = new Button("Save Student");

		undergraduate = new RadioButton("Undergraduate");
		graduate = new RadioButton("Graduate");

		ToggleGroup tgrp = new ToggleGroup();

		undergraduate.setToggleGroup(tgrp);
		graduate.setToggleGroup(tgrp);

		displayArea = new TextArea();

		
		addButton.setOnAction(e->{
			int under = 1;
			
			if (graduate.isSelected()) {
				under = 0;

			}
			cs2012.addStudent(
					Integer.parseInt(field_CIN.getText()), 
					field_name.getText(), 
					Integer.parseInt(field_age.getText()), 
					field_major.getText(), 
					under, 
					field_thesis_senior.getText());
					displayArea.setText(cs2012.outputStudentList());
		}
		);
		
		
		showButton.setOnAction(e->{
			displayArea.setText(cs2012.outputStudentList());
		}
		);
		
		
		deleteButton.setOnAction(e->{
			cs2012.deleteStudent(Integer.parseInt(field_CIN.getText()));
			displayArea.setText(cs2012.outputStudentList());
		}
		);
		

		modifyButton.setOnAction(e->{
			int under = 1;
			
			if (graduate.isSelected()) {
				under = 0;

			}

			cs2012.modifyStudent(
					Integer.parseInt(field_CIN.getText()), 
					field_name.getText(), 
					Integer.parseInt(field_age.getText()),
					field_major.getText(),
					under, 
					field_thesis_senior.getText());
					displayArea.setText(cs2012.outputStudentList());

		}
		);
		
		loadButton.setOnAction(e->{
			cs2012.loadStudents();
		}
		);
		
		saveButton.setOnAction(e->{
			cs2012.saveStudents();
		}
		);

		GridPane inputPane= new GridPane();
		
		inputPane.add(lable_CIN, 0, 0);
		inputPane.add(label_name, 0, 1);
		inputPane.add(label_age, 0, 2);
		inputPane.add(label_major, 0, 3);
		inputPane.add(label_thesis_senior, 0, 4);

		inputPane.add(field_CIN, 1, 0);
		inputPane.add(field_name, 1, 1);
		inputPane.add(field_age, 1, 2);
		inputPane.add(field_major, 1, 3);
		inputPane.add(field_thesis_senior, 1, 4);

		inputPane.add(addButton, 2, 0);
		inputPane.add(showButton, 2, 1);
		inputPane.add(deleteButton, 2, 2);
		inputPane.add(modifyButton, 2, 3);
		inputPane.add(loadButton, 2, 4);
		inputPane.add(saveButton, 2, 5);

		inputPane.add(undergraduate, 1, 5);
        inputPane.add(graduate, 1, 6);

        GridPane outputPane = new GridPane();

        outputPane.add(displayArea, 0, 0);

        GridPane mainPane = new GridPane();
        
        mainPane.add(inputPane, 0, 0);
        mainPane.add(outputPane, 0, 1);

		Scene mainScene = new Scene(mainPane, 470, 350);

		primaryStage.setScene(mainScene);
		primaryStage.show();

	}


public static void main(String[] args) {
		launch(args);
		
	}
}
