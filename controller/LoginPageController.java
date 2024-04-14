package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import application.Main;

public class LoginPageController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    private void initialize() {
        signUpLink.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/signUpPage.fxml"));
                Parent signUpRoot = loader.load();
                Scene signUpScene = new Scene(signUpRoot);
                Stage stage = (Stage) signUpLink.getScene().getWindow();
                stage.setScene(signUpScene);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle any exceptions
            }
        });
    }

    @FXML
    private void handleLogin() throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        // Check if the username and password match the expected values
        if (username.equals("admin") && password.equals("password")) {
            // Call the showHomePage method from the Main class
            showHomePage();
            
            // Close the login window
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.close();
        } else {
            // Show an alert dialog for invalid credentials
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("The username or password you entered is incorrect.");
            alert.showAndWait();
        }
    }
 // Method to switch to home page
 	  public static void showHomePage() throws IOException {
 		    // Load the home page
 		    FXMLLoader homeLoader = new FXMLLoader(Main.class.getResource("fxml/homePage.fxml"));
 		    homeLoader.setController(new HomePageController());
 		    Parent homeRoot = homeLoader.load();
 		    Scene homeScene = new Scene(homeRoot);

 		    // Set the stage with the home scene
 		    Stage stage = new Stage();
 		    stage.setScene(homeScene);
 		    stage.setTitle("Home Page");
 		    stage.show();
 		}
    
    
}
