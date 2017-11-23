package view.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainMenu_Controller implements Initializable{


    @FXML
    private Card Add_New_Student;

    @FXML
    private Card Add_New_Course;

    @FXML
    private Card Date_Accouncement;

    @FXML
    private Card Define_Grade;

    @FXML
    private Card Define_sub;

    @FXML
    private Card Add_Exam_mark;
    
    Stage chingingStage;

    @FXML
    void act_Add_Exam_mark(MouseEvent event) {
   
    		FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Add_Mark.fxml"));
		
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
    void act_Add_New_Course(MouseEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Add_New_Course.fxml"));
		
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
    void act_Add_New_Student(MouseEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Add_New_Student.fxml"));
		
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
    void act_Date_Accouncement(MouseEvent event) {
    	
    }

    @FXML
    void act_Define_Grade(MouseEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/UI_Define_Grade.fxml"));
		
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
    void act_Define_sub(MouseEvent event) {
    	FXMLLoader root = new FXMLLoader(getClass().getResource("/view/ui/Ui_Define_Course.fxml"));
		
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
