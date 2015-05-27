package edu.fudan.langlab.gxt.client.component.form.factory;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ListView;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.listview.GXTListViewComponent;

public class DefaultObjectSelectorFactory implements IInitializerSupport {
	@Inject
	RuntimeGinjector runtimeGinjector;

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	@RequireContentProvider
	@WidgetProvider(isDefault = true)
	public <T> RadioButtonSelector<T> createAsRadioGroupItem(String id,
			String title) {
		return new RadioButtonSelector<T>(id, title,false, runtimeGinjector);
	}
	@RequireContentProvider
	@WidgetProvider
	public <T> RadioButtonSelector<T> createAsRequiredRadioGroupItem(String id,
			String title) {
		return new RadioButtonSelector<T>(id, title,true, runtimeGinjector);
	}

	@RequireContentProvider
	@WidgetProvider
	public <T> ComboBoxSelector<T> createAsComboBoxItem(String id, String title) {
		return new ComboBoxSelector<T>(id, title, false,runtimeGinjector);
	}
	@RequireContentProvider
	@WidgetProvider
	public <T> ComboBoxSelector<T> createAsRequiredComboBoxItem(String id, String title) {
		return new ComboBoxSelector<T>(id, title, true,runtimeGinjector);
	}
	@RequireContentProvider
	@WidgetProvider
	public <T> ListGridSelector<T> createAsListGridItem(String id, String title, GXTGridComponent<T> listGrid) {
		return new ListGridSelector<T>(id, title, false,listGrid);
	}
	@RequireContentProvider
	@WidgetProvider
	public <T> SuggestionComboBoxSelector<T> createAsSuggestionItem(String id, String title) {
		return new SuggestionComboBoxSelector<T>(id, title, false,runtimeGinjector);
	}
	@RequireContentProvider
	@WidgetProvider
	public <T> SuggestionComboBoxSelector<T> createAsRequiredSuggestionItem(String id, String title) {
		return new SuggestionComboBoxSelector<T>(id, title,true, runtimeGinjector);
	}
	@RequireContentProvider
	@WidgetProvider
	public <T> SuggestionComboBoxSelector<T> createAsSuggestionItem(String id, String title, GXTListViewComponent<T> listView) {
		return new SuggestionComboBoxSelector<T>(id, title, false,listView,runtimeGinjector);
	}
	@RequireContentProvider
	@WidgetProvider
	public <T> SuggestionComboBoxSelector<T> createAsRequiredSuggestionItem(String id, String title, GXTListViewComponent<T> listView) {
		return new SuggestionComboBoxSelector<T>(id, title, true,listView,runtimeGinjector);
	}
	
	
	@WidgetProvider
	public <T> ReadonlyItem<T> createAsReadonlyItem(String id, String title){
		return new ReadonlyItem<T>(id,title){
			@Override
			protected String toString(T value) {
				return runtimeGinjector.getObjectNameProvider().getName(value);
			}
		};
	}
	
	@WidgetProvider
	public <T> IValueProvider<T> createAsDelegateItem(String id, String title, IValueProvider<T> valueProvider){
		return new ComponentDelegateValueProvider<T>(valueProvider);
	}

}
