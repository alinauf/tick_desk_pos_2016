package model;

import database.jdbcConnect;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.*;


public class PosSelectionModel {

	//Variables
	private String subProductName;



	private String productCat;
	private Double subProductPrice;
	private int arr[] = new int[5];
	
	//Views
	ListView<String> subCatListModel;
	
	//Connections
	jdbcConnect jdbcobj=new jdbcConnect();//make an object of jdbcConnect class
    Connection myConn=jdbcConnect.Connectdb();//Use the Connectdb function to connect to database 
    
    //Constructors
   /* public PosSelectionModel(String subProductName) {
    	super();
    	this.subProductName = subProductName;
    }*/
    
	public PosSelectionModel(String subProductName,Double subProductPrice) {
		super();
		this.subProductName = subProductName;
		this.subProductPrice = subProductPrice;
	}
    
    
/*	public PosSelectionModel(String subProductName, String productCat, double subProductPrice) {
		super();
		this.subProductName = subProductName;
		this.productCat = productCat;
		this.subProductPrice = subProductPrice;
	}*/
   
    //Methods
    
    
	/*public ListView<PosSelectionModel> fillSubCatListModel()  {	
		
		try {
		//	subCatListModel= new ListView<String>();
		    Statement myStat=myConn.createStatement();
		    ResultSet myRs= myStat.executeQuery("select subProductName from subProductsCat"); //Sql Query
		    
		    subCatListModel.getItems().add("lol");
		      while (myRs.next()) {
		    	  subCatListModel.getItems().add(myRs.getString("subProductName"));//Assigning the name got from sql query to a variable subCatListModel      	
		          System.out.print(myRs.getString("subProductName"));//For testing,remove latr
		      }      		
			//return subCatListModel;
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return subCatListModel;

	}*/
	
	public String[] returnSubCatList() {
	    String[] a = null ;
	    int counter=0;
	    try {
			//	subCatListModel= new ListView<String>();
			    Statement myStat=myConn.createStatement();
			    ResultSet myRs= myStat.executeQuery("select subProductName from subProductsCat"); //Sql Query
			    
			    subCatListModel.getItems().add("lol");
			      while (myRs.next()) {
			    	  a[counter]=myRs.getString("subProductName");
			    	  //subCatListModel.getItems().add(myRs.getString("subProductName"));//Assigning the name got from sql query to a variable subCatListModel      	
			          System.out.print(myRs.getString("subProductName"));//For testing,remove latr
			          counter++;
			      }    
			      
			      
			      
				//return subCatListModel;
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
			
	    return a; 
	}
	
    public String test(){
	    Statement myStat;
    	String hu ="l";
		try {
			myStat = myConn.createStatement();
			ResultSet myRs= myStat.executeQuery("select subProductName from subProductsCat"); //Sql Query
	    			 while (myRs.next()) {
	    			 hu=myRs.getString("subProductName");
	    			 }	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hu;
	    
    } 
    
    //Getters
	public String getSubProductName() {
		return subProductName;
	}


    //Setters

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	
	
	
	

}
