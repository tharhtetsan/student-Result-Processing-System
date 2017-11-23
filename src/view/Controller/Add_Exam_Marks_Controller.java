package view.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import controller.DB.*;
import model.ObjectReferences.*;
import controller.fileReadWrite.*;

public class Add_Exam_Marks_Controller implements Initializable{

	   @FXML
	    private JFXComboBox<String> cbo_year;

	    @FXML
	    private JFXComboBox<String> cbo_major;


	    @FXML
	    private TextField txt_filePath;

	    @FXML
	    private Button btn_fileChoose;

	    @FXML
	    private Pane secondPane;

	    @FXML
	    private TableView<Obj_AddMark> tb_sub;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_roll;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_name;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_sub1;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_sub2;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_sub3;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_sub4;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_sub5;

	    @FXML
	    private TableColumn<Obj_AddMark, String> col_sub6;

	    @FXML
	    private JFXComboBox<String> cbo_AceYear;

	    @FXML
	    private JFXComboBox<String> cbo_term;

	    @FXML
	    private Button btn_clear;

	    @FXML
	    private Button btn_Save;

	    
	   private  Quaries db;
	   private ArrayList<Obj_db_Define_Course> arl_data;
	   private String SearchYear="";
	   private String Major="";
	   private String acYear="";
	   private String term="";
	   private Obj_db_Define_Course selected_Obj;
			
	   
	   private FileChooser fileChooser;
	   private ExcelReadWrite ExcelreadWrite;
	   private ArrayList excelData;
	   
	   private String strTemp="";
	   private String ColNames[];
	   private ArrayList<Obj_db_Course_profile> Courses_db;
	   private  Obj_db_Define_Course CouseSelectedTerm;
		
	   
	   
	   
	   private ObservableList<Obj_AddMark> items1 = FXCollections.observableArrayList();
	   
	   
		private ArrayList<ExcelData_row_col> arl_excelData;
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			fileChooser=new FileChooser();
			db=new Quaries(1);
			arl_data=db.get_Define_Course_Data();
			Set<String> setYear=new HashSet<>();
			for(int i=0;i<arl_data.size();i++)
			{
				setYear.add(arl_data.get(i).getForyear());
			}
			cbo_year.getItems().addAll(setYear);
			Intialize_Cols();
			tb_sub.setItems(items1);
			
		}
	    
		



	    @FXML
	    void cbo_year_Act(ActionEvent event) {
			SearchYear=cbo_year.getSelectionModel().getSelectedItem().toString().trim();
			Set<String> setMajor=new HashSet<>();
    	 	cbo_term.getItems().clear();
	    	for(Obj_db_Define_Course obj: arl_data)
	    	{
	    		if(obj.getForyear().trim().equalsIgnoreCase(SearchYear))
	    		{
	    			setMajor.add(obj.getMajor());
	    		}
	    	}
	    	cbo_major.getItems().clear();
	    	cbo_major.getItems().addAll(setMajor);
	    }

	    @FXML
	    void cbo_major_Act(ActionEvent event) {
	    	if(cbo_major.getSelectionModel().getSelectedItem()!=null)
	    	{
	    		Major=cbo_major.getSelectionModel().getSelectedItem().toString().trim();
	    			Set<String> setAcYear=new HashSet<>();
	    			cbo_AceYear.getItems().clear();
			    	for(Obj_db_Define_Course obj: arl_data)
			    	{
			    		if(obj.getMajor().trim().equalsIgnoreCase(Major) && obj.getForyear().trim().equalsIgnoreCase(SearchYear))
			    		{
			    			setAcYear.add(obj.getAcedimic_year());
			    		}
			    	}
			    	cbo_AceYear.getItems().clear();
			    	cbo_AceYear.getItems().addAll(setAcYear);
	    	}
	    }
	    
	    		@FXML
	    		void cbo_AceYear_Act(ActionEvent event) {
	    	 	acYear=cbo_AceYear.getSelectionModel().getSelectedItem().toString().trim();
	    	 	Set<String> setTerm=new HashSet<>();
	    	 	cbo_term.getItems().clear();
		    	for(Obj_db_Define_Course obj: arl_data)
		    	{
		    		if(obj.getMajor().trim().equalsIgnoreCase(Major) && obj.getForyear().trim().equalsIgnoreCase(SearchYear) && obj.getAcedimic_year().trim().equalsIgnoreCase(acYear))
		    		{
		    			setTerm.add(obj.getTerm());
		    		}
		    	}
		    	cbo_term.getItems().addAll(setTerm);
	    	 	
	    	 	
	    }

	 
	    
	    
		@FXML
	    void btn_Save_Act(ActionEvent event) {
			/*
			 * merge courseid and course refName
			 */
			HashMap<String,String> hashMap=new HashMap<>();
    		for(Obj_db_Course_profile obj:Courses_db)	    		
    			hashMap.put(obj.getCourseId(), obj.getRefName());
    		
    		
    	
    		
    		/*
    		 * get student data by current Acedimic courseId;
    		 */
    		HashMap<String,String> arlStudent_Names=db.get_Student_IdAndName_all();
    	
    		if(selected_Obj.getIsMarkFill().equalsIgnoreCase("Yes"))
    		{
    			/*
    			 * 
    			 * 
    			 * 
    			 */
    		}
    		else
    		{
    			if(items1.size()>1)
    			for(Obj_AddMark objMark: items1)
    			{
    				String stuName=objMark.getName_s();
    				ArrayList<String> arlTempMark=new ArrayList<>();
    				arlTempMark.add(objMark.getSub1_s());
    				arlTempMark.add(objMark.getSub2_s());
    				arlTempMark.add(objMark.getSub3_s());
    				arlTempMark.add(objMark.getSub4_s());
    				arlTempMark.add(objMark.getSub5_s());
    				arlTempMark.add(objMark.getSub6_s());
    				
    				for(int i=0;i<ColNames.length;i++)
    				{
    					Obj_db_Course objSubMark=new Obj_db_Course();
    			
        				String PrimaryKey=db.getPrimaryKey("id", hashMap.get(ColNames[i]), "IDC-");
        				objSubMark.setId(PrimaryKey);
        				objSubMark.setStuid(arlStudent_Names.get(stuName.trim()));
        				
        				objSubMark.setfMark(arlTempMark.get(i));
        				objSubMark.setfGrade(DefineGrade(arlTempMark.get(i)));
        				objSubMark.setAceId(selected_Obj.getId());
        				
        				System.out.println(objSubMark.getStuid()+"\t"+hashMap.get(ColNames[i].trim()));
        				db.set_Exam_Mark(objSubMark, hashMap.get(ColNames[i].trim()));
        				
        				Alert ttt = new Alert(AlertType.INFORMATION);
    					ttt.setContentText("Record Save Successfully!");
    					ttt.show();
        				
        			
    				}
    			}
    			items1.clear();
    		}
    			
		
	    }

	    private String IsPass(String string) {
			
			return null;
		}





		private String DefineGrade(String markStr) {
			
	    	String returnStr="";
	    	int mark=Integer.parseInt(markStr);
	    	try{
	    		if(mark>80)
	    			returnStr="A";
	    		else if(mark>60)
	    			returnStr="B";
	    		else if(mark>40)
	    			returnStr="C";
	    		else if(mark>20)
	    			returnStr="D";
	    		else 
	    			returnStr="E";
	    			
	    		
	    		
	    	}catch(Exception e)
	    	{
	    		/*
	    		 * 
	    		 */
	    	}
	    	
			return returnStr;
		}





		@FXML
	    void btn_Search_Act(ActionEvent event) {
			
			term=cbo_term.getSelectionModel().getSelectedItem().toString().trim();
		    
			ArrayList<Obj_db_Define_Course> arlDefine_Couse=db.get_Define_Course_Data(SearchYear,Major, acYear, "No");
			if(term.equalsIgnoreCase("First Term"))
			{
				CouseSelectedTerm=arlDefine_Couse.get(0);
				
				
			}else
			{
				CouseSelectedTerm=arlDefine_Couse.get(1);
			}
			
				selected_Obj=CouseSelectedTerm;
	    	 strTemp=selected_Obj.getCourseId();
	    	 ColNames=strTemp.split("[',']");
	    	
	    	
	    	/*
	    	 * add col Names;
	    	 */
	    	if(ColNames.length==6)
	    	{
	    		Courses_db=db.get_Course_Data();
	    		HashMap<String,String> hashMap=new HashMap<>();
	    		for(Obj_db_Course_profile obj:Courses_db)	    		
	    			hashMap.put(obj.getCourseId(), obj.getName());
	    			
	    		col_sub1.setText(hashMap.get(ColNames[0]));
	    		col_sub2.setText(hashMap.get(ColNames[1]));
	    		col_sub3.setText(hashMap.get(ColNames[2]));
	    		col_sub4.setText(hashMap.get(ColNames[3]));
	    		col_sub5.setText(hashMap.get(ColNames[4]));
	    		col_sub6.setText(hashMap.get(ColNames[5]));
	    		tb_sub.refresh();
	    	}
	    	
	    	

			
	    	
			
			
	    	
	    }

	    @FXML
	    void btn_clear_Act(ActionEvent event) {
	    	items1.clear();
	    	ExcelreadWrite=null;
	    	
	    }

	    @FXML
	    void btn_fileChoose_Act(ActionEvent event) {
	    	fileChooser.setTitle("Open Excel File");
			fileChooser.getExtensionFilters().clear();
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Excel  File", "*.xlsx","*.xls"));
			File file = fileChooser.showOpenDialog(new Stage());
			if (file != null)
			{	
				try {
					txt_filePath.setText(file.getCanonicalPath()+"");
					ExcelreadWrite=new ExcelReadWrite(file.getAbsolutePath());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 
				arl_excelData=ExcelreadWrite.ReadExcel_by_Col_index(8);
				System.out.println(arl_excelData.size());
				SetData_toTalbes(arl_excelData);
			}
			else
			{
				System.out.println("Error  in file choosing");
			}
	    }





		private void SetData_toTalbes(ArrayList<ExcelData_row_col> arl_excelData) {
			
			excelData=new ArrayList<>();
			
			for(ExcelData_row_col tempObj : arl_excelData)
			{
					ArrayList<ExcelData>  Obj=tempObj.getExcel_data();
					
					Obj_AddMark mark=new Obj_AddMark();
					mark.setRoll_s(Obj.get(0).getValue());
					mark.setName_s(Obj.get(1).getValue());
					mark.setSub1_s(Obj.get(2).getValue());
					mark.setSub2_s(Obj.get(3).getValue());
					mark.setSub3_s(Obj.get(4).getValue());
					mark.setSub4_s(Obj.get(5).getValue());
					mark.setSub5_s(Obj.get(6).getValue());
					mark.setSub6_s(Obj.get(7).getValue());
					
					
					SetData_to_Table1(mark);
					
			}
		}





		private void SetData_to_Table1(Obj_AddMark mark) {
			
			items1.add(mark);
		}
	    
		public void  Intialize_Cols()
		{
			col_roll.setCellValueFactory(cellData -> cellData.getValue().getRoll());
			col_name.setCellValueFactory(cellData -> cellData.getValue().getName());
			col_sub1.setCellValueFactory(cellData -> cellData.getValue().getSub1());
			col_sub2.setCellValueFactory(cellData -> cellData.getValue().getSub2());
			col_sub3.setCellValueFactory(cellData -> cellData.getValue().getSub3());
			col_sub4.setCellValueFactory(cellData -> cellData.getValue().getSub4());
			col_sub5.setCellValueFactory(cellData -> cellData.getValue().getSub5());
			col_sub6.setCellValueFactory(cellData -> cellData.getValue().getSub6());
			
		}
		
	    
	   

	
}
