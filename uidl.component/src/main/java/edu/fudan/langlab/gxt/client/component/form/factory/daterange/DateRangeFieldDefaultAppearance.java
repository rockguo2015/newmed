package edu.fudan.langlab.gxt.client.component.form.factory.daterange;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.widget.core.client.button.IconButton.IconConfig;

import edu.fudan.langlab.gxt.client.component.form.factory.daterange.DateRangeField.DateRangeFieldAppearance;

public class DateRangeFieldDefaultAppearance implements DateRangeFieldAppearance{
	 public interface DateRangeFieldResources extends ClientBundle {
		    @Source("DateRangeField.css")
		    DateRangeFieldStyle css();
		    
		    @Source("fromTo2.png")
		    @ImageOptions(repeatStyle = RepeatStyle.None)
		    ImageResource fromTo();
	 }
	 public interface DateRangeFieldStyle extends CssResource {
		 String fromTo();
	 }
	 
	  private final DateRangeFieldResources resources;
	  private final DateRangeFieldStyle style;
	  
	  public DateRangeFieldDefaultAppearance() {
	    this(GWT.<DateRangeFieldResources>create(DateRangeFieldResources.class));
	  }
	  
	  public DateRangeFieldDefaultAppearance(DateRangeFieldResources resources) {
	    this.resources = resources;
	    this.style = this.resources.css();
	    
	    StyleInjectorHelper.ensureInjected(style, true);
	  }
	  
	@Override
	public IconConfig fromTo() {
		return new IconConfig(style.fromTo());
	}
	 
}
