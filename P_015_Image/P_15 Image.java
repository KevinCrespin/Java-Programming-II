import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class P_15 Image extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image error = new Image("error.png");
		ImageView errorImageView = new ImageView(error);
		Image info = new Image("info.png");
		ImageView infoImageView = new ImageView(info);
		Image warning = new Image("warning.png");
		ImageView warningImageView = new ImageView(warning);
		
		FlowPane mainPane = new FlowPane();
		mainPane.getChildren().add(errorImageView);
		mainPane.getChildren().add(infoImageView);
		mainPane.getChildren().add(warningImageView);
		Scene mainScene = new Scene(mainPane, 800, 500);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
