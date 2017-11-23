package view.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import model.ObjectReferences.*;
import controller.DB.*;

public class Add_New_Course_Controller implements Initializable{

	

	  @FXML
	    private Text txt_CourseId;

	    @FXML
	    private JFXTextField txt_CourseName;

	    @FXML
	    private JFXTextField txt_trName;

	    @FXML
	    private JFXTextArea txt_aim;

	    @FXML
	    private Text txt_date;

	    @FXML
	    private Text txt_refName;

	    @FXML
	    private JFXButton btn_reset;

	    @FXML
	    private JFXButton btn_save;

	    @FXML
	    private JFXComboBox<String> cbo_year;
	    
	    private String name;
	    private String id;
	    private String refName;
	    private String trName;
	    private String aim;
	    private String date;
	    private String foryear;
	    Quaries db;
	    
	    private Obj_db_Course_profile course;
	    
	    @FXML
	    void btn_reset_Act(ActionEvent event) {

	    	txt_CourseId.setText(db.getPrimaryKey("CourseId", "Course_tb", "COU-"));
			txt_refName.setText("Course_"+txt_CourseId.getText().substring(4,11));
			txt_CourseName.setText("");
			txt_aim.setText("");
			txt_trName.setText("");
			cbo_year.setValue("Choose Year");
	    }

	    @FXML
	    void btn_save_Act(ActionEvent event) {
	    	
	    	name=txt_CourseName.getText().toString().trim();
	    	aim=txt_aim.getText().toString().trim();
	    	trName=txt_trName.getText().toString().trim();
	    	date=txt_date.getText().toString().trim();
	    	refName=txt_refName.getText().toString().trim();
	    	id=txt_CourseId.getText().toString().trim();
	    	foryear=cbo_year.getSelectionModel().getSelectedItem().toString();
	    	
	    	course=new Obj_db_Course_profile();
	    	course.setCourseId(id);
	    	course.setAim(aim);
	    	course.setTrName(trName);
	    	course.setDate(date);
	    	course.setRefName(refName);
	    	course.setName(name);
	    	course.setForYear(foryear);
	    	
	    	db.AddNewCourse(course);
	    	
	    	
	    	txt_CourseId.setText(db.getPrimaryKey("CourseId", "Course_tb", "COU-"));
			txt_refName.setText("Course_"+txt_CourseId.getText().substring(4,11));
			txt_CourseName.setText("");
			txt_aim.setText("");
			txt_trName.setText("");
		
			cbo_year.setValue("Choose Year");
	    	
	    	
	    }

	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			db=new Quaries(1);
			ArrayList arl_years=new ArrayList<>();
			arl_years.add("First Year");
			arl_years.add("Second Year");
			arl_years.add("Third Year");
			arl_years.add("Fourth Year");
			arl_years.add("Final Year");
			
			cbo_year.getItems().clear();
			cbo_year.getItems().addAll(arl_years);
			txt_CourseId.setText(db.getPrimaryKey("CourseId", "Course_tb", "COU-"));
			
			txt_refName.setText("Course_"+txt_CourseId.getText().substring(4,11));
			
		}
    
    
    
}
