package edu.fudan.langlab.theme.fudanmed.client.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.theme.base.client.toolbar.ToolBarBaseAppearance;

public class MedToolBarAppearance extends ToolBarBaseAppearance {

	public interface MedToolBarResources extends ClientBundle {
		@Source({ "com/sencha/gxt/theme/base/client/toolbar/ToolBarBase.css",
				"MedToolBar.css" })
		MedToolBarStyle style();

	}

	public interface MedToolBarStyle extends ToolBarBaseStyle, CssResource {

	}

	private final MedToolBarStyle style;
	private final MedToolBarResources resources;

	public MedToolBarAppearance() {
		this(GWT.<MedToolBarResources> create(MedToolBarResources.class));
	}

	public MedToolBarAppearance(MedToolBarResources resources) {
		this.resources = resources;
		this.style = this.resources.style();

		StyleInjectorHelper.ensureInjected(style, true);
	}

	@Override
	public String toolBarClassName() {
		return style.toolBar();
	}

}
