package menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bazaButton;

    @FXML
    private Button firstButton;

    @FXML
    private Button secondButton;

    @FXML
    private Button thirdButton;

    @FXML
    void initialize() {
        bazaButton.setOnAction(event -> openNewScene("/com/company/app.fxml"));
        firstButton.setOnAction(event -> openNewScene("/development/development3/dopQuestion.fxml"));
        secondButton.setOnAction(event -> openNewScene("/development/development2/allergy.fxml"));
        thirdButton.setOnAction(event -> openNewScene("/development/development1/pribors.fxml"));
    }
    public void openNewScene(String window){
        bazaButton.getScene().getWindow().hide();
        firstButton.getScene().getWindow().hide();
        secondButton.getScene().getWindow().hide();
        thirdButton.getScene().getWindow().hide();
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

