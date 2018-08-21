import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class P_19 Add_Numbers extends Application  {

	TextField num1Field = new TextField();
	TextField num2Field = new TextField();
	TextField totalField = new TextField();

	public void start(Stage primaryStage) throws Exception {

		GridPane mainPane = new GridPane();
		Label num1 = new Label("  Number 1   ");
		Label num2 = new Label("  Number 2   ");
		Button addButton = new Button("Add");

		mainPane.add(num1, 0, 0);
		mainPane.add(num2, 0, 1);
		mainPane.add(addButton, 0, 2);

		mainPane.add(num1Field, 1, 0);
		mainPane.add(num2Field, 1, 1);
		mainPane.add(totalField, 1, 2);

		addButton.setOnAction(new addButtonHandler());
		totalField.setOnAction(new addButtonHandler());

		Scene mainScene = new Scene(mainPane, 230, 100);
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	
	class addButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			
			int num1v = Integer.parseInt(num1Field.getText());
			int num2v = Integer.parseInt(num2Field.getText());
			int total = num1v + num2v;
			totalField.setText(String.valueOf(total));

		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}

}
