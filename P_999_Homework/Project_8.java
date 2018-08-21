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

class Student10 {
	int CIN;
	String name;
	int age;
	String major;
	int undergraduate = 1;

	Student10(int CIN, String name, int age, String major, int undergraduate) {
		
		this.CIN = CIN;
		this.name = name;
		this.age = age;
		this.major = major;
		this.undergraduate = undergraduate;
	}

	public String outputInformation10() {
		String tmp = new String(); 
		tmp = null;
		tmp = CIN + "  " + age +"   " + name + "   " + major + "  " + undergraduate;
		return tmp;

	}
	
	public boolean equals10(Student10 s) {
		if ((this.CIN == s.CIN) && (this.name == s.name) &&
		(this.age == s.age) && (this.major == s.major)) {

			return true;
		}
		
		else {
			
			return false;
		}

	}

	public String toString10() {
		String tmp = String.valueOf(CIN);
		tmp = tmp + " " + name;
		tmp = tmp + " " + String.valueOf(age);
		tmp = tmp + " " + major;
		return tmp;
	}



}


class GraduateStudent10 extends Student10 {
	String thesis;
	
	GraduateStudent10(int CIN, String name, int age, String major, int undergraduate, String thesis) {
		super(CIN, name, age, major, undergraduate);
		this.thesis = thesis;

	}

	public String outputInformation10() {
		String tmp;
		tmp = new String();
		tmp = super.outputInformation10() + " " + thesis;
		return tmp;

	}

}



class UnderGraduateStudent10 extends Student10 {
	String seniorDesign;
	UnderGraduateStudent10(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
		super(CIN, name, age, major, undergraduate);
		this.seniorDesign = seniorDesign;

	}

	public String outputInformation10() {
		String tmp;
		tmp = new String();
		tmp = super.outputInformation10() + " " + seniorDesign;
		return tmp;

	}

}


class StudentList10 {

	Student10[] studentList10;
	int studentNum;
	
	public StudentList10() {

	    studentList10 = new Student10[100];
	    studentNum = 0;
		studentList10[studentNum] = new GraduateStudent10(305469273, "Kevin C", 19, "B.S Computer Science", 0, "Study of 4D Arrays");
		studentNum ++; 
		studentList10[studentNum] = new UnderGraduateStudent10(305569874, "Roby H", 20, "M.S Computer Science", 1, "Implementation of University App");
		studentNum ++;
		studentList10[studentNum] = new GraduateStudent10(506015791, "Marie F", 18, "M.S Computer Science", 0, "Study of 4D Arrays");
		studentNum ++;
		studentList10[studentNum] = new UnderGraduateStudent10(605486862, "Alicia T", 21, "B.S Computer Science", 1, "Development of CSU Portal");
		studentNum ++;

	}

    public void addStudent10(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
    	
		if (undergraduate == 1) {
			studentList10[studentNum] = new UnderGraduateStudent10(CIN, name, age, major, undergraduate, seniorDesign);
			studentNum++;

		}
		else {
			studentList10[studentNum] = new GraduateStudent10(CIN, name, age, major, undergraduate, seniorDesign);
			studentNum++;

		}
    }

	public String outputStudentList10() {
        String tmp;
        tmp = new String();
		for (int i = 0; i < studentNum; i++) {
			tmp = tmp + studentList10[i].outputInformation10();
            tmp = tmp + "\n";

		}
        return tmp;

	}


	public int findIndex10(int CIN) {
		int index = -1;
		for (int i = 0; i < studentNum; i++) {
			if (CIN == studentList10[i].CIN) {
				index = i;
				return index;

			}

		}
		return index;
	}

	public void deleteStudent10(int CIN) {
		int sIndex = findIndex10(CIN);

		for (int j = sIndex; j < studentNum - 1; j++) {
			studentList10[j] = studentList10[j+1];
			
		}
		studentNum--;
	}

	public void modifyStudent10(int CIN, String name, int age, String major, int undergraduate, String seniorDesign) {
		int sIndex = findIndex10(CIN);
		
		if (undergraduate == 1) {
			studentList10[sIndex] = new UnderGraduateStudent10(CIN, name, age, major, 1, seniorDesign);

		}
		
		else {
			studentList10[sIndex] = new GraduateStudent10(CIN, name, age, major, 1, seniorDesign);
			
		}

	}

}


public class Project_8 extends Application {
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

	RadioButton undergraduate;
	RadioButton graduate;

	TextArea displayArea;

	StudentList10 cs20122 = new StudentList10();

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
			cs20122.addStudent10(
					Integer.parseInt(field_CIN.getText()), 
					field_name.getText(), 
					Integer.parseInt(field_age.getText()), 
					field_major.getText(), 
					under, 
					field_thesis_senior.getText());
					displayArea.setText(cs20122.outputStudentList10());
		}
		);
		
		
		showButton.setOnAction(e->{
			displayArea.setText(cs20122.outputStudentList10());
		}
		);
		
		
		deleteButton.setOnAction(e->{
			cs20122.deleteStudent10(Integer.parseInt(field_CIN.getText()));
			displayArea.setText(cs20122.outputStudentList10());
		}
		);
		

		modifyButton.setOnAction(e->{
			int under = 1;
			
			if (graduate.isSelected()) {
				under = 0;

			}

			cs20122.modifyStudent10(
					Integer.parseInt(field_CIN.getText()), 
					field_name.getText(), 
					Integer.parseInt(field_age.getText()),
					field_major.getText(),
					under, 
					field_thesis_senior.getText());
					displayArea.setText(cs20122.outputStudentList10());

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
