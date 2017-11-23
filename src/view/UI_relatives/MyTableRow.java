package view.UI_relatives;

import model.ObjectReferences.*;
import view.UI_reference_Obj.Stu_profile;;

public class MyTableRow {
	private Boolean selected = false;
	private Object eachrow;
	private Class TableDataClass;

	public MyTableRow(Object o) {
		if(o instanceof Obj_stu_profile)
			this.eachrow= (Stu_profile) o;
		
	}

	public Class getTableDataClass() {
		return TableDataClass;
	}
	public Boolean getSelected() {
		return selected;
	}
	
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Object getEachrow() {
		
		return eachrow;
	}

	public void setEachrow(Object rowlist) {
		this.eachrow = rowlist;
	}

	public void setSelected(boolean selected) {
		this.selected=selected;
	}

	public boolean isSelected() {
		return selected;
	}

}
