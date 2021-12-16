package com.company;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(event->{
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();
            if(!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);

            }else{
                System.out.println("Error");
            }
                });

        loginSignUpButton.setOnAction(event -> openNewScene("/com/company/signUp.fxml"));


    }

    private void loginUser(String loginText, String loginPassword) {
DataBaseHandler db = new DataBaseHandler();
ResultSet res = db.getUser(loginText, loginPassword);
int counter = 0;
while (true){
    try {
        if (!res.next()) break;
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    counter++;
}
if (counter>=1){
openNewScene("/com/company/app.fxml");
}
else {
    JOptionPane.showMessageDialog(null, "Неправильно введены данные!");
}
    }
    public void openNewScene(String window){
        loginSignUpButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}

