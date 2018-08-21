import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Project_7 extends Application {

	int nOfBalls = 50;
	int velocity = 40;
	int distance = 1;
	int horizontalLength = 1800;
	int verticalLength = 1000;

	public void start(Stage primaryStage) throws Exception {
		
		int [] deltaX = new int[nOfBalls];
		int [] deltaY = new int[nOfBalls];
		int [] positionX = new int[nOfBalls];
		int [] positionY = new int[nOfBalls];
		
		IntegerProperty [] X = new SimpleIntegerProperty[nOfBalls];
		IntegerProperty [] Y = new SimpleIntegerProperty[nOfBalls];
		
		Circle circles[] = new Circle[nOfBalls];
		Pane mainPane = new Pane();
		
		for (int j = 0; j < nOfBalls; j++) {
			positionX[j] = 50 + (int)(Math.random() * (horizontalLength - 50));
			positionY[j] = 50 + (int)(Math.random() * (verticalLength - 50));
			deltaX[j] = j + distance;
			deltaY[j] = j + distance;	
			X[j] = new SimpleIntegerProperty();
			Y[j] = new SimpleIntegerProperty();
		}
		
		for (int r = 0; r < nOfBalls; r++) {	
			circles[r] = new Circle();
			circles[r].centerXProperty().bind(X[r]);
			circles[r].centerYProperty().bind(Y[r]);
			circles[r].setRadius(radius());
			circles[r].setFill(randomColor());
			mainPane.getChildren().add(circles[r]);
		}
			
		Scene mainScene = new Scene(mainPane, horizontalLength, verticalLength);
		mainScene.setFill(Color.BLACK);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle(" [" + nOfBalls + "] Bouncy Balls");
		primaryStage.show();
	
		new Thread (new Runnable() {		
	
			public void run() {
				
				while (true) {
				for (int i = 0; i < nOfBalls; i++) {
					positionX[i] = positionX[i] - deltaX[i];
					X[i].set(positionX[i]);
					
					positionY[i] = positionY[i] - deltaY[i];
					Y[i].set(positionY[i]);
				}
				
				try {
					Thread.sleep(velocity);
				} catch (Exception e) 
				{  }
				
				for(int i = 0; i < nOfBalls; i++) {
					if (positionX[i] > horizontalLength - 10) {
						deltaX[i] = -deltaX[i];
					}
					if (positionX[i] < 10) {
						deltaX[i] = -deltaX[i];
					}
					if (positionY[i] > verticalLength - 10) {
						deltaY[i] = -deltaY[i];
					}
					if (positionY[i] < 10) {
						deltaY[i] = -deltaY[i];
					}
					
				}
				}
			}
		}
		).start();
	}
	
	public Color randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }
	
	public int radius() {
		int radius = 1 + (int)(Math.random() * 100);
		return radius;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}