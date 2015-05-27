package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory.RadioButtonSingleEntitySelector;

import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;

public class DefaultObjectSelectorFactory {
	@Inject
	RuntimeGinjector runtimeGinjector;

	@WidgetProvider(isDefault=true)
	@RequireContentProvider
	public <T> ComboBoxSingleEntitySelector<T> createAsSelectItemAdaptor(String id,
			String title) {
		return new ComboBoxSingleEntitySelector<T>(id, title, runtimeGinjector);
	}
	
	@WidgetProvider
	@RequireContentProvider
	public <T> RadioButtonSingleEntitySelector<T> createAsRadioGroupItem(
			String id, String title,int radioCols) {
		return new RadioButtonSingleEntitySelector<T>(id, title,
				runtimeGinjector,radioCols);
	}
	
	/**
	 * @param id
	 * @param title
	 * @return
	 * The columns of the radio will use the default value "3"
	 */
	@WidgetProvider
	@RequireContentProvider
	public <T> RadioButtonSingleEntitySelector<T> createAsRadioGroupItem(
			String id, String title) {
		return new RadioButtonSingleEntitySelector<T>(id, title,
				runtimeGinjector);
	}
	
	/**
	 * @param id
	 * @param title
	 * @return
	 */
	@WidgetProvider
	public <T> ReadonlyValueProvider<T> createAsReadonlyTextItem(String id,
			String title) {
		return new ReadonlyValueProvider<T>(id, title, runtimeGinjector);
	}
	
	/**
	 * @param id
	 * @param title
	 * @return
	 */
	@WidgetProvider
	@RequireContentProvider
	public <T> SuggestionTextBox<T> createAsSuggestItem(String id, String title){
		return new SuggestionTextBox<T>(id,title,runtimeGinjector);
	}
}