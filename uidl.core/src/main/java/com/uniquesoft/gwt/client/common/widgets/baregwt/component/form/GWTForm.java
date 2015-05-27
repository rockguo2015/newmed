package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

/**
 * This class is used to contain all kinds of forms that we would use in UIDL.
 * 
 */
public class GWTForm extends FlexTable {

	private int columns = 1;

	public GWTForm() {
		setWidth("100%");
	}

	public GWTForm(int columns) {
		this.columns = columns;
	}

	/**
	 * @param size
	 *            Set the max columns that the form would display in a row.
	 */
	public void setColumns(int size) {
		this.columns = size;
	}

	/**
	 * @param formItems
	 *            Set all kinds of form widgets into the form. The widgets will
	 *            display according to the sequence that they are added to the
	 *            Form.
	 */
	public void setItems(GWTFormItem... formItems) {
		int row = 0;
		int colNum = 0;
		int colSpans;
		int colSpansCount = 0;
		for (GWTFormItem formItem : formItems) {
			colSpans = formItem.getColspan();
			if (colNum + colSpansCount + colSpans + 1 > 2 * columns) {
				row++;
				colNum = 0;
				colSpansCount = 0;
			}

			if (colSpans > 1) {
				colSpansCount += colSpans - 1;
			}

			setWidget(row, colNum++, formItem.getLabelWidget());
			setWidget(row, colNum, formItem.getValueWidget());
			this.getFlexCellFormatter().setColSpan(row, colNum, colSpans);
			colNum = colNum + 1;
		}

	}

	/**
	 * @param formItems
	 * It may be used to avoid too many "as widget" in UIDL form in the future
	 */
	public void setItems(ICanAsWidget... formItems) {

	}

	/* 
	 * use "XXForm.asWidget" instead of "new GWTForm" in the View of UIDL 
	 */
	@Override
	public Widget asWidget() {
		return new GWTForm();
	}
}
