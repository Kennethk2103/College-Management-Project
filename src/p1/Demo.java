package p1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import p1.College;

public class Demo extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		launch(args);

		
	}
	public void start(Stage primaryStage) throws Exception {
		College college = College.getCollege();
		Utilities.loadLists("First Names.txt","Last Names.txt","textbook_titles.txt","textbook_isbns.txt","Majors.txt");
		Utilities.restorePersonBag();
		Utilities.restoreTextBookBag();
		MenuBar menuBar = MenuView.getMenuBar();
		BorderPane root = (BorderPane) RootView.getRootPane();
		root.setTop(menuBar);

		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(e -> {
			Utilities.restorePersonBag();
			Utilities.restoreTextBookBag();
			System.out.println("Bags backed upped");
		});
		primaryStage.show();	
		
	}

}
