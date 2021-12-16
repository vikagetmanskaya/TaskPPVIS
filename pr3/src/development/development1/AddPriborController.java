package development.development1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import development.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPriborController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Label choisePribor;

    @FXML
    private TextField idInput;

    @FXML
    private TextField priborInput;

    @FXML
    private Button returnButton;

    @FXML
    void initialize() {
        DBHandler db = new DBHandler();
        addButton.setOnAction(event-> db.signUpPribor(Integer.parseInt(idInput.getText()), priborInput.getText()));
        returnButton.setOnAction(event-> openNewScene("/development/development1/pribors.fxml"));
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

