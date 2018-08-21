import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class P_28 GUI_Data_Storage extends Application {
		Label label_header1;
		Label label_header2;
		
		Label label_ccn;
		Label label_ed;
		Label label_sc;
		
		static TextField field_ccn;
		static TextField field_ed;
		static TextField field_sc;
		
		Button thanks;
		
		static Image[] icon = new Image[5];
		ImageView[] view = new ImageView[5];
		
		GridPane left;
		GridPane right;
		GridPane right_up;
		GridPane right_down;
		GridPane main;
		GridPane bye;
		
		Scene mainScene;
		Scene byeScene;
		
	public void start(Stage primaryStage) throws Exception {
		
		label_header1 = new Label("Hi-hi there...");
		label_header2 = new Label("Do you th-think I could have your \n"
								+ "credit card information, p-please?");
		
		label_ccn = new Label("Card number:  ");
		label_ed = new Label("Expiry date:  ");
		label_sc = new Label("Security code:  ");		
		
		field_ccn = new TextField();
		field_ed = new TextField();
		field_sc = new TextField();
		
		thanks = new Button("Th-thanks");
		
		icon[0] = new Image("icon.png");
		icon[1] = new Image("icon2.png");
		icon[2] = new Image("icon3.png");
		icon[3] = new Image("icon4.png");
		icon[4] = new Image("gif.gif");

		
		for (int i = 0; i <= 4; i++) {
			view[i] = new ImageView(icon[i]);
		}
		
		int random = 0 + (int)(Math.random() * ((3 - 0) + 1));
		
		view[random].setFitHeight(290);
		view[random].setFitWidth(272);
		
		left = new GridPane();
		left.add(view[random], 0, 2);
	
		right_up = new GridPane();
		
		right_up.setHgap(10);
		right_up.setVgap(10);
		right_up.setPadding(new Insets(20, 20, 20, 20));
		
		right_up.add(label_header1, 0, 0);
		right_up.add(label_header2, 0, 1);
		
		right_down = new GridPane();
		
		right_down.setHgap(10);
		right_down.setVgap(10);
		right_down.setPadding(new Insets(20, 20, 20, 20));
		
		right_down.add(label_ccn, 0, 0);
		right_down.add(field_ccn, 1, 0);
		
		right_down.add(label_ed, 0, 1);
		right_down.add(field_ed, 1, 1);
		
		right_down.add(label_sc, 0, 2);
		right_down.add(field_sc, 1, 2);
		right_down.add(thanks, 1, 3);
		
		right = new GridPane();
		
		right.add(right_up, 0, 0);
		right.add(right_down, 0, 1);
		
		main = new GridPane();
	
		main.setHgap(10);
		main.setVgap(10);
		main.setPadding(new Insets(10, 10, 10, 10));
		
		main.add(left, 0, 0);
		main.add(right, 1, 0);
		
		bye = new GridPane();
		
		mainScene = new Scene(main, 590, 310);
		byeScene = new Scene(bye, 493, 279);
		
		thanks.setOnAction(e-> {
			try {
				thanks();
				bye.add(view[4], 0, 0);
				primaryStage.setTitle("Thanks Onii-Chan!");
				primaryStage.setScene(byeScene);
				primaryStage.show();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		);
		
		field_ccn.setOnMouseClicked(e-> {
			fastboi();
		});
		
		primaryStage.setTitle("Totally Not Malware");
		primaryStage.getIcons().add(icon[random]);
		primaryStage.setResizable(false);
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}
	
	public static void thanks() throws IOException {
		SimpleDateFormat date = new SimpleDateFormat("EEEE, MMMM d, yyyy (hh:mm)");
		Date now = new Date();
		
		try (PrintWriter printWriter = new PrintWriter(new FileWriter("information.txt", true))) {
			printWriter.write(date.format(now));
			printWriter.write("  [" + field_ccn.getText() + "]");
			printWriter.write("  [" + field_ed.getText() + "]");
			printWriter.println("  [" + field_sc.getText() + "]");
			printWriter.flush();
		} catch (IOException exp) {
		    exp.printStackTrace();
		}
	}
		
	public static void fastboi() {
		Stage fastStage = new Stage();
		
		Image fastImg = new Image("img.png");
		ImageView fastView = new ImageView(fastImg);
		
		GridPane fastGP = new GridPane();
		
		fastGP.add(fastView, 0, 0);
		
		Scene fastScene = new Scene(fastGP, 639, 340);
		
		fastStage.setScene(fastScene);
		fastStage.show();
		fastStage.setResizable(false);
		fastStage.setTitle("I DUNNOOOO... OKAY I GUESS HERE YA GO");
		fastStage.getIcons().add(icon[3]);
	}

	public static void main(String[] args) {
	launch(args);
	}

}
