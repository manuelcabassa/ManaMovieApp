/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package manamovieapp;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Manuel
 */
public class database {
    
    public static Connection connectDb(){
        try{
            
        String url = "jdbc:mysql://localhost:3306/manamovie";
        //Class.forName ("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection (url, "usuario", "password");
            
        return conn;
            
        }catch(Exception e){
            e.printStackTrace();}
        
        return null;
    }
    
    
 
}
