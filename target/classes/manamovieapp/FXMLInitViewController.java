
package manamovieapp;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.sql.*; 
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class FXMLInitViewController implements Initializable {


    @FXML
    private AnchorPane signIn_form;
    @FXML
    private Button signIn_btnLogin;
    @FXML
    private TextField signIn_username;
    @FXML
    private PasswordField signIn_password;
    @FXML
    private Hyperlink signIn_createAccount;
    @FXML
    private AnchorPane signUp_form;
    @FXML
    private Button signUp_btnRegister;
    @FXML
    private TextField signUp_dateOfBirth;
    @FXML
    private PasswordField signUp_password;
    @FXML
    private TextField signUp_username;
    @FXML
    private TextField signUp_city;
    @FXML
    private TextField signUp_lastName;
    @FXML
    private TextField signUp_middleName;
    @FXML
    private TextField signUp_firstName;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    public void signInn(){
        
        String sqlScript = "SELECT * FROM client WHERE username = ? and password = ?";
        Alert alert;
        
        connect = database.connectDb();

        
        if(connect == null){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        
        try {
        prepare = connect.prepareStatement(sqlScript);
        prepare.setString(1, signIn_username.getText());
        prepare.setString(2, signIn_password.getText());
        
        result = prepare.executeQuery();
        
        
        //Check user and pass if is empty or not
        if(signIn_username.getText().isEmpty() || signIn_password.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the fields");
            alert.showAndWait();
            
            
        }else{
            
            if(result.next()){
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Login!");
                alert.showAndWait();
                
                signIn_form.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
                
                
                Stage stage = new Stage();
                stage.setUserData("mcabassa");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
                
                
            }else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong username or password");
                alert.showAndWait();
            }
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void switchForm(ActionEvent event){
        if(event.getSource() == signIn_createAccount){
            signIn_form.setVisible(false);
            signUp_form.setVisible(true);
        }else{
            signIn_form.setVisible(true);
            signUp_form.setVisible(false);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
