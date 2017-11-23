package model.ObjectReferences;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_Course_profile {

	private StringProperty years;
	private IntegerProperty Pass;
	private IntegerProperty Fail;
	private IntegerProperty Destination;
	private IntegerProperty total;
	private StringProperty percentage;
	
	public Obj_Course_profile()
	{
		
	}
	
	public Obj_Course_profile(String years,Integer pass,Integer fail,Integer destination,Integer total,String percent)
	{
		this.years=new SimpleStringProperty(years);
		this.Pass=new SimpleIntegerProperty(pass);
		this.Fail=new SimpleIntegerProperty(fail);
		this.Destination=new SimpleIntegerProperty(destination);
		this.total=new SimpleIntegerProperty(total);
		this.percentage=new SimpleStringProperty(percent);
	}
	
	public String getYears_s() {
		return years.get();
	}
	public void setYears_s(String years) {
		this.years = new SimpleStringProperty(years);
	}
	public Integer getPass_s() {
		return Pass.get();
	}
	public void setPass_s(Integer pass) {
		Pass = new SimpleIntegerProperty(pass);
	}
	public Integer getFail_s() {
		return Fail.get();
	}
	public void setFail_s(Integer fail) {
		Fail = new SimpleIntegerProperty(fail);
	}
	public Integer getDestination_s() {
		return Destination.get();
	}
	public void setDestination_s(Integer destination) {
		Destination = new SimpleIntegerProperty(destination);
	}
	public Integer getTotal_s() {
		return total.get();
	}
	public void setTotal_s(Integer total) {
		this.total =new SimpleIntegerProperty(total);
	}
	public String getPercentage_s() {
		return percentage.get();
	}
	public void setPercentage_s(String percentage) {
		this.percentage = new SimpleStringProperty(percentage);
	}
	
	
	
	
	public StringProperty getYears() {
		return years;
	}
	public void setYears(StringProperty years) {
		this.years = years;
	}
	public IntegerProperty getPass() {
		return Pass;
	}
	public void setPass(IntegerProperty pass) {
		Pass = pass;
	}
	public IntegerProperty getFail() {
		return Fail;
	}
	public void setFail(IntegerProperty fail) {
		Fail = fail;
	}
	public IntegerProperty getDestination() {
		return Destination;
	}
	public void setDestination(IntegerProperty destination) {
		Destination = destination;
	}
	public IntegerProperty getTotal() {
		return total;
	}
	public void setTotal(IntegerProperty total) {
		this.total = total;
	}
	public StringProperty getPercentage() {
		return percentage;
	}
	public void setPercentage(StringProperty percentage) {
		this.percentage = percentage;
	}
	
	
	
	
	
}
