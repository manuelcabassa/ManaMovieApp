/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manamovieapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Manuel
 */
public class itemController {
    
    @FXML
    private Button btnMovieDetailt;

    @FXML
    private ImageView img;
    
    private Movies movie;
    
    public void setData(Movies movie){
        this.movie = movie;
        Image image = new Image(getClass().getResourceAsStream(movie.getImgPath()));
        //Image image = new Image("file: ..\\..\\java\\Image\\65.jpg");
        img.setImage(image);
    }

    
}
