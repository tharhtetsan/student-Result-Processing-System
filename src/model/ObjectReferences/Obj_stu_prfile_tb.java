package model.ObjectReferences;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obj_stu_prfile_tb {
	
	private StringProperty no;
	private StringProperty name;
	private StringProperty trName;
	private StringProperty term;
	
	public Obj_stu_prfile_tb()
	{
		
	}
	
	public Obj_stu_prfile_tb(String No,String Name,String Term,String Trname)
	{
		this.no=new SimpleStringProperty(No);
		this.name=new SimpleStringProperty(Name);
		this.trName=new SimpleStringProperty(Trname);
		this.term=new SimpleStringProperty(Term);
	}

	
	
	public StringProperty getTerm() {
		return term;
	}

	public void setTerm(StringProperty term) {
		this.term = term;
	}

	public StringProperty getNo() {
		return no;
	}

	public void setNo(StringProperty no) {
		this.no = no;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getTrName() {
		return trName;
	}

	public void setTrName(StringProperty trName) {
		this.trName = trName;
	}
	
	
	
	

}
