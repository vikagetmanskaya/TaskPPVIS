package development;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SelectDevelopmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    void initialize() {
    Button1.setOnAction(event ->openNewScene("/development/development3/dopQuestion.fxml"));
    Button2.setOnAction(event -> openNewScene("/development/development2/allergy.fxml"));
        Button3.setOnAction(event -> openNewScene("/development/development1/pribors.fxml"));
    }
    public void openNewScene(String window){
        Button1.getScene().getWindow().hide();
        Button2.getScene().getWindow().hide();
        Button3.getScene().getWindow().hide();
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
