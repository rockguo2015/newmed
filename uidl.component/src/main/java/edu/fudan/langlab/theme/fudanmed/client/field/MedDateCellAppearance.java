package edu.fudan.langlab.theme.fudanmed.client.field;

import com.google.gwt.core.shared.GWT;
import com.sencha.gxt.theme.base.client.field.DateCellDefaultAppearance;

public class MedDateCellAppearance extends DateCellDefaultAppearance {
	 public interface MedDateCellResources extends DateCellResources{
		 @Source({"MedValueBaseField.css", "MedTextField.css", "MedTriggerField.css"})
		    DateCellStyle css();
	 }
	 
	 public MedDateCellAppearance(){
		 this(GWT.<MedDateCellResources>create(MedDateCellResources.class));
	 }

	public MedDateCellAppearance(MedDateCellResources resource) {
		super(resource);
	}
}
