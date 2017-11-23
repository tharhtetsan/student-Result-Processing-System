package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_histroy {

	private StringProperty id;
	private StringProperty rollRecord;
	private StringProperty Firstyear1;
	private StringProperty Firstyear2;
	private StringProperty Secondyear1;
	private StringProperty Secondyear2;
	private StringProperty Thirdyear1;
	private StringProperty Thirdyear2;
	private StringProperty Fourthyear1;
	private StringProperty Fourthyear2;
	private StringProperty Final1;
	
	private StringProperty RepeatorId;

	
	public Obj_histroy()
	{
		this.id=new SimpleStringProperty("-");
		this.rollRecord=new SimpleStringProperty("-");
		this.Firstyear1=new SimpleStringProperty("-");
		this.Firstyear2=new SimpleStringProperty("-");
		this.Secondyear1=new SimpleStringProperty("-");
		this.Secondyear2=new SimpleStringProperty("-");
		this.Thirdyear1=new SimpleStringProperty("-");
		this.Thirdyear2=new SimpleStringProperty("-");
		this.Fourthyear1=new SimpleStringProperty("-");
		this.Fourthyear2=new SimpleStringProperty("-");
		this.Final1=new SimpleStringProperty("-");
		this.RepeatorId=new SimpleStringProperty("-");
	}
	
	public Obj_histroy(String id,String rollRecored,String f1,String f2,String s1,String s2,String t1,String t2,String fo1,String fo2,String Final1,String repeartorid)
	{
		this.id=new SimpleStringProperty(id);
		this.rollRecord=new SimpleStringProperty(rollRecored);
		this.Firstyear1=new SimpleStringProperty(f1);
		this.Firstyear2=new SimpleStringProperty(f2);
		this.Secondyear1=new SimpleStringProperty(s1);
		this.Secondyear2=new SimpleStringProperty(s2);
		this.Thirdyear1=new SimpleStringProperty(t1);
		this.Thirdyear2=new SimpleStringProperty(t2);
		this.Fourthyear1=new SimpleStringProperty(fo1);
		this.Fourthyear2=new SimpleStringProperty(fo2);
		this.Final1=new SimpleStringProperty(Final1);
		this.RepeatorId=new SimpleStringProperty(repeartorid);
		
		
		
	}
	
	public String getId_s() {
		return id.get();
	}

	public void setId_s(String id) {
		this.id =new SimpleStringProperty( id);
	}

	public String getRollRecord_s() {
		return rollRecord.get();
	}

	public void setRollRecord_s(String rollRecord) {
		this.rollRecord = new SimpleStringProperty(rollRecord);
	}

	public String getFirstyear1_s() {
		return Firstyear1.get();
	}

	public void setFirstyear1_s(String firstyear1) {
		Firstyear1 = new SimpleStringProperty(firstyear1);
	}

	public String getFirstyear2_s() {
		return Firstyear2.get();
	}

	public void setFirstyear2_s(String firstyear2) {
		Firstyear2 = new SimpleStringProperty(firstyear2);
	}

	public String getSecondyear1_s() {
		return Secondyear1.get();
	}

	public void setSecondyear1_s(String secondyear1) {
		Secondyear1 = new SimpleStringProperty(secondyear1);
	}

	public String getSecondyear2_s() {
		return Secondyear2.get();
	}

	public void setSecondyear2_s(String secondyear2) {
		Secondyear2 = new SimpleStringProperty(secondyear2);
	}

	public String getThirdyear1_s() {
		return Thirdyear1.get();
	}

	public void setThirdyear1_s(String thirdyear1) {
		Thirdyear1 = new SimpleStringProperty(thirdyear1);
	}

	public String getThirdyear2_s() {
		return Thirdyear2.get();
	}

	public void setThirdyear2_s(String thirdyear2) {
		Thirdyear2 = new SimpleStringProperty(thirdyear2);
	}

	public String getFourthyear1_s() {
		return Fourthyear1.get();
	}

	public void setFourthyear1_s(String fourthyear1) {
		Fourthyear1 = new SimpleStringProperty(fourthyear1);
	}

	public String getFourthyear2_s() {
		return Fourthyear2.get();
	}

	public void setFourthyear2_s(String fourthyear2) {
		Fourthyear2 = new SimpleStringProperty(fourthyear2);
	}

	public String getFinal1_s() {
		return Final1.get();
	}

	public void setFinal1_s(String final1) {
		Final1 = new SimpleStringProperty(final1);
	}

	public String getRepeatorId_s() {
		return RepeatorId.get();
	}

	public void setRepeatorId_s(String repeatorId) {
		RepeatorId = new SimpleStringProperty(repeatorId);
	}
	
	
	
	
	
	
	
}
