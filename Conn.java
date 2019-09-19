package Login;


import java.sql.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Conn {
    static private Connection conn;
    
    public static Connection getConnection() {
        try{
            if(conn == null){
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "Chemage@123");
            System.out.println("Connection Successfull");
        }
        return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
        
    }
    
}
    

