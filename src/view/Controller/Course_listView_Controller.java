package view.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import controller.DB.*;
import model.ObjectReferences.*;


public class Course_listView_Controller implements Initializable{


	
	
	
	
	@FXML
    private JFXRadioButton rdo_ViewAll;

    @FXML
    private ToggleGroup rdo_toggleGroup;

    @FXML
    private JFXRadioButton rdo_SearchID;

    @FXML
    private JFXComboBox<String> cbo_year;

    @FXML
    private JFXComboBox<String> cbo_Major;

    @FXML
    private JFXComboBox<String> cbo_courseId;

    @FXML
    private JFXButton btn_serarch;

    @FXML
    private ImageView btn_search;

    @FXML
    private Pane secondPane;

    
    
    
    
    
    private static ArrayList<Obj_db_Define_Course> arlDB_definCourse;
    private Quaries db;
    
    private static Obj_db_Course_profile selectedCourse;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		db=new Quaries(1);
		arlDB_definCourse=db.get_Define_Course_Data();
		Set<String> setYear=new HashSet();
		
		for(Obj_db_Define_Course obj : arlDB_definCourse)
			setYear.add(obj.getForyear());
		
		cbo_year.getItems().clear();
		cbo_year.getItems().addAll(setYear);
		
		
		
	}
    
    @FXML
    void btn_searchAction(ActionEvent event) {
    
		
		if(!rdo_SearchID.isSelected())
		{
			
		}else{
			
			String tempYear="";
	    	tempYear=cbo_year.getSelectionModel().getSelectedItem().trim();
			String tempMajor="";
			tempMajor=cbo_Major.getSelectionModel().getSelectedItem().trim();
			String tempId="";
			tempId=cbo_courseId.getSelectionModel().getSelectedItem().trim();
			
			if((tempYear=="" || tempYear==null)||(tempMajor=="" ||tempMajor==null)||(tempId=="" || tempId==null))
			{
				
			}
			else
			{
				SearchDATA(tempYear,tempMajor,tempId);
			}
		}
		

    }

    private void SearchDATA(String tempYear, String tempMajor, String tempId) {
    	
    	selectedCourse=db.get_Course_Data(tempId);
    	
    	String	Pane_url="/view/ui/UI_Course_profile.fxml";
    	Parent window3 = null;
    		
	try {
    			
			    window3 = (Pane)FXMLLoader.load(getClass().getResource(Pane_url));
    		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    		secondPane.getChildren().clear();
    		secondPane.getChildren().add(window3);
    		
    	
    	
	}
    

	@FXML
    void cbo_Major_Act(ActionEvent event) {
    	Set<String> setID=new HashSet();
		String tempYear=cbo_year.getSelectionModel().getSelectedItem().trim();
		String tempMajor=cbo_Major.getSelectionModel().getSelectedItem().trim();
		
		String StrTemp[] = null;
		for(Obj_db_Define_Course obj : arlDB_definCourse)
			{
				if(obj.getForyear().trim().equalsIgnoreCase(tempYear) && obj.getMajor().trim().equalsIgnoreCase(tempMajor) )
					{
						System.out.println(obj.getCourseId());
						StrTemp=obj.getCourseId().split("[',']");
					}
			}
		for(int a=0;a<StrTemp.length;a++)
			setID.add(StrTemp[a]);
		
		cbo_courseId.getItems().clear();
		cbo_courseId.getItems().addAll(setID);
    }

    
    
    @FXML
    void cbo_year_Act(ActionEvent event) {
    	Set<String> setMajor=new HashSet();
		String tempYear=cbo_year.getSelectionModel().getSelectedItem().trim();
		for(Obj_db_Define_Course obj : arlDB_definCourse)
			{
				if(obj.getForyear().trim().equalsIgnoreCase(tempYear))
					setMajor.add(obj.getMajor());
			}
		
		cbo_Major.getItems().clear();
		cbo_courseId.getItems().clear();
		cbo_Major.getItems().addAll(setMajor);
    }

    
    
    @FXML
    void rdo_SearchIDAction(ActionEvent event) {

    }

    @FXML
    void rdo_ViewAllAction(ActionEvent event) {
    	
    	
    	
    	String	Pane_url="/view/ui/UI_Course_list.fxml";
    	Parent window3 = null;
    		
	try {
    			
			    window3 = (Pane)FXMLLoader.load(getClass().getResource(Pane_url));
    		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    		secondPane.getChildren().clear();
    		secondPane.getChildren().add(window3);
    		
    	
    	

    }

	public static Obj_db_Course_profile getSelectedCourse() {
		return selectedCourse;
	}

	public static void setSelectedCourse(Obj_db_Course_profile selectedCourse) {
		Course_listView_Controller.selectedCourse = selectedCourse;
	}

    
    
	
	
	
	
	
	
	
	
    

    
}
