package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_Result_Generate_tb {

	private StringProperty no;
	private StringProperty sub;
	private StringProperty mark;
	private StringProperty grade;
	private StringProperty remark;
	
	
	public Obj_Result_Generate_tb()
	{
		
	}
	
	public Obj_Result_Generate_tb(String No,String Sub,String Mark,String Grade,String Remark)
	{
		this.no=new SimpleStringProperty(No);
		this.sub=new SimpleStringProperty(Sub);
		this.mark=new SimpleStringProperty(Mark);
		this.grade=new SimpleStringProperty(Grade);
		this.remark=new SimpleStringProperty(Remark);
		
	}

	public StringProperty getNo() {
		return no;
	}

	public void setNo(StringProperty no) {
		this.no = no;
	}

	public StringProperty getSub() {
		return sub;
	}

	public void setSub(StringProperty sub) {
		this.sub = sub;
	}

	public StringProperty getMark() {
		return mark;
	}

	public void setMark(StringProperty mark) {
		this.mark = mark;
	}

	public StringProperty getGrade() {
		return grade;
	}

	public void setGrade(StringProperty grade) {
		this.grade = grade;
	}

	public StringProperty getRemark() {
		return remark;
	}

	public void setRemark(StringProperty remark) {
		this.remark = remark;
	}
	
	
}
