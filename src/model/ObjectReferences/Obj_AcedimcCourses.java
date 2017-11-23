package model.ObjectReferences;

import java.util.ArrayList;

public class Obj_AcedimcCourses {
	
	private String id;
	private String year;
	private String foryear;
	private ArrayList<String> courseid;
	
	public Obj_AcedimcCourses()
	{
		
	}
	
	public Obj_AcedimcCourses(String id,String year,String foryear,ArrayList<String> courseid)
	{
		this.id=id;
		this.year=year;
		this.foryear=foryear;
		this.courseid=courseid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getForyear() {
		return foryear;
	}

	public void setForyear(String foryear) {
		this.foryear = foryear;
	}

	public ArrayList<String> getCourseid() {
		return courseid;
	}

	public void setCourseid(ArrayList<String> courseid) {
		this.courseid = courseid;
	}



}
