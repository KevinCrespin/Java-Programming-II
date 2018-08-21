import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class P_16 Grid_Pane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane mainGridPane = new GridPane();
		Button okButton = new Button("OK");
		Button cancelButton = new Button("CANCEL");
		Button exitButton = new Button ("EXIT");
		
		mainGridPane.add(okButton, 0, 0);
		mainGridPane.add(cancelButton, 1, 0);
		mainGridPane.add(exitButton, 1, 1);
		
		Scene mainScene = new Scene(mainGridPane, 400, 500);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		}
	

	public static void main(String[] args) {
		launch(args);
	}

}
