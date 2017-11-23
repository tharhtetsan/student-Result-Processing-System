package model.ObjectReferences;

import java.util.ArrayList;

public class result_stu_print_view {

	private String stu_name;
	private String nrc;
	private String stu_id;
	
	private ArrayList<String> arl_class;
	private ArrayList<String> arl_roll;
	private ArrayList<String> arl_years;
	private ArrayList<ArrayList<String>> arl2_marks;
	private ArrayList<ArrayList<String>> arl2_course;
	
	
	
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public ArrayList<String> getArl_class() {
		return arl_class;
	}
	public void setArl_class(ArrayList<String> arl_class) {
		this.arl_class = arl_class;
	}
	public ArrayList<String> getArl_roll() {
		return arl_roll;
	}
	public void setArl_roll(ArrayList<String> arl_roll) {
		this.arl_roll = arl_roll;
	}
	public ArrayList<String> getArl_years() {
		return arl_years;
	}
	public void setArl_years(ArrayList<String> arl_years) {
		this.arl_years = arl_years;
	}
	public ArrayList<ArrayList<String>> getArl2_marks() {
		return arl2_marks;
	}
	public void setArl2_marks(ArrayList<ArrayList<String>> arl2_marks) {
		this.arl2_marks = arl2_marks;
	}
	public ArrayList<ArrayList<String>> getArl2_course() {
		return arl2_course;
	}
	public void setArl2_course(ArrayList<ArrayList<String>> arl2_course) {
		this.arl2_course = arl2_course;
	}
	
	
	
 	
	
}
