package edu.fudan.langlab.theme.fudanmed.client.button;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.button.ButtonCellDefaultAppearance;
import com.sencha.gxt.theme.base.client.button.ButtonTableFrameResources;
import com.sencha.gxt.theme.base.client.frame.TableFrame;

public class MedButtonCellAppearance<C> extends
		ButtonCellDefaultAppearance<C> {

	public interface MedButtonCellResources extends ButtonCellResources {
		@Source({ "com/sencha/gxt/theme/base/client/button/ButtonCell.css",
				"ButtonCell.css" })
		@Override
		ButtonCellStyle style();
	}

	public MedButtonCellAppearance() {
		 super(GWT.<ButtonCellResources> create(MedButtonCellResources.class), GWT.<ButtonCellTemplates>create(ButtonCellTemplates.class), new TableFrame(GWT.<ButtonTableFrameResources> create(MedButtonTableFrameResources.class)));
	}
}
