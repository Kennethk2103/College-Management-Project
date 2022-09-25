package p1;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import p1.College;

public class TextbookView {
	
	private static Pane textbookPane;
	
	
	private TextbookView() {
		
		
		
		///Textbook info boxes
		
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
		
		HBox isbnBox = new HBox(20);
		TextField isbnField = new TextField();
		Label isbnLbl = new Label("Isbn");
		isbnBox.setAlignment(Pos.CENTER);
		isbnBox.getChildren().addAll(isbnLbl,isbnField);
		
		TextField priceField = new TextField();
		Label priceFieldLbl = new Label("Price");
		HBox priceBox = new HBox(20);
		priceBox.setAlignment(Pos.CENTER);
		priceBox.getChildren().addAll(priceFieldLbl,priceField);
	
		TextField titleField = new TextField();
		Label titleFieldLbl = new Label("Title");
		HBox titleBox = new HBox(20);
		titleBox.setAlignment(Pos.CENTER);
		titleBox.getChildren().addAll(titleFieldLbl,titleField);
		
		
		HBox textbookBox = new HBox(50);///50 pixels seperating parts of hbo	
		textbookBox.setAlignment(Pos.CENTER);
		textbookBox.getChildren().addAll(firstNameBox,lastNameBox,isbnBox,priceBox,titleBox);
			
		///buttons
		Button insertBtn = new Button("Insert");
		insertBtn.setMaxSize(100, 50);
		insertBtn.setPrefSize(100,20);
		insertBtn.setOnAction(e -> {
			Textbook textbook = new Textbook(titleField.getText(),new Name(firstNameField.getText(),lastNameField.getText()),isbnField.getText() ,Double.valueOf(priceField.getText()));
			College.getTextbookBag().insert(textbook);
			firstNameField.clear();
			lastNameField.clear();
			priceField.clear();
			titleField.clear();
			isbnField.clear();
			
		});
		Button searchBtn = new Button("Search");
		searchBtn.setMaxSize(100, 50);
		searchBtn.setPrefSize(100,20);
		searchBtn.setOnAction(e->{
			String isbn = isbnField.getText();
			Textbook textbook = College.getTextbookBag().sequentialSearchByIsbn(isbn);
			if(textbook==null) {
				System.out.println("No textbook found");
			}
			else {
				firstNameField.setText(textbook.getName().getFirstName());
				lastNameField.setText(textbook.getName().getLastName());
				priceField.setText(String.valueOf(textbook.getPrice()));
				titleField.setText(textbook.getTitle());
			}
		});
		
		Button updateBtn = new Button("Update");
		updateBtn.setMaxSize(100, 50);
		updateBtn.setPrefSize(100,20);
		updateBtn.setOnAction(e->{
			String isbn = isbnField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String title = titleField.getText();
			Double price = Double.valueOf(priceField.getText());
			Textbook book = new Textbook(title,new Name(firstName,lastName),isbn,price);
			College.getTextbookBag().update(book);
		});
		
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setMaxSize(100, 50);
		cancelBtn.setPrefSize(100,20);
		cancelBtn.setOnAction(e-> {
			firstNameField.clear();
			lastNameField.clear();
			priceField.clear();
			titleField.clear();
			isbnField.clear();
		});
		Button deleteBtn = new Button("Delete");
		deleteBtn.setMaxSize(100, 50);
		deleteBtn.setPrefSize(100,20);
		deleteBtn.setOnAction(e->{
			String isbn = isbnField.getText();
			College.getTextbookBag().deleteByIsbn(isbn);
		});
		
		HBox btnBox = new HBox(50);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(insertBtn,searchBtn,cancelBtn,updateBtn,deleteBtn);
		
		
		
		
		textbookPane = new VBox(50);
		((VBox)textbookPane).setAlignment(Pos.CENTER);
	 
		textbookPane.getChildren().add(textbookBox);

		textbookPane.getChildren().add(btnBox);
		
	}
	
	public static Pane getTextbookPane() {
		if(textbookPane==null) {
			new TextbookView();
		}
		return textbookPane;
	}
}
