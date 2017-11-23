package view.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.ActionBar;
import application.DrawerLayout;
import application.Main;
import application.MaterialRootLayout;
import application.MaterialText;
import application.TabTitle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import controller.DB.*;

public class LoginController implements Initializable{

	private String userName;
	private String password;
	
	private String userID;
	
	@FXML
    private StackPane spaneMain;

	 @FXML
	    private JFXTextField txt_userName;

	 @FXML
	    private JFXPasswordField txt_password;
	    
	 @FXML
	    private JFXButton btn_login;
	 
	 @FXML
	    private ImageView imgv_load;

	 
	 Quaries db;
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			db=new Quaries();
			
		}

	 
	 
	    @FXML
	    void btn_loginAction(ActionEvent event) {
	    	userName=txt_userName.getText().trim();
	    	password=txt_password.getText().trim();
	    	userID=db.getUserId(userName,password);
	    	
	    	if(userID.equalsIgnoreCase("1"))
	    	{
	    		Stage stage = (Stage) btn_login.getScene().getWindow();
	    	   
	    		
	    		
	    		
	    		 stage.close();
		    	    
	    		
	    		// do what you have to do
	    	   
	    		ActionBar actionBar = new ActionBar("\tStudent Result Processing and Transcript Generation System");
	            DrawerLayout drawerLayout = new DrawerLayout();
	            try {
					drawerLayout.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ui/Mainframe.fxml")));
				drawerLayout.setMaxWidth(150);
	            Color white = Color.WHITE;
	      
	            actionBar.addTab(new TabTitle(new MaterialText("Main Menu", white)), FXMLLoader.load(getClass().getResource("/view/ui/MainMenu.fxml")));
	            actionBar.addTab(new TabTitle(new MaterialText("View", white)), FXMLLoader.load(getClass().getResource("/view/ui/MainMenu2.fxml")));
	            actionBar.addTab(new TabTitle(new MaterialText("Result Overview", white)), FXMLLoader.load(getClass().getResource("/view/ui/result_list.fxml")));
	           
	            } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            
	            MaterialRootLayout root = new MaterialRootLayout(actionBar, drawerLayout);
	           Stage primaryStage=new Stage();
	           primaryStage.setTitle("");
	            primaryStage.setScene(new Scene(root, 1400, 920));
	            //   primaryStage.setFullScreen(true);
	            primaryStage.show();
	            
	            
	            actionBar.setStyle("-fx-background-color :TEAL");
	    	
	    	
	    	}
	    	else
	    	{
	    		Alert ttt = new Alert(AlertType.INFORMATION);
				ttt.setContentText("Incorrect username or password ! \n please try again .");
				ttt.show();
	    	}
	    }
	    
	    
	    
	    


		private String getUserProfileID() {

			return null;
		}






		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public LoginController()
	    {
	    	userName="";
	    	password="";
	    }






	
	    
		
}
