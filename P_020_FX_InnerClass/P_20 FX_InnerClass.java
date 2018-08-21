import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class P_20 FX_InnerClass extends Application {
	int radius = 20;
	
	Circle myCircle = new Circle();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane buttonGridPane = new GridPane();
		
		Button enlarge = new Button("Enlarge");
		Button shrink = new Button("Shrink");
		
		// EventHandler Class
		enlarge.setOnAction(new EnlargeButtonHandler());
		// Event
		shrink.setOnAction(ShrinkButtonEvent -> {
			radius = radius - 5;
			myCircle.setRadius(radius);
		});
		
		buttonGridPane.add(enlarge, 0,  0);
		buttonGridPane.add(shrink, 1, 0);
		
		myCircle.setCenterX(100);
		myCircle.setCenterY(100);
		myCircle.setRadius(radius);
		
		Pane mainPane = new Pane();
		mainPane.getChildren().add(buttonGridPane);
		mainPane.getChildren().add(myCircle);
		
		Scene mainScene = new Scene(mainPane, 400, 200);
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}
	
	class EnlargeButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			radius = radius + 5;
			myCircle.setRadius(radius);		
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
