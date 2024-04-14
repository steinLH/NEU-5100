package application.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import application.Event;
import application.Main;


public class SignUpPageController {
	
	@FXML
	private Hyperlink signUpLink;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signUpButton;
    
    @FXML
	 public static void handleSignUp() throws IOException {
		    // Load the signUp page
		    FXMLLoader signUpLoader = new FXMLLoader(Main.class.getResource("fxml/homePage.fxml"));
		    signUpLoader.setController(new HomePageController());
		    Parent signUpRoot = signUpLoader.load();
		    Scene signUpScene = new Scene(signUpRoot);

		    // Set the stage with the home scene
		    Stage stage = new Stage();
		    stage.setScene(signUpScene);
		    stage.setTitle("home Page");
		    stage.show();
		    System.out.println("handleSignUp");
		}
	  

}
