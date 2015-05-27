package edu.fudan.langlab.theme.blue.client.grid;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.grid.ColumnHeaderDefaultAppearance;

public class MyColumnHeaderDefaultAppearance extends
		ColumnHeaderDefaultAppearance {
	public interface MyColumnHeaderResources extends ColumnHeaderResources {
		@Source("ColumnHeader.css")
		ColumnHeaderStyle style();
	}

	public MyColumnHeaderDefaultAppearance() {
		super(GWT.<ColumnHeaderResources> create(MyColumnHeaderResources.class));
	}
}
