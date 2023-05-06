/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manamovieapp;

import java.awt.event.MouseEvent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manamovieapp.Movies;
import manamovieapp.Movies;
import manamovieapp.Movies;
import manamovieapp.Movies;

/**
 *
 * @author Manuel
 */
public class itemController {
    
    @FXML
    private AnchorPane MovieView;
    
    @FXML
    private AnchorPane detailPanel;
    
    @FXML
    private Button btnMovieDetailt;

    @FXML
    private ImageView img;
    
    public Movies movie;
    
    public Stage stage;
    public Scene scene;
    public static String movieID;
    @FXML
    private Label movieName;
    
    
    public void setData(Movies movie){
        this.movie = movie;
        Image image = new Image(getClass().getResourceAsStream(movie.getImgPath()));
        img.setImage(image);
    }
    
    public void btnMovieDetailt(){
        
    }
    
        
    @FXML
    void showMovieDetail(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdetail.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        

    }

    
}
