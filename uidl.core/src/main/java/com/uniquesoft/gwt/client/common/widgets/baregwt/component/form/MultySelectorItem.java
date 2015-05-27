package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a class for multy values widgets. we can set several single values widget 
 * into it .
 *
 */
public class MultySelectorItem extends FlexTable{
	private int columns = 3;
	
	public MultySelectorItem(){
		setWidth("100%");
	}
	public MultySelectorItem(int columns) {
		this.columns = columns;
	}

	public void setColumns(int size) {
		this.columns = size;
	}
	/**
	 * @param widgets
	 * Add the collection of single value widget to make a Multy-Value widget
	 */
	public void setItems(Widget...widgets){
		int row = 0;
		int colNum = 0;
		for(Widget item : widgets){
			if(colNum >= columns){
				row++;
				colNum = 0;
			}
			setWidget(row, colNum++, item);
		}
		
	}
	/**
	 * @param id
	 * @return
	 * Select the single widget by the id. We use the field "title" to 
	 * store the id information  
	 */
	public Widget getField(String id){
		int totlaRows = getRowCount();
		int temp,temp1,temp2;
		for(temp=0;temp < totlaRows;temp++){
			temp2 = getCellCount(temp);
			for(temp1 = 0;temp1 < temp2;temp1++){
				if(getWidget(temp, temp1).getTitle().equals(id)){
					return getWidget(temp, temp1);
				}
			}
		}
		return null;
	}
}