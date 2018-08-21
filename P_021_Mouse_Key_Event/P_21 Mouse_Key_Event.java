import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class P_21 Mouse_Key_Event extends Application {

	Circle c;
	int x = 400;
	int y = 350;
	int distance = 100;

	public void start(Stage primaryStage) throws Exception {

		Pane mainPane = new Pane();
		c = new Circle();
		c.setFill(Color.WHITE);
		c.setRadius(30);
		c.setCenterX(400);
		c.setCenterY(350);
		
  	    mainPane.getChildren().add(c);
  	    
  	    
		mainPane.setOnMouseDragged(e->{
				c.setCenterX(e.getX());
				c.setCenterY(e.getY());
		}
		);

		mainPane.setOnMouseClicked(e->{
				c.setCenterX(e.getX());
				c.setCenterY(e.getY());
		}
		);

		Scene mainScene = new Scene(mainPane, 800, 700);
		mainScene.setFill(Color.DARKSLATEGREY);

		
		mainScene.addEventHandler(KeyEvent.KEY_PRESSED, (key)->{

		      if(key.getCode()==KeyCode.ENTER) {
		    	  x = 400;
		    	  y = 350;
		         
		      }
		      
		      if (key.getCode()==KeyCode.UP) {
		    	  y = y - distance;
		    	  
		      }
		  
		      if (key.getCode()==KeyCode.LEFT) {
		    	  x = x - distance;

		      }

		      if (key.getCode()==KeyCode.DOWN) {
		    	  y = y + distance;

		      }

		      if (key.getCode()==KeyCode.RIGHT) {
		    	  x = x + distance;

		      }
			c.setCenterX(x);
			c.setCenterY(y);
		}
		);

		primaryStage.setScene(mainScene);
		primaryStage.show();

	}


	public static void main(String[] args) {
		launch(args);

	}

}