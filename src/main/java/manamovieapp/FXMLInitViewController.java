
package manamovieapp;

import java.io.IOException;
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
import manamovieapp.database;


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
    private TextField signUp_address;
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
    
    public void signInn() throws SQLException, IOException{
        
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
                if("Y".equals(result.getString("isAdmin"))){
                                    alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Login!");
                alert.showAndWait();
                
                signIn_form.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
                
                
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                }
                else{
                    
                signIn_form.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLUserView.fxml"));
                
                
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                }

                
                
                
            }else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong username or password");
                alert.showAndWait();
            }
        }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
         connect.close();
        }
    }
    
    public void signUp() throws SQLException, IOException{
        
        String sqlScript = "INSERT INTO client(firstName, middleName, lastName, address, dateOfBirth, username, password, isAdmin) VALUES(?,?,?,?,?,?,?,?)";
        Alert alert;
        
        connect = database.connectDb();

        
        if(connect == null){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        
        try{
            
        prepare = connect.prepareStatement(sqlScript);
        prepare.setString(1, signUp_firstName.getText());
        prepare.setString(2, signUp_middleName.getText());
        prepare.setString(3, signUp_lastName.getText());
        prepare.setString(4, signUp_address.getText());
        prepare.setString(5, signUp_dateOfBirth.getText());
        prepare.setString(6, signUp_username.getText());
        prepare.setString(7, signUp_password.getText());
        prepare.setString(8, "N");
        
        if(signUp_firstName.getText().isEmpty() ||signUp_lastName.getText().isEmpty() || signUp_address.getText().isEmpty() || signUp_dateOfBirth.getText().isEmpty() 
                || signUp_username.getText().isEmpty() || signUp_password.getText().isEmpty())
        {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the fields, except middle name if you don´t have.");
            alert.showAndWait();
        }else if(signUp_password.getText().length() < 5)
        {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Password need 5 or more characters.");
            alert.showAndWait();
        }else
        {
                prepare.execute();
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Register in Mana Movie App!");
                alert.showAndWait();
                
                
                //Clean input text
                signUp_firstName.setText("");
                signUp_lastName.setText("");
                signUp_middleName.setText("");
                signUp_address.setText("");
                signUp_dateOfBirth.setText("");
                signUp_username.setText("");
                signUp_password.setText("");
                
                signUp_form.getScene().getWindow().hide();
                
                Parent root = FXMLLoader.load(getClass().getResource("FXMLInitView.fxml"));
                
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally
        {
         connect.close();
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
