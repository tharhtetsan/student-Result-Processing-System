package view.Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javax.imageio.ImageIO;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.ObjectReferences.*;
import controller.DB.*;
import model.ObjectReferences.*;


public class Add_New_Student_Controller implements Initializable{
	
	
	  @FXML
	    private ImageView imgv_Stu_Image;

	    @FXML
	    private Text txt_stuId;

	    @FXML
	    private JFXTextField txt_name;

	    @FXML
	    private JFXTextField txt_roll;

	    @FXML
	    private JFXTextField txt_email;

	    @FXML
	    private JFXTextField txt_phno;

	    @FXML
	    private JFXTextField txt_nrc;

	    @FXML
	    private JFXComboBox<String> cbo_year;

	    @FXML
	    private JFXComboBox<String> cbo_major;

	    @FXML
	    private JFXDatePicker txt_BirthDate;

	    @FXML
	    private JFXRadioButton rdo_male;

	    @FXML
	    private ToggleGroup group;

	    @FXML
	    private JFXRadioButton rdo_female;

	    @FXML
	    private Text txt_Currentdate;

	    @FXML
	    private TextArea txt_address;

	    @FXML
	    private TextArea txt_info;

	    @FXML
	    private TextField txt_Fnrc;

	    @FXML
	    private TextField txt_Mname;

	    @FXML
	    private TextField txt_Mnrc;

	    @FXML
	    private TextField txt_Fname;

	    @FXML
	    private TextArea txt_pAddress;

	    @FXML
	    private TextField txt_pPhno;

	    @FXML
	    private JFXButton btn_Clear;

	    @FXML
	    private JFXButton btn_Save;
	    

	    @FXML
	    private JFXComboBox<String> cbo_AceYear;
	    
	    private String stuId;
	    private String name;
	    private String email;
	    private String phno;
	    private String startDate;
	    private String CurrentCourseId;
	    private String roll;
	    private String birthday;
	    private String gender;
	    private String year;
	    private String major;
	    private String nrc;
	    private String address;
	    private String info;
	   
	    
	    private String pId;
		private String fname;
	    private String Mname;
	    private String fnrc;
	    private String Mnrc;
	    private String pPhno;
	    private String pAddress;
	   
	    private String HistoryId;
	    private String AboutId;
	   
	    Obj_histroy ObjHistroy;
	    Obj_stu_profile ObjStuProfile;
	    Obj_stu_parent ObjParent;
	    
	    
	    private Quaries db;
	    private Circle cir_img;
	    private FileChooser fileChooser = new FileChooser();
	    private File stuImage_file;
	    ArrayList<Obj_db_Define_Course> arlDefineCourse;
	    String ACEyear;

	    @FXML
	    void cbo_major_Act(ActionEvent event) {

	    }


	    @FXML
	    void cbo_AceYear_Act(ActionEvent event) {
	    	 ACEyear=cbo_AceYear.getSelectionModel().getSelectedItem().trim();
	    	cbo_year.getItems().clear();
	    	Set<String> setyear=new HashSet();
			for(Obj_db_Define_Course obj : arlDefineCourse)
			{
				if(ACEyear.equalsIgnoreCase(obj.getAcedimic_year().trim()))
					setyear.add(obj.getForyear().trim());
			}
			cbo_year.getItems().addAll(setyear);
	    }
	    
	    @FXML
	    void cbo_year_Act(ActionEvent event) {

	    	String SearchYear=cbo_year.getSelectionModel().getSelectedItem().trim();
	    	cbo_major.getItems().clear();
	    	/*
	    	 * add marjor
	    	 */
	    	Set<String> setMajor=new HashSet();
			for(Obj_db_Define_Course obj : arlDefineCourse)
			{
				if(SearchYear.equalsIgnoreCase(obj.getForyear().trim()))
					setMajor.add(obj.getMajor().trim());
			}
			cbo_major.getItems().addAll(setMajor);
	    }
	    
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			db=new Quaries(1);
			
			
			txt_stuId.setText(db.getPrimaryKey("stuid","Stu_profile","STU-"));
			
			arlDefineCourse=db.get_Define_Course_Data();
			Set<String> setACEyear=new HashSet();
			for(Obj_db_Define_Course obj : arlDefineCourse)
			{
				setACEyear.add(obj.getAcedimic_year().trim());
			}
			cbo_AceYear.getItems().addAll(setACEyear);
 			
			
		}
	    
	    @FXML
	    void btn_Clear_Act(ActionEvent event) {

	    }
	    
	    
	    @FXML
	    void rdo_Male_Act(ActionEvent event) {
	    	gender="Male";
	    }

	    @FXML
	    void rdo_female_Act(ActionEvent event) {
	    	gender="Female";
	    }

	    
	    
	    @FXML
	    void imgv_Stu_Image_Act(MouseEvent event) {
	    	fileChooser.setTitle("Open Image File");
			fileChooser.getExtensionFilters().clear();
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image  File", "*.jpg",".png"));
			 stuImage_file = fileChooser.showOpenDialog(new Stage());
			if (stuImage_file != null)
			{	
				try {
					Image imge=new Image(new FileInputStream(stuImage_file));
					imgv_Stu_Image.setImage(imge);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Error  in file choosing");
			}

	    }
	    
	    @FXML
	    void btn_Save_Act(ActionEvent event) {
	    	
	    	/*
	    	 * student data collection
	    	 */
	    	stuId=txt_stuId.getText().toString().trim();
	    	name=txt_name.getText().toString().trim();
	    	email=txt_email.getText().toString().trim();
	    	phno=txt_phno.getText().toString().trim();
	    	roll=txt_roll.getText().toString().trim();
	    	birthday=txt_BirthDate.getValue()+"";
	    	nrc=txt_nrc.getText().toString().trim();
	    	year=cbo_year.getSelectionModel().getSelectedItem().toString().trim();
	    	major=cbo_major.getSelectionModel().getSelectedItem().toString().trim();
	    	address=txt_address.getText().toString().trim();
	    	info=txt_info.getText().toString().trim();
	    	startDate=txt_Currentdate.getText().toString().trim();
	    
	    	for(Obj_db_Define_Course obj : arlDefineCourse)
			{
				if(ACEyear.equalsIgnoreCase(obj.getAcedimic_year().trim()) && year.equalsIgnoreCase(obj.getAcedimic_year().trim()) && major.equalsIgnoreCase(obj.getMajor().trim()))
					CurrentCourseId=obj.getId();
			}
	    	
	    	
	    	
	    	/*
	    	 * parent Data
	    	 */
	    	pId="";
	    	fname=txt_Fname.getText().toString().trim();
	    	Mname=txt_Mname.getText().toString().trim();
	    	fnrc=txt_Fnrc.getText().toString().trim();
	    	Mnrc=txt_Mnrc.getText().toString().trim();
	    	pAddress=txt_pAddress.getText().toString().trim();
	    	pPhno=txt_pPhno.getText().toString().trim();
	    
	    	
	    	
	    	
	    	
	    	
	    	/*
	    	 * History data
	    	 */
	   
	    	
	    /*
	     * add student profile data
	     */
	    	String imgName="";
	    	if(stuImage_file==null)
	    		imgName="default_Male.png";
	    	else
	    		imgName=stuId+".png";
	    		
	    	ObjStuProfile=new Obj_stu_profile(
	    			AboutId,
	    			pId,
	    			HistoryId,
	    			stuId,
	    			name,
	    			birthday,
	    			gender,
	    			CurrentCourseId,
	    			roll,
	    			address,
	    			nrc,
	    			year,
	    			major,
	    			email,
	    			phno,
	    			startDate,
	    			imgName);
	    	
	    	/*
	    	 * add parent data
	    	 */
	    	ObjParent=new Obj_stu_parent(
	    			pId,
	    			fname,
	    			fnrc,
	    			Mname,
	    			Mnrc,
	    			pAddress,
	    			pPhno);
	    	/*
	    	 * add history data
	    	 */
	    	ObjHistroy=new Obj_histroy();
	    	ObjHistroy.setId_s(HistoryId);
	    	ObjHistroy.setRollRecord_s(roll);
	    	
	    	if(stuImage_file!=null)
	    	{
	    		
	    	try {
					
					BufferedImage image = null;
					image = ImageIO.read(stuImage_file);
					 ImageIO.write(image, "png", new File("stuProfile_images/"+imgName));
			        
				} catch (
						Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	db.AddNewStudent(ObjHistroy, ObjParent, ObjStuProfile);
	    	
   }
	    
	    
	 
	    
	    
	    
	   
    
	

}
