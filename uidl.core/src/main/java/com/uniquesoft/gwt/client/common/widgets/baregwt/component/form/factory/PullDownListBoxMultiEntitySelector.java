package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IMultiValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * Select single or several options from the listBox,it needs a content provider.
 *
 * @param <T>
 */
public class PullDownListBoxMultiEntitySelector<T> implements
IMultiValueSelector<T> {

	private ListBox selectItem;
	private GWTFormItem formItem;
	private IObjectNameProvider nameProvider;
	private ContentProvider<T> provider;

	private ValueChangedManager<Collection<T>> valueChangedManager = new ValueChangedManager<Collection<T>>();
	PullDownListBoxMultiEntitySelector(String id, final String title,
			RuntimeGinjector runtimeGinjector){
		nameProvider = runtimeGinjector.getObjectNameProvider();
		selectItem = new ListBox(true);
	
		formItem = new GWTFormItem() {
			Label label = new Label(title);

			@Override
			public Widget getLabelWidget() {
				return label;
			}

			@Override
			public Widget getValueWidget() {
				return selectItem;
			}

		};
	}
	private T getcontainedItem(String id){
		for (T item : provider.getContents()){
			if(id.equals(nameProvider.getId(item))){
				return item;
			}
		}
		return null;
	}
	@Override
	public Collection<T> getValue() {
		int index = 0;
		Collection<T> result = Lists.newArrayList();
		
		for(;index < selectItem.getItemCount();index++){
			if(selectItem.isItemSelected(index)){
				if(null != getcontainedItem(selectItem.getItemText(index))){
					result.add(getcontainedItem(selectItem.getItemText(index)));
				}
			}
		}
		return result;
	}

	@Override
	public void addValueChangedListener(
			ValueChangedListener<Collection<T>> listener) {
		valueChangedManager.addValueChangedListener(listener);
		
	}

	private void setValueAsSelected(String id){
		int index = 0;
		for(;index < selectItem.getItemCount();index++){
			if(id.equals(selectItem.getItemText(index))){
				selectItem.setItemSelected(index, true);
				break;
			}
		}
	}
	@Override
	public void setValue(Collection<T> values) {
		if (values != null) {
			for (T singleValue : values) {
				setValueAsSelected(nameProvider.getId(singleValue));
			}
		}
		
	}

	@Override
	public GWTFormItem asWidget() {
	
		return formItem;
	}

	/**
	 * @param provider
	 * display the item id on the page for client to choose 
	 */
	private void updateContents(ContentProvider<T> provider) {
		selectItem.clear();
		for (T item : provider.getContents()) {
			selectItem.addItem(nameProvider.getId(item));
		}
	}
	@Override
	public void setContentProvider(final ContentProvider<T> provider) {
		this.provider = provider;
		updateContents(this.provider);
		this.provider.addContentChangedListener(new ContentChangedListener() {

			@Override
			public void onContentChanged() {
				updateContents(provider);
			}
		});
	}
	
}