package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form;

import com.google.gwt.user.client.ui.Widget;

/**
 * It is used to add a label for the form widget we used. You can see this class 
 * is widely used in Form factory. In GWTForm Factory, we will encapsulate the widget 
 * to add a label to show the widget title.
 * 
 */
public abstract class GWTFormItem {

	/**
	 * colspan is used to set how many columns the uidl widget will use,
	 * for example, some radio widget needs longer place to show, then we can
	 * set the colspan to 3 or 5 .remember that the title of each item will also
	 * occupy an column.
	 */
	private int colspan = 1;
	
	/**
	 * We may use this field to decide how many rows the widget will use, but now the 
	 * factory class has not finished related method to support it.
	 */
	private int rowspan = 1;

	/**
	 * @return
	 * To new a label for the form widget
	 */
	public abstract Widget getLabelWidget();

	/**
	 * @return
	 * Add the form widget we need to use
	 */
	public abstract Widget getValueWidget();

	public void setColspan(int colSpan) {
		this.colspan = colSpan;
	}

	/**
	 * @return
	 */
	public int getColspan() {
		return colspan;
	}
	
	public void setRowspan(int rowSpan){
		this.rowspan = rowSpan;
	}
	
	public int getRowspan(){
		return rowspan;
	}
	
}
