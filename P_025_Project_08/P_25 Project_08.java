import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
	
	public String showStudents() {
		String studentInfo;
		studentInfo = ("CIN: " + CIN + "\n") +
		("Name: " + name + "\n") +
		("Age: " + age + "\n") +
		("Major: " + major + "\n") +
		("Units: " + units + "\n");
		return studentInfo;
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
	
	public String showStudents() {
		String studentInfo;
		studentInfo = super.showStudents() +
		("University: " + BSBAUniversity + "\n") +
		("Fee: $" + String.format("%,.2f", (units * GraduateFee)) + "\n");
		return studentInfo;
	}

}

class CalStateUndergraduateStudent2 extends CalStateStudent3 {
	String HighSchool = GraduateORUndergraduate;
	final double UndergraduateFee = 600.00;
	

	CalStateUndergraduateStudent2(int CIN, String name, int age, String major, int units, String HighSchool) {
		super(CIN, name, age, major, units, HighSchool);
		this.HighSchool = HighSchool;
	}
	
	public String showStudents() {
		String studentInfo;
		studentInfo = super.showStudents() + 
		("Highschool: " + HighSchool + "\n") +
		("Fee: $" + String.format("%,.2f", (units * UndergraduateFee)) + "\n");
		return studentInfo;
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
	
	public String showStudents() {
		String studentInfo = new String();
		for (int i = 0; i < studentNumber; i++) {
			studentInfo = studentInfo + studentList2[i].showStudents();
			studentInfo = studentInfo + "\n";
		}
		return studentInfo;
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
	}
	
	public void addStudentUndergraduate(int CIN, String name, int age, String major, int units, String highschool) {
		studentList2[studentNumber++] = new CalStateUndergraduateStudent2(CIN, name, age, major, units, highschool);
	}
	

	public void addStudentGraduate(int CIN, String name, int age, String major, int units, String university) {
		studentList2[studentNumber++] = new CalStateGraduateStudent2(CIN, name, age, major, units, university);
	}
	

	public void deleteStudentByCIN(int CIN) {
		int index = 0;
		try {
		for (int i = 0; i < studentNumber; i++) {
			if (CIN == studentList2[i].CIN) {
				index = i;
			}
		}
		
		for (int j = index; j < studentNumber - 1; j++) {
			studentList2[j] = studentList2[j + 1];
		}
		studentNumber--;
		} catch (NumberFormatException a){
			
		}
		
	}
	
	public void deleteStudentByName(String name) {
		int index = 0;
		name = name.toUpperCase();
		for (int i = 0; i < studentNumber; i++) {
			if (name.contains(studentList2[i].getName().toUpperCase())) {
				index = i;
			}
		}
		
		for (int j = index; j < studentNumber - 1; j++) {
			studentList2[j] = studentList2[j + 1];
		}
		studentNumber--;
	}
	
	
	public void modifyStudentByCIN(String studentLevel, int oldCIN, int CIN, String name, int age, String major, int units, String uniHigh) {
		int index = 0;
		try{
			for (int i = 0; i < studentNumber; i++) {
				if (oldCIN == studentList2[i].CIN) {
					index = i;
					studentLevel = studentLevel.toUpperCase();
					if (studentLevel.equals("UNDERGRADUATE")) {
						studentList2[index] = new CalStateUndergraduateStudent2(CIN, name, age, major, units, uniHigh);
					}
					else if (studentLevel.equals("GRADUATE")) {
		    			studentList2[index] = new CalStateGraduateStudent2(CIN, name, age, major, units, uniHigh);
					}
				}
			}
		} catch (NumberFormatException a){
		}
	}
	
	public void modifyStudentByName(String studentLevel, String oldName, int CIN, String name, int age, String major, int units, String uniHigh) {
		int index = 0;
		oldName = oldName.toUpperCase();
		for (int i = 0; i < studentNumber; i++) {
				if (oldName.contains(studentList2[i].getName().toUpperCase())) {
					index = i;
					studentLevel = studentLevel.toUpperCase();
					if (studentLevel.equals("UNDERGRADUATE")) {
						studentList2[index] = new CalStateUndergraduateStudent2(CIN, name, age, major, units, uniHigh);
					}
					else if (studentLevel.equals("GRADUATE")) {
		    			studentList2[index] = new CalStateGraduateStudent2(CIN, name, age, major, units, uniHigh);
					}
				}
		}
	}
}


public class P_25 Project_08 extends Application {
	Label label_CIN;
	Label label_name;
	Label label_age;
	Label label_major;
	Label label_units;
	Label label_university;
	Label label_highSchool;
	
	TextField field_CIN;
	TextField field_name;
	TextField field_age;
	TextField field_major;
	TextField field_units;
	TextField field_university;
	TextField field_highSchool;

	Button addButton;
	Button showButton;
	Button deleteButton;
	Button modifyButton;
	Button exitButton;
	
	Button undergraduateButton;
	Button graduateButton;
	
	Button CINButton;
	Button nameButton;
	
	Button sortByNothingButton;
	Button sortByCINButton;
	Button sortByNameButton;
	Button sortByAgeButton;

	TextArea displayArea;
	
	StudentList2 menu = new StudentList2();
	
	public void start(Stage primaryStage) throws Exception {
		label_CIN = new Label(" CIN: ");
		label_name = new Label(" Name: ");
		label_age = new Label(" Age: ");
		label_major = new Label(" Major: ");
		label_units = new Label(" Units:");
		label_university = new Label(" University: ");
		label_highSchool = new Label(" Highschool: ");

		field_CIN = new TextField();
		field_name = new TextField();
		field_age = new TextField();
		field_major = new TextField();
		field_units = new TextField();
		field_university = new TextField();
		field_highSchool = new TextField();

		showButton = new Button("Show Student List");
		showButton.setMaxWidth(Double.MAX_VALUE);
		addButton = new Button("Add Student");
		addButton.setMaxWidth(Double.MAX_VALUE);
		deleteButton = new Button("Delete Student");
		deleteButton.setMaxWidth(Double.MAX_VALUE);
		modifyButton = new Button("Modify Student");
		modifyButton.setMaxWidth(Double.MAX_VALUE);
		exitButton = new Button("Exit");
		exitButton.setMaxWidth(Double.MAX_VALUE);

		displayArea = new TextArea();
		displayArea.setMinWidth(100);
		displayArea.setMinHeight(600);
		
		GridPane inputPane = new GridPane();
		
		showButton.setOnAction(e->{
			printBy();
		}
		);
		
		addButton.setOnAction(e->{
			addlevelWindow();
		}
		);
		
		
		deleteButton.setOnAction(e->{
			deleteByWindow();
		}
		);
	
		modifyButton.setOnAction(e->{
			modifyByWindow();
		}
		);
	
		exitButton.setOnAction(e->{
			System.exit(0);
		}
		);
	
		inputPane.add(showButton, 0, 0);
		inputPane.add(addButton, 0, 1);
		inputPane.add(deleteButton, 0, 2);
		inputPane.add(modifyButton, 0, 3);
		inputPane.add(exitButton, 0, 4);

        	GridPane outputPane = new GridPane();

        	outputPane.add(displayArea, 0, 0);

        	GridPane mainPane = new GridPane();
        
        	mainPane.add(inputPane, 0, 0);
        	mainPane.add(outputPane, 1, 0);

		Scene mainScene = new Scene(mainPane, 590, 600);

		primaryStage.setScene(mainScene);
		primaryStage.show();

	}
	
	public void printBy() {
		
		Stage printByStage = new Stage();
		Label label_PrintByInfo = new Label("Select an option");
		
		sortByNothingButton = new Button("Show List");
		sortByNothingButton.setMaxWidth(Double.MAX_VALUE);
		sortByCINButton = new Button("Show List Sorted By CIN");
		sortByCINButton.setMaxWidth(Double.MAX_VALUE);
		sortByNameButton = new Button("Show List Sorted by Name");
		sortByNameButton.setMaxWidth(Double.MAX_VALUE);
		sortByAgeButton = new Button("Show List Sorted by Age");
		sortByAgeButton.setMaxWidth(Double.MAX_VALUE);
		
		sortByNothingButton.setOnAction(e->{
			displayArea.setText(menu.showStudents());
			printByStage.close();
		}
		);
		
		sortByCINButton.setOnAction(e->{
			menu.showStudentByCIN();
			displayArea.setText(menu.showStudents());
			printByStage.close();
		}
		);
		
		sortByNameButton.setOnAction(e->{
			menu.showStudentByName();
			displayArea.setText(menu.showStudents());
			printByStage.close();
		}
		);
		
		sortByAgeButton.setOnAction(e->{
			menu.showStudentByAge();
			displayArea.setText(menu.showStudents());
			printByStage.close();
		}
		);
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_PrintByInfo, 0, 0);
		gridPane.add(sortByNothingButton, 0, 1);
		gridPane.add(sortByCINButton, 0, 2);

		gridPane.add(sortByNameButton, 1, 1);
		gridPane.add(sortByAgeButton, 1, 2);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 300, 70);
		
		printByStage.setScene(mainScene);
		printByStage.show();
	}
	
	public void addlevelWindow() {
		
		Stage addlevelStage = new Stage();
		Label label_levelInfo = new Label("Enter Student level");
		
		undergraduateButton = new Button(" Undergraduate");
		undergraduateButton.setMaxWidth(Double.MAX_VALUE);
		graduateButton = new Button("Graduate");
		graduateButton.setMaxWidth(Double.MAX_VALUE);
		
		undergraduateButton.setOnAction(e->{
			addUndergraduateWindow();
			addlevelStage.close();
		}
		);
		
		graduateButton.setOnAction(e->{
			addGraduateWindow();
			addlevelStage.close();
		}
		);
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_levelInfo, 0, 0);
		gridPane.add(graduateButton, 0, 1);
		gridPane.add(undergraduateButton, 1, 1);
		
		GridPane mainPane = new GridPane();
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 200, 45);
		
		addlevelStage.setScene(mainScene);
		addlevelStage.show();
		
	}
	
	public void addGraduateWindow() {
		
		Stage addGraduateStage = new Stage();
		Button addStudentButton = new Button("Add Student");
		
		GridPane gridPane = new GridPane();
	
		gridPane.add(label_CIN, 0, 0);
		gridPane.add(label_name, 0, 1);
		gridPane.add(label_age, 0, 2);
		gridPane.add(label_major, 0, 3);
		gridPane.add(label_units, 0, 4);
		gridPane.add(label_university, 0, 5);
		
		gridPane.add(field_CIN, 1, 0);
		gridPane.add(field_name, 1, 1);
		gridPane.add(field_age, 1, 2);
		gridPane.add(field_major, 1, 3);
		gridPane.add(field_units, 1, 4);
		gridPane.add(field_university, 1, 5);
		gridPane.add(addStudentButton, 1, 6);
		addStudentButton.setMaxWidth(Double.MAX_VALUE);
		
		addStudentButton.setOnAction(e->{
			menu.addStudentGraduate(Integer.parseInt(field_CIN.getText()), 
								 field_name.getText(),
								 Integer.parseInt(field_age.getText()),
								 field_major.getText(),
								 Integer.parseInt(field_units.getText()),
								 field_university.getText());
			displayArea.setText(menu.showStudents());
			addGraduateStage.close();
		}
		);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 215, 180);
		
		addGraduateStage.setScene(mainScene);
		addGraduateStage.show();
	}
	
	public void addUndergraduateWindow() {
		
		Stage addUndergraduateStage = new Stage();
		Button addStudentButton = new Button("Add Student");
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_CIN, 0, 0);
		gridPane.add(label_name, 0, 1);
		gridPane.add(label_age, 0, 2);
		gridPane.add(label_major, 0, 3);
		gridPane.add(label_units, 0, 4);
		gridPane.add(label_highSchool, 0, 5);
		
		gridPane.add(field_CIN, 1, 0);
		gridPane.add(field_name, 1, 1);
		gridPane.add(field_age, 1, 2);
		gridPane.add(field_major, 1, 3);
		gridPane.add(field_units, 1, 4);
		gridPane.add(field_highSchool, 1, 5);
		gridPane.add(addStudentButton, 1, 6);
		addStudentButton.setMaxWidth(Double.MAX_VALUE);
		
		addStudentButton.setOnAction(e->{
			menu.addStudentUndergraduate(Integer.parseInt(field_CIN.getText()), 
					 				field_name.getText(),
					 				Integer.parseInt(field_age.getText()),
					 				field_major.getText(),
					 				Integer.parseInt(field_units.getText()),
					 				field_highSchool.getText());
			displayArea.setText(menu.showStudents());
			addUndergraduateStage.close();
		}
		);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 220, 180);
		
		addUndergraduateStage.setScene(mainScene);
		addUndergraduateStage.show();
	}
	
	public void deleteByWindow() {
		
		Stage deleteByStage = new Stage();
		Label label_deleteBy = new Label(" Delete Using");
		
		CINButton = new Button("Student CIN");
		CINButton.setMaxWidth(Double.MAX_VALUE);
		nameButton = new Button("Student Name");
		nameButton.setMaxWidth(Double.MAX_VALUE);
		
		CINButton.setOnAction(e->{
			deleteCINWindow();
			deleteByStage.close();
		}
		);
		
		nameButton.setOnAction(e->{
			deleteNameWindow();
			deleteByStage.close();
		}
		);
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_deleteBy, 0, 0);
		gridPane.add(CINButton, 0, 1);
		gridPane.add(nameButton, 1, 1);
		
		GridPane mainPane = new GridPane();
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 174, 45);
		
		deleteByStage.setScene(mainScene);
		deleteByStage.show();
		
	}
	
	public void deleteCINWindow() {
		
		Stage deleteCINStage = new Stage();
		Button deleteStudentButton = new Button("Delete Student");
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_CIN, 0, 0);
		
		gridPane.add(field_CIN, 1, 0);
		gridPane.add(deleteStudentButton, 1, 1);
		deleteStudentButton.setMaxWidth(Double.MAX_VALUE);
		
		deleteStudentButton.setOnAction(e->{
			menu.deleteStudentByCIN(Integer.parseInt(field_CIN.getText()));
			displayArea.setText(menu.showStudents());
			deleteCINStage.close();
		}
		);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 180, 52);
		
		deleteCINStage.setScene(mainScene);
		deleteCINStage.show();
	}
	
	public void deleteNameWindow() {
		
		Stage deleteNameStage = new Stage();
		Button deleteStudentButton = new Button("Delete Student");
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_name, 0, 0);
		
		gridPane.add(field_name, 1, 0);
		gridPane.add(deleteStudentButton, 1, 1);
		deleteStudentButton.setMaxWidth(Double.MAX_VALUE);
		
		deleteStudentButton.setOnAction(e->{
			menu.deleteStudentByName(field_name.getText());
			displayArea.setText(menu.showStudents());
			deleteNameStage.close();
		}
		);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 192, 52);
		
		deleteNameStage.setScene(mainScene);
		deleteNameStage.show();
	}
	
	public void modifyByWindow() {
		
		Stage modifyByStage = new Stage();
		Label label_deleteBy = new Label(" Modify Using");
		
		CINButton = new Button("Student CIN");
		CINButton.setMaxWidth(Double.MAX_VALUE);
		nameButton = new Button("Student Name");
		nameButton.setMaxWidth(Double.MAX_VALUE);
		
		CINButton.setOnAction(e->{
			modifyCINWindow();
			modifyByStage.close();
		}
		);
		
		nameButton.setOnAction(e->{
			modifyNameWindow();
			modifyByStage.close();
		}
		);
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_deleteBy, 0, 0);
		gridPane.add(CINButton, 0, 1);
		gridPane.add(nameButton, 1, 1);
		
		GridPane mainPane = new GridPane();
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 174, 45);
		
		modifyByStage.setScene(mainScene);
		modifyByStage.show();
		
	}
	
	public void modifyCINWindow() {
		
		Stage modifyCINStage = new Stage();
		
		Label label_modifyCIN = new Label("OLD CIN:");
		Label new_CIN = new Label("NEW CIN:");
		Label new_name = new Label("NEW Name:");
		Label new_age = new Label("NEW Age:");
		Label new_major = new Label("NEW Major:");
		Label new_units = new Label("NEW Units:");
		Label new_uniHigh = new Label("NEW University/Highschool:");
		
		TextField field_modifyCIN = new TextField();
		TextField field_uniHigh = new TextField();
	
		undergraduateButton = new Button(" Undergraduate");
		undergraduateButton.setMaxWidth(Double.MAX_VALUE);
		graduateButton = new Button("Graduate");
		graduateButton.setMaxWidth(Double.MAX_VALUE);
		
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_modifyCIN, 0, 0);
		gridPane.add(new_CIN, 0, 1);
		gridPane.add(new_name, 0, 2);
		gridPane.add(new_age, 0, 3);
		gridPane.add(new_major, 0, 4);
		gridPane.add(new_units, 0, 5);
		gridPane.add(new_uniHigh, 0, 6);
		gridPane.add(graduateButton, 0, 7);
		
		gridPane.add(field_modifyCIN, 1, 0);
		gridPane.add(field_CIN, 1, 1);
		gridPane.add(field_name, 1, 2);
		gridPane.add(field_age, 1, 3);
		gridPane.add(field_major, 1, 4);
		gridPane.add(field_units, 1, 5);
		gridPane.add(field_uniHigh, 1, 6);
		gridPane.add(undergraduateButton, 1, 7);
		
		undergraduateButton.setOnAction(e->{
			menu.modifyStudentByCIN("UNDERGRADUATE", 
									Integer.parseInt(field_modifyCIN.getText()),
									Integer.parseInt(field_CIN.getText()), 
									field_name.getText(),
									Integer.parseInt(field_age.getText()),
									field_major.getText(),
									Integer.parseInt(field_units.getText()),
									field_uniHigh.getText());
			displayArea.setText(menu.showStudents());
			modifyCINStage.close();
		}
		);
		
		graduateButton.setOnAction(e->{
			menu.modifyStudentByCIN("GRADUATE", 
									Integer.parseInt(field_modifyCIN.getText()),
									Integer.parseInt(field_CIN.getText()), 
									field_name.getText(),
									Integer.parseInt(field_age.getText()),
									field_major.getText(),
									Integer.parseInt(field_units.getText()),
									field_uniHigh.getText());
			displayArea.setText(menu.showStudents());
			modifyCINStage.close();
		}
		);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 298, 200);
		
		modifyCINStage.setScene(mainScene);
		modifyCINStage.show();
	}
	
	public void modifyNameWindow() {
		
		Stage modifyNameStage = new Stage();
		
		Label label_modifyName = new Label("OLD Name:");
		Label new_CIN = new Label("NEW CIN:");
		Label new_name = new Label("NEW Name:");
		Label new_age = new Label("NEW Age:");
		Label new_major = new Label("NEW Major:");
		Label new_units = new Label("NEW Units:");
		Label new_uniHigh = new Label("NEW University/Highschool:");
		
		TextField field_modifyName = new TextField();
		TextField field_uniHigh = new TextField();
	
		undergraduateButton = new Button(" Undergraduate");
		undergraduateButton.setMaxWidth(Double.MAX_VALUE);
		graduateButton = new Button("Graduate");
		graduateButton.setMaxWidth(Double.MAX_VALUE);
		
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(label_modifyName, 0, 0);
		gridPane.add(new_CIN, 0, 1);
		gridPane.add(new_name, 0, 2);
		gridPane.add(new_age, 0, 3);
		gridPane.add(new_major, 0, 4);
		gridPane.add(new_units, 0, 5);
		gridPane.add(new_uniHigh, 0, 6);
		gridPane.add(graduateButton, 0, 7);
		
		gridPane.add(field_modifyName, 1, 0);
		gridPane.add(field_CIN, 1, 1);
		gridPane.add(field_name, 1, 2);
		gridPane.add(field_age, 1, 3);
		gridPane.add(field_major, 1, 4);
		gridPane.add(field_units, 1, 5);
		gridPane.add(field_uniHigh, 1, 6);
		gridPane.add(undergraduateButton, 1, 7);
		
		undergraduateButton.setOnAction(e->{
			menu.modifyStudentByName("UNDERGRADUATE", 
									field_modifyName.getText(),
									Integer.parseInt(field_CIN.getText()), 
									field_name.getText(),
									Integer.parseInt(field_age.getText()),
									field_major.getText(),
									Integer.parseInt(field_units.getText()),
									field_uniHigh.getText());
			displayArea.setText(menu.showStudents());
			modifyNameStage.close();
		}
		);
		
		graduateButton.setOnAction(e->{
			menu.modifyStudentByName("GRADUATE", 
									field_modifyName.getText(),
									Integer.parseInt(field_CIN.getText()), 
									field_name.getText(),
									Integer.parseInt(field_age.getText()),
									field_major.getText(),
									Integer.parseInt(field_units.getText()),
									field_uniHigh.getText());
			displayArea.setText(menu.showStudents());
			modifyNameStage.close();
		}
		);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(gridPane, 0, 0);
		
		Scene mainScene = new Scene(mainPane, 298, 200);
		
		modifyNameStage.setScene(mainScene);
		modifyNameStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
