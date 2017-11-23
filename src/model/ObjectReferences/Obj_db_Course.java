package model.ObjectReferences;

import java.sql.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_db_Course {

	
	private String id;
	private String stuid;
	private String fMark;
	private String fGrade;
	private String aceId;

	

	public String getAceId() {
		return aceId;
	}

	public void setAceId(String aceId) {
		this.aceId = aceId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getfMark() {
		return fMark;
	}

	public void setfMark(String fMark) {
		this.fMark = fMark;
	}

	public String getfGrade() {
		return fGrade;
	}

	public void setfGrade(String fGrade) {
		this.fGrade = fGrade;
	}

	public Obj_db_Course()
	{
		
	}
	
	public Obj_db_Course(String Id,String Stuid,String fmark,String fgrade,String aceID)
	{
	
		this.id=Id;
		this.stuid=Stuid;
		this.fMark=fmark;
		this.fGrade=fgrade;
		this.aceId=aceID;

	}


	
	
	
	
}
