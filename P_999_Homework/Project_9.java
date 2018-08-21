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

class Student11 {
	int CIN;
	String name;
	int age;
	String major;
	int undergraduate = 1;

	Student11(int CIN, String name, int age, String major, int undergraduate) {
		
		this.CIN = CIN;
		this.name = name;
		this.age = age;
		this.major = major;
		this.undergraduate = undergraduate;
	}

	public String outputInformation11() {
		String tmp = new String(); 
		tmp = null;
		tmp = CIN + " " + age +" " + name + " " + major + " " + undergraduate;
		return tmp;

	}

	public boolean equals(Student11 s) {
		if ((this.CIN == s.CIN) && (this.name == s.name) &&
		(this.age == s.age) && (this.major == s.major)) {

			return true;
		}
		
		else {
			
			return false;
		}

	}

	public String toString11() {
		String tmp = String.valueOf(CIN);
		tmp = tmp + " " + name;
		tmp = tmp + " " + String.valueOf(age);
		tmp = tmp + " " + major;
		return tmp;
	}

	public void saveStudent11(PrintWriter pw)


	{
		pw.println(CIN);
		pw.println(name);
		pw.println(age);
		pw.println(major);
		pw.println(undergraduate);

	}

}


class GraduateStudent11 extends Student11 {
	String thesis;
	
	GraduateStudent11(int CIN, String name, int age, String major, int undergraduate, String thesis) {
		super(CIN, name, age, major, undergraduate);
		this.thesis = thesis;

	}

	public String outputInformation11() {
		String tmp;
		tmp = new String();
		tmp = super.outputInformation11() + " " + thesis;
		return tmp;

	}

	public void saveStudent11(PrintWriter pw) {
		super.saveStudent11(pw);
		pw.println(thesis);

	}

}



class UnderGraduateStudent11 extends Student11 {
	String seniorDesign;
	UnderGraduateStudent11(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
		super(CIN, name, age, major, undergraduate);
		this.seniorDesign = seniorDesign;

	}

	public String outputInformation11() {
		String tmp;
		tmp = new String();
		tmp = super.outputInformation11() + " " + seniorDesign;
		return tmp;

	}

	public void saveStudent11(PrintWriter pw)	{
		super.saveStudent11(pw);
		pw.println(seniorDesign);

	}
}


class StudentList11 {

	Student11[] studentList;
	int studentNum;
	
	public StudentList11() {

	    studentList = new Student11[100];
	    studentNum = 0;
		studentList[studentNum] = new GraduateStudent11(305469273, "Kevin Crespin", 19, "B.S Computer Science", 1, "4D Arrays");
		studentNum ++; 
		studentList[studentNum] = new UnderGraduateStudent11(305569874, "Bobby Hernandez", 20, "Computer Science", 1, "Implementation of Library System");
		studentNum ++;
		studentList[studentNum] = new GraduateStudent11(506015791, "Mary Fernandez", 18, "Computer Science", 0, "Study of 3D Image");
		studentNum ++;
		studentList[studentNum] = new UnderGraduateStudent11(605486862, "Alice Trejo", 21, "Computer Science", 1, "Development of CSU Portal");
		studentNum ++;

	}

    public void addStudent11(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
    	
		if (undergraduate == 1) {
			studentList[studentNum] = new UnderGraduateStudent11(CIN, name, age, major, undergraduate, seniorDesign);
			studentNum++;

		}
		else {
			studentList[studentNum] = new GraduateStudent11(CIN, name, age, major, undergraduate, seniorDesign);
			studentNum++;

		}
    }

	public String outputStudentList11() {
        String tmp;
        tmp = new String();
		for (int i = 0; i < studentNum; i++) {
			tmp = tmp + studentList[i].outputInformation11();
            tmp = tmp + "\n";

		}
        return tmp;

	}

	public void loadStudents11() {
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
					studentList[i] = new UnderGraduateStudent11(CIN, name, age, major, 1, seniorDesign);

				}

				else {
					String thesis = fileScanner.nextLine();
					studentList[i] = new GraduateStudent11(CIN, name, age, major, 0, thesis);
				}

			}
			fileScanner.close();
		} catch (Exception e) { 		}
	}

	public void saveStudents11() {
		File studentFile = new File("c:\\ttp\\studentFile.txt");

		try {
			PrintWriter pw = new PrintWriter(studentFile);
			pw.println(studentNum);
			
			for (int i = 0; i < studentNum; i++) {
				studentList[i].saveStudent11(pw);

			}
			pw.flush();
			pw.close();

		} catch (Exception e) { 		}

	}

	public int findIndex11(int CIN) {
		int index = -1;
		for (int i = 0; i < studentNum; i++) {
			if (CIN == studentList[i].CIN) {
				index = i;
				return index;

			}

		}
		return index;
	}

	public void deleteStudent11(int CIN) {
		int sIndex = findIndex11(CIN);

		for (int j = sIndex; j < studentNum - 1; j++) {
			studentList[j] = studentList[j+1];
			
		}
		studentNum--;
	}

	public void modifyStudent11(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
		int sIndex = findIndex11(CIN);
		
		if (undergraduate == 1) {
			studentList[sIndex] = new UnderGraduateStudent11(CIN, name, age, major, 1, seniorDesign);

		}
		
		else {
			studentList[sIndex] = new GraduateStudent11(CIN, name, age, major, 1, seniorDesign);
			
		}

	}

}


public class Project_9 extends Application {
	Label label_CIN;
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

	StudentList11 cs2012 = new StudentList11();

public void start(Stage primaryStage) throws Exception {
		label_CIN = new Label(" CIN: ");
		label_name = new Label(" Name: ");
		label_age = new Label(" Age: ");
		label_major = new Label(" Major: ");
		label_thesis_senior = new Label(" Thesis/Senior Design:");

		field_CIN = new TextField();
		field_name = new TextField();
		field_age = new TextField();
		field_major = new TextField();
		field_thesis_senior = new TextField();

		addButton = new Button("Add");
		addButton.setMaxWidth(Double.MAX_VALUE);
		showButton = new Button("Show");
		showButton.setMaxWidth(Double.MAX_VALUE);
		deleteButton = new Button("Delete");
		deleteButton.setMaxWidth(Double.MAX_VALUE);
		modifyButton = new Button("Modify");
		modifyButton.setMaxWidth(Double.MAX_VALUE);
		loadButton = new Button("Load");
		loadButton.setMaxWidth(Double.MAX_VALUE);
		saveButton = new Button("Save");
		saveButton.setMaxWidth(Double.MAX_VALUE);

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
			cs2012.addStudent11(
					Integer.parseInt(field_CIN.getText()), 
					field_name.getText(), 
					Integer.parseInt(field_age.getText()), 
					field_major.getText(), 
					under, 
					field_thesis_senior.getText());
					displayArea.setText(cs2012.outputStudentList11());
		}
		);
		
		
		showButton.setOnAction(e->{
			displayArea.setText(cs2012.outputStudentList11());
		}
		);
		
		
		deleteButton.setOnAction(e->{
			cs2012.deleteStudent11(Integer.parseInt(field_CIN.getText()));
			displayArea.setText(cs2012.outputStudentList11());
		}
		);
		

		modifyButton.setOnAction(e->{
			int under = 1;
			
			if (graduate.isSelected()) {
				under = 0;

			}

			cs2012.modifyStudent11(
					Integer.parseInt(field_CIN.getText()), 
					field_name.getText(), 
					Integer.parseInt(field_age.getText()),
					field_major.getText(),
					under, 
					field_thesis_senior.getText());
					displayArea.setText(cs2012.outputStudentList11());

		}
		);
		
		loadButton.setOnAction(e->{
			cs2012.loadStudents11();
		}
		);
		
		saveButton.setOnAction(e->{
			cs2012.saveStudents11();
		}
		);

		GridPane inputPane= new GridPane();
		
		inputPane.add(label_CIN, 0, 0);
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
        mainPane.add(outputPane, 1, 0);

		Scene mainScene = new Scene(mainPane, 800, 180);

		primaryStage.setScene(mainScene);
		primaryStage.show();

	}


public static void main(String[] args) {
		launch(args);
		
	}
}
