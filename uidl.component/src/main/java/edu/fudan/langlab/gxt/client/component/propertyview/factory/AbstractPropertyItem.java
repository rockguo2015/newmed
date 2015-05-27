package edu.fudan.langlab.gxt.client.component.propertyview.factory;

import com.google.gwt.user.client.ui.Label;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

public abstract class AbstractPropertyItem<T> implements IValueViewer<T>,IPropertyItem<T> {
	private String name;
	private T value;
	private int colspan;
	private String id;
	private Label label;
	
	public AbstractPropertyItem(){
		
	}

	public AbstractPropertyItem(String id, String name, int colspan) {
		label = new Label();
		this.id = id;
		this.name = name;
		this.colspan = colspan;
	}

	public AbstractPropertyItem(String id, String name) {
		label = new Label();
		this.id = id;
		this.name = name;
		this.colspan = 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getValue() {
		return value;
	}

	public IValueViewer<T> setValue(T value) {
		this.value = value;
		label.setText(toString(value));
		return this;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	public abstract String toString(T value);

	@Override
	public Label asWidget() {
		return label;
	}

}