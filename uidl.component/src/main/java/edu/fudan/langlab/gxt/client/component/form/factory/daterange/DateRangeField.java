package edu.fudan.langlab.gxt.client.component.form.factory.daterange;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.button.IconButton;
import com.sencha.gxt.widget.core.client.button.IconButton.IconConfig;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;


public class DateRangeField extends AdapterField<UIDateRange> {
	private HorizontalPanel panel;
	private DateField fromDate;
	private DateField toDate;
	private final DateRangeFieldAppearance appearance;
	private IconButton fromTo;

	public interface DateRangeFieldAppearance {
		IconConfig fromTo();
	}

	public DateRangeField() {
		super(new HorizontalPanel());
		appearance = GWT.create(DateRangeFieldAppearance.class);
		panel = (HorizontalPanel) getWidget();
		fromDate = new DateField();
		fromDate.setWidth(100);
		toDate = new DateField();
		toDate.setWidth(100);
		fromTo = new IconButton(appearance.fromTo());
		panel.add(fromDate);
		panel.add(new Label("~"));
		panel.add(toDate);
	}

	@Override
	public void setValue(UIDateRange value) {
		fromDate.setValue(value.getFrom());
		toDate.setValue(value.getTo());
	}

	@Override
	public UIDateRange getValue() {
		UIDateRange result = new UIDateRange();
		result.setFrom(fromDate.getValue());
		result.setTo(toDate.getValue());
		return result;
	}
	
	public void addValueChangedListener(final ValueChangedListener<UIDateRange> listener){
		fromDate.addValueChangeHandler(new ValueChangeHandler<Date>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				listener.onValueChanged(getValue());
				
			}
		});
		toDate.addValueChangeHandler(new ValueChangeHandler<Date>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				listener.onValueChanged(getValue());
				
			}
		});
	}

}
