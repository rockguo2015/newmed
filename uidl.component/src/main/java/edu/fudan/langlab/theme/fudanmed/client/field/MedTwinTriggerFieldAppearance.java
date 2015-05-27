package edu.fudan.langlab.theme.fudanmed.client.field;

import com.google.gwt.core.shared.GWT;
import com.sencha.gxt.theme.base.client.field.TwinTriggerFieldDefaultAppearance;

public class MedTwinTriggerFieldAppearance extends
		TwinTriggerFieldDefaultAppearance {

	public interface MedTwinTriggerFieldResources extends
			TwinTriggerFieldResources {
		@Override
		@Source({ "MedValueBaseField.css", "MedTextField.css",
				"MedTriggerField.css", "MedTwinTriggerField.css" })
		TwinTriggerFieldStyle css();
	}
	
	public MedTwinTriggerFieldAppearance(){
		this(GWT.<MedTwinTriggerFieldResources>create(MedTwinTriggerFieldResources.class));
	}

	public MedTwinTriggerFieldAppearance(MedTwinTriggerFieldResources resource) {
		super(resource);
	}
}
