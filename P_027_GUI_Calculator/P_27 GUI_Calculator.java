import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class P_27 GUI_Calculator extends Application {
		Button one;		
		Button two;
		Button three;
		Button four;
		Button five;
		Button six;
		Button seven;
		Button eight;
		Button nine;
		Button zero;
		
		Button addition;
		Button substraction;
		Button multiplication;
		Button division;
		Button power;
		Button root;
		Button equal;
		Button point;
		Button delete;
		Button clearEntry;
		
		TextArea displayArea;
		
		String output = "";
		int operation = 0;
		Double temp1 = 0.0;
		Double temp2 = 0.0;
		
	public void start(Stage primaryStage) throws Exception {
		
		one = new Button("1");
		one.setMinSize(75, 50);
		
		two = new Button("2");
		two.setMinSize(75, 50);
		
		three = new Button("3");
		three.setMinSize(75, 50);
		
		four = new Button("4");
		four.setMinSize(75, 50);
		
		five = new Button("5");
		five.setMinSize(75, 50);
		
		six = new Button("6");
		six.setMinSize(75, 50);
		
		seven = new Button("7");
		seven.setMinSize(75, 50);
		
		eight = new Button("8");
		eight.setMinSize(75, 50);
		
		nine = new Button("9");
		nine.setMinSize(75, 50);
		
		zero = new Button("0");
		zero.setMinSize(75, 50);
		
		addition = new Button("+");
		addition.setMinSize(75, 50);
		
		substraction = new Button("-");
		substraction.setMinSize(75, 50);
		
		multiplication = new Button("*");
		multiplication.setMinSize(75, 50);
		
		division = new Button("/");
		division.setMinSize(75, 50);
		
		power = new Button("^");
		power.setMinSize(75, 50);
		
		Image sqr = new Image("root.png");
		ImageView sq = new ImageView(sqr);
		sq.setFitHeight(25);
		sq.setFitWidth(25);
		root = new Button("", sq);
		root.setMinSize(75, 50);
		
		equal = new Button("=");
		equal.setMinSize(75, 50);
		
		point = new Button(".");
		point.setMinSize(75, 50);
		
		delete = new Button("DELETE");
		delete.setMinSize(75, 50);
		
		clearEntry = new Button("CE");
		clearEntry.setMinSize(75, 50);
		
		displayArea = new TextArea();
		displayArea.setMinWidth(300);
		displayArea.setMinHeight(100);
		displayArea.setFont(Font.font ("Computerfont", 20));
		displayArea.setEditable(false);
		
		GridPane outputPane = new GridPane();
		
		outputPane.add(displayArea, 0, 0);
		
		GridPane inputPane = new GridPane();
		
		inputPane.add(root, 0, 0);
		inputPane.add(power, 1, 0);
		inputPane.add(division, 2, 0);
		inputPane.add(clearEntry, 3, 0);
		
		inputPane.add(seven, 0, 1);
		inputPane.add(eight, 1, 1);
		inputPane.add(nine, 2, 1);
		inputPane.add(multiplication, 3, 1);
		
		inputPane.add(four, 0, 2);
		inputPane.add(five, 1, 2);
		inputPane.add(six, 2, 2);
		inputPane.add(substraction, 3, 2);
		
		inputPane.add(one, 0, 3);
		inputPane.add(two, 1, 3);
		inputPane.add(three, 2, 3);
		inputPane.add(addition, 3, 3);
		
		inputPane.add(delete, 0, 4);
		inputPane.add(zero, 1, 4);
		inputPane.add(point, 2, 4);
		inputPane.add(equal, 3, 4);
		
		GridPane mainPane = new GridPane();
		
		mainPane.add(outputPane, 0 , 0);
		mainPane.add(inputPane, 0 , 1);
		
		Scene mainScene = new Scene(mainPane, 300, 400);
		
		numButtonActions();
		opButtonActions();
		
		primaryStage.setScene(mainScene);
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.setTitle("Calculator");
		primaryStage.getIcons().add(new Image("icon.png"));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void numButtonActions() {
		
		one.setOnAction(e->{ 
			output = output + "1";
			displayArea.setText(output);
		}
		);
		
		two.setOnAction(e->{
			output = output + "2";
			displayArea.setText(output);
		}
		);
		
		three.setOnAction(e->{
			output = output + "3";
			displayArea.setText(output);
		}
		);
		
		four.setOnAction(e->{
			output = output + "4";
			displayArea.setText(output);
		}
		);
		
		five.setOnAction(e->{
			output = output + "5";
			displayArea.setText(output);
		}
		);
		
		six.setOnAction(e->{
			output = output + "6";
			displayArea.setText(output);
		}
		);
		
		seven.setOnAction(e->{
			output = output + "7";
			displayArea.setText(output);
		}
		);
		
		eight.setOnAction(e->{
			output = output + "8";
			displayArea.setText(output);
		}
		);
		
		nine.setOnAction(e->{
			output = output + "9";
			displayArea.setText(output);
		}
		);
		
		zero.setOnAction(e->{
			output = output + "0";
			displayArea.setText(output);
		}
		);
		
	}
	
	public void opButtonActions() {
		
		addition.setOnAction(e->{
			temp1 = Double.parseDouble(output);
			output = output + " + ";
			operation = 1;
			displayArea.setText(output);
		}
		);
		
		substraction.setOnAction(e->{
			temp1 = Double.parseDouble(output);
			output = output + " - ";
			operation = 2;
			displayArea.setText(output);
		}
		);
		
		multiplication.setOnAction(e->{
			temp1 = Double.parseDouble(output);
			output = output + " * ";
			operation = 3;
			displayArea.setText(output);
		}
		);
		
		division.setOnAction(e->{
			temp1 = Double.parseDouble(output);
			output = output + " / ";
			operation = 4;
			displayArea.setText(output);
		}
		);
		
		power.setOnAction(e->{
			temp1 = Double.parseDouble(output);
			output = output + " ^ ";
			operation = 5;
			displayArea.setText(output);
		}
		);

		root.setOnAction(e->{
			temp1 = Math.pow(Double.parseDouble(output), 0.5);
			displayArea.setText(Double.toString(temp1));
			clear();
		}
		);
		
		equal.setOnAction(e->{
			String[] splitedOutput = output.split(" ");
			temp2 = Double.parseDouble(splitedOutput[2]);
			switch(operation) {
				case 1:
					output = Double.toString(temp1 + temp2);
					break;
				case 2:
					output = Double.toString(temp1 - temp2);
					break;
				case 3:
					output = Double.toString(temp1 * temp2);
					break;
				case 4:
					output = Double.toString(temp1 / temp2);
					break;
				case 5:
					output = Double.toString(Math.pow(temp1, temp2));
					break;
				default:
					output = "ERROR";
					break;
			}
			if (output.charAt((output.length() - 1)) == 48) {
				output = output.substring(0, output.length() - 2);
			}
			displayArea.setText(output);
			clear();
		}
		);
		
		point.setOnAction(e->{
			output = output + ".";
			displayArea.setText(output);
		}
		);
		
		delete.setOnAction(e->{
			output = output.substring(0, output.length() - 1);
			displayArea.setText(output);
		}
		);
		
		clearEntry.setOnAction(e->{
			clear();
			displayArea.setText(output);
		}
		);
		
	}
	
	public void clear() {
		output = "";
		temp1 = 0.0;
		temp2 = 0.0;
		operation = 0;
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}