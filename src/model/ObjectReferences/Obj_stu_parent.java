package model.ObjectReferences;

public class Obj_stu_parent {

	private String parentid;
	private String father_name;
	private String father_nrc;
	private String mother_name;
	private String mother_nrc;
	private String parent_address;
	private String parent_phno;
	
	
	
	public Obj_stu_parent()
	{
		
	}
	public Obj_stu_parent(String ParentId,String fName,String fNrc,String mName,String Mnrc,String address,String pnoNo)
	{
		this.parentid=ParentId;
		this.father_name=fName;
		this.father_nrc=fNrc;
	
		this.mother_name=mName;
		
		this.mother_nrc=Mnrc;
		
		this.parent_address=address;
		this.parent_phno=pnoNo;
	}
	
	

	public String getParent_address() {
		return parent_address;
	}


	public void setParent_address(String parent_address) {
		this.parent_address = parent_address;
	}


	public String getFather_name() {
		return father_name;
	}


	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}


	public String getFather_nrc() {
		return father_nrc;
	}


	public void setFather_nrc(String father_nrc) {
		this.father_nrc = father_nrc;
	}



	public String getMother_name() {
		return mother_name;
	}


	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}


	public String getMother_nrc() {
		return mother_nrc;
	}


	public void setMother_nrc(String mother_nrc) {
		this.mother_nrc = mother_nrc;
	}




	public String getParent_phno() {
		return parent_phno;
	}


	public void setParent_phno(String parent_phno) {
		this.parent_phno = parent_phno;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	
	

}
