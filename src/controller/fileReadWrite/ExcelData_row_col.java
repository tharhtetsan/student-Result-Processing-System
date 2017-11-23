package controller.fileReadWrite;

import java.util.ArrayList;

public class ExcelData_row_col {
	private ArrayList<ExcelData>  Excel_data;
	
	public ExcelData_row_col(ArrayList arl_Excel_data)
	{
		this.Excel_data=arl_Excel_data;
	}

	public ArrayList<ExcelData> getExcel_data() {
		return Excel_data;
	}

	public void setExcel_data(ArrayList<ExcelData> excel_data) {
		Excel_data = excel_data;
	}
	
}
