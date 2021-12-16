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

public class BuyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox allProduct;

    @FXML
    private Button buyButton;

    @FXML
    private Button checkButton;

    @FXML
    private Label choiseProduct;

    @FXML
    private TextField idInput;

    @FXML
    private TextField productInput;

    @FXML
    private VBox res;

    @FXML
    private Button returnButton;
DataBaseHandler db;
    @FXML
    void initialize() {
        db = new DataBaseHandler();
        checkButton.setOnAction(event->initData());
        buyButton.setOnAction(event-> db.addProduct(Integer.parseInt(idInput.getText()), productInput.getText()));
        returnButton.setOnAction(event ->openNewScene("/com/company/choiceRecipe.fxml"));
    }
    private void initData() {


        try {
            ArrayList<String> recipes = db.getProduct();
            for (int i = 0; i < recipes.size(); i++)
                res.getChildren().add(new Label(recipes.get(i)));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void openNewScene(String window){
        returnButton.getScene().getWindow().hide();
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
