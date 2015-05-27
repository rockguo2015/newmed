package edu.fudan.langlab.theme.blue.client.button;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance;

public class MyButtonCellDefaultAppearance<C> extends
		ButtonCellDefaultAppearance<C> {
	public interface MyButtonCellResources extends ButtonCellResources {
		@Source({ "com/sencha/gxt/theme/base/client/button/ButtonCell.css",
				"ButtonCell.css" })
		ButtonCellStyle style();
	}

	public MyButtonCellDefaultAppearance() {
		super(GWT.<ButtonCellResources> create(MyButtonCellResources.class));
	}
}
