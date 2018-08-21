import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class Ok implements EventHandler<ActionEvent> {
	
	public void handle(ActionEvent event) {
		System.out.println("hellooo...");
		
	}

} 

public class P_18 OK_Button_Handler extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		Button okButton = new Button("ok");
		Ok obHandler = new Ok();
		okButton.setOnAction(obHandler);
		
		Pane mainPane = new Pane();
		mainPane.getChildren().add(okButton);

		Scene mainScene = new Scene(mainPane, 200, 100);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}