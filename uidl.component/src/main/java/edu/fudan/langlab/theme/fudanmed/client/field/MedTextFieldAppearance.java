package edu.fudan.langlab.theme.fudanmed.client.field;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.field.TextFieldDefaultAppearance;

public class MedTextFieldAppearance extends TextFieldDefaultAppearance {
	
	
	public interface MedTextFieldResources extends TextFieldResources{
		 @Source({"MedValueBaseField.css","MedTextField.css"})
		 TextFieldStyle css();
	}
	
	
	public MedTextFieldAppearance() {
	    this(GWT.<MedTextFieldResources> create(MedTextFieldResources.class));
	  }

	  public MedTextFieldAppearance(TextFieldResources resources) {
	    super(resources);
	  }


}
