package view.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import PDF_tamplates.*;
import model.ObjectReferences.*;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import controller.DB.*;

public class Generate_Result_Controller implements Initializable{
	
	 @FXML
	    private JFXComboBox<String> cbo_year;

	    @FXML
	    private JFXComboBox<String> cbo_Major;

	    @FXML
	    private JFXComboBox<String> cbo_stuNRC;

	    @FXML
	    private JFXButton btn_serarch;

	    @FXML
	    private ImageView btn_search;

	    @FXML
	    private JFXComboBox<String> cbo_stuYear;

	    @FXML
	    private Button btn_ViewResult;

	    @FXML
	    private Text txt_about_mark;

	    @FXML
	    private Text txt_isPass;

	    @FXML
	    private Text txt_date;
	    
	    @FXML
	    private TableView<Obj_Result_Generate_tb> tb_view;

	    
	    @FXML
	    private TableColumn<Obj_Result_Generate_tb,String> col_no;

	    @FXML
	    private TableColumn<Obj_Result_Generate_tb,String> col_sub;

	    @FXML
	    private TableColumn<Obj_Result_Generate_tb,String> col_mark;

	    @FXML
	    private TableColumn<Obj_Result_Generate_tb,String> col_grade;

	    @FXML
	    private TableColumn<Obj_Result_Generate_tb,String> col_remark;
	   
	    private ObservableList<Obj_Result_Generate_tb> items1 = FXCollections.observableArrayList();
	    
	    
	    
	    @FXML
	    private Button btn_Clear;

	    @FXML
	    private Button btn_Generate;

	    
	    private Quaries db;
	    private ArrayList<Obj_stu_profile_all> arlStu_DATA_all;
	    private String stuYear="";
	    private String stuMajor="";
	    private String SearchYear="";
	    private String stuNRC="";
	    private String pritYear;
	    
	    
	    private Obj_stu_profile_all selectedSTU;
	    private ArrayList<String> selectedACE_courseId;
	    private Obj_db_Define_Course ACE_firstTerm=null;
	    private Obj_db_Define_Course ACE_secondTerm=null;
	    
	    private Obj_result SelectedStu_data;
	    
	    
	    private ArrayList<Obj_resultGenerate_marks> arlSelected_tbMarks;
	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			db=new Quaries(1);
			Intialize_Cols();
			tb_view.setItems(items1);
			
			arlStu_DATA_all=db.get_ALL_Student_DATA();
			selectedACE_courseId=new ArrayList();
			arlSelected_tbMarks=new ArrayList();
			
			Set<String> setYears=new HashSet();
			
			for(Obj_stu_profile_all objTemp : arlStu_DATA_all)
			{
				setYears.add(objTemp.getStu().getYear_s());
			}
			
			cbo_year.getItems().clear();
			cbo_year.getItems().addAll(setYears);
			
		}
	    
	    
	    @FXML
	    void btn_ViewResult_Act(ActionEvent event) {
	    	
	    	 pritYear=cbo_stuYear.getSelectionModel().getSelectedItem().trim();
	    	stuYear=cbo_year.getSelectionModel().getSelectedItem().trim();
	    	stuMajor=cbo_Major.getSelectionModel().getSelectedItem().trim();
	    	
	    	//System.out.print(pritYear+"\t"+stuYear+"\t"+stuMajor+"jkjkj");
	    	
	    	int index1=99;
	    	int index2=99;
	    	
	    	if(pritYear.equalsIgnoreCase("First year"))
	    	{
	    		index1=0;
	    		index2=1;
	    	}
	    	else if(pritYear.equalsIgnoreCase("Second year"))
	    	{
	    		index1=2;
	    		index2=3;
	    	}
	    	else if(pritYear.equalsIgnoreCase("Third year"))
	    	{
	    		index1=4;
	    		index2=5;
	    	}
	    	else if(pritYear.equalsIgnoreCase("Fourth year"))
	    	{
	    		index1=6;
	    		index2=7;
	    	}
	    	else if(pritYear.equalsIgnoreCase("Final year"))
	    	{
	    		index1=9;
	    		
	    	}
	    	
	    	System.out.println(pritYear);
	    	String firstTermId=selectedACE_courseId.get(index1);
	    	String SecondTermId=selectedACE_courseId.get(index2);
	    	
	    	
	    	System.out.println("\n"+firstTermId+"<\t"+SecondTermId+"<<<haha"+index1+"\t"+index2+"\t"+selectedACE_courseId);
		    
	    	ACE_firstTerm=db.get_AceCourse_by_id(firstTermId.trim());
	    	ACE_secondTerm=db.get_AceCourse_by_id(SecondTermId.trim());
	    
	    	
	    	//System.out.println(ACE_firstTerm+"\t"+ACE_secondTerm+"<<<haha________________________________________");
	    	SetDATA_Ui_tbDATA(ACE_firstTerm,ACE_secondTerm);


	    	/*
	    	 * get data to UI table
	    	 */
	    	items1.clear();
	    	for(  Obj_resultGenerate_marks   objTemp : arlSelected_tbMarks)
	    	{
	    		Obj_Result_Generate_tb obj=new Obj_Result_Generate_tb(objTemp.getNo(),objTemp.getSub(),objTemp.getMark(),objTemp.getGrade(),objTemp.getRemark());
	    		items1.add(obj);
	    		
	    	}
	    	tb_view.refresh();
	    	
	    	String StrTitle="This is to certify that "+SelectedStu_data.getSutName()+" has obtained the following marks in the "+SelectedStu_data.getYear()+". Examination held in September,"+SelectedStu_data.getExamYear()+"";
	   		String pass=SelectedStu_data.getIsPass()+"";
	   		String date="Date : "+SelectedStu_data.getDate()+"";
	    	txt_about_mark.setText(StrTitle);
	    	txt_isPass.setText(pass);	
	    	txt_date.setText(date);
			
	    	
	    	btn_Generate.setDisable(false);
	    	
	    		
	    }

	    
		
		
	    
	    private void SetDATA_Ui_tbDATA(Obj_db_Define_Course course1, Obj_db_Define_Course course2) {
			
	    	String strFirstTerm[]=course1.getCourseId().split("[',']");
	    	String strSecondTerm[]=course2.getCourseId().split("[',']");
	    
	    	arlSelected_tbMarks.clear();
	    	int TotoalMark=0;
	    	String isPass="Pass";
	    	for(int a=0;a<strFirstTerm.length;a++)
	    	{
	    		String strCouseId1=strFirstTerm[a];
	    		Obj_db_Course_profile CourseObj1=db.get_Course_Data(strCouseId1.trim());
	    		
	    		String strCouseId2=strFirstTerm[a];
	    		Obj_db_Course_profile CourseObj2=db.get_Course_Data(strCouseId2.trim());
	    		
	    		
	    		/*
	    		 * get mark by sudent id and ace Id
	    		 */
	    		System.out.println(strCouseId1+"\t"+strCouseId2);
	    		String stuId=selectedSTU.getStu().getStuId_s();
	    		String str1Mark=db.get_Course_Mark(stuId,course1.getId().trim(),CourseObj1.getRefName().trim());
	    	
	    		String str2Mark=db.get_Course_Mark(stuId,course2.getId().trim(),CourseObj2.getRefName().trim());
		    	
	    		
	    		String CouserName=CourseObj1.getName()+"+"+CourseObj2.getName();
	    		System.out.println(str1Mark+"\t"+str2Mark+"<<<");
	    		int AverageMark=(Integer.parseInt(str1Mark)+Integer.parseInt(str2Mark))/2;
	    		TotoalMark+=AverageMark;
	    		
	    		if(AverageMark<50)
	    			isPass="Fail";
	    		
	    		String Grade=GetGrade(AverageMark);
	    		//System.out.println(Grade+"\t"+AverageMark+">>>"+selectedSTU.getStu().getStuId()+"\t"+CouserName+"\t"+course1.getId()+"\t"+course2.getId());
	    		
	    		

	            Obj_resultGenerate_marks PDF_tb=new Obj_resultGenerate_marks();
	            PDF_tb.setNo((1+a)+"");
	            PDF_tb.setSub(CouserName);
	            PDF_tb.setMark(AverageMark+"");
	            PDF_tb.setGrade(Grade);
	            PDF_tb.setRemark(isDestination(AverageMark));
	            arlSelected_tbMarks.add(PDF_tb);
	            
	         
	    		
	    	}
	    	/*
	    	 * add total
	    	 */
	    	Obj_resultGenerate_marks PDF_tb=new Obj_resultGenerate_marks();
            PDF_tb.setNo("");
            PDF_tb.setSub("TOTAL");
            PDF_tb.setMark(TotoalMark+"");
            PDF_tb.setGrade("");
            PDF_tb.setRemark("");
    		arlSelected_tbMarks.add(PDF_tb);
        
    		SelectedStu_data=new Obj_result();
    		SelectedStu_data.setSutName(selectedSTU.getStu().getStuName_s()+" ("+selectedSTU.getStu().getNrc_s()+") ");
    		SelectedStu_data.setRoll(" ("+selectedSTU.getStu().getNrc_s()+") ");
    		SelectedStu_data.setYear(pritYear+". ");
    		SelectedStu_data.setIsPass(isPass);
    		String strACEyear[]=course1.getAcedimic_year().split("-");
    		SelectedStu_data.setExamYear(strACEyear[1]+".");
    		System.out.println(strACEyear[1]);
    		Date date=new Date();
    		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    		SelectedStu_data.setDate(dateFormat.format(date)+"");
            
            
		}


		private String isDestination(int averageMark) {
			
			if(averageMark<80)
				return "-";
			else
				return "Destinction";
		}


		private String GetGrade(int mark) {
			
			String returnStr="";
			if(mark>=80)
    			returnStr="A";
    		else if(mark>=60)
    			returnStr="B";
    		else if(mark>=40)
    			returnStr="C";
    		else if(mark>=20)
    			returnStr="D";
    		else 
    			returnStr="E";
			
			
			return returnStr;
		}


		@FXML
	    void btn_Clear_Act(ActionEvent event) {

	    }

	    @FXML
	    void btn_Generate_Act(ActionEvent event) {

	    	String OutputFilePath="Desktop/"+selectedSTU.getStu().getStuId_s()+"_Restult.pdf";
	    	
	    	  try {
		            /* User home directory location */
		            String userHomeDirectory = System.getProperty("user.home");
		            /* Output file location */
		            String outputFile = userHomeDirectory + File.separatorChar +OutputFilePath;

		            /* List to hold Items */
		            List<Obj_resultGenerate_marks> listItems = new ArrayList<Obj_resultGenerate_marks>();

		           
		            listItems=arlSelected_tbMarks;
		            
		            
		            /* Convert List to JRBeanCollectionDataSource */
		            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

		            /* Map to hold Jasper report Parameters */
		            Map<String, Object> parameters = new HashMap<String, Object>();
		            parameters.put("Result_Generate1", itemsJRBean);

		            
		            parameters.put("stu_StudentName",SelectedStu_data.getSutName());
		            parameters.put("stu_StudentRoll",SelectedStu_data.getRoll());
		            parameters.put("stu_year",SelectedStu_data.getYear());
		            parameters.put("stu_ExamYear",SelectedStu_data.getExamYear());
		            parameters.put("stu_Date",SelectedStu_data.getDate());
		            parameters.put("stu_isPass",SelectedStu_data.getIsPass());

		            
		            /* Using compiled version(.jasper) of Jasper report to generate PDF */
		            JasperPrint jasperPrint = JasperFillManager.fillReport("/Users/tharhtetsan/Documents/workspace/java/student_Result_processing/src/PDF_tamplates/Result_Generate_Tamplate.jasper", parameters, new JREmptyDataSource());

		            /* outputStream to create PDF */
		            OutputStream outputStream = new FileOutputStream(new File(outputFile));
		            /* Write content to PDF file */
		            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

		            
		 
		            System.out.println("File Generated");
		        } catch (JRException ex) {
		            ex.printStackTrace();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
	    	
	    	
	    	
	    	
	    }

	    

	    
	    @FXML
	    void btn_searchAction(ActionEvent event) {
	    	
	    	stuNRC=cbo_stuNRC.getSelectionModel().getSelectedItem().trim();
	    	cbo_stuYear.getItems().clear();
	    	
	    	if(stuNRC=="")
	    	{
	    		
	    	}
	    	else if(stuYear=="")
	    	{
	    		
	    	}
	    	else if(stuMajor=="")
	    	{
	    		
	    	}
	    	else
	    	{
	    		for(Obj_stu_profile_all objTemp : arlStu_DATA_all)
				{
					if(objTemp.getStu().getYear_s().trim().equalsIgnoreCase(stuYear)  && objTemp.getStu().getMajor_s().trim().equalsIgnoreCase(stuMajor) && objTemp.getStu().getNrc_s().equalsIgnoreCase(stuNRC))
					{
						selectedSTU=objTemp;
						System.out.println(objTemp.getHistory().getFirstyear2_s()+"<<<>>>"+objTemp.getHistory().getFirstyear1_s());
					}
				}
	    	}
	    	
	    
	    	
	    	if(selectedSTU!=null)
	    	{
	    		if(selectedSTU.getStu().getYear_s().trim().equalsIgnoreCase("First year"))
	    		{
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear1_s().trim());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear2_s().trim());
	    			
	    			cbo_stuYear.getItems().add("First Year");
	    			
	    		}else if(selectedSTU.getStu().getYear_s().trim().equalsIgnoreCase("Second year"))
	    		{
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear2_s());
	    			
	    			cbo_stuYear.getItems().add("First Year");
	    			cbo_stuYear.getItems().add("Second Year");
	    			
	    			
	    		}else if(selectedSTU.getStu().getYear_s().trim().equalsIgnoreCase("Third year"))
	    		{
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getThirdyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getThirdyear2_s());
	    		
	    			cbo_stuYear.getItems().add("First Year");
	    			cbo_stuYear.getItems().add("Second Year");
	    			cbo_stuYear.getItems().add("Third Year");
	    			
	    		}else if(selectedSTU.getStu().getYear_s().trim().equalsIgnoreCase("Fourth year"))
	    		{
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getThirdyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getThirdyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFourthyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFourthyear2_s());
	    		
	    			
	    			cbo_stuYear.getItems().add("First year");
	    			cbo_stuYear.getItems().add("Second year");
	    			cbo_stuYear.getItems().add("Third year");
	    			cbo_stuYear.getItems().add("Fourth year");
	    			
	    		}else if(selectedSTU.getStu().getYear_s().trim().equalsIgnoreCase("Final year"))
	    		{
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFirstyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getSecondyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getThirdyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getThirdyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFourthyear1_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFourthyear2_s());
	    			selectedACE_courseId.add(selectedSTU.getHistory().getFinal1_s());
	    		
	    			cbo_stuYear.getItems().add("First year");
	    			cbo_stuYear.getItems().add("Second year");
	    			cbo_stuYear.getItems().add("Third year");
	    			cbo_stuYear.getItems().add("Fourth year");
	    			cbo_stuYear.getItems().add("Final year");
	    		}
	    	
	    		
	    	}
	    	
	    	
	    }

	    @FXML
	    void cbo_Major_Act(ActionEvent event) {
	    	stuMajor=cbo_Major.getSelectionModel().getSelectedItem().trim();
	    	Set<String> setNrc=new HashSet();
			
			for(Obj_stu_profile_all objTemp : arlStu_DATA_all)
			{
				if(objTemp.getStu().getYear_s().trim().equalsIgnoreCase(stuYear)  && objTemp.getStu().getMajor_s().trim().equalsIgnoreCase(stuMajor))
					setNrc.add(objTemp.getStu().getNrc_s());
			}
			
			cbo_stuNRC.getItems().clear();
			cbo_stuNRC.getItems().addAll(setNrc);
	    }

	    @FXML
	    void cbo_stuNRC_Act(ActionEvent event) {
	    	stuNRC=cbo_stuNRC.getSelectionModel().getSelectedItem().trim();
	    	
	    }

	    @FXML
	    void cbo_year_Act(ActionEvent event) {
	    	
	    	stuYear=cbo_year.getSelectionModel().getSelectedItem().trim();
	    	Set<String> setMajor=new HashSet();
			
			for(Obj_stu_profile_all objTemp : arlStu_DATA_all)
			{
				if(objTemp.getStu().getYear_s().trim().equalsIgnoreCase(stuYear))
				setMajor.add(objTemp.getStu().getMajor_s());
			}
			
			cbo_Major.getItems().clear();
			cbo_Major.getItems().addAll(setMajor);

	    }

	
	    public void  Intialize_Cols()
		{
			//Course tb repare;
					col_no.setCellValueFactory(cellData -> cellData.getValue().getNo());
					col_sub.setCellValueFactory(cellData -> cellData.getValue().getSub());
					col_mark.setCellValueFactory(cellData -> cellData.getValue().getMark());
					col_grade.setCellValueFactory(cellData -> cellData.getValue().getGrade());
					col_remark.setCellValueFactory(cellData -> cellData.getValue().getRemark());
		}
		

}
