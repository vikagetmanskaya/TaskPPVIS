package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button continueCookButton;

    @FXML
    private Button createNewRecipeButton;

    @FXML
    void initialize() {
       createNewRecipeButton.setOnAction(event -> openNewScene("/com/company/createNew.fxml"));
       continueCookButton.setOnAction(event->openNewScene("/com/company/choiceRecipe.fxml"));
    }
    public void openNewScene(String window){
        continueCookButton.getScene().getWindow().hide();
        createNewRecipeButton.getScene().getWindow().hide();
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
