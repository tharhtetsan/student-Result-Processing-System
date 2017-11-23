package view.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import view.UI_relatives.*;
import controller.DB.*;
import model.ObjectReferences.*;
public class Result_list_Controller implements Initializable{


	 @FXML
	    private BarChart<?, ?> bar_chart_main;

	    @FXML
	    private AreaChart<?, ?> Area_Chart_1;

	    @FXML
	    private CategoryAxis CategoryAxis_main;

	    @FXML
	    private NumberAxis NumverAxis_main;

	    @FXML
	    private PieChart Pie_Chart_1;

	    @FXML
	    private AreaChart<?, ?> Area_Chart_2;

	    @FXML
	    private CategoryAxis CategoryAxis_main1;

	    @FXML
	    private NumberAxis NumverAxis_main1;

	    @FXML
	    private PieChart Pie_Chart_2;

	    @FXML
	    private AreaChart<?, ?> Area_Chart_3;

	    @FXML
	    private CategoryAxis CategoryAxis_main2;

	    @FXML
	    private NumberAxis NumverAxis_main2;

	    @FXML
	    private PieChart Pie_Chart_3;

	    @FXML
	    private AreaChart<?, ?> Area_Chart_4;

	    @FXML
	    private CategoryAxis CategoryAxis_main3;

	    @FXML
	    private NumberAxis NumverAxis_main3;

	    @FXML
	    private PieChart Pie_Chart_4;

	    @FXML
	    private AreaChart<?, ?> Area_Chart_5;

	    @FXML
	    private CategoryAxis CategoryAxis_main4;

	    @FXML
	    private NumberAxis NumverAxis_main4;

	    @FXML
	    private PieChart Pie_Chart_5;

	
	    
	    Quaries db;
	    private static ArrayList<Obj_db_Define_Course> arlDB_definCourse;
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		db=new Quaries(1);
		
		/*
		 * get all ACE couse data
		 */
		  arlDB_definCourse=db.get_Define_Course_Data();
		ArrayList<Obj_Course_profile> arlDATA_first=new ArrayList();
		ArrayList<Obj_Course_profile> arlDATA_second=new ArrayList();
		ArrayList<Obj_Course_profile> arlDATA_third=new ArrayList();
		ArrayList<Obj_Course_profile> arlDATA_fourth=new ArrayList();
		ArrayList<Obj_Course_profile> arlDATA_final=new ArrayList();
		
		
		/*
		 * get learn course from db by year;
		 */
		ArrayList<Obj_db_Define_Course> firstYear=db.get_AceCourse_by_year("First year");
		ArrayList<Obj_db_Define_Course> secondYear=db.get_AceCourse_by_year("Second year");
		ArrayList<Obj_db_Define_Course> thirdYear=db.get_AceCourse_by_year("Third year");
		ArrayList<Obj_db_Define_Course> fourthYear=db.get_AceCourse_by_year("Fourth year");
		ArrayList<Obj_db_Define_Course> finalYear=db.get_AceCourse_by_year("Final year");
		
		
		System.out.println(">>>>>>>>???????");
		
		System.out.println(firstYear.size());
		System.out.println(secondYear.size());
		System.out.println(thirdYear.size());
		System.out.println(fourthYear.size());
		System.out.println(fourthYear.size());
		System.out.println(finalYear.size());
		
		
		/*
		 * for learn couses id
		 */
		Set<String> setFirstYearCouseId=new HashSet();
		Set<String> setSecondYearCouseId=new HashSet();
		Set<String> setThirdYearCouseId=new HashSet();
		Set<String> setFourthYearCouseId=new HashSet();
		Set<String> setFinalYearCouseId=new HashSet();
		
		
		
		
		/*
		 * choose course id by year
		 */
		if(firstYear.size()!=0)
		{
			for(Obj_db_Define_Course obj : firstYear)
			{
				String strCourseIds[]=obj.getCourseId().split("[',']");
				for(String  courseId:strCourseIds)
					setFirstYearCouseId.add(courseId);
			}
		}
		
		
		if(secondYear.size()!=0)
		{
			for(Obj_db_Define_Course obj : firstYear)
			{
				String strCourseIds[]=obj.getCourseId().split("[',']");
				for(String  courseId:strCourseIds)
					setSecondYearCouseId.add(courseId);
			}
		}
		
		
		
		if(thirdYear.size()!=0)
		{
			for(Obj_db_Define_Course obj : firstYear)
			{
				String strCourseIds[]=obj.getCourseId().split("[',']");
				for(String  courseId:strCourseIds)
					setThirdYearCouseId.add(courseId);
			}
		}
		
		
		if(fourthYear.size()!=0)
		{
			for(Obj_db_Define_Course obj : firstYear)
			{
				String strCourseIds[]=obj.getCourseId().split("[',']");
				for(String  courseId:strCourseIds)
					setFourthYearCouseId.add(courseId);
			}
		}
		
		
		if(finalYear.size()!=0)
		{
			for(Obj_db_Define_Course obj : firstYear)
			{
				String strCourseIds[]=obj.getCourseId().split("[',']");
				for(String  courseId:strCourseIds)
					setFinalYearCouseId.add(courseId);
			}
		}
		
		
		
		
		
		/*
		 * learn couses
		 */
		Set<String> setFirstYearCouseREF=new HashSet();
		Set<String> setSecondYearCousREF=new HashSet();
		Set<String> setThirdYearCouseREF=new HashSet();
		Set<String> setFourthYearCouseREF=new HashSet();
		Set<String> setFinalYearCouseREF=new HashSet();
		
		
		
		for(String couID : setFirstYearCouseId)
			setFirstYearCouseREF.add(db.get_Course_Data(couID).getRefName().trim());
		
		for(String couID : setSecondYearCouseId)
			setSecondYearCousREF.add(db.get_Course_Data(couID).getRefName().trim());
	
		for(String couID : setThirdYearCouseId)
			setThirdYearCouseREF.add(db.get_Course_Data(couID).getRefName().trim());
	
		for(String couID : setThirdYearCouseId)
			setFourthYearCouseREF.add(db.get_Course_Data(couID).getRefName().trim());
	
		for(String couID : setFinalYearCouseId)
			setFinalYearCouseREF.add(db.get_Course_Data(couID).getRefName().trim());
	
		
		/*
		 * collect all data
		 */
		 ArrayList<Obj_Course_profile> arlSetUpDATA_first = null;
		 ArrayList<Obj_Course_profile> arlSetUpDATA_second=null;
		 ArrayList<Obj_Course_profile> arlSetUpDATA_third=null;
		 ArrayList<Obj_Course_profile> arlSetUpDATA_fourth=null;
		 ArrayList<Obj_Course_profile> arlSetUpDATA_final=null;
						
		 for(String tbName : setFirstYearCouseREF)
			 arlSetUpDATA_first=CollectDATA(tbName);
		 
		 for(String tbName : setSecondYearCousREF)
			 arlSetUpDATA_second=CollectDATA(tbName);
		 
		 for(String tbName : setThirdYearCouseREF)
			 arlSetUpDATA_third=CollectDATA(tbName);
		 
		 for(String tbName : setFourthYearCouseREF)
			 arlSetUpDATA_fourth=CollectDATA(tbName);
		 
		 for(String tbName : setFinalYearCouseREF)
			 arlSetUpDATA_final=CollectDATA(tbName);
		 
		 
		 Set<String> arlBarChart_value_first=new HashSet();
		 Set<String> arlBarChart_value_second=new HashSet();
		 Set<String> arlBarChart_value_third=new HashSet();
		 Set<String> arlBarChart_value_fourth=new HashSet();
		 Set<String> arlBarChart_value_final=new HashSet();
		 
		 Set<String> arlBarChart_year_first=new HashSet();
		 Set<String> arlBarChart_year_second=new HashSet();
		 Set<String> arlBarChart_year_third=new HashSet();
		 Set<String> arlBarChart_year_fourth=new HashSet();
		 Set<String> arlBarChart_year_final=new HashSet();
		 
		 
		 
		 
		 
		 
		 if(arlSetUpDATA_first!=null)
			 Sample_Data_set(arlSetUpDATA_first,"First Year",Area_Chart_1,Pie_Chart_1,arlBarChart_year_first,arlBarChart_value_first);
		
		 if(arlSetUpDATA_second!=null)
			 Sample_Data_set(arlSetUpDATA_second,"Scond Year",Area_Chart_2,Pie_Chart_2,arlBarChart_year_second,arlBarChart_value_second);
		
		 if(arlSetUpDATA_third!=null)
			 Sample_Data_set(arlSetUpDATA_third,"Third Year",Area_Chart_3,Pie_Chart_3,arlBarChart_year_third,arlBarChart_value_third);
		
		 if(arlSetUpDATA_fourth!=null)
			 Sample_Data_set(arlSetUpDATA_fourth,"Fourth Year",Area_Chart_4,Pie_Chart_4,arlBarChart_year_fourth,arlBarChart_value_fourth);
		
		 if(arlSetUpDATA_final!=null)
			 Sample_Data_set(arlSetUpDATA_final,"Final Year",Area_Chart_5,Pie_Chart_5,arlBarChart_year_final,arlBarChart_value_final);
		
		 
		 
		 /*
		  * set barchart
		  */
		 ArrayList<String> arlfirst_year_barchart=new ArrayList();
		 ArrayList<Integer>arlfirst_value_barchart=new ArrayList();
//			
//		 for(String str : arlBarChart_year_first )
//			 arlfirst_year_barchart.add(str);
//		 
//			 for(String str : arlBarChart_value_first )
//			 {
//				 System.out.print(str);
//				 arlfirst_value_barchart.add(Integer.parseInt(str.toString().trim()));
//			 }
			 
		 arlfirst_year_barchart.add("2012-2013");
		 arlfirst_value_barchart.add(69);
		 
		 arlfirst_year_barchart.add("2013-2014");
		 arlfirst_value_barchart.add(67);
		 
		 arlfirst_year_barchart.add("2014-2015");
		 arlfirst_value_barchart.add(75);
		 
		 arlfirst_year_barchart.add("2015-2016");
		 arlfirst_value_barchart.add(50);
		 
		 arlfirst_year_barchart.add("2016-2017");
		 arlfirst_value_barchart.add(66);
		 
			 
		if(arlfirst_year_barchart.size()!=0 && arlfirst_value_barchart.size()!=0 )
			 SetMainBarChart(arlfirst_year_barchart,arlfirst_value_barchart,"First year");
		 
		
		
		 ArrayList<String> arlsecond_year_barchart=new ArrayList();
		 ArrayList<Integer>arlsecond_value_barchart=new ArrayList();
//			
//		 for(String str : arlBarChart_year_second )
//			 arlsecond_year_barchart.add(str);
//		 
//			 for(String str : arlBarChart_value_second )
//			 {
//				 System.out.print(str);
//				 arlsecond_value_barchart.add(Integer.parseInt(str.toString().trim()));
//			 }
		 
		 
		 arlsecond_year_barchart.add("2012-2013");
		 arlsecond_value_barchart.add(0);
		 
		 arlsecond_year_barchart.add("2013-2014");
		 arlsecond_value_barchart.add(60);
		 
		 arlsecond_year_barchart.add("2014-2015");
		 arlsecond_value_barchart.add(77);
		 
		 arlsecond_year_barchart.add("2015-2016");
		 arlsecond_value_barchart.add(58);
		 
		 arlsecond_year_barchart.add("2016-2017");
		 arlsecond_value_barchart.add(78);
		 
		if(arlsecond_year_barchart.size()!=0 && arlsecond_value_barchart.size()!=0 )
			 SetMainBarChart(arlsecond_year_barchart,arlsecond_value_barchart,"Second year");
		 
		
		
		
		 ArrayList<String> arlthird_year_barchart=new ArrayList();
		 ArrayList<Integer>arlthird_value_barchart=new ArrayList();
			
//		 for(String str : arlBarChart_year_third )
//			 arlthird_year_barchart.add(str);
//		 
//			 for(String str : arlBarChart_value_third )
//			 {
//				 System.out.print(str);
//				 arlthird_value_barchart.add(Integer.parseInt(str.toString().trim()));
//			 }
		 
		 arlthird_year_barchart.add("2012-2013");
		 arlthird_value_barchart.add(0);
		 
		 arlthird_year_barchart.add("2013-2014");
		 arlthird_value_barchart.add(0);
		 
		 arlthird_year_barchart.add("2014-2015");
		 arlthird_value_barchart.add(72);
		 
		 arlthird_year_barchart.add("2015-2016");
		 arlthird_value_barchart.add(64);
		 
		 arlthird_year_barchart.add("2016-2017");
		 arlthird_value_barchart.add(65);
			 
		if(arlthird_year_barchart.size()!=0 && arlthird_value_barchart.size()!=0 )
			 SetMainBarChart(arlthird_year_barchart,arlthird_value_barchart,"Third year");
		 
		
		
		 ArrayList<String> arlfourth_year_barchart=new ArrayList();
		 ArrayList<Integer>arlfourth_value_barchart=new ArrayList();
//			
//		 for(String str : arlBarChart_year_fourth )
//			 arlfourth_year_barchart.add(str);
//		 
//			 for(String str : arlBarChart_value_fourth )
//			 {
//				 System.out.print(str);
//				 arlfourth_value_barchart.add(Integer.parseInt(str.toString().trim()));
//			 }
		 
		 
		 arlfourth_year_barchart.add("2012-2013");
		 arlfourth_value_barchart.add(0);
		 
		 arlfourth_year_barchart.add("2013-2014");
		 arlfourth_value_barchart.add(0);
		 
		 arlfourth_year_barchart.add("2014-2015");
		 arlfourth_value_barchart.add(0);
		 
		 arlfourth_year_barchart.add("2015-2016");
		 arlfourth_value_barchart.add(73);
		 
		 arlfourth_year_barchart.add("2016-2017");
		 arlfourth_value_barchart.add(81);
		 
		if(arlfourth_year_barchart.size()!=0 && arlfirst_value_barchart.size()!=0 )
			 SetMainBarChart(arlfourth_year_barchart,arlfirst_value_barchart,"Fourth year");
		 
		
		

		
		 ArrayList<String> arlfinal_year_barchart=new ArrayList();
		 ArrayList<Integer>arlfinal_value_barchart=new ArrayList();
			
//		 for(String str : arlBarChart_year_final )
//			 arlfinal_year_barchart.add(str);
//		 
//			 for(String str : arlBarChart_value_final )
//			 {
//				 System.out.print(str);
//				 arlfinal_value_barchart.add(Integer.parseInt(str.toString().trim()));
//			 }
		 
		 
		 
		 arlfinal_year_barchart.add("2012-2013");
		 arlfinal_value_barchart.add(0);
		 
		 arlfinal_year_barchart.add("2013-2014");
		 arlfinal_value_barchart.add(0);
		 
		 arlfinal_year_barchart.add("2014-2015");
		 arlfinal_value_barchart.add(0);
		 
		 arlfinal_year_barchart.add("2015-2016");
		 arlfinal_value_barchart.add(0);
		 
		 arlfinal_year_barchart.add("2016-2017");
		 arlfinal_value_barchart.add(69);
		 
			 
		if(arlfinal_year_barchart.size()!=0 && arlfinal_value_barchart.size()!=0 )
			 SetMainBarChart(arlfinal_year_barchart,arlfinal_value_barchart,"Final Year");
		 
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	private ArrayList<Obj_Course_profile> CollectDATA(String tbName) {
		
		
		ArrayList<Obj_db_Course> SelectedCourseDATA=db.get_Create_CourseDATA(tbName.trim());
		   
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
			 
		   int totalPass=0;
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
			  }
			   
			   totalPass+=pass;
		   }
		   
		  return arlSetUpDATA;
		   
	}







	public void Sample_Data_set(ArrayList<Obj_Course_profile> arl,String name,AreaChart Area_Chart,PieChart pieChart,Set<String> Setyear,Set<String> SetValue)
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
			       
			
				
				sumPass+=temp.getPass_s();
				sumTotal+=temp.getTotal_s();
				sumDestination+=temp.getDestination_s();
				sumFail+=temp.getFail_s();
				
				Setyear.add(temp.getYears_s().trim());
			
			}
			
			Area_Chart.getData().add(series);	//add data to area chart	
	        
		
		 	
			double perDest=(sumDestination/sumTotal)*100;
			double perPass=(sumPass/sumTotal)*100;
			double perFail=(sumFail/sumTotal)*100;
			String LabelDest=String.format("Distinction- %.2f ", perDest);
			String LabelPass=String.format("Pass- %.2f ", perPass); 
			String LabelFail=String.format("Fail- %.2f ", perFail);
			
			
			
		   ObservableList<PieChart.Data> pieChartData = 
	                FXCollections.observableArrayList(
	                    new PieChart.Data(LabelDest,perDest),
	                    new PieChart.Data(LabelPass,perPass),
	                    new PieChart.Data(LabelFail,perFail)
	                    );
	                   
	      
		   pieChart.setTitle("Overall Condition");
		   pieChart.setData(pieChartData);
		   pieChart.setLabelsVisible(true);
		   
		   int value=(int) perPass;
		   SetValue.add(value+"");
	 }
	
	
	
	
	
	
	
	
	
	
	
	public void SetMainBarChart(ArrayList<String> year_1,ArrayList<Integer> count_1,String Name)
	{
		
		
		XYChart.Series series = new XYChart.Series();
        series.setName(Name);
	     for(int a=0;a<year_1.size();a++)
	     {
	    	 
	    	   series.getData().add(new XYChart.Data(year_1.get(a),count_1.get(a)));
	     }   
	       
	     bar_chart_main.getData().add(series);
	}
	
	 
	  
	  
	   public void SetAreaChartData(AreaChart areaChart,XYChart.Series series)
		{
		     areaChart.getData().add(series);
	    }
	   
	   public void SetBarChartData(BarChart barChart,XYChart.Series series)
		{
		     barChart.getData().add(series);
	    }
	   
	
	   
	   
	   public XYChart.Series Marke_Series(ArrayList arl_XY_Data)
		{
				XYChart.Series series = new XYChart.Series();
		    for(int i=0;i<arl_XY_Data.size();i++)
		       {
		        	 series.getData().add(arl_XY_Data.get(i));
		      }
		return series;
		}
		   
	   
	   public ArrayList Make_Chart_XY_Data_(ArrayList<Obj_Area_chart> arl_data)
	   {
		   ArrayList<XYChart.Data> arl_Return=new ArrayList();
		   
		   for(Obj_Area_chart Obj: arl_data)
		   {
			   arl_Return.add(new XYChart.Data(Obj.getxValue(),Obj.getyValue()));
		   }
		   
		   return arl_Return;
		   
	   }
	   
	   
	

}
