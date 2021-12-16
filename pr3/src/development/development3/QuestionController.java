package development.development3;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.company.HomeController;
import development.DBHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class QuestionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amountInput;

    @FXML
    private Label amountProduct;

    @FXML
    private Label recipe;

    @FXML
    private TextField nameInput;
    @FXML
    private TextField priemInput;
    @FXML
    private TextField productInput;



    @FXML
    private Button nextButton1;

    @FXML
    private VBox res;

    DBHandler db = null;

    @FXML
    void initialize() {
    db = new DBHandler();
    nextButton1.setOnAction(event-> initData());

    }
    private void initData() {


        try {
            ArrayList<String> recipes = db.getAllRecipe(nameInput.getText(), Integer.parseInt(amountInput.getText()), priemInput.getText(), productInput.getText());
            for (int i = 0; i < recipes.size(); i++)
                res.getChildren().add(new Label(recipes.get(i)));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
