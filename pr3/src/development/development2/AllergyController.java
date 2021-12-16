package development.development2;

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

public class AllergyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField allergyInput;

    @FXML
    private Label allergyProduct;

    @FXML
    private Button nextButton1;

    @FXML
    private VBox res;
    @FXML
    private Button returnButton;
    @FXML
    private TextField priemInput;

    @FXML
    private TextField productInput;

    @FXML
    private Label recipe;

    DBHandler db;

    @FXML
    void initialize() {
db = new DBHandler();
nextButton1.setOnAction(event-> initData());
        returnButton.setOnAction(event ->openNewScene("/com/company/allRecipe.fxml"));
    }
    private void initData() {


        try {
            ArrayList<String> recipes = db.getAllRecipeWithoutAllergy(allergyInput.getText(), priemInput.getText(), productInput.getText());
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

