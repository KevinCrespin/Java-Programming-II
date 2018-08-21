import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class P_26 Mouse_Event extends Application {
	Image doggo = new Image("APPLE.gif");
	ImageView dog = new ImageView(doggo);
	int x = 400;
	int y = 350;
	int distance = 200;

	public void start(Stage primaryStage) throws Exception {

		Pane mainPane = new Pane();
		dog.setX(400);
		dog.setY(350);
		
  	    mainPane.getChildren().add(dog);
  	    
		mainPane.setOnMouseDragged(e->{
				dog.setX(e.getX());
				dog.setY(e.getY());
		}
		);

		mainPane.setOnMouseClicked(e->{
				dog.setX(e.getX());
				dog.setY(e.getY());
		}
		);

		Scene mainScene = new Scene(mainPane, 800, 700);
		mainScene.setFill(Color.BLACK);

		mainScene.addEventHandler(KeyEvent.KEY_PRESSED, (key)->{

		      if(key.getCode()==KeyCode.ENTER) {
		    	  x = 400;
		    	  y = 350;
		         
		      }
		      
		      if (key.getCode()==KeyCode.W) {
		    	  y = y - distance;
		    	  
		      }
		  
		      if (key.getCode()==KeyCode.A) {
		    	  x = x - distance;

		      }

		      if (key.getCode()==KeyCode.S) {
		    	  y = y + distance;

		      }

		      if (key.getCode()==KeyCode.D) {
		    	  x = x + distance;

		      }
			dog.setX(x);
			dog.setY(y);
		}
		);

		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
