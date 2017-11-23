package view.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.Caret;

import application.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainMenu2_Controller implements Initializable{
	
	@FXML
    private Card card_student_listView;

    @FXML
    private Card card_Course_Overview;

    @FXML
    private Card card_result_view;

    @FXML
    private Card card_result_annoucenment;

    @FXML
    private Card card_generate_transcript;

    @FXML
    private Card card_generate_result;

    
    
    Stage chingingStage;
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	chingingStage=new Stage();
		
	}
    
    
    @FXML
    void act_student_listView(MouseEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Student_listView.fxml"));
		
		Scene scene=null;
		try {
			scene = new Scene(((Parent) root.load()),850,500);
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
    void act_Course_Overview(MouseEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Course_listView.fxml"));
		
		Scene scene=null;
		try {
			scene = new Scene(((Parent) root.load()),850,500);
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
    void act_card_result_view(MouseEvent event) {
    	
    }
    
    
    @FXML
    void card_generate_result_Act(MouseEvent event) {
    	
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Result_Generate.fxml"));
		
		Scene scene=null;
		try {
			scene = new Scene(((Parent) root.load()),850,500);
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
    void card_generate_transcript_Act(MouseEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Transcript_Generate.fxml"));
		
		Scene scene=null;
		try {
			scene = new Scene(((Parent) root.load()),850,500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chingingStage.close();
		chingingStage.setScene(scene);
		chingingStage.setResizable(true);
		chingingStage.show();

    }
    
    
    
    

}
