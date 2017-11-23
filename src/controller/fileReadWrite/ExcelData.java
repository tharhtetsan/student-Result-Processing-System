package controller.fileReadWrite;

public class ExcelData 
{
	private String colAddress;
	private String rowAddress;
	private String value;
	private String realAddress;
	
	public ExcelData(String colAddress,String rowAddress,String value,String realAddress)
	{
		this.colAddress=colAddress;
		this.rowAddress=rowAddress;
		this.value=value;
		this.realAddress=realAddress;
	}
	
	public String getRealAddress() {
		return realAddress;
	}

	public void setRealAddress(String realAddress) {
		this.realAddress = realAddress;
	}

	public String getColAddress() {
		return colAddress;
	}

	public void setColAddress(String colAddress) {
		this.colAddress = colAddress;
	}

	public String getRowAddress() {
		return rowAddress;
	}

	public void setRowAddress(String rowAddress) {
		this.rowAddress = rowAddress;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
