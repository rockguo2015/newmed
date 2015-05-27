package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import java.util.LinkedHashMap;

import com.google.common.collect.Lists;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * This is a choice for all left data types. In UIDL ,we have to write a
 * content-provider to provider the contents of the widget
 * 
 * @param <T>
 */
public class ComboBoxSingleEntitySelector<T> implements
		ISingleValueSelector<T>, ObjectSelectionProvider<T> {

	private ListBox selectItem;
	private GWTFormItem formItem;
	private IObjectNameProvider nameProvider;
	private ContentProvider<T> provider;

	private ValueChangedManager<T> selectionChangeManager = new ValueChangedManager<T>();

	/**
	 * Create a GWTFormItem that contains a label and a selectBox.
	 * 
	 * @param id
	 * @param title
	 * @param runtimeGinjector
	 */
	public ComboBoxSingleEntitySelector(String id, final String title,
			RuntimeGinjector runtimeGinjector) {
		nameProvider = runtimeGinjector.getObjectNameProvider();
		selectItem = new ListBox();
		selectItem.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				selectionChangeManager.fireValueChangedEvent(getValue());

			}
		});
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

	private void updateContents(ContentProvider<T> provider) {
		LinkedHashMap<String, String> values = new LinkedHashMap<String, String>();
		values.put("__NULL__", "");
		selectItem.clear();
		for (T item : provider.getContents()) {
			values.put(nameProvider.getId(item), nameProvider.getName(item));
			selectItem.addItem(nameProvider.getId(item));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ISelector#
	 * setContentProvider
	 * (com.uniquesoft.gwt.client.common.widgets.contentprovider
	 * .ContentProvider) Set the contents into the selectBox.
	 */
	@Override
	public void setContentProvider(final ContentProvider<T> provider) {
		this.provider = provider;
		this.provider.addContentChangedListener(new ContentChangedListener() {

			@Override
			public void onContentChanged() {
				updateContents(provider);
			}
		});
		updateContents(provider);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider
	 * #getValue() Get the object by the selected choice in the selectbox. First
	 * get the index of the selected option, then get its id value ,at last get
	 * the object in the content provider.
	 */
	@Override
	public T getValue() {
		if (selectItem.getValue(selectItem.getSelectedIndex()) == null)
			return null;
		String selectedId = selectItem.getValue(selectItem.getSelectedIndex());
		for (T item : provider.getContents()) {
			if (nameProvider.getId(item).equals(selectedId))
				return item;
		}
		return null;
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<T> listener) {
		selectionChangeManager.addValueChangedListener(listener);

	}

	private int getItemIndex(String id) {
		int length = selectItem.getItemCount();
		while (length >= 0) {
			if (selectItem.getItemText(length).equals(id)) {
				return length;
			}
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue
	 * (java.lang.Object) Set the selectBox's value that will be shown on the
	 * page.
	 */
	@Override
	public IValueViewer<T> setValue(T value) {
		int index = getItemIndex(nameProvider.getId(value));
		if (-1 != index) {
			selectItem.setItemSelected(index, true);
		}
		return this;
	}

	@Override
	public GWTFormItem asWidget() {

		return formItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider#
	 * getSelectedObjects() If no option is selected ,then return a empty List,
	 * else set the selected object in it.
	 */
	@Override
	public Iterable<T> getSelectedObjects() {
		if (getValue() != null)
			return Lists.<T> newArrayList(getValue());
		else
			return Lists.newArrayList();
	}

	@Override
	public void addSelectionChangedListener(
			com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<T> listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deselect() {
		if (selectItem.getSelectedIndex() != -1)
			selectItem.setItemSelected(selectItem.getSelectedIndex(), false);

	}

	@Override
	public void select(T item) {
		setValue(item);
		
	}

}