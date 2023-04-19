
package manamovieapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class AdminPanelController implements Initializable {

    @FXML
    private AnchorPane adminPanel;
    @FXML
    private Button adminPanelCustomers;
    @FXML
    private Button adminPanelRentals;
    @FXML
    private Button adminPanelMovies;
    @FXML
    private Text welcomeAdminText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String welcome = welcomeAdminText.getText();
        Stage stage = new Stage();
        
        welcomeAdminText.setText(welcome + "" + stage.getUserData());
        
    }    
    
}
