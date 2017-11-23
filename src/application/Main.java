

package application;

import application.*;
import controller.DB.Db_commection;
import controller.DB.Quaries;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ActionBar actionBar = new ActionBar("\tStudent Result Processing and Transcript Generation System");
        DrawerLayout drawerLayout = new DrawerLayout();
        drawerLayout.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ui/Mainframe.fxml")));
        drawerLayout.setMaxWidth(150);
        Color white = Color.WHITE;
  
        actionBar.addTab(new TabTitle(new MaterialText("Main Menu", white)), FXMLLoader.load(getClass().getResource("/view/ui/MainMenu.fxml")));
        actionBar.addTab(new TabTitle(new MaterialText("View", white)), FXMLLoader.load(getClass().getResource("/view/ui/MainMenu2.fxml")));
        actionBar.addTab(new TabTitle(new MaterialText("Result Overview", white)), FXMLLoader.load(getClass().getResource("/view/ui/result_list.fxml")));
      
        
        MaterialRootLayout root = new MaterialRootLayout(actionBar, drawerLayout);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1400, 920));
        //   primaryStage.setFullScreen(true);
        primaryStage.show();
        System.out.println("ggg");
       
        actionBar.setStyle("-fx-background-color :TEAL");
    }


    	public static void main(String[] args) {
     	//Quaries query=new Quaries();
    	
    	launch(args);
        System.out.println("ggg");
    }
    	
    	public Main()
    	{
    		(new Main()).Application.launch(new Stage());
    	}
    
}
