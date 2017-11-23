package view.UI_relatives;

public class Obj_Area_chart {

	private String xValue;
	private String yValue;
	
	
	public Obj_Area_chart()
	{
		
	}
	public Obj_Area_chart(String xValue,String yValue)
	{
		this.xValue=xValue;
		this.yValue=yValue;
	}
	public String getxValue() {
		return xValue;
	}
	public void setxValue(String xValue) {
		this.xValue = xValue;
	}
	public String getyValue() {
		return yValue;
	}
	public void setyValue(String yValue) {
		this.yValue = yValue;
	}
	
}
