package view.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.scene.chart.PieChart.Data;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import controller.DB.*;
import model.ObjectReferences.*;




public class Course_profile_Controller implements Initializable{

	  @FXML
	    private Text txt_title;
	
	  	@FXML
	    private TableView<Obj_Course_profile> tb_view_sub;

	    @FXML
	    private TableColumn<Obj_Course_profile, String> col_Acedimic_year;

	    @FXML
	    private TableColumn<Obj_Course_profile, Number> col_Pass;

	    @FXML
	    private TableColumn<Obj_Course_profile, Number> col_Fail;

	    @FXML
	    private TableColumn<Obj_Course_profile, Number> Col_Destination;

	    @FXML
	    private TableColumn<Obj_Course_profile, Number> col_total;

	    @FXML
	    private TableColumn<Obj_Course_profile, String> col_percent;

	    @FXML
	    private PieChart Pie_chart_sub;

	    @FXML
	    private AreaChart<?, ?> AreaChart_main;

	    @FXML
	    private CategoryAxis CategoryAxis_main;

	    @FXML
	    private NumberAxis NumverAxis_main;

	    @FXML
	    private PieChart Pie_chart_main;
	 
	    
	    private ObservableList<Obj_Course_profile> items1 = FXCollections.observableArrayList();

	    private static ArrayList<Obj_db_Define_Course> arlDB_definCourse;
	    private Quaries db;
	    
	    private static Obj_db_Course_profile selectedCourse;
	    
	    
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
		
		   db=new Quaries(1);
		   arlDB_definCourse=db.get_Define_Course_Data();
		   selectedCourse=Course_listView_Controller.getSelectedCourse();
		   
		   Intialize_Cols();
		 
		   
		   SetDATA_db(selectedCourse);
		
	}
	   
	   
	   
	   
	   private void SetDATA_db(Obj_db_Course_profile selectedCourse2) {
		
		   String tb_Name=selectedCourse.getRefName();
		   
		   ArrayList<Obj_db_Course> SelectedCourseDATA=db.get_Create_CourseDATA(tb_Name.trim());
		   
		   /*
		    * set add ace year
		    */
		   HashMap<String,String> hashACEyears_all=new HashMap();
		   for(Obj_db_Define_Course objTemp : arlDB_definCourse)
		   {
			   hashACEyears_all.put(objTemp.getId(), objTemp.getAcedimic_year());
		   }
		   
		   /*
		    * choose ace year
		    */
		   HashMap<String,String> hashACEyears_cou=new HashMap();
		   Set<String>	setACEid=new HashSet();
		   for(Obj_db_Course objTemp :SelectedCourseDATA)
		   {
			   String key=objTemp.getAceId();
			   setACEid.add(key);
			   hashACEyears_cou.put(key, hashACEyears_all.get(key));
		   }
		  //System.out.println(hashACEyears_cou+"\t"+setACEid);
		   ArrayList<Obj_Course_profile> arlSetUpDATA=new ArrayList<>();
			  
		   for(String ACE_ID : setACEid)
		   {
			   int pass=0;
			   int fail=0;
			   int destination=0;
			   
			   for(Obj_db_Course objTemp :SelectedCourseDATA)
			   {
				   if(objTemp.getAceId().trim().equalsIgnoreCase(ACE_ID))
				   {
					  int mark=Integer.parseInt(objTemp.getfMark());
					  if(mark<50)
					  {
						  fail++;
					  }
					  else
					  {
						  pass++;
					  }
					  
					  
					  if(mark>=80)
					  {
						  destination++;
					  }
				   }
				   
				   Obj_Course_profile objDATA=new Obj_Course_profile(hashACEyears_cou.get(ACE_ID),pass,fail,destination,0,"%");
				   arlSetUpDATA.add(objDATA);   
				   System.out.println(ACE_ID+">>>>>????"+pass+"\t"+fail+"\t"+destination);
			   }
			   
			   
		   }
		   
		   Sample_Data_set(arlSetUpDATA,selectedCourse.getName());
		   
		   
	   }




	public void Sample_Data_set(ArrayList<Obj_Course_profile> arl,String name)
		{
			String str=name;
			XYChart.Series series = new XYChart.Series();
	        series.setName(str);
	         
		   
		 
			
			double sumPass=0;
			double sumTotal=0;
			double sumDestination=0;
			double sumFail=0;
			for(int i=0;i < arl.size();i++)
			{
				Obj_Course_profile temp=arl.get(i);
				temp.setTotal_s(temp.getPass_s()+temp.getFail_s());
				
				double percent=((double)temp.getPass_s()/temp.getTotal_s())*100;
				
				String per=String.format("%.2f ", percent);
				temp.setPercentage_s(per);
				
				/*
				 * add data to area chat series
				 */
				series.getData().add(new XYChart.Data(temp.getYears_s(),percent));
			       
				items1.add(temp);
				
				sumPass+=temp.getPass_s();
				sumTotal+=temp.getTotal_s();
				sumDestination+=temp.getDestination_s();
				sumFail+=temp.getFail_s();
				
			}
			
			tb_view_sub.setItems(items1); //add data to table
			AreaChart_main.getData().add(series);	//add data to area chart	
	        
		
		 	
			double perDest=(sumDestination/sumTotal)*100;
			double perPass=(sumPass/sumTotal)*100;
			double perFail=(sumFail/sumTotal)*100;
			  
			System.out.println(((double)sumPass/510)*100+"\t"+sumFail+"\t"+sumDestination+"\t"+sumTotal);
		
			System.out.println(perDest+"\t"+perPass+"\t"+perFail);
			String LabelDest=String.format("Distinction- %.2f ", perDest);
			String LabelPass=String.format("Pass- %.2f ", perPass); 
			String LabelFail=String.format("Fail- %.2f ", perFail);
		   ObservableList<PieChart.Data> pieChartData = 
	                FXCollections.observableArrayList(
	                    new PieChart.Data(LabelDest,perDest),
	                    new PieChart.Data(LabelPass,perPass),
	                    new PieChart.Data(LabelFail,perFail)
	                    );
	                   
	      
	       Pie_chart_main.setTitle("Overall Conducation");
	        Pie_chart_main.setData(pieChartData);
	        Pie_chart_main.setLabelsVisible(true);
	   }
		
	   public void  Intialize_Cols()
		{
			//Course tb repare;
					col_Acedimic_year.setCellValueFactory(cellData -> cellData.getValue().getYears());
					col_Pass.setCellValueFactory(cellData -> cellData.getValue().getPass());
					col_Fail.setCellValueFactory(cellData -> cellData.getValue().getFail());
					Col_Destination.setCellValueFactory(cellData -> cellData.getValue().getDestination());
					col_total.setCellValueFactory(cellData -> cellData.getValue().getTotal());
					col_percent.setCellValueFactory(cellData -> cellData.getValue().getPercentage());
					
		}
	   
	   
	   
	   
	   
}
