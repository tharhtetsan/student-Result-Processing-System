package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_stu_about {
	
	private StringProperty aboutid;
	private StringProperty stuId;
	private StringProperty ParentId;
	private  StringProperty HistoryId;
	
	
	public Obj_stu_about()
	{
		
	}
	
	public Obj_stu_about(String aboutid,String stuId,String parentId,String HistoryId)
	{
		this.aboutid=new SimpleStringProperty(aboutid);
		this.stuId=new SimpleStringProperty(stuId);
		this.ParentId=new SimpleStringProperty(parentId);
		this.HistoryId=new SimpleStringProperty(HistoryId);
	}


	

	public StringProperty getAboutid() {
		return aboutid;
	}




	public void setAboutid(StringProperty aboutid) {
		this.aboutid = aboutid;
	}




	public StringProperty getParentId() {
		return ParentId;
	}




	public void setParentId(StringProperty parentId) {
		ParentId = parentId;
	}




	public StringProperty getHistoryId() {
		return HistoryId;
	}




	public void setHistoryId(StringProperty historyId) {
		HistoryId = historyId;
	}




	public void setStuId(StringProperty stuId) {
		this.stuId = stuId;
	}




	public String getAboutid_s() {
		return aboutid.get();
	}




	public void setAboutid_s(String aboutid) {
		this.aboutid = new SimpleStringProperty(aboutid);
	}




	public String getStuId() {
		return stuId.get();
	}

	public void setStuId_s(String stuId) {
		this.stuId = new SimpleStringProperty(stuId);
	}

	public String getParentId_s() {
		return ParentId.get();
	}

	public void setParentId_s(String parentId) {
		ParentId =  new SimpleStringProperty(parentId);
	}

	public String getHistoryId_s() {
		return HistoryId.get();
	}

	public void setHistoryId_s(String historyId) {
		HistoryId = new SimpleStringProperty(historyId);
	}
	
	 
	
}
