package view.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import controller.DB.*;
import model.ObjectReferences.*;

public class Student_listView_Controller  implements Initializable{
	

	  @FXML
	    private JFXRadioButton rdo_ViewAll;

	    @FXML
	    private ToggleGroup rdo_toggleGroup;

	    @FXML
	    private JFXRadioButton rdo_SearchNRC;

	    @FXML
	    private JFXComboBox<String> cbo_year;

	    @FXML
	    private JFXButton btn_serarch;

	    @FXML
	    private ImageView btn_search;

	    @FXML
	    private Pane secondPane;
	    
	    @FXML
	    private JFXComboBox<String> cbo_nrc;
    
    final static int ViewAll=1;
    final static int SearchNRC=3;
    
    
   private static  String strNrc="";
   private static  String strYear="";
   private static Obj_stu_profile_all SelectdObj;
    Quaries db;
    ArrayList<Obj_stu_profile_all> arl_DATA;
   
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	db=new Quaries(1);
    	arl_DATA=new ArrayList<>();
    	arl_DATA=db.get_ALL_Student_DATA();
    	
    	Set<String> arlYear=new HashSet<>();
    	for(Obj_stu_profile_all obj : arl_DATA )
    	{
    		arlYear.add(obj.getStu().getYear_s());
    	}
    	cbo_year.getItems().clear();
    	cbo_year.setValue("Choose Year");
    	cbo_year.getItems().addAll(arlYear);
    	
    	
    	
    }
    
    
    
    @FXML
    void btn_searchAction(ActionEvent event) {
    	 if(!rdo_SearchNRC.isSelected())
     	{
     
     	}
    	 else if(strYear.equalsIgnoreCase(""))
    	{
    		/*
    		 * 
    		 */
    	}
    	else if(strNrc.equalsIgnoreCase(""))
    	{
    		/*
    		 * 
    		 */
    	}
    	else
    	{
    		
    		/*
    		 * set selected obj to other controller
    		 */
    		for(Obj_stu_profile_all obj  : arl_DATA)
    		{
    			if(obj.getStu().getNrc_s().equalsIgnoreCase(strNrc.trim()))
    			{
    				SelectdObj=obj;
    			}
    		}
    		
    		
    		String	Pane_url="/view/ui/UI_Student_profile.fxml";
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
    	
    }

    
    @FXML
    void cbo_nrc_Act(ActionEvent event) {
		strYear=(cbo_year.getSelectionModel().getSelectedItem().toString().trim());
		strNrc=(cbo_nrc.getSelectionModel().getSelectedItem().toString().trim());

    }
    

    @FXML
    void cbo_year_Act(ActionEvent event) {
    	String selectedYear=cbo_year.getSelectionModel().getSelectedItem().toString().trim();
    	
    	ArrayList<String> arlNrc=new ArrayList<>();
    	/*
    	 * add nrc
    	 */
    	for(Obj_stu_profile_all obj : arl_DATA)
    	{
    		if(selectedYear.equalsIgnoreCase(obj.getStu().getYear_s().trim()))
    		{
    			arlNrc.add(obj.getStu().getNrc_s().trim());
    		}
    	}
    	cbo_nrc.getItems().clear();
    	
    	cbo_nrc.getItems().addAll(arlNrc);
    	
    }
    
    @FXML
    void rdo_SearchNRC_Act(ActionEvent event) {
    	if(rdo_SearchNRC.isSelected())
    	{
    		
		    		
    	}
    }

    @FXML
    void rdo_ViewAllAction(ActionEvent event) {
    	if(rdo_ViewAll.isSelected())
    	{
    		String Pane_url="/view/ui/UI_Student_list.fxml";
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
    }


  


	
  
   

    
    @FXML
    void txt_idAction(ActionEvent event) {

    }



	public static String getStrNrc() {
		return strNrc;
	}



	public static void setStrNrc(String strNrc) {
		Student_listView_Controller.strNrc = strNrc;
	}



	public static String getStrYear() {
		return strYear;
	}



	public static void setStrYear(String strYear) {
		Student_listView_Controller.strYear = strYear;
	}



	public static Obj_stu_profile_all getSelectdObj() {
		return SelectdObj;
	}



	public static void setSelectdObj(Obj_stu_profile_all selectdObj) {
		SelectdObj = selectdObj;
	}



    
    
	
  
    
    
	
	
	
}
