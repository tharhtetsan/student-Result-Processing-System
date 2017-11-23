package SampleData;

import model.ObjectReferences.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import controller.DB.*;
import controller.fileReadWrite.ExcelData;
import controller.fileReadWrite.ExcelData_row_col;
import controller.fileReadWrite.ExcelReadWrite;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Add_stu extends Application{

	
	private static FileChooser fileChooser;
	static Quaries db;
	 private static ExcelReadWrite ExcelreadWrite;
	 private static ArrayList<ExcelData_row_col> arl_excelData;
	 private static ArrayList excelData;
	 
	
	static  ArrayList<Obj_histroy>  ObjHistroy=new ArrayList();
	static  ArrayList<Obj_stu_profile> ObjStuProfile=new ArrayList();
	static ArrayList<Obj_stu_parent>ObjParent=new ArrayList();
	 
	public static void main(String args[])
	{
		db=new Quaries();
		Application.launch(args);
		
		
	}
	
	
	
	
	private static  void SetData_toTalbes_History(ArrayList<ExcelData_row_col> arl_excelData) {
		
		excelData=new ArrayList<>();
		
		for(ExcelData_row_col tempObj : arl_excelData)
		{
				ArrayList<ExcelData>  Obj=tempObj.getExcel_data();
				
				Obj_histroy his=new Obj_histroy();
				his.setId_s(Obj.get(0).getValue());
				his.setRollRecord_s(Obj.get(1).getValue());
				his.setFirstyear1_s(Obj.get(2).getValue());
				his.setFirstyear2_s(Obj.get(3).getValue());
				his.setSecondyear1_s(Obj.get(4).getValue());
				his.setSecondyear2_s(Obj.get(5).getValue());
				his.setThirdyear1_s(Obj.get(6).getValue());
				his.setThirdyear2_s(Obj.get(7).getValue());
				his.setFourthyear1_s(Obj.get(8).getValue());
				his.setFourthyear2_s(Obj.get(9).getValue());
				his.setFinal1_s(Obj.get(10).getValue());
				his.setRepeatorId_s(Obj.get(11).getValue());
				
				
				
				
			ObjHistroy.add(his);
		}
	}


private static  void SetData_toTalbes_Student(ArrayList<ExcelData_row_col> arl_excelData) {
		
		excelData=new ArrayList<>();
		
		for(ExcelData_row_col tempObj : arl_excelData)
		{
				ArrayList<ExcelData>  Obj=tempObj.getExcel_data();
				
				Obj_stu_profile stu=new Obj_stu_profile();
				stu.setStuId_s(Obj.get(0).getValue());
				stu.setStuName_s(Obj.get(1).getValue());
				stu.setBirthDate_s(Obj.get(2).getValue());
				stu.setGender_s(Obj.get(3).getValue());
				stu.setCurrentCourseId_s(Obj.get(4).getValue());
				stu.setCurrentRoll_s(Obj.get(5).getValue());
				stu.setAddress_s(Obj.get(6).getValue());
				stu.setNrc_s(Obj.get(7).getValue());
				stu.setYear_s(Obj.get(8).getValue());
				stu.setMajor_s(Obj.get(9).getValue());
				stu.setEmail_s(Obj.get(10).getValue());
				stu.setPhno_s(Obj.get(11).getValue());
				stu.setStartDate_s(Obj.get(12).getValue());
				stu.setImgName_s(Obj.get(13).getValue());
				
				ObjStuProfile.add(stu);
			
		}
	}

private static  void SetData_toTalbes_Parent(ArrayList<ExcelData_row_col> arl_excelData) {
	
	excelData=new ArrayList<>();
	
	for(ExcelData_row_col tempObj : arl_excelData)
	{
			ArrayList<ExcelData>  Obj=tempObj.getExcel_data();
			
			Obj_stu_parent par=new Obj_stu_parent();
			
			par.setParentid(Obj.get(0).getValue());
			par.setFather_name(Obj.get(1).getValue());
			par.setFather_nrc(Obj.get(2).getValue());
			par.setMother_name(Obj.get(3).getValue());
			par.setMother_nrc(Obj.get(4).getValue());
			par.setParent_address(Obj.get(5).getValue());
			par.setParent_phno(Obj.get(6).getValue());
			
			
			ObjParent.add(par);
		
	}
}



	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		fileChooser=new FileChooser();
		fileChooser.setTitle("Open Excel File");
		fileChooser.getExtensionFilters().clear();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Excel  File", "*.xlsx","*.xls"));
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null)
		{	
			try {
				
				ExcelreadWrite=new ExcelReadWrite(file.getAbsolutePath());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
			arl_excelData=ExcelreadWrite.ReadExcel_by_Col_index(14);
			SetData_toTalbes_Student(arl_excelData);
		}
		else
		{
			System.out.println("Error  in file choosing");
		}
		
		
		
		
		fileChooser=new FileChooser();
		fileChooser.setTitle("Open Excel File");
		fileChooser.getExtensionFilters().clear();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Excel  File", "*.xlsx","*.xls"));
		File file1 = fileChooser.showOpenDialog(new Stage());
		if (file != null)
		{	
			try {
				
				ExcelreadWrite=new ExcelReadWrite(file1.getAbsolutePath());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
			arl_excelData=ExcelreadWrite.ReadExcel_by_Col_index(7);
			SetData_toTalbes_Parent(arl_excelData);
		}
		else
		{
			System.out.println("Error  in file choosing");
		}
		
		
		
		
		
		
		
		fileChooser=new FileChooser();
		fileChooser.setTitle("Open Excel File");
		fileChooser.getExtensionFilters().clear();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Excel  File", "*.xlsx","*.xls"));
		File file2 = fileChooser.showOpenDialog(new Stage());
		if (file != null)
		{	
			try {
				
				ExcelreadWrite=new ExcelReadWrite(file2.getAbsolutePath());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
			arl_excelData=ExcelreadWrite.ReadExcel_by_Col_index(12);
			SetData_toTalbes_History(arl_excelData);
		}
		else
		{
			System.out.println("Error  in file choosing");
		}
		
		
		
		System.out.println(ObjHistroy.size());
		System.out.println(ObjStuProfile.size());
		System.out.println(ObjParent.size());
		
		for(int i=0;i<ObjHistroy.size();i++)
		{
			Obj_histroy  ObjHistroy1=ObjHistroy.get(i);
			Obj_stu_profile ObjStuProfile1=ObjStuProfile.get(i);
			Obj_stu_parent ObjParent1=ObjParent.get(i);
			db.AddNewStudent(ObjHistroy1,ObjParent1,ObjStuProfile1);
			System.out.println(ObjHistroy1.getFinal1_s());
		}
		
		
	}

}
