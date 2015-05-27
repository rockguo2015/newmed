package edu.fudan.langlab.theme.blue.client.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;

public class MyBlueTabPanelApperance extends
		com.sencha.gxt.theme.blue.client.tabs.BlueTabPanelAppearance {

	public interface MyBlueTabPanelResources extends BlueTabPanelResources {
		@Source({ "com/sencha/gxt/theme/base/client/tabs/TabPanel.css",
				"BlueTabPanel.css" })
		BlueTabPanelStyle style();
	}

	public interface BlueTemplate extends Template {
		@XTemplate(source = "TabPanel.html")
		SafeHtml render(TabPanelStyle style);
	}

	public MyBlueTabPanelApperance() {
		super(
				GWT.<BlueTabPanelResources> create(MyBlueTabPanelResources.class),
				GWT.<Template> create(BlueTemplate.class), GWT
						.<ItemTemplate> create(ItemTemplate.class));
	}
}
