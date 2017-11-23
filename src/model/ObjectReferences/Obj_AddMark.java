package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_AddMark {
	
	private StringProperty roll;
	private StringProperty name;
	private StringProperty sub1;
	private StringProperty sub2;
	private StringProperty sub3;
	private StringProperty sub4;
	private StringProperty sub5;
	private StringProperty sub6;
	
	
	public Obj_AddMark()
	{
		
	}
	public Obj_AddMark(String Roll,String Name,String Sub1,String Sub2,String Sub3,String Sub4,String Sub5,String Sub6)
	{
		this.roll=new SimpleStringProperty(Roll);
		this.name=new SimpleStringProperty(Name);
		this.sub1=new SimpleStringProperty(Sub1);
		this.sub2=new SimpleStringProperty(Sub2);
		this.sub3=new SimpleStringProperty(Sub3);
		this.sub4=new SimpleStringProperty(Sub4);
		this.sub5=new SimpleStringProperty(Sub5);
		this.sub6=new SimpleStringProperty(Sub6);
		
	}
	
	
	public StringProperty getRoll() {
		return roll;
	}
	public void setRoll(StringProperty roll) {
		this.roll = roll;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public StringProperty getSub1() {
		return sub1;
	}
	public void setSub1(StringProperty sub1) {
		this.sub1 = sub1;
	}
	public StringProperty getSub2() {
		return sub2;
	}
	public void setSub2(StringProperty sub2) {
		this.sub2 = sub2;
	}
	public StringProperty getSub3() {
		return sub3;
	}
	public void setSub3(StringProperty sub3) {
		this.sub3 = sub3;
	}
	public void setSub4(StringProperty sub4) {
		this.sub4 = sub4;
	}
	public void setSub5(StringProperty sub5) {
		this.sub5 = sub5;
	}
	public void setSub6(StringProperty sub6) {
		this.sub6 = sub6;
	}
	
	
	
	
	public String getRoll_s() {
		return roll.get();
	}
	public void setRoll_s(String roll) {
		this.roll = new SimpleStringProperty(roll);
	}
	public String getName_s() {
		return name.get();
	}
	public void setName_s(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public String getSub1_s() {
		return sub1.get();
	}
	public void setSub1_s(String sub1) {
		this.sub1 = new SimpleStringProperty(sub1);
	}
	public String getSub2_s() {
		return sub2.get();
	}
	public void setSub2_s(String sub2) {
		this.sub2 =new SimpleStringProperty( sub2);
	}
	public String getSub3_s() {
		return sub3.get();
	}
	public void setSub3_s(String sub3) {
		this.sub3 = new SimpleStringProperty(sub3);
	}
	public String getSub4_s() {
		return sub4.get();
	}
	public StringProperty getSub4() {
		return sub4;
	}
	public StringProperty getSub5() {
		return sub5;
	}
	public StringProperty getSub6() {
		return sub6;
	}
	public void setSub4_s(String sub4) {
		this.sub4 = new SimpleStringProperty(sub4);
	}
	public String getSub5_s() {
		return sub5.get();
	}
	public void setSub5_s(String sub5) {
		this.sub5 = new SimpleStringProperty(sub5);
	}
	public String getSub6_s() {
		return sub6.get();
	}
	public void setSub6_s(String sub6) {
		this.sub6 = new SimpleStringProperty(sub6);
	}	
	
	

}
