
package manamovieapp;

import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private AnchorPane AddNewUser;
    @FXML
    private TableView<Customers> tableView;
    @FXML
    private TableColumn<Customers, String> IdColumn;
    @FXML
    private TableColumn<Customers, String> firstNameColumn;
    @FXML
    private TableColumn<Customers, String> middleNameColumn;
    @FXML
    private TableColumn<Customers, String> lastNameColumn;
    @FXML
    private TableColumn<Customers, String> adressColumn;
    @FXML
    private TableColumn<Customers, LocalDate> dateOfBirthColumn;
    @FXML
    private TableColumn<Customers, String> usernameColumn;
    @FXML
    private TableColumn<Customers, String> isAdminColumn;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtMiddleName;
    @FXML
    private TextField txtLasttName;
    @FXML
    private TextField txtAdress;
    @FXML
    private TextField txtDateOfBirth;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtIsAdmin;
    
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    Alert alert;
   


    
    public void customersView() throws SQLException
    {
            adminPanel.setVisible(false);
            CustomerView.setVisible(true);
            
       IdColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("Id")); 
       firstNameColumn.setCellValueFactory(new PropertyValueFactory<Customers,String>("firstName"));
       middleNameColumn.setCellValueFactory(new PropertyValueFactory<Customers,String>("middleName"));
       lastNameColumn.setCellValueFactory(new PropertyValueFactory<Customers,String>("lastName"));
       adressColumn.setCellValueFactory(new PropertyValueFactory<Customers,String>("adress"));
       dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<Customers, LocalDate>("dateOfBirth"));
       usernameColumn.setCellValueFactory(new PropertyValueFactory<Customers,String>("username"));
       isAdminColumn.setCellValueFactory(new PropertyValueFactory<Customers,String>("isAdmin"));

        try {
            tableView.setItems(getCustomers());
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
    }
    
    public void addCustomer(){
        
            CustomerView.setVisible(false);
            AddNewUser.setVisible(true);
            
        
    }
    public void BtnAddNewUser() throws SQLException{
        
        String sqlScript = "INSERT INTO client(firstName, middleName, lastName, address, dateOfBirth, username, password, isAdmin) VALUES(?,?,?,?,?,?,?,?)";
        
        connect = database.connectDb();
        
        if(connect == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        
        try{
            
        prepare = connect.prepareStatement(sqlScript);
        prepare.setString(1, txtFirstName.getText());
        prepare.setString(2, txtMiddleName.getText());
        prepare.setString(3, txtLasttName.getText());
        prepare.setString(4, txtAdress.getText());
        prepare.setString(5, txtDateOfBirth.getText());
        prepare.setString(6, txtUsername.getText());
        prepare.setString(7, txtPassword.getText());
        prepare.setString(8, txtIsAdmin.getText());
        
        if(txtFirstName.getText().isEmpty() ||txtLasttName.getText().isEmpty() || txtAdress.getText().isEmpty() || txtDateOfBirth.getText().isEmpty() 
                || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || txtIsAdmin.getText().isEmpty())
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the fields, except middle name if you don´t have.");
            alert.showAndWait();
        }else if(txtPassword.getText().length() < 5)
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Password need 5 or more characters.");
            alert.showAndWait();
        }else
        {
                prepare.execute();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Register the new user!");
                alert.showAndWait();
                
                
                //Clean input text
                txtFirstName.setText("");
                txtMiddleName.setText("");
                txtLasttName.setText("");
                txtAdress.setText("");
                txtDateOfBirth.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
                txtIsAdmin.setText("");
                
                
                
        try {
            tableView.setItems(getCustomers());
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                AddNewUser.setVisible(false);
                CustomerView.setVisible(true);
                
                //Parent root = FXMLLoader.load(getClass().getResource("FXMLInitView.fxml"));
                
                //Stage stage = new Stage();
                //Scene scene = new Scene(root);
                //stage.setScene(scene);
                //stage.show();
        }
            
            
        }catch(SQLException e){
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
        
        public void BackToLastView(){
            
            if(CustomerView != null){
                adminPanel.setVisible(true);
                CustomerView.setVisible(false);
            }
        }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String welcome = welcomeAdminText.getText();
        welcomeAdminText.setText(welcome + " " + "Admin");
        
      
        
        
    } 
    
        public ObservableList<Customers> getCustomers() throws SQLException
    {
        
        String sqlScript = "SELECT * FROM client";
        
        connect = database.connectDb();
        
        if(connect == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        try{
        statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(sqlScript);
        
        if(rs != null){
            ObservableList<Customers> customer = FXCollections.observableArrayList();
            while(rs.next()){
                /*String Id = rs.getNString(1);
                String firstName = rs.getString("firstName");
                String middleName = rs.getString("middleName");
                String lastName = rs.getString("lastName");
                String city = rs.getString("city");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String username = rs.getString("username");
                String isAdmin = rs.getString("isAdmin");*/
                Integer Id = rs.getInt(1);
                String firstName = rs.getNString(2);
                String middleName = rs.getNString(3);
                String lastName = rs.getNString(4);
                String adress = rs.getNString(5);
                Date dateOfBirth = rs.getDate(6);
                String username = rs.getNString(7);
                String isAdmin = rs.getNString(9);
                
                Customers customers = new Customers(Id.toString(), firstName, middleName, lastName, adress, dateOfBirth.toLocalDate(), username, isAdmin);
                customer.add(customers);
                
            }
            return customer;
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error populating the table, try later");
            alert.showAndWait();
            
        }
        
        //customer.add(new Customers(1, "test", "test", "test", "san juan", LocalDate.of(1993, 02, 23), "mcabassa", "Y"));
        }catch(Exception e){e.printStackTrace();}
        finally
        {
         connect.close();
        }
        return null;
        
        
    }
        
    
    
}
