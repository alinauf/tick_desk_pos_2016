package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.jdbcConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.PosSelectionModel;

public class PosSelectionController {

	//Variables
	private Main main;
	private Stage posSelectionWindow;
	//Views
	@FXML ListView<String> subCatList; // For listView

	@FXML TableView<PosSelectionModel> tableView;
	//@FXML TableColumn<PosSelectionModel, Integer> quantityColumn;
	@FXML TableColumn<PosSelectionModel, String> productColumn;
	@FXML TableColumn<PosSelectionModel, Double> priceColumn;
	
	//private ObservableList<PosSelectionModel> selectedList =FXCollections.observableArrayList();
	
	

	
	//For Testing
	jdbcConnect jdbcobj=new jdbcConnect();//make an object of jdbcConnect class
    Connection myConn=jdbcConnect.Connectdb();//Use the Connectdb function to connect to database 
 
   //

	public void initialize(){ //automatically called
		productColumn.setCellValueFactory(new PropertyValueFactory<PosSelectionModel,String>("subProductName"));		
		//lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<PosSelectionModel,Double>("subProductPrice"));

	}

    
	public void setMain(Main main,Stage primaryStage) {
		this.main=main;
		posSelectionWindow=primaryStage;
	//	subCatList = posModel.fillSubCatListModel();
		
		addToList();
		try{
		tableView.setItems(getSelectedList());}
		catch(Exception e){
	    	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Warning header");
			alert.setContentText("Table View"+e);
			alert.showAndWait();
			
		}
		//subCatList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	
	}
	
	
	@FXML
	public void addToList(){
	
	try{
		
	//Create Connection	
    Statement myStat=myConn.createStatement();
    ResultSet myRs= myStat.executeQuery("select subProductName from subProductsCat");
	
    //Loop through the array
	 while (myRs.next()) {
		 subCatList.getItems().add(myRs.getString("subProductName"));//Assigning the name got from sql query to a variable subCatListModel      	
         System.out.print(myRs.getString("subProductName"));//For testing,remove latr
     }
	
	subCatList.getItems().addAll("Muffins","Cookies","Cinnamon Rolls","Pudding");

	
	}//End of try
	catch(Exception e){
	       // JOptionPane.showMessageDialog(null, e);
	    	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Warning header");
			alert.setContentText("Cant Connect"+e);
			alert.showAndWait();
	     //   return null;
	    }
	
	}
	
	private ObservableList<PosSelectionModel> selectedList =FXCollections.observableArrayList(); // ForTable List

	public ObservableList<PosSelectionModel> getSelectedList(){
		return selectedList;		
	}
	
	//The List When Clicked
	public void subCatOnClick(){
		System.out.println("clicked on " + subCatList.getSelectionModel().getSelectedItem());					
		selectedList.add(new PosSelectionModel(subCatList.getSelectionModel().getSelectedItem(),92.0));
	//	setTableData();
		//productColumn.setCellValueFactory(new PropertyValueFactory<PosSelectionModel,String>("subProductName"));
	//	tableView.setItems(selectedList);
		}

	
	


	//TO set Table Data
	public void setTableData(){
		//selectedList.add(new PosSelectionModel(subCatList.getSelectionModel().getSelectedItem()));
//		selectedList.add(new Person("Mike","mik",22));
		//selectedList.add(new Person("dadd","fil",21));
		

		
	}
		
	//Getters	
	public ListView<String> getSubCatList() {
		return subCatList;
	}

	//Setters
	public void setSubCatList(ListView<String> subCatList) {
		this.subCatList = subCatList;
	}

	

	
	
//End of Class
}