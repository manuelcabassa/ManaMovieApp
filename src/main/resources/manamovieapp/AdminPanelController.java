
package manamovieapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
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
    @FXML
    private AnchorPane CustomerView;
    @FXML
    //private TableView table;
    
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    //private ObservableList<User> data;


    
    public void customersView() throws SQLException
    {
            adminPanel.setVisible(false);
            CustomerView.setVisible(true);
            
            
            String sqlScript = "SELECT * FROM Client";
            
                    Alert alert;
        
        connect = database.connectDb();

        
        if(connect == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        
        try{
            
            ResultSet rs = connect.createStatement().executeQuery(sqlScript);  
            while(rs.next())
                    {
                        //table.setItems(rs);
                    }

            
        }catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
         connect.close();
        }
            
            
    }
    
        public void signOut() throws IOException
    {
            
                CustomerView.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLInitView.fxml"));
                
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String welcome = welcomeAdminText.getText();
        Stage stage = new Stage();
        
        welcomeAdminText.setText(welcome + "" + "Admin");
        
    }    
    
}
