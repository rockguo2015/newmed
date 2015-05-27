package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.datagrid;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.DataGrid.Resources;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.view.client.ProvidesKey;

public class AdvDataGrid<T> extends DataGrid<T> implements AdvClickNotifier{

	AdvClickListener listeners;

	public AdvDataGrid(int pageSize, Resources resources,ProvidesKey<T> keyProvider) {
		super(pageSize, resources, keyProvider);
		sinkEvents(Event.ONMOUSEUP | Event.ONDBLCLICK | Event.ONCONTEXTMENU);
	}

	public void onBrowserEvent2(Event event) {
//		super.onBrowserEvent2(event);
		event.cancelBubble(true);// This will stop the event from being
									// propagated
		event.preventDefault();
		
		if(DOM.eventGetButton(event) == Event.BUTTON_RIGHT) {
			listeners.onRightClick(this, event);
		}else {
			super.onBrowserEvent2(event);
		}
	}

	@Override
	public void addClickListener(AdvClickListener listener) {
		listeners = listener;
		
	}

	@Override
	public void removeClickListener(AdvClickListener listener) {
		// TODO Auto-generated method stub
		
	}

}
