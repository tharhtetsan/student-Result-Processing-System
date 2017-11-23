package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_Result_View_tb {

	
	private StringProperty  stuid;
	private StringProperty name;
	private StringProperty sub1_1;
	private StringProperty sub1_2;
	private StringProperty sub1_3;
	private StringProperty sub1_4;
	private StringProperty sub1_5;
	private StringProperty sub1_6;
	private StringProperty isPass;
	
	public Obj_Result_View_tb()
	{
		
	}
	
	public Obj_Result_View_tb(String id,String name,String sub1,String sub2,String sub3,String sub4,String sub5,String sub6,String pass)
	{
		this.stuid=new SimpleStringProperty(id);
		this.name=new SimpleStringProperty(name);
		this.sub1_1=new SimpleStringProperty(sub1);
		this.sub1_2=new SimpleStringProperty(sub2);
		this.sub1_3=new SimpleStringProperty(sub3);
		this.sub1_4=new SimpleStringProperty(sub4);
		this.sub1_5=new SimpleStringProperty(sub5);
		this.sub1_6=new SimpleStringProperty(sub6);
		this.isPass=new SimpleStringProperty(pass);
		
	}

	public StringProperty getStuid() {
		return stuid;
	}

	public void setStuid(StringProperty stuid) {
		this.stuid = stuid;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getSub1_1() {
		return sub1_1;
	}

	public void setSub1_1(StringProperty sub1_1) {
		this.sub1_1 = sub1_1;
	}

	public StringProperty getSub1_2() {
		return sub1_2;
	}

	public void setSub1_2(StringProperty sub1_2) {
		this.sub1_2 = sub1_2;
	}

	public StringProperty getSub1_3() {
		return sub1_3;
	}

	public void setSub1_3(StringProperty sub1_3) {
		this.sub1_3 = sub1_3;
	}

	public StringProperty getSub1_4() {
		return sub1_4;
	}

	public void setSub1_4(StringProperty sub1_4) {
		this.sub1_4 = sub1_4;
	}

	public StringProperty getSub1_5() {
		return sub1_5;
	}

	public void setSub1_5(StringProperty sub1_5) {
		this.sub1_5 = sub1_5;
	}

	public StringProperty getSub1_6() {
		return sub1_6;
	}

	public void setSub1_6(StringProperty sub1_6) {
		this.sub1_6 = sub1_6;
	}

	public StringProperty getIsPass() {
		return isPass;
	}

	public void setIsPass(StringProperty isPass) {
		this.isPass = isPass;
	}
	
	
	
	
	
	
}
