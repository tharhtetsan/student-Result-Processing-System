package model.ObjectReferences;

public class Obj_transcript {
	
	private String trnId;
	private String sutId;
	private String count;
	
	public Obj_transcript()
	{
		
	}
	
	public Obj_transcript(String Tran,String Stu,String Count)
	{
		this.trnId=Tran;
		this.sutId=Stu;
		this.count=Count;
	}

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public String getSutId() {
		return sutId;
	}

	public void setSutId(String sutId) {
		this.sutId = sutId;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	
	
	
	

}
