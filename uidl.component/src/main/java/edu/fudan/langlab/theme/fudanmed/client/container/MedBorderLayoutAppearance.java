package edu.fudan.langlab.theme.fudanmed.client.container;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.container.BorderLayoutBaseAppearance;


public class MedBorderLayoutAppearance extends BorderLayoutBaseAppearance {
	public interface MedBorderLayoutResources extends BorderLayoutResources {
		@Override
		@Source({
				"com/sencha/gxt/theme/base/client/container/BorderLayout.css",
				"MedBorderLayout.css" })
		public MedBorderLayoutStyle css();
	}

	public interface MedBorderLayoutStyle extends BorderLayoutStyle {

	}

	public MedBorderLayoutAppearance() {
		this(GWT.<MedBorderLayoutResources> create(MedBorderLayoutResources.class));
	}

	public MedBorderLayoutAppearance(MedBorderLayoutResources resources) {
		super(resources);
	}
}
