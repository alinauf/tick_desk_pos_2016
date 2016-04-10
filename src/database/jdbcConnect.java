package database;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class jdbcConnect {
	    
	    Connection myConn =null;//Set the Connection variable to null
	    
	    public static Connection Connectdb(){
	    try{
	 	Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tDPos", "root","password");
	       // JOptionPane.showMessageDialog(null,"Connected to db");
	/*	Alert alert1 = new Alert(AlertType.INFORMATION);
		alert1.setTitle("Information");
		alert1.setHeaderText("Connection myConn");
		alert1.setContentText("Connected");
		alert1.showAndWait();*/
	 	System.out.println("Houston i can hear you!!");
	    return myConn;
	    
	    
	    }
	    catch(Exception e){
	       // JOptionPane.showMessageDialog(null, e);
	    	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Warning header");
			alert.setContentText("Cant Connect"+e);
			alert.showAndWait();
	        return null;
	    }
	    
	}
	    
	    
	}
	
	

