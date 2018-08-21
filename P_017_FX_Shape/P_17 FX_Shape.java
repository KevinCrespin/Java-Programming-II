import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class P_17 FX_Shape extends Application {
	public void start(Stage primaryStage) throws Exception {

		Text helloText = new Text("Hello...");
		helloText.setX(300);
		helloText.setY(300);
		helloText.setFont(Font.font("Verdana", 40));

		Rectangle smallRectangle = new Rectangle(50, 60, 100, 100);
		Line shortLine = new Line(200, 200, 300, 300);
		
		Pane mainPane = new Pane();
		mainPane.getChildren().add(helloText);
		mainPane.getChildren().add(smallRectangle);
		mainPane.getChildren().add(shortLine);

		Scene mainScene = new Scene(mainPane, 800, 600);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
