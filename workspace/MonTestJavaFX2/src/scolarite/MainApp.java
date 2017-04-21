package scolarite;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public MainApp() {
		super();
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gestion scolarite");
		this.primaryStage.setWidth(900);
		this.primaryStage.setHeight(500);
		this.primaryStage.setX(0);
		this.primaryStage.setY(0);
		this.initRootLayout();
		this.loadEleveOverview();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void initRootLayout() {
		//Load rootLayout from FXML file
		try {
			//Load rootLayout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//Show the scene containing
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadEleveOverview() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/EleveOverview.fxml"));
			AnchorPane eleveOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(eleveOverview);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
