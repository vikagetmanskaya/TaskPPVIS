package com.company;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button nextButton;

    @FXML
    private TextField priemInput = new TextField();

    @FXML
    private TextField productInput = new TextField();



    @FXML
    private Label selectPiem;


    @FXML
    private Label selectProduct;

    @FXML
    private Button checkAll;
    @FXML
    private Button nextButton1;

    @FXML
    private VBox res;
    DataBaseHandler db = null;


    @FXML
    void initialize() {
        db = new DataBaseHandler();
        nextButton.setOnAction(event -> initData());
        checkAll.setOnAction(event -> openNewScene("/com/company/allRecipe.fxml"));
        nextButton1.setOnAction(event ->openNewScene("/com/company/choiceRecipe.fxml"));


    }

    private void initData() {


        try {
            ArrayList<String> recipes = db.getRecipes(priemInput.getText(), productInput.getText());
            for (int i = 0; i < recipes.size(); i++)
                res.getChildren().add(new Label(recipes.get(i)));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void openNewScene(String window){
        checkAll.getScene().getWindow().hide();
        nextButton1.getScene().getWindow().hide();
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
