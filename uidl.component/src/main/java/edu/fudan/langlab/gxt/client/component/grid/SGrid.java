package edu.fudan.langlab.gxt.client.component.grid;

import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class SGrid<M> extends Grid<M> implements IHasState{

	public SGrid(ListStore<M> store, ColumnModel<M> cm) {
		super(store, cm);
	}

	private Object state;

	public Object getState() {
		return state;
	}

	public void setState(Object state) {
		this.state = state;
	}
	

}
