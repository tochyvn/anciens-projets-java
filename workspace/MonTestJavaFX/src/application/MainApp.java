package application;
	
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
		this.primaryStage.setTitle("Gestion scolarité");
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
			//Add AnchorPane in the rootLayout
			AnchorPane eleveOverview = (AnchorPane) FXMLLoader.load(getClass().getResource("view/EleveOverview.fxml"));
			rootLayout.setCenter(eleveOverview);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
