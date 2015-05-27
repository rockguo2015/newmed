package edu.fudan.langlab.theme.fudanmed.client.field;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.theme.base.client.field.TriggerFieldDefaultAppearance;

public class MedTriggerFieldAppearance extends TriggerFieldDefaultAppearance {
	public interface MedTriggerFieldResources extends TriggerFieldResources {
		@Override
		@Source({ "MedValueBaseField.css", "MedTextField.css",
				"MedTriggerField.css" })
		TriggerFieldStyle css();

		@Override
		ImageResource triggerArrow();

		// @Override
		// @Source("triggerArrow.png")
		// ImageResource triggerArrowClick();
		//
		// @Override
		// @Source("triggerArrow.png")
		// ImageResource triggerArrowFocus();
		//
		// @Override
		// @Source("triggerArrow.png")
		// ImageResource triggerArrowFocusClick();
		//
		// @Override
		// @Source("triggerArrow.png")
		// ImageResource triggerArrowFocusOver();
		//
		// @Override
		// @Source("triggerArrow.png")
		// ImageResource triggerArrowOver();
	}

	public MedTriggerFieldAppearance() {
		this(
				GWT.<MedTriggerFieldResources> create(MedTriggerFieldResources.class));
	}

	public MedTriggerFieldAppearance(MedTriggerFieldResources resources) {
		super(resources);
	}

}
