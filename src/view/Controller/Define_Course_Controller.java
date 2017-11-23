package view.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Set;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.ObjectReferences.*;
import controller.DB.*;

public class Define_Course_Controller implements Initializable{

	 @FXML
	    private JFXComboBox<String> cbo_year;

	    @FXML
	    private Button btn_search;

	    @FXML
	    private Pane secondPane;

	    @FXML
	    private Text txt_ContainSub;
	    
	    @FXML
	    private Label txt_id;

	    @FXML
	    private JFXRadioButton rdo_first;

	    @FXML
	    private ToggleGroup rdo_term;

	    @FXML
	    private JFXRadioButton rdo_Second;

	    @FXML
	    private FlowPane btn_fpane;

	    @FXML
	    private Button btn_Save;

	    @FXML
	    private Button btn_Clear;
	    
	    @FXML
	    private JFXComboBox<String> cbo_major;

	    @FXML
	    private JFXComboBox<String> cbo_acYear;
	    
	    
	   private ArrayList<Obj_db_Course_profile> arlCourse=null;
	   private Quaries db;
	   private Set<String> arl_Year;
	   private Set<String> arl_courseId;
	   private String term="";
	   private String SearchYear="";
	   private String acYear="";
	   private String major="";
	   
	   
	   
	   private Set<String> arl_ACyear;
	   
	    @FXML
	    void btn_Clear_Act(ActionEvent event) {
	    	
	    	cbo_year.setValue("");
	    	btn_fpane.getChildren().clear();
	    	txt_ContainSub.setText("");
	    	rdo_first.setSelected(false);
	    	rdo_Second.setSelected(false);
	    
	    	cbo_major.getItems().clear();
	    	

	    }

	    @FXML
	    void cbo_acYear_Act(ActionEvent event) {
	    		acYear=cbo_acYear.getSelectionModel().getSelectedItem().toString();
	    }

	    @FXML
	    void cbo_major_Act(ActionEvent event) {
	    	major=cbo_major.getSelectionModel().getSelectedItem().toString();
	    }
	    
	    @FXML
	    void btn_Save_Save(ActionEvent event) {
	    	
	    	if(arl_courseId.size()==0 || arl_courseId.size()!=6)
	    	{
	    		
	    	}
	    	else if(term=="")
	    	{
	    		
	    	}else if(major=="")
	    	{
	    		
	    	}else if(acYear=="")
	    	{
	    		
	    	}else
	    	{
	    		String str_CourseId="";
				for(String str : arl_courseId)
				{
					str_CourseId+=(str)+",";
				}
				
				Obj_db_Define_Course obj=new Obj_db_Define_Course();
				obj.setId(txt_id.getText().toString());
				obj.setCourseId(str_CourseId);
				obj.setForyear(SearchYear);
				obj.setTerm(term);
				obj.setMajor(major);
				obj.setAcedimic_year(acYear);
				obj.setIsMarkFill("No");
				
				/*
				 * clear previous data
				 */
				db.DefineNewCourse(obj);
				txt_id.setText(db.getPrimaryKey("AcedimicId","AcedimicCoures_tb", "ACE-"));
				cbo_year.setValue("");
				btn_fpane.getChildren().clear();
				txt_ContainSub.setText("");
				
				cbo_major.setValue("Choose Major");
				cbo_acYear.setValue("");
				rdo_first.setSelected(false);
				rdo_Second.setSelected(false);
				major="";
				term="";
				acYear="";
				
	    	}
	    		
	    }

	    @FXML
	    void btn_search_Act(ActionEvent event) {

	    	 SearchYear=cbo_year.getSelectionModel().getSelectedItem();
	    	txt_ContainSub.setText("");
	    	btn_fpane.getChildren().clear();
	    	arl_courseId.clear();
	    	
	    	for(int i=0;i<arlCourse.size();i++)
	    	{
	    		if(arlCourse.get(i).getForYear().equalsIgnoreCase(SearchYear))
	    		{
	    			Button btn=new Button(arlCourse.get(i).getName());
	    			btn.setAccessibleText(arlCourse.get(i).getCourseId());
	    			btn_fpane.getChildren().add(btn);
	    			
	    			btn.setOnAction(e->{
	    				String temp=btn.getAccessibleText()+","+txt_ContainSub.getText();
	    				
	    					arl_courseId.clear();
		    				String arl_temp[]=temp.split("[',']");
		    				for(int a=0;a<arl_temp.length;a++)
		    				{
		    					arl_courseId.add(arl_temp[a]);
		    					
		    				}
		    				String str_CourseId="";
		    				for(String str : arl_courseId)
		    				{
		    					str_CourseId+=(str)+",";
		    				}
		    				
		    				txt_ContainSub.setText(str_CourseId);
		    				
	    				
	    			});
	    		}
	    	}
	    	
	    	
	    	
	    	/*
	    	 * add marjor
	    	 */
	    	Set<String> arlMajor=new HashSet<>();
	    	if(SearchYear.equalsIgnoreCase("First Year"))
	    	{
	    		arlMajor.add("CST");
	    	}else if(SearchYear.equalsIgnoreCase("Second Year"))
	    	{
	    		arlMajor.add("2CS");
	    		arlMajor.add("2CT");
	    	}else if(SearchYear.equalsIgnoreCase("Third Year"))
	    	{
	    		arlMajor.add("3CT");
	    		arlMajor.add("3CS");
	    	}else if(SearchYear.equalsIgnoreCase("Fourth Year"))
	    	{
	    		arlMajor.add("4CT(NWK)");
	    		arlMajor.add("4CT(ESY)");
	    		arlMajor.add("4CS(KE)");
	    		arlMajor.add("4CS(SE)");
	    		arlMajor.add("4CS(HPC)");
	    		arlMajor.add("4CS(BIS)");
	    		
	    	}else{
	    		arlMajor.add("5CT(NWK)");
	    		arlMajor.add("5CT(ESY)");
	    		arlMajor.add("5CS(KE)");
	    		arlMajor.add("5CS(SE)");
	    		arlMajor.add("5CS(HPC)");
	    		arlMajor.add("5CS(BIS)");
	    	}
	    	
	    	
	    	cbo_major.setValue("Choose Major");
	    	cbo_major.getItems().clear();
	    	cbo_major.getItems().addAll(arlMajor);
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			db=new Quaries(1);
			arlCourse=db.get_Course_Data();
			arl_Year=new HashSet<>();
			arl_courseId=new HashSet<String>();
			
			for(int i=0;i<arlCourse.size();i++)
			{
				arl_Year.add(arlCourse.get(i).getForYear());
			}
			cbo_year.getItems().addAll(arl_Year);
			txt_id.setText(db.getPrimaryKey("AcedimicId","AcedimicCoures_tb", "ACE-"));
		
			arl_ACyear=new HashSet<String>();
			arl_ACyear.add("2012-2013");
			arl_ACyear.add("2013-2014");
			arl_ACyear.add("2014-2015");
			arl_ACyear.add("2015-2016");
			arl_ACyear.add("2016-2017");
			arl_ACyear.add("2017-2018");
			arl_ACyear.add("2018-2019");
			arl_ACyear.add("2019-2020");
			cbo_acYear.getItems().clear();
			cbo_acYear.getItems().addAll(arl_ACyear);
			
			
			
		}
		

	    @FXML
	    void rdo_Second_Act(ActionEvent event) {
	    	term="First Term";
	    }

	    @FXML
	    void rdo_first_Act(ActionEvent event) {
	    	term="Second Term";
	    	
	    }
}
