package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class PlainHTMLTD extends ComplexPanel implements
		InsertPanel.ForIsWidget {
	TableCellElement cellElement;

	public PlainHTMLTD() {
		cellElement = DOM.createTD().cast();
		setElement(cellElement);
	}

	public void setColSpan(int colspan) {
		cellElement.setColSpan(colspan);
	}
	
	public void setRowSpan(int rowspan){
		cellElement.setRowSpan(rowspan);
	}

	@Override
	public void add(Widget child) {
		add(child, getElement());
	}

	@Override
	public void insert(Widget w, int beforeIndex) {
		insert(w, getElement(), beforeIndex, true);

	}

	public void setAttribute(String key, String value) {
		getElement().setAttribute(key, value);
	}

	@Override
	public void insert(IsWidget w, int beforeIndex) {
		insert(asWidgetOrNull(w), beforeIndex);
	}
}
