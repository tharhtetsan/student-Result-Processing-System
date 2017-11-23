package model.ObjectReferences;

public class Obj_db_Course_profile {

	private String courseId;
	private String refName;
	private String date;
	private String aim;
	private String trName;
	private String name;
	private String forYear;
	
	
	public Obj_db_Course_profile()
	{
		
	}
	public Obj_db_Course_profile(String id,String Name,String Date,String refName,String trName,String Aim,String foryear)
	{
		this.courseId=id;
		this.name=Name;
		this.date=Date;
		this.refName=refName;
		this.aim=Aim;
		this.forYear=foryear;
		this.trName=trName;
	}
	
	public String getForYear() {
		return forYear;
	}
	public void setForYear(String forYear) {
		this.forYear = forYear;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAim() {
		return aim;
	}
	public void setAim(String aim) {
		this.aim = aim;
	}
	public String getTrName() {
		return trName;
	}
	public void setTrName(String trName) {
		this.trName = trName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
