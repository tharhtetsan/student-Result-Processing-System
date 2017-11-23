package view.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import controller.DB.Quaries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuBar implements Initializable{
	

    @FXML
    private JFXButton btn_Setting;

    @FXML
    private JFXButton btn_About;

    
    Stage chingingStage;
    Quaries db;
    @FXML
    void btn_About_Act(ActionEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/aboutTeam.fxml"));
		Scene scene=null;
		try {
			scene = new Scene(((Parent) root.load()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chingingStage.close();
		chingingStage.setScene(scene);
		chingingStage.setResizable(true);
		chingingStage.show();
    }

    @FXML
    void btn_Setting_Act(ActionEvent event) {
    	
    	    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/PasswordChange.fxml"));
    			Scene scene=null;
    			try {
    				scene = new Scene(((Parent) root.load()));
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			chingingStage.close();
    			chingingStage.setScene(scene);
    			chingingStage.setResizable(true);
    			chingingStage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chingingStage=new Stage();
		
	}


}
