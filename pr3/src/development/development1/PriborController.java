package development.development1;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import development.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PriborController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPriborButton;

    @FXML
    private VBox allRecipe;

    @FXML
    private Button checkRecipeButton;

    @FXML
    private Label choiseRecipe;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField priemInput;

    @FXML
    private TextField productInput;

    @FXML
    private VBox res;
    DBHandler db;

    @FXML
    void initialize() {
        db = new DBHandler();
checkRecipeButton.setOnAction(event -> initData());
addPriborButton.setOnAction(event -> openNewScene("/development/development1/addPribor.fxml"));
    }
    private void initData() {


        try {
            ArrayList<String> recipes = db.getAllRecipeWithPribors(nameInput.getText(), priemInput.getText(), productInput.getText());
            for (int i = 0; i < recipes.size(); i++)
                res.getChildren().add(new Label(recipes.get(i)));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void openNewScene(String window){
        addPriborButton.getScene().getWindow().hide();
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

