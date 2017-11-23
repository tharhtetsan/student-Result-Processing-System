package view.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import model.ObjectReferences.Obj_db_Course;
import model.ObjectReferences.Obj_stu_profile;
import controller.DB.*;
import model.ObjectReferences.*;


public class Course_list_Controller implements Initializable{

	  @FXML
	    private TableView<Obj_db_Course_profile_tb> tb_Course;

	    @FXML
	    private TableColumn<Obj_db_Course_profile_tb,String> col_id;

	    @FXML
	    private TableColumn<Obj_db_Course_profile_tb,String> col_name;

	    @FXML
	    private TableColumn<Obj_db_Course_profile_tb,String> col_refName;

	    @FXML
	    private TableColumn<Obj_db_Course_profile_tb,String> col_trName;

	    @FXML
	    private TableColumn<Obj_db_Course_profile_tb,String> col_year;

	    @FXML
	    private TableColumn<Obj_db_Course_profile_tb,String> col_startDate;

	    @FXML
	    private TableColumn<Obj_db_Course_profile_tb,String> col_Aim;

	    @FXML
	    private JFXRadioButton rdo_first;

	    @FXML
	    private ToggleGroup rdo_group;

	    @FXML
	    private JFXRadioButton rdo_second;

	    @FXML
	    private JFXRadioButton rdo_third;

	    @FXML
	    private JFXRadioButton rdo_fourth;

	    @FXML
	    private JFXRadioButton rdo_final;
    
    
    private ObservableList<Obj_db_Course_profile_tb> items1 = FXCollections.observableArrayList();
    private Quaries db;
    
    private ArrayList<Obj_db_Course_profile> arl_CourseDATA;
    
    
    
    
    
    @FXML
    void rdo_final_Act(ActionEvent event) {
    	
    	items1.clear();
    	if(rdo_final.isSelected())
	    {
	    	for(Obj_db_Course_profile objTemp : arl_CourseDATA)
			{
	    		if(objTemp.getForYear().trim().equalsIgnoreCase("Final Year"))
	    		{
	    			Obj_db_Course_profile_tb dbObj=new Obj_db_Course_profile_tb(objTemp.getCourseId(),objTemp.getName(),objTemp.getDate(),objTemp.getAim(),objTemp.getTrName(),objTemp.getName(),objTemp.getForYear());
	    			items1.add(dbObj);
					
	    		}
			}
	    }
    }

    @FXML
    void rdo_first_Act(ActionEvent event) {
    	items1.clear();
    	if(rdo_first.isSelected())
	    {
	    	for(Obj_db_Course_profile objTemp : arl_CourseDATA)
			{
	    		if(objTemp.getForYear().trim().equalsIgnoreCase("First Year"))
	    		{
	    		
	    			Obj_db_Course_profile_tb dbObj=new Obj_db_Course_profile_tb(objTemp.getCourseId(),objTemp.getName(),objTemp.getDate(),objTemp.getAim(),objTemp.getTrName(),objTemp.getName(),objTemp.getForYear());
	    			items1.add(dbObj);
					
	    		}
			}
	    }
    }

    @FXML
    void rdo_fourth_Act(ActionEvent event) {
    	items1.clear();
    	if(rdo_fourth.isSelected())
	    {
	    	for(Obj_db_Course_profile objTemp : arl_CourseDATA)
			{
	    		if(objTemp.getForYear().trim().equalsIgnoreCase("Fourth Year"))
	    		{
	    			Obj_db_Course_profile_tb dbObj=new Obj_db_Course_profile_tb(objTemp.getCourseId(),objTemp.getName(),objTemp.getDate(),objTemp.getAim(),objTemp.getTrName(),objTemp.getName(),objTemp.getForYear());
	    			items1.add(dbObj);
					
	    		}
			}
	    }
    }

    @FXML
    void rdo_second_Act(ActionEvent event) {
    	items1.clear();
    	if(rdo_second.isSelected())
	    {
	    	for(Obj_db_Course_profile objTemp : arl_CourseDATA)
			{
	    		if(objTemp.getForYear().trim().equalsIgnoreCase("Second Year"))
	    		{
	    			Obj_db_Course_profile_tb dbObj=new Obj_db_Course_profile_tb(objTemp.getCourseId(),objTemp.getName(),objTemp.getDate(),objTemp.getAim(),objTemp.getTrName(),objTemp.getName(),objTemp.getForYear());
	    			items1.add(dbObj);
					
	    		}
			}
	    }
    }

    @FXML
    void rdo_third_Act(ActionEvent event) {
    	items1.clear();
    	if(rdo_third.isSelected())
	    {
	    	for(Obj_db_Course_profile objTemp : arl_CourseDATA)
			{
	    		if(objTemp.getForYear().trim().equalsIgnoreCase("Third Year"))
	    		{
	    			Obj_db_Course_profile_tb dbObj=new Obj_db_Course_profile_tb(objTemp.getCourseId(),objTemp.getName(),objTemp.getDate(),objTemp.getAim(),objTemp.getTrName(),objTemp.getName(),objTemp.getForYear());
	    			items1.add(dbObj);
					
	    		}
			}
	    }
    }
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Intialize_Cols();
		db=new Quaries(1);
		arl_CourseDATA=db.get_Course_Data();
		
		tb_Course.setItems(items1);
		for(Obj_db_Course_profile objTemp : arl_CourseDATA)
		{
			Obj_db_Course_profile_tb dbObj=new Obj_db_Course_profile_tb(objTemp.getCourseId(),objTemp.getName(),objTemp.getDate(),objTemp.getAim(),objTemp.getTrName(),objTemp.getName(),objTemp.getForYear());
			
			items1.add(dbObj);
			
		}
		
		
		
		
		
	}
    
    
    

	
	
	public void  Intialize_Cols()
	{
		//Course tb repare;
				col_id.setCellValueFactory(cellData -> cellData.getValue().getCourseId());
				col_name.setCellValueFactory(cellData -> cellData.getValue().getName());
				col_refName.setCellValueFactory(cellData -> cellData.getValue().getRefName());
				col_startDate.setCellValueFactory(cellData -> cellData.getValue().getDate());
				col_year.setCellValueFactory(cellData -> cellData.getValue().getForYear());
				col_trName.setCellValueFactory(cellData -> cellData.getValue().getTrName());
				col_Aim.setCellValueFactory(cellData -> cellData.getValue().getAim());
	}
	
	
	
}
