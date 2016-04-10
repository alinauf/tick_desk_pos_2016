
package controller;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.PosSelectionModel;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	private Stage window;
	
	@Override
	
	public void start(Stage primaryStage) {
		this.window = primaryStage; //To Set The Stage
		PosSelectionWindow(); // To call main window
		}
	
	public void PosSelectionWindow(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/PosSelectionView.fxml"));//TO connect with the view
			AnchorPane pane = loader.load();
			
			PosSelectionController PosSelectionController = loader.getController(); //The fxml will connect to controller
			PosSelectionController.setMain(this,this.window);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
			window.setFullScreen(true);
			window.setResizable(false);
			window.setScene(scene);
			window.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			e.getCause();
		}
	}
	
//	private ObservableList<PosSelectionModel> selectedList =FXCollections.observableArrayList(); // ForTable List

	/*public ObservableList<PosSelectionModel> getSelectedList(){
		return selectedList;		
	}*/
	
	public Main(){
		//To add Data to Table when program starts
		//selectedList.add(new PosSelectionModel("Charlie",92));
		//selectedList.add(new PosSelectionModel("Mike","mik","777007212","Dubai","12334"));
		//selectedList.add(new PosSelectionModel("dadd","fil","123454321","France","1776"));
		//selectedList.add(new PosSelectionModel("jonny","mdas","87654367","Sri Lanka","65432"));
		//selectedList.add(new PosSelectionModel("dada","mama","0956789345","Germany","14576"));

		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}