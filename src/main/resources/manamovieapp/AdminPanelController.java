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
import javafx.scene.control.Label;
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
    private AnchorPane confirmDeleteUser;
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
    
    //Delete form fields

    @FXML
    private TextField txtIdDelete;
    @FXML
    private TextField txtfirstNameDelete;
    @FXML
    private TextField txtlastNameDelete;
    @FXML
    private TextField txtaddressDelete;
    
    //Edit form fields
    
    @FXML
    private AnchorPane EditUserView;
    @FXML
    private TextField txtEditUser_id;
    @FXML
    private TextField txtEditUser_firstName;
    @FXML
    private TextField txtEditUser_middleName;
    @FXML
    private TextField txtEditUser_lastName;
    @FXML
    private TextField txtEditUser_address;
    @FXML
    private TextField txtEditUser_dateOfBirth;
    @FXML
    private TextField txtEditUser_username;
    @FXML
    private TextField txtEditUser_isAdmin;
    
    //Movie panel
    @FXML
    private AnchorPane movieAdminPanel;
    @FXML
    private TableView<Movies> tableViewMovie;
    @FXML
    private TableColumn<Movies, String> idMovieColumn;
    @FXML
    private TableColumn<Movies, String> titleMovieColumn;
    @FXML
    private TableColumn<Movies, String> directorMovieColumn;
    @FXML
    private TableColumn<Movies, String> writtersMovieColumn;
    @FXML
    private TableColumn<Movies, LocalDate> releaseDateMovieColumn;
    @FXML
    private TableColumn<Movies, String> runningTimeMovieColumn;
    @FXML
    private TableColumn<Movies, String> ratedMovieColumn;
    @FXML
    private TableColumn<Movies, String> genreMovieColumn;
    @FXML
    private TableColumn<Movies, String> castMovieColumn;
    @FXML
    private TableColumn<Movies, String> imgPathMovieColumn;
    
    
   
    
    
    
    //Sql parameters

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    Alert alert;

    //Customers admin panel
    public void customersView() throws SQLException {
        adminPanel.setVisible(false);
        CustomerView.setVisible(true);

        IdColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("Id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("firstName"));
        middleNameColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("middleName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("lastName"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("adress"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<Customers, LocalDate>("dateOfBirth"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("username"));
        isAdminColumn.setCellValueFactory(new PropertyValueFactory<Customers, String>("isAdmin"));

        try {
            tableView.setItems(getCustomers());
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addCustomer() {

        CustomerView.setVisible(false);
        AddNewUser.setVisible(true);

    }

    public void BtnAddNewUser() throws SQLException {

        String sqlScript = "INSERT INTO client(firstName, middleName, lastName, address, dateOfBirth, username, password, isAdmin) VALUES(?,?,?,?,?,?,?,?)";

        connect = database.connectDb();

        if (connect == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }

        try {

            prepare = connect.prepareStatement(sqlScript);
            prepare.setString(1, txtFirstName.getText());
            prepare.setString(2, txtMiddleName.getText());
            prepare.setString(3, txtLasttName.getText());
            prepare.setString(4, txtAdress.getText());
            prepare.setString(5, txtDateOfBirth.getText());
            prepare.setString(6, txtUsername.getText());
            prepare.setString(7, txtPassword.getText());
            prepare.setString(8, txtIsAdmin.getText().toUpperCase());

            if (txtFirstName.getText().isEmpty() || txtLasttName.getText().isEmpty() || txtAdress.getText().isEmpty() || txtDateOfBirth.getText().isEmpty()
                    || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || txtIsAdmin.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the fields, except middle name if you don´t have.");
                alert.showAndWait();
            } else if (txtPassword.getText().length() < 5) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Password need 5 or more characters.");
                alert.showAndWait();
            } else {
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }

    }
    
    public void EditUserView()
    {
        
        Customers customer = tableView.getSelectionModel().getSelectedItem();
        int index = tableView.getSelectionModel().getSelectedIndex();

        if ((index - 1) < -1) {
            EditUserView.setVisible(false);
            CustomerView.setVisible(true);
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("First select the row you want to edit.");
            alert.showAndWait();
            return;
        } else {
        CustomerView.setVisible(false);
        EditUserView.setVisible(true);
        txtEditUser_id.setText(customer.getId());
        txtEditUser_firstName.setText(customer.getFirstName());
        txtEditUser_middleName.setText(customer.getMiddleName());
        txtEditUser_lastName.setText(customer.getLastName()); 
        txtEditUser_address.setText(customer.getAdress());
        txtEditUser_username.setText(customer.getUsername()); 
        txtEditUser_dateOfBirth.setText(customer.getDateOfBirth().toString());
        txtEditUser_isAdmin.setText(customer.getIsAdmin()); 
        }
        
        
       
    }
    
    public void BtnEditUser() throws SQLException{
        
        Customers customer = tableView.getSelectionModel().getSelectedItem();
        int index = tableView.getSelectionModel().getSelectedIndex();
        String sqlScript = "UPDATE client SET firstName = ?, middleName = ?, lastname = ?, address = ?, dateOfBirth = ?, username = ?, isAdmin = ?\n" +
" WHERE idClient = ?";

        connect = database.connectDb();

        if (connect == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        
        try{
            
            
            if(txtEditUser_id.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The id fields is empty or not found.");
                alert.showAndWait();
            }else{
                prepare = connect.prepareStatement(sqlScript);
                prepare.setString(1, txtEditUser_firstName.getText());
                prepare.setString(2, txtEditUser_middleName.getText());
                prepare.setString(3, txtEditUser_lastName.getText());
                prepare.setString(4, txtEditUser_address.getText());
                prepare.setString(5, txtEditUser_dateOfBirth.getText());
                prepare.setString(6, txtEditUser_username.getText());
                prepare.setString(7, txtEditUser_isAdmin.getText());
                prepare.setString(8, txtEditUser_id.getText());
                prepare.execute();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("The record has succefully updated.");
                alert.showAndWait();
                
                try {
                    tableView.setItems(getCustomers());
                } catch (SQLException ex) {
                    Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                CustomerView.setVisible(true);
                EditUserView.setVisible(false);
            }
            
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.close();
        }
        
    }

    public void deleteCustomers() throws SQLException {

        Customers customer = tableView.getSelectionModel().getSelectedItem();
        int index = tableView.getSelectionModel().getSelectedIndex();

        if ((index - 1) < -1) {
            confirmDeleteUser.setVisible(false);
            CustomerView.setVisible(true);
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("First select the row you want to delete.");
            alert.showAndWait();
            return;
        } else {
         CustomerView.setVisible(false);
        confirmDeleteUser.setVisible(true);
        txtIdDelete.setText(customer.getId());
        txtfirstNameDelete.setText(customer.getFirstName());
        txtlastNameDelete.setText(customer.getLastName());
        txtaddressDelete.setText(customer.getAdress());
        
           
        }

    }

    public void btnConfirmDeleteUser() throws SQLException {

        Customers customer = tableView.getSelectionModel().getSelectedItem();
        int index = tableView.getSelectionModel().getSelectedIndex();
        String sqlScript = "Delete from client WHERE idClient = ?";

        connect = database.connectDb();

        if (connect == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        
        try{
            
            prepare = connect.prepareStatement(sqlScript);
            prepare.setString(1, txtIdDelete.getText());
            
            if(txtIdDelete.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The id fields is empty.");
                alert.showAndWait();
            }else{
                prepare.execute();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("The record has succefully delete.");
                alert.showAndWait();
                
                try {
                    tableView.setItems(getCustomers());
                } catch (SQLException ex) {
                    Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                CustomerView.setVisible(true);
                confirmDeleteUser.setVisible(false);
            }
            
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            connect.close();
        }


        //txtfirstNameDelete.setText(customer.getFirstName());

    }
    
    
    
    //Movie admin panel
    
    public void movieAdminPanel(){
        
        adminPanel.setVisible(false);
        movieAdminPanel.setVisible(true);
        
        idMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("Id"));
        titleMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("title"));
        directorMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("director"));
        writtersMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("writters"));
        releaseDateMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, LocalDate>("releaseDate"));
        runningTimeMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("runningTime"));
        ratedMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("rated"));
        genreMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("genre"));
        castMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("cast"));
        imgPathMovieColumn.setCellValueFactory(new PropertyValueFactory<Movies, String>("imgPath"));

        try {
            tableViewMovie.setItems(getMovies());
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    public void signOut() throws IOException {

        CustomerView.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInitView.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void BackToLastView() {

        if (CustomerView.getScene().getWindow().isShowing()) {
            
            
            CustomerView.setVisible(false);
            adminPanel.setVisible(true);
            
        } 
        
        if (confirmDeleteUser != null) {
            //confirmDeleteUser.getScene().getWindow().hide();
            adminPanel.setVisible(false);
            CustomerView.setVisible(true);
            confirmDeleteUser.setVisible(false);
        }
        if (EditUserView != null) {
            //confirmDeleteUser.getScene().getWindow().hide();
            adminPanel.setVisible(false);
            CustomerView.setVisible(true);
            EditUserView.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String welcome = welcomeAdminText.getText();
        welcomeAdminText.setText(welcome + " " + "Admin");

    }

    public ObservableList<Customers> getCustomers() throws SQLException {

        String sqlScript = "SELECT * FROM client";

        connect = database.connectDb();

        if (connect == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(sqlScript);

            if (rs != null) {
                ObservableList<Customers> customer = FXCollections.observableArrayList();
                while (rs.next()) {
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
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error populating the table, try later");
                alert.showAndWait();

            }

            //customer.add(new Customers(1, "test", "test", "test", "san juan", LocalDate.of(1993, 02, 23), "mcabassa", "Y"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return null;

    }
       public ObservableList<Movies> getMovies() throws SQLException {

        String sqlScript = "SELECT * FROM movie";

        connect = database.connectDb();

        if (connect == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error connection with database");
            alert.showAndWait();
        }
        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(sqlScript);

            if (rs != null) {
                ObservableList<Movies> movie = FXCollections.observableArrayList();
                while (rs.next()) {
                    /*String Id = rs.getNString(1);
                String firstName = rs.getString("firstName");
                String middleName = rs.getString("middleName");
                String lastName = rs.getString("lastName");
                String city = rs.getString("city");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String username = rs.getString("username");
                String isAdmin = rs.getString("isAdmin");*/
                    Integer Id = rs.getInt(1);
                    String title = rs.getNString(2);
                    String director = rs.getNString(3);
                    String writters = rs.getNString(4);
                    Date releaseDate = rs.getDate(5);
                    String runningTime = rs.getNString(6);
                    String rated = rs.getNString(7);
                    String genre = rs.getNString(8);
                    String cast = rs.getNString(9);
                    String imgPath = rs.getNString(10);

                    Movies movies = new Movies(Id.toString(), title, director, writters, releaseDate.toLocalDate(), runningTime, rated, genre, cast, imgPath);
                    movie.add(movies);

                }
                return movie;
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error populating the table, try later");
                alert.showAndWait();

            }

            //customer.add(new Customers(1, "test", "test", "test", "san juan", LocalDate.of(1993, 02, 23), "mcabassa", "Y"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }
        return null;

    }

}
