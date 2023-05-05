/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manamovieapp;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author manuel
 */
public class Movies {
    
    private SimpleStringProperty Id;
    private SimpleStringProperty title;
    private SimpleStringProperty director;
    private SimpleStringProperty writters;
    private LocalDate releaseDate;
    private SimpleStringProperty runningTime;
    private SimpleStringProperty rated;
    private SimpleStringProperty genre;
    private SimpleStringProperty cast;
    private SimpleStringProperty imgPath;
    private SimpleStringProperty isRented;
    
    public Movies(){
        
    }

    public Movies(String id, String title, String director, String writters, LocalDate releaseDate, String runningTime, String rated, String genre, String cast, String imgPath, String isrented) {
        this.Id = new SimpleStringProperty(id);
        this.title = new SimpleStringProperty(title);
        this.director = new SimpleStringProperty(director);
        this.writters = new SimpleStringProperty(writters);
        this.releaseDate = releaseDate;
        this.runningTime = new SimpleStringProperty(runningTime);
        this.rated = new SimpleStringProperty(rated);
        this.genre = new SimpleStringProperty(genre);
        this.cast = new SimpleStringProperty(cast);
        this.imgPath = new SimpleStringProperty(imgPath);
        this.isRented = new SimpleStringProperty(isrented);
    }


    public String getId() {
        return Id.get();
    }

    public void setId(SimpleStringProperty Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(SimpleStringProperty title) {
        this.title = title;
    }

    public String getDirector() {
        return director.get();
    }

    public void setDirector(SimpleStringProperty director) {
        this.director = director;
    }

    public String getWritters() {
        return writters.get();
    }

    public void setWritters(SimpleStringProperty writters) {
        this.writters = writters;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRunningTime() {
        return runningTime.get();
    }

    public void setRunningTime(SimpleStringProperty runningTime) {
        this.runningTime = runningTime;
    }

    public String getRated() {
        return rated.get();
    }

    public void setRated(SimpleStringProperty rated) {
        this.rated = rated;
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(SimpleStringProperty genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast.get();
    }

    public void setCast(SimpleStringProperty cast) {
        this.cast = cast;
    }

    public String getImgPath() {
        return imgPath.get();
    }

    public void setImgPath(SimpleStringProperty imgPath) {
        this.imgPath = imgPath;
    }
    
        public String getIsRented() {
        return isRented.get();
    }

    public void setIsRented(SimpleStringProperty isRented) {
        this.isRented = isRented;
    }
    
    
}
