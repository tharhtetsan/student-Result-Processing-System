package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_stu_profile extends Obj_stu_about{

	private StringProperty Id;
	private StringProperty stuName;
	private StringProperty BirthDate;
	private StringProperty gender;
	private StringProperty CurrentCourseId;
	private StringProperty CurrentRoll;
	private StringProperty Address;
	private StringProperty Nrc;
	private StringProperty year;
	private StringProperty major;
	private StringProperty email;
	private StringProperty phno;
	private StringProperty startDate;
	private StringProperty imgName;
	
	
	
	
	public void setImgName(StringProperty imgName) {
		this.imgName = imgName;
	}

	public String getImgName_s() {
		return imgName.get();
	}

	public void setImgName_s(String imgName) {
		this.imgName = new SimpleStringProperty(imgName);
	}

	public void setId(StringProperty id) {
		Id = id;
	}

	public Obj_stu_profile()
	{
		super("","","","");
	}
	
	public Obj_stu_profile(String aboutid,String parentid,String historyid,String id,String name,String birthday,String gender,String Courseid,String roll,String address,String nrc,String year,String major,String email,String phno,String startDate,String img)
	{
		super(aboutid,id,parentid,historyid);
		
		
		this.Id=new SimpleStringProperty(id);
		
		this.stuName=new SimpleStringProperty(name);
		this.BirthDate=new SimpleStringProperty(birthday);
		this.gender=new SimpleStringProperty(gender);
		this.CurrentCourseId=new SimpleStringProperty(Courseid);
		this.CurrentRoll=new SimpleStringProperty(roll);
		this.Address=new SimpleStringProperty(address);
		this.Nrc=new SimpleStringProperty(nrc);
		this.email=new SimpleStringProperty(email);
		this.phno=new SimpleStringProperty(phno);
		this.startDate=new SimpleStringProperty(startDate);
		this.year=new SimpleStringProperty(year);
		this.major=new SimpleStringProperty(major);
		this.imgName=new SimpleStringProperty(img);
	}
	
	
	
	

	
	public void setStuId(StringProperty stuId) {
		this.Id = stuId;
	}
	
	public void setStuName(StringProperty stuName) {
		this.stuName = stuName;
	}

	public void setBirthDate(StringProperty birthDate) {
		BirthDate = birthDate;
	}

	public void setGender(StringProperty gender) {
		this.gender = gender;
	}
	
	public void setCurrentCourseId(StringProperty currentCourseId) {
		CurrentCourseId = currentCourseId;
	}
	
	public void setCurrentRoll(StringProperty currentRoll) {
		CurrentRoll = currentRoll;
	}
	
	public void setAddress(StringProperty address) {
		Address = address;
	}
	
	public void setNrc(StringProperty nrc) {
		Nrc = nrc;
	}

	public void setYear(StringProperty bEHS_id) {
		year = bEHS_id;
	}
	
	public void setMajor(StringProperty bEHS_mark) {
		major = bEHS_mark;
	}
	
	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public void setPhno(StringProperty phno) {
		this.phno = phno;
	}
	
	public void setStartDate(StringProperty startDate) {
		this.startDate = startDate;
	}
	

	
	public StringProperty getId() {
		return Id;
	}
	public StringProperty getCurrentCourseId() {
		return CurrentCourseId;
	}
	public StringProperty getCurrentRoll() {
		return CurrentRoll;
	}
	public StringProperty getStartDate() {
		return startDate;
	}
	public StringProperty getEmail() {
		return email;
	}
	public StringProperty getPhno() {
		return phno;
	}
	public StringProperty getMajor() {
		return major;
	}
	public StringProperty getYear() {
		return year;
	}
	public StringProperty getNrc() {
		return Nrc;
	}
	public StringProperty getAddress() {
		return Address;
	}
	
	public StringProperty getGender() {
		return gender;
	}
	public StringProperty getBirthDate() {
		return BirthDate;
	}
	public StringProperty getStuName() {
		return stuName;
	}
	
	
	
	
	public void setStuId_s(String stuId) {
		this.Id=new SimpleStringProperty(stuId);
	}
	
	public void setStuName_s(String stuName) {
		this.stuName=new SimpleStringProperty(stuName);
	}

	public void setBirthDate_s(String birthDate) {
		BirthDate=new SimpleStringProperty(birthDate);
	}

	public void setGender_s(String gender) {
		this.gender=new SimpleStringProperty(gender);
	}
	
	public void setCurrentCourseId_s(String currentCourseId) {
		CurrentCourseId=new SimpleStringProperty(currentCourseId);
	}
	
	public void setCurrentRoll_s(String currentRoll) {
		CurrentRoll=new SimpleStringProperty(currentRoll);
	}
	
	public void setAddress_s(String address) {
		Address=new SimpleStringProperty(address);
	}
	
	public void setNrc_s(String nrc) {
		Nrc=new SimpleStringProperty(nrc);
	}

	public void setYear_s(String bEHS_id) {
		year=new SimpleStringProperty(bEHS_id);
	}
	
	public void setMajor_s(String bEHS_mark) {
		major =new SimpleStringProperty(bEHS_mark);
	}
	
	public void setEmail_s(String email) {
		this.email =new SimpleStringProperty(email);
	}

	public void setPhno_s(String phno) {
		this.phno =new SimpleStringProperty(phno);
	}
	
	public void setStartDate_s(String startDate) {
		this.startDate =new SimpleStringProperty(startDate);
	}
	
	
	
	
	
	public String getStuId_s() {
		return Id.get();
	}
	public String getCurrentCourseId_s() {
		return CurrentCourseId.get();
	}
	public String getCurrentRoll_s() {
		return CurrentRoll.get();
	}
	public String getStartDate_s() {
		return startDate.get();
	}
	public String getEmail_s() {
		return email.get();
	}
	public String getPhno_s() {
		return phno.get();
	}
	public String getMajor_s() {
		return major.get();
	}
	public String getYear_s() {
		return year.get();
	}
	public String getNrc_s() {
		return Nrc.get();
	}
	public String getAddress_s() {
		return Address.get();
	}
	
	public String getGender_s() {
		return gender.get();
	}
	public String getBirthDate_s() {
		return BirthDate.get();
	}
	public String getStuName_s() {
		return stuName.get();
	}
	
	
}

