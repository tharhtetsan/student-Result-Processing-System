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

public class Add_newCourse extends Application{

	
	private static FileChooser fileChooser;
	static Quaries db;
	 private static ExcelReadWrite ExcelreadWrite;
	 private static ArrayList<ExcelData_row_col> arl_excelData;
	 private static ArrayList excelData;
	 
	 
	public static void main(String args[])
	{
		db=new Quaries();
		
		Application.launch(args);
	}
	
	
	
	
	private static  void SetData_toTalbes(ArrayList<ExcelData_row_col> arl_excelData) {
		
		excelData=new ArrayList<>();
		
		for(ExcelData_row_col tempObj : arl_excelData)
		{
				ArrayList<ExcelData>  Obj=tempObj.getExcel_data();
				
				Obj_db_Course_profile couse=new Obj_db_Course_profile();
				couse.setCourseId(Obj.get(0).getValue());
				couse.setName(Obj.get(1).getValue());
				couse.setDate(Obj.get(2).getValue());
				couse.setRefName(Obj.get(3).getValue());
				couse.setTrName(Obj.get(4).getValue());
				couse.setAim(Obj.get(5).getValue());
				couse.setForYear(Obj.get(6).getValue());
				
				db.AddNewCourse(couse);
			
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
			
			 
			arl_excelData=ExcelreadWrite.ReadExcel_by_Col_index(7);
			SetData_toTalbes(arl_excelData);
		}
		else
		{
			System.out.println("Error  in file choosing");
		}
	}

}
