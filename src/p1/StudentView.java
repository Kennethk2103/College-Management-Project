package p1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import p1.College;
import p1.Utilities;

public class StudentView {
	
	private static Pane studentView;
	
	private StudentView() {
		studentView = new VBox(30);
		((VBox)studentView).setAlignment(Pos.CENTER);
		
		TextField firstNameField = new TextField();
		Label firstNameLbl = new Label("First Name");
		HBox firstNameBox = new HBox(20);
		firstNameBox.setAlignment(Pos.CENTER);
		firstNameBox.getChildren().addAll(firstNameLbl,firstNameField);
		
		TextField lastNameField = new TextField();
		Label lastNameLbl = new Label("Last Name");
		HBox lastNameBox = new HBox(20);
		lastNameBox.setAlignment(Pos.CENTER);
		lastNameBox.getChildren().addAll(lastNameLbl,lastNameField);
		
		HBox idBox = new HBox(20);
		TextField idField = new TextField();
		Label idLbl = new Label("Id");
		idBox.setAlignment(Pos.CENTER);
		idBox.getChildren().addAll(idLbl,idField);
		
		TextField gpaField = new TextField();
		Label gpaFieldLbl = new Label("Gpa");
		HBox gpaBox = new HBox(20);
		gpaBox.setAlignment(Pos.CENTER);
		gpaBox.getChildren().addAll(gpaFieldLbl,gpaField);
	
		TextField majorField = new TextField();
		Label majorFieldLbl = new Label("Major");
		HBox majorBox = new HBox(20);
		majorBox.setAlignment(Pos.CENTER);
		majorBox.getChildren().addAll(majorFieldLbl,majorField);
		
		
		HBox studentBox = new HBox(50);///50 pixels seperating parts of hbo	
		studentBox.setAlignment(Pos.CENTER);
		studentBox.getChildren().addAll(firstNameBox,lastNameBox,idBox,gpaBox,majorBox);
			
		///buttons
		Button insertBtn = new Button("Insert");
		insertBtn.setMaxSize(100, 50);
		insertBtn.setPrefSize(100,20);
		insertBtn.setOnAction(e -> {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String major = majorField.getText();
			double gpa = Double.parseDouble(gpaField.getText());
			Student student = new Student(new Name(firstName,lastName),gpa,major);
			College.getPersonBag().insert(student);
			firstNameField.clear();
			lastNameField.clear();
			gpaField.clear();
			majorField.clear();
			idField.clear();
			
		});
		Button searchBtn = new Button("Search");
		searchBtn.setMaxSize(100, 50);
		searchBtn.setPrefSize(100,20);
		searchBtn.setOnAction(e->{
			String id = idField.getText();
			Person person =  College.getPersonBag().searchById(id);
			if(person instanceof Student) {
				Student student = (Student) person;
				firstNameField.setText(student.getName().getFirstName());
				lastNameField.setText(student.getName().getLastName());
				gpaField.setText(String.valueOf(student.getGpa()));
				majorField.setText(student.getMajor());
			}
		});
		
		Button updateBtn = new Button("Update");
		updateBtn.setMaxSize(100, 50);
		updateBtn.setPrefSize(100,20);
		updateBtn.setOnAction(e->{
			String id = idField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String major = majorField.getText();
			double gpa = Double.parseDouble(gpaField.getText());
			Student s = new Student(new Name(firstName,lastName),id,gpa,major);
			College.getPersonBag().update(s);
		});
		
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setMaxSize(100, 50);
		cancelBtn.setPrefSize(100,20);
		cancelBtn.setOnAction(e-> {
			firstNameField.clear();
			lastNameField.clear();  
			gpaField.clear();
			majorField.clear();
			idField.clear();
		});
		Button deleteBtn = new Button("Delete");
		deleteBtn.setMaxSize(100, 50);
		deleteBtn.setPrefSize(100,20);
		deleteBtn.setOnAction(e->{
			String id = idField.getText();
			College.getPersonBag().deleteById(id);
		});
		
		HBox btnBox = new HBox(50);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(insertBtn,searchBtn,cancelBtn,updateBtn,deleteBtn);
		
		
		
		
		studentView.getChildren().addAll(studentBox,btnBox);
		
	}
	
	public static Pane getStudentPane() {
		if(studentView ==null) {
			new StudentView();
			return studentView;
			
		}
		else {
			return studentView;
		}
	}
}
