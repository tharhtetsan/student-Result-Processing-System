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

import com.jfoenix.controls.JFXComboBox;

import PDF_tamplates.Obj_transcript_Generate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import controller.DB.*;
import model.ObjectReferences.*;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Generate_Transcript_Controller implements Initializable{


    @FXML
    private JFXComboBox<String> cbo_Aceyear;
	
	@FXML
    private JFXComboBox<String> cbo_Major;

    @FXML
    private JFXComboBox<String> cbo_stuNRC;

    @FXML
    private Button btn_ViewResult;

    @FXML
    private Text txt_tCount;

    @FXML
    private Text stu_date;

    @FXML
    private Text stu_sub;

    @FXML
    private Text stu_about;

    @FXML
    private Text stu_t1;

    @FXML
    private Text stu_t2;

    @FXML
    private Text stu_t3;

    @FXML
    private Text stu_t4;

    @FXML
    private Text stu_t5;


    @FXML
    private Text txt_about1;
    
    @FXML
    private Button btn_Clear;

    @FXML
    private Button btn_Generate;

    
    
    
   private Quaries db=null;
   private ArrayList<Obj_stu_profile_all> arlStu_DATA_all=null;
   private Obj_stu_profile_all selectedSTU;
   private int Trans_Count;
   private ArrayList<Obj_db_Define_Course> arlACE_DATA;
   
   private Set<String> arlACE_id;
   ArrayList<Obj_db_Define_Course> arl_SelectedCourse=new ArrayList<>();
   Obj_Result_View_tb  mark1=null;
   Obj_Result_View_tb  mark2=null;
	   
   
   private String stuYear="First Year";
   private String stuMajor="";
   private String AceYear="";
   private String stuNRC="";
   private String trnascriptCount;
   
   private Obj_transcript_Generate objPDF;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		db=new Quaries(1);
		arlStu_DATA_all=db.get_ALL_Student_DATA();
		arlACE_DATA=db.get_Define_Course_Data();
		
		ArrayList<Obj_db_Define_Course> arl_SelectedCourse=new ArrayList<>();
		Set<String> setMajor=new HashSet();
		Set<String> setAceYear=new HashSet();
		
		
		
		for(Obj_stu_profile_all objTemp : arlStu_DATA_all)
		{
			if(objTemp.getStu().getMajor_s().equalsIgnoreCase("5CS(BIS)") || objTemp.getStu().getMajor_s().equalsIgnoreCase("5CS(SE)") || objTemp.getStu().getMajor_s().equalsIgnoreCase("5CS(HPC)") || objTemp.getStu().getMajor_s().equalsIgnoreCase("5CS(KE)") || objTemp.getStu().getMajor_s().equalsIgnoreCase("5CS(HPC)") || objTemp.getStu().getMajor_s().equalsIgnoreCase("5CS(KE)") || objTemp.getStu().getMajor_s().equalsIgnoreCase("5CT(NMK)") || objTemp.getStu().getMajor_s().equalsIgnoreCase("5CT(ESY)"))
			setMajor.add(objTemp.getStu().getMajor_s().trim());
		}
		
		for(Obj_db_Define_Course objTemp  : arlACE_DATA)
		{
			if(objTemp.getForyear().trim().equalsIgnoreCase(stuYear))
				{
					setAceYear.add(objTemp.getAcedimic_year());
				}
		}
		
		
	
		cbo_Major.getItems().clear();
		cbo_Major.getItems().addAll(setMajor);
		
		cbo_Aceyear.getItems().clear();
		cbo_Aceyear.getItems().addAll(setAceYear);
	
	}
    
	
	
	
	
	  @FXML
	  void cbo_Aceyear_Act(ActionEvent event) 
	  {
		  
		  
	  }
    
	  
	  
    @FXML
    void btn_Clear_Act(ActionEvent event) {

    }

    @FXML
    void btn_Generate_Act(ActionEvent event) {
    	String OutputFilePath="Desktop/"+selectedSTU.getStu().getStuId_s()+"_Transcript.pdf";
    	
  	  try {
	            /* User home directory location */
	            String userHomeDirectory = System.getProperty("user.home");
	            /* Output file location */
	            String outputFile = userHomeDirectory + File.separatorChar +OutputFilePath;

	           
	          
	            
	      
	            /* Map to hold Jasper report Parameters */
	            Map<String, Object> parameters = new HashMap<String, Object>();
	          
	            
	            parameters.put("stu_Date",objPDF.getStuDate());
	            parameters.put("stu_sub",objPDF.getStuSub());
	            parameters.put("stu_about",objPDF.getStuAbout());
	            parameters.put("stu_t1",objPDF.getStu_t1());
	            parameters.put("stu_t2",objPDF.getStu_t2());
	            parameters.put("stu_t3",objPDF.getStu_t3());
	            parameters.put("stu_t4",objPDF.getStu_t4());
	            parameters.put("stu_t5",objPDF.getStu_t5());
	            parameters.put("stu_about1",objPDF.getStuAbout1());
		          
		          
	            
	            Trans_Count++;
	            db.UpdateStudent_Transcript_Count(selectedSTU.getStu().getStuId_s().trim(),Trans_Count+"");
	            
	            /* Using compiled version(.jasper) of Jasper report to generate PDF */
	            JasperPrint jasperPrint = JasperFillManager.fillReport("/Users/tharhtetsan/Documents/workspace/java/student_Result_processing/src/PDF_tamplates/Tanscript_Generate_Templates.jasper", parameters, new JREmptyDataSource());

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
    void btn_ViewResult_Act(ActionEvent event) {

    	stuMajor=cbo_Major.getSelectionModel().getSelectedItem().toString().trim();
    	AceYear=cbo_Aceyear.getSelectionModel().getSelectedItem().toString().trim();
    	stuNRC=cbo_stuNRC.getSelectionModel().getSelectedItem().toString().trim();
    
    	if(stuMajor==null  || AceYear==null || stuNRC==null )
    	{
    		return ;
    	}
    	
    	
    	
    	for(Obj_stu_profile_all objTemp : arlStu_DATA_all)
		{
    		if(objTemp.getStu().getNrc_s().equalsIgnoreCase(stuNRC))
    			selectedSTU=objTemp;
		}
    
    	String trnascriptCount=db.getStudent_Transcript_Count(selectedSTU.getStu().getStuId_s().trim());
    	Trans_Count=Integer.parseInt(trnascriptCount.trim());
    	txt_tCount.setText(trnascriptCount.trim());
    	
    	
    	
    	
    	
    	String date[]=selectedSTU.getStu().getStartDate_s().split("['/']");
    	String ACEYears[]=AceYear.split("-");
    			
    	String stu_t1="December, 20"+date[2];
    	String stu_t2="As shown per attached copy of mark list ";
    	String stu_t3=getBachelor(selectedSTU.getStu().getMajor_s());
    	String stu_t4=getGrade(AceYear.trim())+"";
    	
    	
    	System.out.println(stu_t4+"<<??/"+AceYear.trim());
    	String stu_t5="Grade A+ or 100 marks is maximum";
    	Date Currentdate=new Date();
    	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    	String stu_Date="Date :"+dateFormat.format(Currentdate)+"";
    	
    	
    	String st1="";
    	String st2="";
    	String st3="";
    	String st4="";
    	
    	if(selectedSTU.getStu().getGender_s().equalsIgnoreCase("Male"))
    	{
    		st1="He";
    		st2="his";
    		st3="Mister";
    		st4="son";
    	}else
    	{
    		st1="She";
    		st2="her";
    		st3="Miss";
    		st4="daughter";
    	}
    	
    	
    	String stu_sub=": Acedemic Transcript of "+st3+" "+selectedSTU.getStu().getStuName_s();
    	
    	String stu_about="This is to certify that "+st3+" "+selectedSTU.getStu().getStuName_s()+"("+selectedSTU.getStu().getNrc_s()+") "+st4+" of "+selectedSTU.getParent().getFather_name()+""
    			+ " had attended the University Of Computer Studies, Mandalay, Myanmar in December 20"+date[2]+" and  passed "+st2+" "+getBachelor1(selectedSTU.getStu().getMajor_s())+" degree examination from this Unversity in September, "+ACEYears[1]+". ";
    	
    	String stu_about1="";
    	
    	if(stu_t4.equalsIgnoreCase("A+") || stu_t4.equalsIgnoreCase("A") || stu_t4.equalsIgnoreCase("A-") || stu_t4.equalsIgnoreCase("B+"))
    	{
    		stu_about1=st1+" passed in the "+stu_t3+" degree examination and was qualified proceed the Master of"+getBachelor2(selectedSTU.getStu().getMajor_s())+" degree program at the Univeristy of Computer Studies, Mandalay, Myanmar ."+st2+" attested copies of mark list for five year is here after attached.";
    	}
    	else
    	{
    		stu_about1=st1+" passed in the "+stu_t3+" degree examination. "+st2+" attested copies of mark list for five year is here after attached.";
        	
    	}
    	
    	
    	
    
    	objPDF=new Obj_transcript_Generate();
    		objPDF.setStu_t1(stu_t1);
    		objPDF.setStu_t2(stu_t2);
    		objPDF.setStu_t3(stu_t3);
    		objPDF.setStu_t4(stu_t4);
    		objPDF.setStu_t5(stu_t5);
    		objPDF.setStuAbout(stu_about);
    		objPDF.setStuAbout1(stu_about1);
    		objPDF.setStuDate(stu_Date);
    		objPDF.setStuSub(stu_sub);
    		
    		
    		
    		this.stu_date.setText(stu_Date);
    		this.stu_sub.setText(stu_sub);
    		this.stu_t1.setText(stu_t1);
    		this.stu_t2.setText(stu_t2);
    		this.stu_t3.setText(stu_t3);
    		this.stu_t4.setText(stu_t4);
    		this.stu_t5.setText(stu_t5);
    		this.stu_about.setText(stu_about);
    		this.txt_about1.setText(stu_about1);
    		btn_Generate.setDisable(false);
    	
    }
    
    public String getGrade(String ACE_year)
    {
    	
    	arl_SelectedCourse=db.get_Define_Course_Data("Final year",stuMajor,ACE_year,"No");
    	System.out.println(arl_SelectedCourse.size());
    	if(arl_SelectedCourse.size()!=1)
    		return "";
    	
    	System.out.println(arl_SelectedCourse.get(0).getCourseId());
    	
    	String str1[]=arl_SelectedCourse.get(0).getCourseId().split("[',']");
    	
    	ArrayList<String> CouseName1=new ArrayList();
    	
    	for(String CouseId : str1)
    	{
    		String str=db.get_Course_Data(CouseId.trim()).getRefName();
    		CouseName1.add(str);
    	}
    	

    	
    	//System.out.println(CouseName1);
    	//System.out.println(CouseName2);
    	
    	mark1=db.getExam_Mark1(CouseName1,arl_SelectedCourse.get(0).getId(),selectedSTU.getStu().getStuId_s());
    	
       
    	String Grade="";
    	
    	Obj_Result_View_tb FinalMark=isPassObj(mark1);
    	
    	int sub1=Integer.parseInt(FinalMark.getSub1_1().get().toString());
    	int sub2=Integer.parseInt(FinalMark.getSub1_2().get().toString());
    	int sub3=Integer.parseInt(FinalMark.getSub1_3().get().toString());
    	int sub4=Integer.parseInt(FinalMark.getSub1_4().get().toString());
    	int sub5=Integer.parseInt(FinalMark.getSub1_5().get().toString());
    	
    	int totalMark=sub1+sub2+sub3+sub4+sub5;
    	
    	Grade=defineTranscript_Grade(totalMark/6);
    	return Grade;
    }
    
    
    
    
    
    private String defineTranscript_Grade(int totalMark) {
		
    	String strReturn="";
    	
    	if(totalMark>=80)
    		strReturn="A+";
    	else if(totalMark>=75)
    		strReturn="A";
    	else if(totalMark>=70)
    		strReturn="A-";
    	else if(totalMark>=65)
    		strReturn="B+";
    	else if(totalMark>=60)
    		strReturn="B";
    	else if(totalMark>=55)
    		strReturn="B-";
    	else if(totalMark>=45)
    		strReturn="C+";
    	else if(totalMark>=40)
    		strReturn="C";
    	else 
    		strReturn="C-";
 	
		return strReturn;
	}





	private Obj_Result_View_tb isPassObj(Obj_Result_View_tb tbObj1) {
		
		int sub1=Integer.parseInt(tbObj1.getSub1_1().get().trim());
		int sub2=Integer.parseInt(tbObj1.getSub1_2().get().trim());
		int sub3=Integer.parseInt(tbObj1.getSub1_3().get().trim());
		int sub4=Integer.parseInt(tbObj1.getSub1_4().get().trim());
		int sub5=Integer.parseInt(tbObj1.getSub1_5().get().trim());
		int sub6=Integer.parseInt(tbObj1.getSub1_6().get().trim());
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
				(sub1)+"",
				(sub2)+"",
				(sub3)+"",
				(sub4)+"",
				(sub5)+"",
				(sub6)+"",
				isPass);
		
		
		return ADD_tb;
				
}
    
    
    private String getBachelor(String major_s) {
		
    	String strReturn="";
    	if(major_s.contains("5CS(SE)"))
    		strReturn="B.C.Sc.(Software Engineering)";
    	else if(major_s.contains("5CS(BIS)"))
    		strReturn="B.C.Sc.(Business Information System)";
    	else if(major_s.contains("5CS(KE)"))
    		strReturn="B.C.Sc.(Knowledge Engineering)";
    	else if(major_s.contains("5CS(HPC)"))
    		strReturn="B.C.Sc.(High Performance Computing)";
    	else if(major_s.contains("5CT(NWK)"))
    		strReturn="B.C.Sc.(Networking Engineering)"; 
        else if(major_s.contains("5CT(ESY)"))
        	strReturn="B.C.Sc.(Embedded System)"; 		    				 
    		    		    	
			
		return strReturn;
	}

   private String getBachelor2(String major_s) {
		
    	String strReturn="";
    	if(major_s.contains("5CS(SE)"))
    		strReturn="Computer Science";
    	else if(major_s.contains("5CS(BIS)"))
    		strReturn="Computer Science";
    	else if(major_s.contains("5CS(KE)"))
    		strReturn="Computer Science";
    	else if(major_s.contains("5CS(HPC)"))
    		strReturn="Computer Science";
    	else if(major_s.contains("5CT(NWK)"))
    		strReturn="Computer Technology"; 
        else if(major_s.contains("5CT(ESY)"))
        	strReturn="Computer Technology"; 		    				 
    		    		    	
			
		return strReturn;
	}

 private String getBachelor1(String major_s) {
		
    	String strReturn="";
    	if(major_s.contains("5CS(SE)"))
    		strReturn="Bachelor of Computer Science (B.C.Sc.(Software Engineering))";
    	else if(major_s.contains("5CS(BIS)"))
    		strReturn="Bachelor of Computer Science (B.C.Sc.(Business Information System))";
    	else if(major_s.contains("5CS(KE)"))
    		strReturn="Bachelor of Computer Science (B.C.Sc.(Knowledge Engineering))";
    	else if(major_s.contains("5CS(HPC)"))
    		strReturn="Bachelor of Computer Science (B.C.Sc.(High Performance Computing))";
    	else if(major_s.contains("5CT(NWK)"))
    		strReturn="Bachelor of Computer Technology (B.C.Sc.(Networking Engineering))"; 
        else if(major_s.contains("5CT(ESY)"))
        	strReturn="Bachelor of Computer Technology (B.C.Sc.(Embedded System))"; 		    				 
    		    		    	
			
		return strReturn;
	}




	@FXML
    void cbo_Major_Act(ActionEvent event) {
    	Set<String> setNrc=new HashSet();
		
    	String major=cbo_Major.getSelectionModel().getSelectedItem().toString().trim();
    	String AceYear=cbo_Aceyear.getSelectionModel().getSelectedItem().toString().trim();
    	
    	if(major==null  || AceYear==null)
    	{
    		return ;
    	}
    	
    	
    	System.out.println(AceYear+"\t"+major);
    	
    	/*
    	 * 
    	 * Search Nrc
    	 */
    	int i=0;
    	System.out.println(arlStu_DATA_all.size());
    	for(Obj_stu_profile_all objTemp : arlStu_DATA_all)
		{
    		if(objTemp.getStu().getMajor_s().trim().equalsIgnoreCase(major) && !objTemp.getHistory().getFinal1_s().trim().equalsIgnoreCase("-"))
    		{
    			System.out.println(i++);
    			setNrc.add(objTemp.getStu().getNrc_s().trim());
    		}
		}
    	
    	
    	cbo_stuNRC.getItems().clear();
    	cbo_stuNRC.getItems().addAll(setNrc);
    	

    }

    
    
    @FXML
    void cbo_stuNRC_Act(ActionEvent event) {
    	

    }


}
