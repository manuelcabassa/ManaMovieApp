/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package manamovieapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class FXMLUserViewController implements Initializable {

    @FXML
    private AnchorPane MovieView;

    @FXML
    private ChoiceBox<String> choiceBoxGenre;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    private List<Movies> addMovies = new ArrayList<>();

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private List<Movies> getData() throws SQLException {

        List<Movies> movies = new ArrayList<>();
        Movies movie;
        String sqlScript = "Select * from movie";
        String imgPath;
        String path;
        
        String uri;

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
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(sqlScript);
        
       
            
            while(rs.next())
            {
            movie = new Movies();
            imgPath =rs.getNString(10);
            path = imgPath.substring(60);
            uri = path.replace("\\", "/");
            
            movie.setImgPath( uri);
            movies.add(movie);
                
                
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
         connect.close();
        }
        
        
 

        /*for (int i = 0; i < 5; i++) {
            movie = new Movies();
            movie.setImgPath("/Image/ScreenMovie.jpg");
            movies.add(movie);
        }*/
        return movies;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            addMovies.addAll(getData());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLUserViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int column = 0;
        int row = 0;

        try {
            for (int i = 0; i < addMovies.size(); i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlloader.load();

                itemController itemController = fxmlloader.getController();
                itemController.setData(addMovies.get(i));
                if (column == 4) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
