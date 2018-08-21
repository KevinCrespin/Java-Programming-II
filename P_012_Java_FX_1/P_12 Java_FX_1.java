import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class P_13 Java_FX_1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane shapePane = new Pane();
		Circle smallCircle = new Circle();
		smallCircle.centerXProperty().bind(shapePane.widthProperty().divide(2));
		smallCircle.centerYProperty().bind(shapePane.heightProperty().divide(2));
		smallCircle.setRadius(150);
		smallCircle.setFill(Color.RED);
		
		shapePane.getChildren().add(smallCircle);
		
		Scene mainScene = new Scene(shapePane, 600, 400);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
		Button someButton = new Button("Better");
		Scene someScene = new Scene(someButton, 400, 300);
		Stage someStage = new Stage();
		someStage.setScene(someScene);
		someStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
