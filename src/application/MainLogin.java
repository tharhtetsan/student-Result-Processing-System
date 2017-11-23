package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLogin extends Application{


	public static void main(String args[])
	{
		Application.launch(args);

	}
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/Login.fxml"));
		
		Scene scene = new Scene(((Parent) root.load()),850,500);
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.setMaximized(true);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
}
