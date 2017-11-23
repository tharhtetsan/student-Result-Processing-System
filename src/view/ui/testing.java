package view.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testing extends Application{

	
	
	public static void main(String args[])
	{
		Application.launch(args);

	}
	

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		FXMLLoader root = new FXMLLoader(getClass().getResource("UI_Student_listView.fxml"));
		
		Scene scene = new Scene(((Parent) root.load()),850,500);
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();
	}
}
