package PDF_tamplates;

import java.util.ArrayList;

import model.ObjectReferences.Obj_resultGenerate_marks;

public class Obj_result {

	private String sutName;
	private String roll;
	private String year;
	private String ExamYear;
	private String isPass;
	private String date;
	
	
	public Obj_result()
	{
		
	}
	
	public Obj_result(String name,String Roll,String Year,String ExYear,String Pass,String Date)
	{
		this.sutName=name;
		this.roll=Roll;
		this.year=Year;
		this.ExamYear=ExYear;
		this.isPass=Pass;
		this.date=Date;
	}

	public String getSutName() {
		return sutName;
	}

	public void setSutName(String sutName) {
		this.sutName = sutName;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getExamYear() {
		return ExamYear;
	}

	public void setExamYear(String examYear) {
		ExamYear = examYear;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
