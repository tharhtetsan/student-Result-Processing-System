package model.ObjectReferences;

public class Obj_db_Define_Course {

	private String id;
	private String foryear;
	private String term;
	private String courseId;
	private String major;
	private String acedimic_year;
	private String isMarkFill;
	
	
	public Obj_db_Define_Course()
	{
		
	}
	public Obj_db_Define_Course(String id,String foryear,String term,String courseId,String Major,String ac_year,String isfill)
	{
		this.id=id;
		this.foryear=foryear;
		this.term=term;
		this.courseId=courseId;
		this.major=Major;
		this.acedimic_year=ac_year;
		this.isMarkFill=isfill;
		
	}
	
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAcedimic_year() {
		return acedimic_year;
	}
	public void setAcedimic_year(String acedimic_year) {
		this.acedimic_year = acedimic_year;
	}
	public String getIsMarkFill() {
		return isMarkFill;
	}
	public void setIsMarkFill(String isMarkFill) {
		this.isMarkFill = isMarkFill;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getForyear() {
		return foryear;
	}
	public void setForyear(String foryear) {
		this.foryear = foryear;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
	
	
	
}
