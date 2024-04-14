package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

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
    private void initialize() {
        // You can initialize any necessary components or data here
    }

    @FXML
    private void handleSignUpButtonClicked() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // Perform validation checks (e.g., check if fields are not empty, validate email format, etc.)

        // If validation passes, you can proceed with signing up the user
        // You can call a method from your backend or perform any other necessary actions here
        signUpUser(username, email, password);

        // Optionally, you can close the signup page after successful signup
        // Stage stage = (Stage) signUpButton.getScene().getWindow();
        // stage.close();
    }

    private void signUpUser(String username, String email, String password) {
        // Implement the logic to sign up the user here
        // This could involve sending the data to a server, saving it to a database, etc.
        // You can customize this method according to your application's requirements
    }
}
