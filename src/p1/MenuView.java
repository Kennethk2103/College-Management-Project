package p1;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import p1.College;
import p1.Utilities;

public class MenuView {
	private static MenuBar menuBar;
	
	private MenuView() {
		menuBar = new MenuBar();
		
		Menu fileMenu = new Menu("File");
		MenuItem importItem = new MenuItem("Import");
		importItem.setOnAction(e -> {
			if(College.getPersonBag()!=null) {
				College.setPersonBag(new PersonBag(2000));
				College.setTextbookBag(new TextbookBag());
			}
			Utilities.fillTextbookBag(College.getTextbookBag(),2000);
			Utilities.importStudents(College.getPersonBag());
			Utilities.importInstructors(College.getPersonBag());
			
			

			
		});
		
		MenuItem saveItem = new MenuItem("Save");
		saveItem.setOnAction(e -> {
			Utilities.backUpPersonBag();
			Utilities.backUpTextBookBag();
		});
		
		MenuItem loadItem= new MenuItem("Load");
		loadItem.setOnAction(e -> {
			Utilities.restorePersonBag();
			Utilities.restoreTextBookBag();
		});
		
		
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.setOnAction(e -> {
			Utilities.backUpPersonBag();
			Utilities.backUpTextBookBag();
			Platform.exit();
		});
		
		
		fileMenu.getItems().addAll(importItem, new SeparatorMenuItem(),saveItem, loadItem, new SeparatorMenuItem(), exitItem);
		
		Menu viewMenu = new Menu("View");
		MenuItem studentItem = new MenuItem("Student");
		MenuItem instructorItem = new MenuItem("Instructor");
		MenuItem textbookItem = new MenuItem("Textbook");
		viewMenu.getItems().addAll(studentItem, instructorItem, textbookItem);
		
		menuBar.getMenus().addAll(fileMenu, viewMenu);
		
		studentItem.setOnAction(e -> {
			BorderPane borderPane = (BorderPane)(RootView.getRootPane());
			borderPane.setTop(MenuView.getMenuBar());
			borderPane.setCenter(StudentView.getStudentPane());
		});
		
		instructorItem.setOnAction(e -> {
			BorderPane borderPane = (BorderPane)(RootView.getRootPane());
			borderPane.setTop(MenuView.getMenuBar());
			borderPane.setCenter(InstructorView.getInstructorPane());
		});
		
		textbookItem.setOnAction(e -> {
			BorderPane borderPane = (BorderPane)(RootView.getRootPane());
			borderPane.setTop(MenuView.getMenuBar());
			borderPane.setCenter(TextbookView.getTextbookPane());
		});
	}
	
	public static MenuBar getMenuBar() {
		if(menuBar == null) {
			return new MenuView().obtainMenuBar();
		} else {
			return menuBar;
		}
	}
	
	private MenuBar obtainMenuBar() {
		return menuBar;
	}
	
	
}