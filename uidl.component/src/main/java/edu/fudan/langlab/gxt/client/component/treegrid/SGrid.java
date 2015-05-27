package edu.fudan.langlab.gxt.client.component.treegrid;

import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;

import edu.fudan.langlab.gxt.client.component.grid.IHasState;

public class SGrid<M> extends TreeGrid<M> implements IHasState{

	public SGrid(TreeStore<M> store, ColumnModel<M> cm, ColumnConfig<M, ?> expandNode) {
		super(store, cm, expandNode);
	}

	private Object state;

	public Object getState() {
		return state;
	}

	public void setState(Object state) {
		this.state = state;
	}

}
