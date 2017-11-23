package model.ObjectReferences;

public class Obj_stu_profile_all {

	
	
	private Obj_stu_parent Parent;
	private Obj_stu_profile stu;
	private  Obj_histroy history;
	
	public Obj_stu_profile_all()
	{
	
	}
	
	public Obj_stu_profile_all(Obj_stu_parent parent,Obj_stu_profile Stu,Obj_histroy History)
	{
		
		this.stu=Stu;
		this.Parent=parent;
		this.history=History;
	}
	

	public Obj_stu_parent getParent() {
		return Parent;
	}

	public void setParent(Obj_stu_parent parent) {
		Parent = parent;
	}

	public Obj_stu_profile getStu() {
		return stu;
	}

	public void setStu(Obj_stu_profile stu) {
		this.stu = stu;
	}

	public Obj_histroy getHistory() {
		return history;
	}

	public void setHistory(Obj_histroy history) {
		this.history = history;
	}
	
	
	
}
