package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.datagrid;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

public interface AdvClickNotifier {
	
	public interface AdvClickListener {
		void onRightClick(Widget sender, Event event);
	}
	
	public void addClickListener(AdvClickListener listener);

	public void removeClickListener(AdvClickListener listener);
}
