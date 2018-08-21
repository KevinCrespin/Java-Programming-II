import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class P_23 FX_More_Controls extends Application {

	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		CheckBox checkBox = new CheckBox();

		mainPane.getChildren().add(checkBox);
		Scene mainScene = new Scene(mainPane, 200, 300);
		
		checkBox.setOnAction(e-> {
			System.out.println("CHECKED");
		});
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
