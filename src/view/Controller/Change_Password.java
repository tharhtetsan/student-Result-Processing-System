package view.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import controller.DB.Quaries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Change_Password implements Initializable{

	
	@FXML
    private JFXTextField txt_Newuser;

    @FXML
    private JFXTextField txt_CurrentPass;

    @FXML
    private JFXTextField txt_Newpass;

   Quaries db;
   String userNamedb;
   String passdb;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		db=new Quaries();
		
	
		passdb=(String) (db.getUserNameAndPass());
	}
    
    
    @FXML
    void btn_Cancel_Act(ActionEvent event) {
    	txt_Newuser.setText("");
    	txt_CurrentPass.setText("");
    	
    	txt_Newpass.setText("");
    }

    @FXML
    void btn_Change_Act(ActionEvent event) {
    	
    	String txtNewUser=txt_Newuser.getText().trim();
    	String txtCurrentPass=txt_CurrentPass.getText().trim();
    	String txtNewPass=txt_Newpass.getText().trim();
    	
    	System.out.println(passdb);
    	if(txtCurrentPass.equalsIgnoreCase(passdb.trim()))
    	{
    		db.ChangeUserNameAndPass(txtNewUser, txtNewPass);
    		Alert ttt = new Alert(AlertType.INFORMATION);
			ttt.setContentText("Success!");
			ttt.show();
    	}else
    	{
    		Alert ttt = new Alert(AlertType.INFORMATION);
			ttt.setContentText("Incorrect Current password pls try again!");
			ttt.show();
    	}
    			
    			

    }
    
    

	
}
