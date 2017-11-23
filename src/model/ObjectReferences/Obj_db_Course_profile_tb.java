package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_db_Course_profile_tb {
	
	private StringProperty courseId;
	private StringProperty refName;
	private StringProperty date;
	private StringProperty aim;
	private StringProperty trName;
	private StringProperty name;
	private StringProperty forYear;
	
	
	public Obj_db_Course_profile_tb()
	{
		
	}

	public Obj_db_Course_profile_tb(String id,String ref,String Date,String Aim,String Trname,String Name,String year)
	{
		this.courseId=new SimpleStringProperty(id);
		this.refName=new SimpleStringProperty(ref);
		this.date=new SimpleStringProperty(Date);
		this.aim=new SimpleStringProperty(Aim);
		this.trName=new SimpleStringProperty(Trname);
		this.name=new SimpleStringProperty(Name);
		this.forYear=new SimpleStringProperty(year);
		
	}

	public StringProperty getCourseId() {
		return courseId;
	}

	public void setCourseId(StringProperty courseId) {
		this.courseId = courseId;
	}

	public StringProperty getRefName() {
		return refName;
	}

	public void setRefName(StringProperty refName) {
		this.refName = refName;
	}

	public StringProperty getDate() {
		return date;
	}

	public void setDate(StringProperty date) {
		this.date = date;
	}

	public StringProperty getAim() {
		return aim;
	}

	public void setAim(StringProperty aim) {
		this.aim = aim;
	}

	public StringProperty getTrName() {
		return trName;
	}

	public void setTrName(StringProperty trName) {
		this.trName = trName;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getForYear() {
		return forYear;
	}

	public void setForYear(StringProperty forYear) {
		this.forYear = forYear;
	}
	
	
	
	
}
