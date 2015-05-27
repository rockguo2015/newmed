package edu.fudan.langlab.theme.blue.client.fieldset;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.field.FieldSetDefaultAppearance;

public class MyBlueFieldSetAppearance extends FieldSetDefaultAppearance {
	public interface MyBLueFieldSetResource extends FieldSetResources{
		@Override
		@Source({"com/sencha/gxt/theme/base/client/field/FieldSet.css","FieldSet.css"})
		FieldSetStyle css();
	}

	public MyBlueFieldSetAppearance(){
		super(GWT.<MyBLueFieldSetResource>create(MyBLueFieldSetResource.class));
	}
}
