package model.ObjectReferences;

import java.util.ArrayList;

public class Obj_Repeator {

	private String repeatorId;
	private String AcedimicCouserId;
	private ArrayList<String> Fail_sub;
	private ArrayList<String> Passed_sub;
	
	
	public Obj_Repeator()
	{
		
	}
	
	public Obj_Repeator(String id,String AcedimciCourseId,ArrayList<String> arl_failSub,ArrayList<String> arl_passSub)
	{
		this.repeatorId=id;
		this.AcedimicCouserId=AcedimciCourseId;
		this.Fail_sub=arl_failSub;
		this.Passed_sub=arl_passSub;
	}

	public String getRepeatorId() {
		return repeatorId;
	}

	public void setRepeatorId(String repeatorId) {
		this.repeatorId = repeatorId;
	}

	public String getAcedimicCouserId() {
		return AcedimicCouserId;
	}

	public void setAcedimicCouserId(String acedimicCouserId) {
		AcedimicCouserId = acedimicCouserId;
	}

	public ArrayList<String> getFail_sub() {
		return Fail_sub;
	}

	public void setFail_sub(ArrayList<String> fail_sub) {
		Fail_sub = fail_sub;
	}

	public ArrayList<String> getPassed_sub() {
		return Passed_sub;
	}

	public void setPassed_sub(ArrayList<String> passed_sub) {
		Passed_sub = passed_sub;
	}
	
	
}
