package edu.fudan.langlab.gxt.client.component.grid.factory;

import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;

public interface IEditableColumn<T> {
	void initializeEditor(GridEditing<T> gridEditing);
}
