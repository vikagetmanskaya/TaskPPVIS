package com.company;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;


    @FXML
    private TextField signUpCountry;

    @FXML
    private TextField signUpId;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();

signUpButton.setOnAction(event -> dbHandler.signUpUser(Integer.parseInt(signUpId.getText()), signUpName.getText(), signUpLastName.getText(), login_field.getText(), password_field.getText(), signUpCountry.getText()));
    }

}
