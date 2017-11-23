package view.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import controller.DB.*;
import model.ObjectReferences.*;

public class Student_profile_Controller implements Initializable{

	@FXML
    private StackPane spane_image;

    @FXML
    private ImageView imgv_Stu_Image;

    @FXML
    private JFXButton btn_Name;

    @FXML
    private Label txt_id;

    @FXML
    private Label txt_email;

    @FXML
    private Label txt_nrc;

    @FXML
    private Label txt_MajorrollYear;

    @FXML
    private Label txt_address;

    @FXML
    private Label txt_birthdate;

    @FXML
    private Label txt_info;

    @FXML
    private Label txt_fname;

    @FXML
    private Label txt_fNrc;

    @FXML
    private Label txt_Mname;

    @FXML
    private Label txt_mNrc;

    @FXML
    private Label txt_pPhno;

    @FXML
    private Label txt_pAddress;
	    
    @FXML
    private TableView<Obj_stu_prfile_tb> tb_couse;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_no;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_name;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_trname;

    @FXML
    private TableView<Obj_stu_prfile_tb> tb_couse1;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_no1;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_name1;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_trname1;

    @FXML
    private TableView<Obj_stu_prfile_tb> tb_couse2;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_no2;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_name2;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_trname2;

    @FXML
    private TableView<Obj_stu_prfile_tb> tb_couse3;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_no3;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_name3;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_trname3;

    @FXML
    private TableView<Obj_stu_prfile_tb> tb_couse4;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_no4;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_name4;

    @FXML
    private TableColumn<Obj_stu_prfile_tb,String> col_trname4;
    

    @FXML
    private TableColumn<Obj_stu_prfile_tb, String> col_term;
    
    @FXML
    private TableColumn<Obj_stu_prfile_tb, String> col_term1;
    
    
    @FXML
    private TableColumn<Obj_stu_prfile_tb, String> col_term2;
    
    
    @FXML
    private TableColumn<Obj_stu_prfile_tb, String> col_term3;
    
    
    @FXML
    private TableColumn<Obj_stu_prfile_tb, String> col_term4;
    
    
    
    
    private ObservableList<Obj_stu_prfile_tb> items = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_prfile_tb> items1 = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_prfile_tb> items2 = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_prfile_tb> items3 = FXCollections.observableArrayList();
    private ObservableList<Obj_stu_prfile_tb> items4 = FXCollections.observableArrayList();
  
    
    private Quaries db;
    private ArrayList<Obj_stu_profile_all> objData;
    private  Obj_stu_profile_all obj;

	private Image stuIm;
    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			db=new Quaries(1);
			
			Intialize_Cols();
			tb_couse.setItems(items);
			tb_couse1.setItems(items1);
			tb_couse2.setItems(items2);
			tb_couse3.setItems(items3);
			tb_couse4.setItems(items4);
			
			
			
			objData=db.get_ALL_Student_DATA();
			obj=Student_listView_Controller.getSelectdObj();
			
			/*
			 * add Student data
			 * 
			 */
			txt_id.setText(obj.getStu().getStuId_s());
			btn_Name.setText(obj.getStu().getStuName_s());
			txt_nrc.setText(obj.getStu().getNrc_s());
			txt_email.setText(obj.getStu().getEmail_s());
			txt_MajorrollYear.setText(obj.getStu().getMajor_s()+"-"+obj.getStu().getCurrentRoll_s()+"("+obj.getStu().getYear_s()+")");
			txt_address.setText(obj.getStu().getAddress_s());
			
			
			String gender="";
			String gender1="";
			String gender2="";
			if(obj.getStu().getGender_s().equalsIgnoreCase("Male"))
			{
				gender="he";
				gender1="his";
				gender2="Mg.";
			}
			else
			{
				gender="she";
				gender1="her";
				gender2="Ma.";
			}	
			
			String Strinfo=gender2+""+obj.getStu().getStuName_s()+" is "+obj.getStu().getMajor_s()+" major student of  of University Of Computer Studies,Mandalay"+gender+" started the University at-"+obj.getStu().getStartDate_s()+" And BirthDay was "+obj.getStu().getBirthDate_s()+"."
					+ "\nHere is "+gender1+"roll recored in each year  :  "+obj.getHistory().getRollRecord_s();
			
			txt_info.setText(Strinfo);
			
			String url="stuProfile_images/"+obj.getStu().getImgName_s().trim();
		
			System.out.print(url);
			try {
		
				stuIm = new Image(new FileInputStream(url));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imgv_Stu_Image.setImage(stuIm);
			
			
			
			
			/*
			 * parent data set
			 * 
			 */
			
			txt_fname.setText(obj.getParent().getFather_name());
			txt_fNrc.setText(obj.getParent().getFather_nrc());
			txt_Mname.setText(obj.getParent().getMother_name());
			txt_mNrc.setText(obj.getParent().getMother_nrc());
			txt_pAddress.setText(obj.getParent().getParent_address());
			txt_pPhno.setText(obj.getParent().getParent_phno());
			txt_birthdate.setText(obj.getStu().getBirthDate_s());
			
			ArrayList<String> arlAceSub=new ArrayList<>();
			arlAceSub.add(obj.getHistory().getFirstyear1_s().trim());
			arlAceSub.add(obj.getHistory().getFirstyear2_s().trim());
			arlAceSub.add(obj.getHistory().getSecondyear1_s().trim());
			arlAceSub.add(obj.getHistory().getSecondyear2_s().trim());
			arlAceSub.add(obj.getHistory().getThirdyear1_s().trim());
			arlAceSub.add(obj.getHistory().getThirdyear2_s().trim());
			arlAceSub.add(obj.getHistory().getFourthyear1_s().trim());
			arlAceSub.add(obj.getHistory().getFirstyear2_s().trim());
			arlAceSub.add(obj.getHistory().getFinal1_s().trim());
			
			
			
			ArrayList<Obj_db_Define_Course> arlDefine_Couse=db.get_Define_Course_Data();
			
			
			System.out.println(arlAceSub);
			ArrayList<Obj_db_Define_Course> Merge_AceSub=new ArrayList();
			ArrayList<String> Merge_AceSub_id=new ArrayList();
			
			for(int b=0;b<arlAceSub.size();b++)
			{
				
				String foundkey="-";
				String foundData="-";
				Obj_db_Define_Course arlDefine=null;
				for(int a=0;a<arlDefine_Couse.size();a++)
				{
					Obj_db_Define_Course arlDefineTemp =arlDefine_Couse.get(a);
					
					if(arlDefineTemp.getId().equalsIgnoreCase(arlAceSub.get(b)))
					{
						foundkey=arlDefineTemp.getCourseId();
						foundData=arlAceSub.get(b);
						arlDefine=arlDefineTemp;
					}
					
				}
				
				if(foundkey=="-" && foundData=="-")
				{
					Merge_AceSub.add(null);
					Merge_AceSub_id.add(getYear(b)+"_null");
				}
				else {
					Merge_AceSub.add(arlDefine);
					Merge_AceSub_id.add(getYear(b)+"_"+foundData);
				}
				
			}
		System.out.println(Merge_AceSub);
		System.out.println(Merge_AceSub_id);
		
			

		/*
		 * retieve couse obj by couse id
		 */
		ArrayList<Obj_db_Course_profile> arlCousesALL=db.get_Course_Data();
		HashMap<String,Obj_db_Course_profile> hashMap_CousersALL=new HashMap();
		for(Obj_db_Course_profile objCouse : arlCousesALL)
		{
			hashMap_CousersALL.put(objCouse.getCourseId(),objCouse );
		}
		System.out.println(hashMap_CousersALL);
		
		
		/*
		 *set data
		 */
		for(int a=0;a<Merge_AceSub_id.size();a++)
		{
			String SearchACE=Merge_AceSub_id.get(a);
			Obj_db_Define_Course objACE=Merge_AceSub.get(a);
			
			if(SearchACE.contains("_null") && objACE==null)
			{
				continue;
			}
			
			String str[]=SearchACE.split("['_']");
			String ACEkey=str[1];
			String year=str[0];
			String term=objACE.getTerm();
			
			String strSubKeys[]=objACE.getCourseId().split("[',']");
			ArrayList<Obj_db_Course_profile> foundObj=new ArrayList<>();
			for(int b=0;b<strSubKeys.length;b++)
			{
				String SearchKey=strSubKeys[b].trim();
				foundObj.add(hashMap_CousersALL.get(SearchKey));
				
			}
			Set_DATA_toTABLE(year,term,foundObj);
		}
			
		
			
		}

		private void Set_DATA_toTABLE(String year, String term, ArrayList<Obj_db_Course_profile> foundObj) {
			
			for( Obj_db_Course_profile objTemp : foundObj)
			{
				
				Obj_stu_prfile_tb obj_tb=new Obj_stu_prfile_tb(objTemp.getCourseId(),objTemp.getName(),term,objTemp.getTrName());
				if(year.equalsIgnoreCase("First Year"))
				{
					Settb_data(obj_tb);
				}
				else if(year.equalsIgnoreCase("Second Year"))
				{
					Settb1_data(obj_tb);
				}
				else if(year.equalsIgnoreCase("Third Year"))
				{
					Settb2_data(obj_tb);
				}
				else if(year.equalsIgnoreCase("Fourth Year"))
				{
					Settb3_data(obj_tb);
				}else
				{
					Settb4_data(obj_tb);
				}
			}
			
			
		}

		
		
		public void Settb_data(Obj_stu_prfile_tb obj)
		{
			items.add(obj);
		}
		
		public void Settb1_data(Obj_stu_prfile_tb obj)
		{
			items1.add(obj);
		}
		public void Settb2_data(Obj_stu_prfile_tb obj)
		{
			items2.add(obj);
		}
		public void Settb3_data(Obj_stu_prfile_tb obj)
		{
			items3.add(obj);
		}
		public void Settb4_data(Obj_stu_prfile_tb obj)
		{
			items4.add(obj);
		}
		
		private String getYear(int  a) {
			
			if(a==0 || a==1)
				return "First Year";
			else if(a==2 || a==3)
				return "Second Year";
			else if(a==4 || a==5)
				return "Third Year";
			else if(a==6 || a==7)
				return "Fourth Year";
			else 
				return "Final Year";
			
			
		}


		public void  Intialize_Cols()
		{
				//first year tb repare;
					col_no.setCellValueFactory(cellData -> cellData.getValue().getNo());
					col_name.setCellValueFactory(cellData -> cellData.getValue().getName());
					col_term.setCellValueFactory(cellData -> cellData.getValue().getTerm());
					col_trname.setCellValueFactory(cellData -> cellData.getValue().getTrName());
					
					//Second year tb repare;
					col_no1.setCellValueFactory(cellData -> cellData.getValue().getNo());
					col_name1.setCellValueFactory(cellData -> cellData.getValue().getName());
					col_term1.setCellValueFactory(cellData -> cellData.getValue().getTerm());
					col_trname1.setCellValueFactory(cellData -> cellData.getValue().getTrName());
					
					//Third year tb repare;
					col_no2.setCellValueFactory(cellData -> cellData.getValue().getNo());
					col_name2.setCellValueFactory(cellData -> cellData.getValue().getName());
					col_term2.setCellValueFactory(cellData -> cellData.getValue().getTerm());
					col_trname2.setCellValueFactory(cellData -> cellData.getValue().getTrName());
					
					//fourth year tb repare;
					col_no3.setCellValueFactory(cellData -> cellData.getValue().getNo());
					col_name3.setCellValueFactory(cellData -> cellData.getValue().getName());
					col_term3.setCellValueFactory(cellData -> cellData.getValue().getTerm());
					col_trname3.setCellValueFactory(cellData -> cellData.getValue().getTrName());
					
					
					//final year tb repare;
					col_no4.setCellValueFactory(cellData -> cellData.getValue().getNo());
					col_name4.setCellValueFactory(cellData -> cellData.getValue().getName());
					col_term4.setCellValueFactory(cellData -> cellData.getValue().getTerm());
					col_trname4.setCellValueFactory(cellData -> cellData.getValue().getTrName());
					
		}
		
}
