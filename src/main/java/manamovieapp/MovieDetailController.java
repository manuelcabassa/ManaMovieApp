/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package manamovieapp;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class MovieDetailController implements Initializable {

    @FXML
    private AnchorPane detailPanel;
    @FXML
    private TextField txtDetailtitle;
    @FXML
    private TextField txtDetaildirector;
    @FXML
    private TextField txtDetailtime;
    @FXML
    private TextField txtDetailrated;
    @FXML
    private TextField txtDetailwritters;
    @FXML
    private TextField txtDetailreleaseDate;
    @FXML
    private TextField txtDetailgenre;
    @FXML
    private TextArea txtDetailcast;
    @FXML
    private Button btnRent;
    @FXML
    private Button btnBack;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //Me quede en que ya tengo el id para buscar la discripcion de la movie
            fillField(getData.id);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fillField(String id) throws SQLException {
        String sqlScript = "select * from movie where idMovie = ?";
        //String sqlScript = "select * from movie";
        Alert alert;
        

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
            //prepare.setInt(1, Integer.valueOf(id));

            
            result = prepare.executeQuery();
        
       
            
            if(result.next())
            {
               txtDetailtitle.setText(result.getNString(2));
                
            }

            
                
            

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }

    }

    public void rentMovieDetail() {

    }

    /*@FXML
    private void rentMovie(ActionEvent event) {
    }
    
        @FXML
    private void back(ActionEvent event) {

    }*/
}
