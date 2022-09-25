package p1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import p1.College;
import p1.Utilities;
public class InstructorView {
	
	private static Pane instructorPane;

	
	private InstructorView() {
		
		
		///Instructor info boxes
		
		TextField firstNameField = new TextField();
		Label firstNameLbl = new Label("First Name");
		HBox firstNameBox = new HBox(20);
		firstNameBox.setAlignment(Pos.CENTER);
		firstNameBox.getChildren().addAll(firstNameLbl,firstNameField);
		
		TextField lastNameField = new TextField();
		Label lastNameLbl = new Label("Last Name");
		HBox LastNameBox = new HBox(20);
		LastNameBox.setAlignment(Pos.CENTER);
		LastNameBox.getChildren().addAll(lastNameLbl,lastNameField);
		
		HBox idBox = new HBox(20);
		TextField idField = new TextField();
		Label idLbl = new Label("Id");
		idBox.setAlignment(Pos.CENTER);
		idBox.getChildren().addAll(idLbl,idField);
		
		TextField salaryField = new TextField();
		Label salaryFieldLbl = new Label("Salary");
		HBox salaryBox = new HBox(20);
		salaryBox.setAlignment(Pos.CENTER);
		salaryBox.getChildren().addAll(salaryFieldLbl,salaryField);
	
		TextField rankField = new TextField();
		Label rankFieldLbl = new Label("Rank");
		HBox rankBox = new HBox(20);
		rankBox.setAlignment(Pos.CENTER);
		rankBox.getChildren().addAll(rankFieldLbl,rankField);
		
		
		HBox instructorBox = new HBox(50);///50 pixels seperating parts of hbo	
		instructorBox.setAlignment(Pos.CENTER);
		instructorBox.getChildren().addAll(firstNameBox,LastNameBox,idBox,salaryBox,rankBox);
			
		///buttons
		Button insertBtn = new Button("Insert");
		insertBtn.setMaxSize(100, 50);
		insertBtn.setPrefSize(100,20);
		insertBtn.setOnAction(e -> {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String rank = rankField.getText();
			Double salary = Double.valueOf(salaryField.getText());
			Instructor instructor = new Instructor(new Name(firstName,lastName),rank,salary);
			
			firstNameField.clear();
			lastNameField.clear();
			salaryField.clear();
			rankField.clear();
			idField.clear();
			College.getPersonBag().insert(instructor);
			
		});
		Button searchBtn = new Button("Search");
		searchBtn.setMaxSize(100, 50);
		searchBtn.setPrefSize(100,20);
		searchBtn.setOnAction(e->{
			String id = idField.getText();

			
			Person person =  College.getPersonBag().searchById(id);
			if(person instanceof Instructor) {
				Instructor instructor = (Instructor)person;
				firstNameField.setText(instructor.getName().getFirstName());
				lastNameField.setText(instructor.getName().getLastName());
				salaryField.setText(String.valueOf(instructor.getSalary()));
				rankField.setText(instructor.getRank());
			}
			else {
				System.out.println("No instructor found with id");
			}
		});
		
		Button updateBtn = new Button("Update");
		updateBtn.setMaxSize(100, 50);
		updateBtn.setPrefSize(100,20);
		updateBtn.setOnAction(e->{
			String id = idField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String rank = rankField.getText();
			Double salary = Double.valueOf(salaryField.getText());
			Instructor instructor = new Instructor(new Name(firstName,lastName),id,rank,salary);
			College.getPersonBag().update(instructor);
		});
		
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setMaxSize(100, 50);
		cancelBtn.setPrefSize(100,20);
		cancelBtn.setOnAction(e-> {
			firstNameField.clear();
			lastNameField.clear();
			salaryField.clear();
			rankField.clear();
			idField.clear();
		});
		Button deleteBtn = new Button("Delete");
		deleteBtn.setMaxSize(100, 50);
		deleteBtn.setPrefSize(100,20);
		deleteBtn.setOnAction(e->{
			String id = idField.getText();
			College.getPersonBag().deleteById(id);
		});
		
		
		HBox btn = new HBox(50);
		btn.setAlignment(Pos.CENTER);
		btn.getChildren().addAll(insertBtn,searchBtn,cancelBtn,updateBtn,deleteBtn);
		
		
		
		
		instructorPane = new VBox(50);
		((VBox)instructorPane).setAlignment(Pos.CENTER);
	 
		instructorPane.getChildren().add(instructorBox);

		instructorPane.getChildren().add(btn);
		
	}
	
	public static Pane getInstructorPane() {
		if(instructorPane==null) {
			new InstructorView();
		}
		return instructorPane;
	}
}
