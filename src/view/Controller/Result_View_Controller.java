package view.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;

import controller.DB.Quaries;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import model.ObjectReferences.*;
public class Result_View_Controller implements Initializable{

	 @FXML
	    private JFXRadioButton rdo_1;

	    @FXML
	    private ToggleGroup rdo_toggleGroup;

	    @FXML
	    private JFXRadioButton rdo_2;

	    @FXML
	    private JFXRadioButton rdo_3;

	    @FXML
	    private JFXRadioButton rdo_4;

	    @FXML
	    private JFXRadioButton rdo_5;

	    @FXML
	    private JFXComboBox<String> cbo_year;

	    @FXML
	    private JFXComboBox<String> cbo_major;

	    @FXML
	    private Button btn_Search;

	    @FXML
	    private TableView<Obj_Result_View_tb> tb_view;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_id;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_name;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_1;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_2;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_3;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_4;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_5;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_6;

	    @FXML
	    private TableColumn<Obj_Result_View_tb,String> col_isPass;

	    @FXML
	    private Text txt_1;

	    @FXML
	    private Text txt_2;

	    @FXML
	    private Text txt_3;

	    @FXML
	    private Text txt_4;

	    @FXML
	    private Text txt_5;

	    @FXML
	    private Text txt_6;

	   
	    String Selectedyear="";
	    String Major;
	    String AcYear;
	    private ObservableList<Obj_Result_View_tb> items = FXCollections.observableArrayList();
	    
	    
	    ArrayList<Obj_db_Define_Course> ACE_arlCouses;
	    private Quaries db;
	    private ArrayList<Obj_db_Define_Course> objData;
	    ArrayList<Obj_db_Course_profile> COU_arlCourses;
	    
	    
	    ArrayList<String> selected_Sub1;
	    ArrayList<String> selected_Sub2;
	    
	  
	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			db=new Quaries(1);
			Intialize_Cols();
			tb_view.setItems(items);
			ACE_arlCouses=db.get_Define_Course_Data();
			COU_arlCourses=db.get_Course_Data();
			
			Set<String >arl_ACyear=new HashSet<String>();
			arl_ACyear.add("2012-2013");
			arl_ACyear.add("2013-2014");
			arl_ACyear.add("2014-2015");
			arl_ACyear.add("2015-2016");
			arl_ACyear.add("2016-2017");
			arl_ACyear.add("2017-2018");
			arl_ACyear.add("2018-2019");
			arl_ACyear.add("2019-2020");
			
			cbo_year.getItems().addAll(arl_ACyear);
		
		}
		
		
	    @FXML
	    void btn_Search_Act(ActionEvent event) {
				/*
				 * clear previous items
				 * 
				 */
	    	items.clear();
			
	    	
	    
	    	System.out.println(Selectedyear+"\t"+Major+"\t"+AcYear);
	    	ArrayList<Obj_db_Define_Course> arlDefine_Couse=db.get_Define_Course_Data(Selectedyear.trim(),Major.trim(), AcYear.trim(), "No");
	    	  System.out.println(arlDefine_Couse.size()+"<<<?");
	    	if(arlDefine_Couse.size()!=2)
	    	{
	    		return;
	    	}
	    	
	    	Obj_db_Define_Course obj1=arlDefine_Couse.get(0);
	    	Obj_db_Define_Course obj2=arlDefine_Couse.get(1);
	    	
	    	selected_Sub1=new ArrayList();
	    	selected_Sub2=new ArrayList();
	    	
	    	
	    	String cou1[]=obj1.getCourseId().split("[',']");
	    	String cou2[]=obj2.getCourseId().split("[',']");
	    	
	    	for(int a=0;a<cou1.length;a++)
	    	{
	    		selected_Sub1.add(cou1[a].trim());
	    		selected_Sub2.add(cou2[a].trim());
	    		
	    	}
	    	
	    	
	    	/*
	    	 * search refName by course Id;
	    	 */
	    	
	    	
	    	ArrayList<String> arl_refCou1=new ArrayList<>();
	    	ArrayList<String> arl_refCou2=new ArrayList<>();
	    	ArrayList<String> arl_nameCou1=new ArrayList<>();
	    	ArrayList<String> arl_nameCou2=new ArrayList<>();
	    	
	    	for(int a=0;a<selected_Sub1.size();a++)
		    {
	    		String couName1="";
	    		String couName2="";
	    		
	    		String refName1="";
	    		String refName2="";
	    		
	    		String couFindKey1=selected_Sub1.get(a);
	    		String couFindKey2=selected_Sub2.get(a);
	    		
		    	for(Obj_db_Course_profile obj : COU_arlCourses)
		    	{
		    		
		    		if(couFindKey1.equalsIgnoreCase(obj.getCourseId().trim()))
		    		{
		    			couName1=obj.getName();
		    			refName1=obj.getRefName();
		    			System.out.println(">>1"+obj.getCourseId()); 
		    			arl_refCou1.add(refName1);
		    			arl_nameCou1.add(couName1);
		    		}
		    		if(couFindKey2.equalsIgnoreCase(obj.getCourseId().trim()))
		    		{
		    			couName2=obj.getName();
		    			refName2=obj.getRefName();
		    			System.out.println(">>2"+obj.getCourseId()); 
		    			
		    			arl_refCou2.add(refName2);
			    		arl_nameCou2.add(couName2);
		    		}	
		    	
		    		
		    	}
		    	
		    }
	    	
	    	//System.out.println(arl_refCou1);
	    	//System.out.println(arl_refCou2);
	    	//System.exit(1);
	    	SetDataToTable(arl_refCou1,arl_refCou2,arl_nameCou1,arl_nameCou2,obj1,obj2);
	    	
	    	
	   }

	    
	    
	  
    	
	  
	    
	    

		private void SetDataToTable(ArrayList<String> arl_refCou1, ArrayList<String> arl_refCou2,
				ArrayList<String> arl_nameCou1, ArrayList<String> arl_nameCou2,Obj_db_Define_Course obj1,Obj_db_Define_Course obj2) {
			
			
		
			
						
						for(int a=0;a<arl_nameCou1.size();a++)
						{
							if(a==0)
								txt_1.setText(arl_nameCou1.get(a)+", "+arl_nameCou2.get(a));
							else if(a==1)
								txt_2.setText(arl_nameCou1.get(a)+", "+arl_nameCou2.get(a));
							else if(a==2)
								txt_3.setText(arl_nameCou1.get(a)+", "+arl_nameCou2.get(a));
							else if(a==3)
								txt_4.setText(arl_nameCou1.get(a)+", "+arl_nameCou2.get(a));
							else if(a==4)
								txt_5.setText(arl_nameCou1.get(a)+", "+arl_nameCou2.get(a));
							else if(a==5)
								txt_6.setText(arl_nameCou1.get(a)+", "+arl_nameCou2.get(a));
						
							System.out.println(arl_nameCou1.get(a)+", "+arl_nameCou2.get(a));
						}
						
						
					
					
						/*
						 * 
						 * add data to table
						 */
						ArrayList<String>objStuIds=db.get_Student_ID_ALL(Selectedyear, Major);
						HashMap<String,String> objStuIDandName=db.get_Student_obj_by_year_and_major1(Selectedyear,Major);
					
						
					
					HashMap<String,Obj_Result_View_tb> arl_objDB1 = new HashMap();
					HashMap<String,Obj_Result_View_tb> arl_objDB2 = new HashMap();
					
					
					for(int a=0;a<objStuIDandName.size();a++)
					{
						System.out.println(arl_refCou1+"\t"+obj1.getId()+"\t"+objStuIds.get(a).trim());
						System.out.println();
						Obj_Result_View_tb temp1=db.getExam_Mark(arl_refCou1,obj1.getId(),objStuIds.get(a).trim());
						Obj_Result_View_tb temp2=db.getExam_Mark(arl_refCou2,obj1.getId(),objStuIds.get(a).trim());
						
						if(temp1!=null && temp2!=null)
						{
						arl_objDB1.put(objStuIds.get(a).trim(),temp1);
						arl_objDB2.put(objStuIds.get(a).trim(),temp2);
						}else
						{
							System.out.println(a+"<<<"+arl_refCou1+"\t"+obj1.getId()+"\t"+objStuIds.get(a).trim());
							System.out.println(a+"<<<"+arl_refCou1+"\t"+obj2.getId()+"\t"+objStuIds.get(a).trim());
							
						}
					}
					
					
					
		
					System.out.println(objStuIDandName+"<<<<????");
					System.out.println(arl_objDB1.size()+"++++"+arl_objDB2.size());
					
					//System.exit(1);
					for(int a=0;a<objStuIds.size();a++)
					{
						Obj_Result_View_tb tbObj1=arl_objDB1.get(objStuIds.get(a).trim());
						Obj_Result_View_tb tbObj2=arl_objDB2.get(objStuIds.get(a).trim());
						
						System.out.println(a+"_______"+(tbObj1==null));
						Obj_Result_View_tb ADD_tb=isPassObj(tbObj1,tbObj2);
						ADD_tb.setStuid(new SimpleStringProperty(tbObj1.getStuid().get()));
						ADD_tb.setName(new SimpleStringProperty(objStuIDandName.get(tbObj1.getStuid().get().trim())));
						
						
						items.add(ADD_tb);
					}
			
		}

		
		
		
		

		private Obj_Result_View_tb isPassObj(Obj_Result_View_tb tbObj1, Obj_Result_View_tb tbObj2) {
			
			int sub1=Integer.parseInt(tbObj1.getSub1_1().get().trim())+Integer.parseInt(tbObj2.getSub1_1().get().trim());
			int sub2=Integer.parseInt(tbObj1.getSub1_2().get().trim())+Integer.parseInt(tbObj2.getSub1_2().get().trim());
			int sub3=Integer.parseInt(tbObj1.getSub1_3().get().trim())+Integer.parseInt(tbObj2.getSub1_3().get().trim());
			int sub4=Integer.parseInt(tbObj1.getSub1_4().get().trim())+Integer.parseInt(tbObj2.getSub1_4().get().trim());
			int sub5=Integer.parseInt(tbObj1.getSub1_5().get().trim())+Integer.parseInt(tbObj2.getSub1_5().get().trim());
			int sub6=Integer.parseInt(tbObj1.getSub1_6().get().trim())+Integer.parseInt(tbObj2.getSub1_6().get().trim());
			String isPass="";
			
			if((sub1< 50) || (sub2/2 <50) || (sub3/2 <50) || (sub4/2<50) || (sub5/2<50) || (sub6/2<50) )
			{
				
				isPass= "Fail";
			}
			else
			{

				isPass= "Pass";
			}
			
			System.out.println(sub1+"\t"+sub2+"\t"+sub3+"\t"+sub4+"\t"+sub5+"\t"+sub6+"\t");
			Obj_Result_View_tb ADD_tb=new Obj_Result_View_tb("-",
					"-",
					sub1/2+"",
					sub2/2+"",
					sub3/2+"",
					sub4/2+"",
					sub5/2+"",
					sub6/2+"",
					isPass);
			
			
			return ADD_tb;
					
	}


		@FXML
	    void rdo_1_Act(ActionEvent event) {
	    	Selectedyear="First year";
	    	cbo_major.getItems().clear();
	    	cbo_major.getItems().add("CST");
	    }

	    @FXML
	    void rdo_2_Act(ActionEvent event) {
	    	Selectedyear="Second year";
	    	ArrayList<String> arl=new ArrayList<>();
	    	arl.add("2CS");
    		arl.add("2CT");
    		
    		cbo_major.getItems().clear();
    		cbo_major.getItems().addAll(arl);
	    }

	    @FXML
	    void rdo_3_Act(ActionEvent event) {
	    	Selectedyear="Third year";
	    	ArrayList<String> arl=new ArrayList<>();
	    	arl.add("3CS");
    		arl.add("3CT");
    		
    		cbo_major.getItems().clear();
    		cbo_major.getItems().addAll(arl);
	    }

	    @FXML
	    void rdo_4_Act(ActionEvent event) {
	    	Selectedyear="Fourth year";
	    	ArrayList<String> arl=new ArrayList<>();
	    	arl.add("4NE");
    		arl.add("4EMS");
    		arl.add("4KE");
    		arl.add("4SE");
    		arl.add("4HPC");
    		arl.add("4BIS");
    		
    		cbo_major.getItems().clear();
    		cbo_major.getItems().addAll(arl);
	    }

	    @FXML
	    void rdo_5_Act(ActionEvent event) {
	    	Selectedyear="Final year";
	    	ArrayList<String> arl=new ArrayList<>();
	    	arl.add("5NE");
    		arl.add("5EMS");
    		arl.add("5KE");
    		arl.add("5SE");
    		arl.add("5HPC");
    		arl.add("5BIS");
    		
    		cbo_major.getItems().clear();
    		cbo_major.getItems().addAll(arl);
	    }
	    
	    

	    @FXML
	    void cbo_major_Act(ActionEvent event) {
	    	Major=cbo_major.getSelectionModel().getSelectedItem().trim();
	    	
	    	
	    }
	    
	    
	    @FXML
	    void cbo_year_Act(ActionEvent event) {
	    	AcYear=cbo_year.getSelectionModel().getSelectedItem().trim();
	    }
	    
	    
	    
	    
	  
		
	    public void Settb_data(Obj_Result_View_tb obj)
		{
			items.add(obj);
		}
		
		public void  Intialize_Cols()
		{
			col_id.setCellValueFactory(cellData -> cellData.getValue().getStuid());
			col_name.setCellValueFactory(cellData -> cellData.getValue().getName());
			col_1.setCellValueFactory(cellData -> cellData.getValue().getSub1_1());
			col_2.setCellValueFactory(cellData -> cellData.getValue().getSub1_2());
			col_3.setCellValueFactory(cellData -> cellData.getValue().getSub1_3());
			col_4.setCellValueFactory(cellData -> cellData.getValue().getSub1_4());
			col_5.setCellValueFactory(cellData -> cellData.getValue().getSub1_5());
			col_6.setCellValueFactory(cellData -> cellData.getValue().getSub1_6());
			col_isPass.setCellValueFactory(cellData -> cellData.getValue().getIsPass());
			
		}
		
	    

}
